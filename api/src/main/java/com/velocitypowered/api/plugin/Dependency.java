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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the {@link Plugin} depends on another plugin in order to enable.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Dependency {

  /**
   * The plugin ID of the dependency.
   *
   * @return The dependency plugin ID
   * @see Plugin#id()
   */
  String id();

  /**
   * Whether or not the dependency is not required to enable this plugin. By default this is
   * {@code false}, meaning that the dependency is required to enable this plugin.
   *
   * @return true if the dependency is not required for the plugin to work
   */
  boolean optional() default false;
}
