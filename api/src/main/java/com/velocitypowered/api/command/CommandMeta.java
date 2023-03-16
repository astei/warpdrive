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

import com.mojang.brigadier.tree.CommandNode;
import java.util.Collection;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Contains metadata for a {@link Command}.
 */
public interface CommandMeta {

  /**
   * Returns a non-empty collection containing the case-insensitive aliases
   * used to execute the command.
   *
   * @return the command aliases
   */
  Collection<String> getAliases();

  /**
   * Returns an immutable collection containing command nodes that provide
   * additional argument metadata and tab-complete suggestions.
   * Note some {@link Command} implementations may not support hinting.
   *
   * @return the hinting command nodes
   */
  Collection<CommandNode<CommandSource>> getHints();

  /**
   * Returns the plugin who registered the command.
   * Note some {@link Command} registrations may not provide this information.
   *
   * @return the registering plugin
   */
  @Nullable Object getPlugin();

  /**
   * Provides a fluent interface to create {@link CommandMeta}s.
   */
  interface Builder {

    /**
     * Specifies additional aliases that can be used to execute the command.
     *
     * @param aliases the command aliases
     * @return this builder, for chaining
     */
    Builder aliases(String... aliases);

    /**
     * Specifies a command node providing additional argument metadata and
     * tab-complete suggestions.
     *
     * @param node the command node
     * @return this builder, for chaining
     * @throws IllegalArgumentException if the node is executable, i.e. has a non-null
     *         {@link com.mojang.brigadier.Command}, or has a redirect.
     */
    Builder hint(CommandNode<CommandSource> node);

    /**
     * Specifies the plugin who registers the {@link Command}.
     *
     * @param plugin the registering plugin
     * @return this builder, for chaining
     */
    Builder plugin(Object plugin);

    /**
     * Returns a newly-created {@link CommandMeta} based on the specified parameters.
     *
     * @return the built {@link CommandMeta}
     */
    CommandMeta build();
  }
}
