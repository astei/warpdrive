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

package com.velocitypowered.api.event.player;

import com.google.common.base.Preconditions;
import com.velocitypowered.api.event.annotation.AwaitingEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import java.util.Optional;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * This event is fired once the player has successfully connected to the target server and the
 * connection to the previous server has been de-established.
 *
 * <p>
 *   <strong>Note</strong>: For historical reasons, Velocity does wait on this event to finish
 *   firing before continuing the server connection process. This behavior is
 *   <strong>deprecated</strong> and likely to be removed in Polymer.
 * </p>
 */
@AwaitingEvent
public final class ServerConnectedEvent {

  private final Player player;
  private final RegisteredServer server;
  private final @Nullable RegisteredServer previousServer;

  /**
   * Constructs a ServerConnectedEvent.
   *
   * @param player the player that was connected
   * @param server the server the player was connected to
   * @param previousServer the server the player was previously connected to, null if none
   */
  public ServerConnectedEvent(Player player, RegisteredServer server,
      @Nullable RegisteredServer previousServer) {
    this.player = Preconditions.checkNotNull(player, "player");
    this.server = Preconditions.checkNotNull(server, "server");
    this.previousServer = previousServer;
  }

  public Player getPlayer() {
    return player;
  }

  public RegisteredServer getServer() {
    return server;
  }

  public Optional<RegisteredServer> getPreviousServer() {
    return Optional.ofNullable(previousServer);
  }

  @Override
  public String toString() {
    return "ServerConnectedEvent{"
        + "player=" + player
        + ", server=" + server
        + ", previousServer=" + previousServer
        + '}';
  }
}
