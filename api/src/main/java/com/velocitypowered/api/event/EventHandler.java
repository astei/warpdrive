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

package com.velocitypowered.api.event;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents an interface to perform direct dispatch of an event. This makes integration easier to
 * achieve with platforms such as RxJava. While this interface can be used to implement an awaiting
 * event handler, {@link AwaitingEventExecutor} provides a more idiomatic means to doing so.
 */
@FunctionalInterface
public interface EventHandler<E> {

  void execute(E event);

  default @Nullable EventTask executeAsync(E event) {
    execute(event);
    return null;
  }
}
