/*
 * Copyright (C) 2018-2023 Velocity Contributors
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

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Identifies a type with a public RSA signature.
 */
public interface KeyIdentifiable {

  /**
   * Returns the timed identified key of the object context. This is only available if the client
   * is running Minecraft 1.19 or newer.
   *
   * @return the key or null if not available
   */
  @Nullable IdentifiedKey getIdentifiedKey();
}
