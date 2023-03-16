/*
 * Copyright (C) 2021 Velocity Contributors
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
import com.mojang.brigadier.Message;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an implementation of brigadier's {@link Message}, providing support for {@link
 * Component} messages.
 */
public final class VelocityBrigadierMessage implements Message, ComponentLike {

  public static VelocityBrigadierMessage tooltip(Component message) {
    return new VelocityBrigadierMessage(message);
  }

  private final Component message;

  private VelocityBrigadierMessage(Component message) {
    this.message = Preconditions.checkNotNull(message, "message");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @NotNull
  public Component asComponent() {
    return message;
  }

  /**
   * Returns the message as a plain text.
   *
   * @return message as plain text
   */
  @Override
  public String getString() {
    return PlainTextComponentSerializer.plainText().serialize(message);
  }
}
