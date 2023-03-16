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

package com.velocitypowered.api.command;

import com.velocitypowered.api.event.command.CommandExecuteEvent;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Handles the registration and execution of commands.
 */
public interface CommandManager {

  /**
   * Returns a builder to create a {@link CommandMeta} with
   * the given alias.
   *
   * @param alias the first command alias
   * @return a {@link CommandMeta} builder
   */
  CommandMeta.Builder metaBuilder(String alias);

  /**
   * Returns a builder to create a {@link CommandMeta} for
   * the given Brigadier command.
   *
   * @param command the command
   * @return a {@link CommandMeta} builder
   */
  CommandMeta.Builder metaBuilder(BrigadierCommand command);

  /**
   * Registers the specified command with the specified aliases.
   *
   * @param alias the first command alias
   * @param command the command to register
   * @param otherAliases additional aliases
   * @throws IllegalArgumentException if one of the given aliases is already registered, or
   *         the given command does not implement a registrable {@link Command} subinterface
   * @see Command for a list of registrable subinterfaces
   */
  default void register(String alias, Command command, String... otherAliases) {
    register(metaBuilder(alias).aliases(otherAliases).build(), command);
  }

  /**
   * Registers the specified Brigadier command.
   *
   * @param command the command to register
   * @throws IllegalArgumentException if the node alias is already registered
   */
  void register(BrigadierCommand command);

  /**
   * Registers the specified command with the given metadata.
   *
   * @param meta the command metadata
   * @param command the command to register
   * @throws IllegalArgumentException if one of the given aliases is already registered, or
   *         the given command does not implement a registrable {@link Command} subinterface
   * @see Command for a list of registrable subinterfaces
   */
  void register(CommandMeta meta, Command command);

  /**
   * Unregisters the specified command alias from the manager, if registered.
   *
   * @param alias the command alias to unregister
   */
  void unregister(String alias);

  /**
   * Unregisters the specified command from the manager, if registered.
   *
   * @param meta the command to unregister
   */
  void unregister(CommandMeta meta);

  /**
   * Retrieves the {@link CommandMeta} from the specified command alias, if registered.
   *
   * @param alias the command alias to lookup
   * @return an {@link CommandMeta} of the alias
   */
  @Nullable CommandMeta getCommandMeta(String alias);

  /**
   * Attempts to asynchronously execute a command from the given {@code cmdLine}.
   *
   * @param source the source to execute the command for
   * @param cmdLine the command to run
   * @return a future that may be completed with the result of the command execution.
   *         Can be completed exceptionally if an exception is thrown during execution.
   */
  CompletableFuture<Boolean> executeAsync(CommandSource source, String cmdLine);

  /**
   * Attempts to asynchronously execute a command from the given {@code cmdLine}
   * without firing a {@link CommandExecuteEvent}.
   *
   * @param source the source to execute the command for
   * @param cmdLine the command to run
   * @return a future that may be completed with the result of the command execution.
   *         Can be completed exceptionally if an exception is thrown during execution.
   */
  CompletableFuture<Boolean> executeImmediatelyAsync(CommandSource source, String cmdLine);

  /**
   * Returns an immutable collection of the case-insensitive aliases registered
   * on this manager.
   *
   * @return the registered aliases
   */
  Collection<String> getAliases();

  /**
   * Returns whether the given alias is registered on this manager.
   *
   * @param alias the command alias to check
   * @return true if the alias is registered; false otherwise
   */
  boolean hasCommand(String alias);
}
