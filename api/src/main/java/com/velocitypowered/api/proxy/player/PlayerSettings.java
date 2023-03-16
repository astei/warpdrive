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

package com.velocitypowered.api.proxy.player;

import java.util.Locale;

/**
 * Represents the client settings for the player.
 */
public interface PlayerSettings {

  /**
   * Returns the locale of the Minecraft client.
   *
   * @return the client locale
   */
  Locale getLocale();

  /**
   * Returns the client's view distance. This does not guarantee the client will see this many
   * chunks, since your servers are responsible for sending the chunks.
   *
   * @return the client view distance
   */
  byte getViewDistance();

  /**
   * Returns the chat setting for the client.
   *
   * @return the chat setting
   */
  ChatMode getChatMode();

  /**
   * Returns whether or not the client has chat colors disabled.
   *
   * @return whether or not the client has chat colors disabled
   */
  boolean hasChatColors();

  /**
   * Returns the parts of player skins the client will show.
   *
   * @return the skin parts for the client
   */
  SkinParts getSkinParts();

  /**
   * Returns the primary hand of the client.
   *
   * @return the primary hand of the client
   */
  MainHand getMainHand();

  /**
   * Returns whether the client explicitly allows listing on the
   * {@link com.velocitypowered.api.proxy.player.TabList} or not in
   * anonymous TabList mode.
   * This feature was introduced in 1.18.
   *
   * @return whether or not the client explicitly allows listing. Always false on older clients.
   */
  boolean isClientListingAllowed();

  /**
   * The client's current chat display mode.
   */
  enum ChatMode {
    SHOWN,
    COMMANDS_ONLY,
    HIDDEN
  }

  /**
   * The player's selected dominant hand.
   */
  enum MainHand {
    LEFT,
    RIGHT
  }
}
