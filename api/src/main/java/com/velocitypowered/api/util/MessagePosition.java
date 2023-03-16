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

package com.velocitypowered.api.util;

/**
 * Represents where a chat message is going to be sent.
 */
public enum MessagePosition {
  /**
   * The chat message will appear in the client's HUD. These messages can be filtered out by the
   * client.
   */
  CHAT,
  /**
   * The chat message will appear in the client's HUD and can't be dismissed.
   */
  SYSTEM,
  /**
   * The chat message will appear above the player's main HUD. This text format doesn't support many
   * component features, such as hover events.
   */
  ACTION_BAR
}
