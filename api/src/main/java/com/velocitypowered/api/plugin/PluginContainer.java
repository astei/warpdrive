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

package com.velocitypowered.api.plugin;

import java.util.Optional;

/**
 * A wrapper around a plugin loaded by the proxy.
 */
public interface PluginContainer {

  /**
   * Returns the plugin's description.
   *
   * @return the plugin's description
   */
  PluginDescription getDescription();

  /**
   * Returns the created plugin if it is available.
   *
   * @return the instance if available
   */
  default Optional<?> getInstance() {
    return Optional.empty();
  }
}
