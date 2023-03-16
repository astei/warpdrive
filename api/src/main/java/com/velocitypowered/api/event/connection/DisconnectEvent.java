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

package com.velocitypowered.api.event.connection;

import com.google.common.base.Preconditions;
import com.velocitypowered.api.event.annotation.AwaitingEvent;
import com.velocitypowered.api.proxy.Player;

/**
 * This event is fired when a player disconnects from the proxy. This operation can take place
 * when the player disconnects due to normal network activity or when the proxy shuts down.
 * Operations on the provided player, aside from basic data retrieval operations, may behave in
 * undefined ways.
 *
 * <p>
 *   Velocity typically fires this event asynchronously and does not wait for a response. However,
 *   it will wait for all {@link DisconnectEvent}s for every player on the proxy to fire
 *   successfully before the proxy shuts down. This event is the sole exception to the
 *   {@link AwaitingEvent} contract.
 * </p>
 */
@AwaitingEvent
public final class DisconnectEvent {

  private final Player player;
  private final LoginStatus loginStatus;

  public DisconnectEvent(Player player, LoginStatus loginStatus) {
    this.player = Preconditions.checkNotNull(player, "player");
    this.loginStatus = Preconditions.checkNotNull(loginStatus, "loginStatus");
  }

  public Player getPlayer() {
    return player;
  }

  public LoginStatus getLoginStatus() {
    return loginStatus;
  }

  @Override
  public String toString() {
    return "DisconnectEvent{"
        + "player=" + player + ", "
        + "loginStatus=" + loginStatus
        + '}';
  }

  /**
   * The status of the connection when the player disconnected.
   */
  public enum LoginStatus {

    SUCCESSFUL_LOGIN,
    CONFLICTING_LOGIN,
    CANCELLED_BY_USER,
    CANCELLED_BY_PROXY,
    CANCELLED_BY_USER_BEFORE_COMPLETE,
    PRE_SERVER_JOIN
  }
}
