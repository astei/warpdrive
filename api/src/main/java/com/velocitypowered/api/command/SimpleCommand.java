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

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * A simple command, modelled after the convention popularized by
 * Bukkit and BungeeCord.
 *
 * <p>Prefer using {@link BrigadierCommand}, which is also
 * backwards-compatible with older clients.
 */
public interface SimpleCommand extends InvocableCommand<SimpleCommand.Invocation> {

  /**
   * Contains the invocation data for a simple command.
   */
  interface Invocation extends CommandInvocation<String @NonNull []> {

    /**
     * Returns the used alias to execute the command.
     *
     * @return the used command alias
     */
    String alias();
  }
}
