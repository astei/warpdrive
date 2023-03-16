/*
 * Copyright (C) 2018-2022 Velocity Contributors
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

package com.velocitypowered.api.event.proxy;

import com.google.common.base.Preconditions;
import com.velocitypowered.api.event.annotation.AwaitingEvent;
import com.velocitypowered.api.proxy.InboundConnection;
import com.velocitypowered.api.proxy.server.ServerPing;

/**
 * This event is fired when a request for server information is sent by a remote client, or when the
 * server sends the MOTD and favicon to the client after a successful login. Velocity will
 * wait on this event to finish firing before delivering the results to the remote client, but
 * you are urged to handle this event as quickly as possible when handling this event due to the
 * amount of ping packets a client can send.
 */
@AwaitingEvent
public final class ProxyPingEvent {

  private final InboundConnection connection;
  private ServerPing ping;

  public ProxyPingEvent(InboundConnection connection, ServerPing ping) {
    this.connection = Preconditions.checkNotNull(connection, "connection");
    this.ping = Preconditions.checkNotNull(ping, "ping");
  }

  public InboundConnection getConnection() {
    return connection;
  }

  public ServerPing getPing() {
    return ping;
  }

  public void setPing(ServerPing ping) {
    this.ping = Preconditions.checkNotNull(ping, "ping");
  }

  @Override
  public String toString() {
    return "ProxyPingEvent{"
        + "connection=" + connection
        + ", ping=" + ping
        + '}';
  }
}
