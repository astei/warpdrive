/*
 * Copyright (C) 2018-2021 Velocity Contributors
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

package com.velocitypowered.api.permission;

/**
 * Function that calculates the permission settings for a given {@link PermissionSubject}.
 */
@FunctionalInterface
public interface PermissionFunction {

  /**
   * A permission function that always returns {@link Tristate#TRUE}.
   */
  PermissionFunction ALWAYS_TRUE = p -> Tristate.TRUE;

  /**
   * A permission function that always returns {@link Tristate#FALSE}.
   */
  PermissionFunction ALWAYS_FALSE = p -> Tristate.FALSE;

  /**
   * A permission function that always returns {@link Tristate#UNDEFINED}.
   */
  PermissionFunction ALWAYS_UNDEFINED = p -> Tristate.UNDEFINED;

  /**
   * Gets the subjects setting for a particular permission.
   *
   * @param permission the permission
   * @return the value the permission is set to
   */
  Tristate getPermissionValue(String permission);
}
