/*
 * Copyright (C) 2021-2022 Velocity Contributors
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

import com.google.common.base.Preconditions;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.messages.ChannelIdentifier;
import java.util.List;

/**
 * This event is fired when a client ({@link Player}) sends a plugin message through the
 * register channel. Velocity will not wait on this event to finish firing.
 */
public final class PlayerChannelRegisterEvent {

  private final Player player;
  private final List<ChannelIdentifier> channels;

  public PlayerChannelRegisterEvent(Player player, List<ChannelIdentifier> channels) {
    this.player = Preconditions.checkNotNull(player, "player");
    this.channels = Preconditions.checkNotNull(channels, "channels");
  }

  public Player getPlayer() {
    return player;
  }

  public List<ChannelIdentifier> getChannels() {
    return channels;
  }

  @Override
  public String toString() {
    return "PlayerChannelRegisterEvent{"
            + "player=" + player
            + ", channels=" + channels
            + '}';
  }
}
