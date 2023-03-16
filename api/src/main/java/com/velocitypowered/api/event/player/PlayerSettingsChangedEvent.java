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

package com.velocitypowered.api.event.player;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.player.PlayerSettings;

/**
 * This event is fired when the client sends new client settings for the player. This event can
 * and typically will be fired multiple times per connection. Velocity will not wait on this event
 * to finish firing.
 */
public final class PlayerSettingsChangedEvent {

  private final Player player;
  private final PlayerSettings playerSettings;

  public PlayerSettingsChangedEvent(Player player, PlayerSettings playerSettings) {
    this.player = Preconditions.checkNotNull(player, "player");
    this.playerSettings = Preconditions.checkNotNull(playerSettings, "playerSettings");
  }

  public Player getPlayer() {
    return player;
  }

  public PlayerSettings getPlayerSettings() {
    return playerSettings;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("player", player)
        .add("playerSettings", playerSettings)
        .toString();
  }
}
