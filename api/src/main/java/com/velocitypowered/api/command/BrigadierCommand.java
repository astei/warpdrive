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

import com.google.common.base.Preconditions;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;

/**
 * A command that uses Brigadier for parsing the command and
 * providing suggestions to the client.
 */
public final class BrigadierCommand implements Command {

  /**
   * The return code used by a {@link com.mojang.brigadier.Command} to indicate
   * the command execution should be forwarded to the backend server.
   */
  public static final int FORWARD = 0xF6287429;

  private final LiteralCommandNode<CommandSource> node;

  /**
   * Constructs a {@link BrigadierCommand} from the node returned by
   * the given builder.
   *
   * @param builder the {@link LiteralCommandNode} builder
   */
  public BrigadierCommand(final LiteralArgumentBuilder<CommandSource> builder) {
    this(Preconditions.checkNotNull(builder, "builder").build());
  }

  /**
   * Constructs a {@link BrigadierCommand} from the given command node.
   *
   * @param node the command node
   */
  public BrigadierCommand(final LiteralCommandNode<CommandSource> node) {
    this.node = Preconditions.checkNotNull(node, "node");
  }

  /**
   * Returns the literal node for this command.
   *
   * @return the command node
   */
  public LiteralCommandNode<CommandSource> getNode() {
    return node;
  }
}
