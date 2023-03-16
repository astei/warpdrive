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

import java.util.UUID;

/**
 * A signed message.
 */
public interface SignedMessage extends KeySigned {

  /**
   * Returns the signed message.
   *
   * @return the message
   */
  String getMessage();

  /**
   * Returns the signers UUID.
   *
   * @return the uuid
   */
  UUID getSignerUuid();

  /**
   * If true the signature of this message applies to a stylized component instead.
   *
   * @return signature signs preview
   */
  boolean isPreviewSigned();

}
