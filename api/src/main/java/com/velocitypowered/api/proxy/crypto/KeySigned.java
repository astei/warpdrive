/*
 * Copyright (C) 2022-2023 Velocity Contributors
 * Copyright (C) $YEAR Warpdrive Contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.velocitypowered.api.proxy.crypto;

import com.google.common.annotations.Beta;
import java.security.PublicKey;
import java.time.Instant;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents the signature of a signed object.
 */
public interface KeySigned {

  /**
   * Returns the key used to sign the object.
   *
   * @return the key
   */
  PublicKey getSigner();

  /**
   * Returns the expiry time point of the key.
   * Note: this limit is arbitrary. RSA keys don't expire,
   * but the signature of this key as provided by the session
   * server will expire.
   *
   * @return the expiry time point
   */
  Instant getExpiryTemporal();


  /**
   * Check if the signature has expired.
   *
   * @return true if proxy time is after expiry time
   */
  default boolean hasExpired() {
    return Instant.now().isAfter(getExpiryTemporal());
  }

  /**
   * Retrieves the signature of the signed object.
   *
   * @return an RSA signature
   */
  @Nullable
  byte[] getSignature();

  /**
   * Validates the signature, expiry temporal and key against the
   * signer public key. Note: This will **not** check for
   * expiry. You can check for expiry with {@link KeySigned#hasExpired()}.
   * <p>DOES NOT WORK YET FOR MESSAGES AND COMMANDS!</p>
   * Addendum: Does not work for 1.19.1 until the user has authenticated.
   *
   * @return validity of the signature
   */
  @Beta
  default boolean isSignatureValid() {
    return false;
  }

  /**
   * Returns the signature salt or null if not salted.
   *
   * @return signature salt or null
   */
  default byte[] getSalt() {
    return null;
  }

}
