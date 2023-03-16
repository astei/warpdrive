/*
 * Copyright (C) 2019-2021 Velocity Contributors
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

package com.velocitypowered.api.proxy.messages;

import static com.velocitypowered.api.proxy.messages.MinecraftChannelIdentifier.create;
import static com.velocitypowered.api.proxy.messages.MinecraftChannelIdentifier.from;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MinecraftChannelIdentifierTest {

  @Test
  void createAllowsValidNamespaces() {
    create("minecraft", "brand");
  }

  @Test
  void createAllowsEmptyName() {
    create("minecraft", "");
  }

  @Test
  void createDisallowsNull() {
    assertAll(
        () -> assertThrows(IllegalArgumentException.class, () -> create(null, "")),
        () -> assertThrows(IllegalArgumentException.class, () -> create("", "")),
        () -> assertThrows(IllegalArgumentException.class, () -> create("minecraft", null))
    );
  }

  @Test
  void fromIdentifierIsCorrect() {
    MinecraftChannelIdentifier expected = MinecraftChannelIdentifier.create("velocity", "test");
    assertEquals(expected, MinecraftChannelIdentifier.from("velocity:test"));
  }

  @Test
  void createAllowsSlashes() {
    create("velocity", "test/test2");
  }

  @Test
  void fromIdentifierThrowsOnBadValues() {
    assertAll(
        () -> assertThrows(IllegalArgumentException.class, () -> from("")),
        () -> assertThrows(IllegalArgumentException.class, () -> from(":")),
        () -> assertThrows(IllegalArgumentException.class, () -> from(":a")),
        () -> assertThrows(IllegalArgumentException.class, () -> from("a:")),
        () -> assertThrows(IllegalArgumentException.class, () -> from("hello:$$$$$$")),
        () -> assertThrows(IllegalArgumentException.class, () -> from("hello::"))
    );
  }


}