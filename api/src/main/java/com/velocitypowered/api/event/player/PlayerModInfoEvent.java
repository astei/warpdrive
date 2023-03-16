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
import com.velocitypowered.api.util.ModInfo;

/**
 * This event is fired when a Forge client sends its mods to the proxy while connecting to a server.
 * Velocity will not wait on this event to finish firing.
 */
public final class PlayerModInfoEvent {

  private final Player player;
  private final ModInfo modInfo;

  public PlayerModInfoEvent(Player player, ModInfo modInfo) {
    this.player = Preconditions.checkNotNull(player, "player");
    this.modInfo = Preconditions.checkNotNull(modInfo, "modInfo");
  }

  public Player getPlayer() {
    return player;
  }

  public ModInfo getModInfo() {
    return modInfo;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("player", player)
        .add("modInfo", modInfo)
        .toString();
  }
}
