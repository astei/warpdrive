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

package com.velocitypowered.api.proxy.server;

import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.messages.ChannelMessageSink;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import net.kyori.adventure.audience.Audience;

/**
 * Represents a server that has been registered with the proxy. The {@code Audience} associated with
 * a {@code RegisteredServer} represent all players on the server connected to this proxy and do not
 * interact with the server in any way.
 */
public interface RegisteredServer extends ChannelMessageSink, Audience {

  /**
   * Returns the {@link ServerInfo} for this server.
   *
   * @return the server info
   */
  ServerInfo getServerInfo();

  /**
   * Returns a list of all the players currently connected to this server on this proxy.
   *
   * @return the players on this proxy
   */
  Collection<Player> getPlayersConnected();

  /**
   * Attempts to ping the remote server and return the server list ping result.
   *
   * @return the server ping result from the server
   */
  CompletableFuture<ServerPing> ping();

  /**
   * Attempts to ping the remote server and return the server list ping result
   * according to the options provided.
   *
   * @param pingOptions the options provided for pinging the server
   * @return the server ping result from the server
   * @since 3.2.0
   */
  CompletableFuture<ServerPing> ping(PingOptions pingOptions);
}
