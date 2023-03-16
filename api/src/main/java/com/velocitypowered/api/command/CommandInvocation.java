/*
 * Copyright (C) 2020-2021 Velocity Contributors
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

package com.velocitypowered.api.command;

/**
 * Provides information related to the possible execution of a {@link Command}.
 *
 * @param <T> the type of the arguments
 */
public interface CommandInvocation<T> {

  /**
   * Returns the source to execute the command for.
   *
   * @return the command source
   */
  CommandSource source();

  /**
   * Returns the arguments after the command alias.
   *
   * @return the command arguments
   */
  T arguments();
}
