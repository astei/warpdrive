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

package com.velocitypowered.api.event.connection;

import com.google.common.base.Preconditions;
import com.velocitypowered.api.event.annotation.AwaitingEvent;
import com.velocitypowered.api.proxy.Player;

/**
 * This event is fired once the player has been fully initialized and is about to connect to their
 * first server. Velocity will wait for this event to finish firing before it fires
 * {@link com.velocitypowered.api.event.player.PlayerChooseInitialServerEvent} with any default
 * servers specified in the configuration, but you should try to limit the work done in any event
 * that fires during the login process.
 */
@AwaitingEvent
public final class PostLoginEvent {

  private final Player player;

  public PostLoginEvent(Player player) {
    this.player = Preconditions.checkNotNull(player, "player");
  }

  public Player getPlayer() {
    return player;
  }

  @Override
  public String toString() {
    return "PostLoginEvent{"
        + "player=" + player
        + '}';
  }
}
