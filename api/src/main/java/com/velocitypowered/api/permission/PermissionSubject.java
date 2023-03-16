/*
 * Copyright (C) 2018-2022 Velocity Contributors
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

import net.kyori.adventure.permission.PermissionChecker;

/**
 * Represents a object that has a set of queryable permissions.
 */
public interface PermissionSubject {

  /**
   * Determines whether or not the subject has a particular permission.
   *
   * @param permission the permission to check for
   * @return whether or not the subject has the permission
   */
  default boolean hasPermission(String permission) {
    return getPermissionValue(permission).asBoolean();
  }

  /**
   * Gets the subjects setting for a particular permission.
   *
   * @param permission the permission
   * @return the value the permission is set to
   */
  Tristate getPermissionValue(String permission);

  /**
   * Gets the permission checker for the subject.
   *
   * @return subject's permission checker
   */
  default PermissionChecker getPermissionChecker() {
    return permission -> getPermissionValue(permission).toAdventureTriState();
  }
}
