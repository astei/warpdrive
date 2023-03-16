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

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * A command that can be executed with arbitrary arguments.
 *
 * <p>Modifying the command tree (e.g. registering a command via
 * {@link CommandManager#register(CommandMeta, Command)}) during
 * permission checking and suggestions provision results in
 * undefined behavior, which may include deadlocks.
 *
 * @param <I> the type of the command invocation object
 */
public interface InvocableCommand<I extends CommandInvocation<?>> extends Command {

  /**
   * Executes the command for the specified invocation.
   *
   * @param invocation the invocation context
   */
  void execute(I invocation);

  /**
   * Provides tab complete suggestions for the specified invocation.
   *
   * @param invocation the invocation context
   * @return the tab complete suggestions
   */
  default List<String> suggest(final I invocation) {
    return ImmutableList.of();
  }

  /**
   * Provides tab complete suggestions for the specified invocation.
   *
   * @param invocation the invocation context
   * @return the tab complete suggestions
   * @implSpec defaults to wrapping the value returned by {@link #suggest(CommandInvocation)}
   */
  default CompletableFuture<List<String>> suggestAsync(final I invocation) {
    return CompletableFuture.completedFuture(suggest(invocation));
  }

  /**
   * Tests to check if the source has permission to perform the specified invocation.
   *
   * <p>If the method returns {@code false}, the handling is forwarded onto
   * the players current server.
   *
   * @param invocation the invocation context
   * @return {@code true} if the source has permission
   */
  default boolean hasPermission(final I invocation) {
    return true;
  }
}
