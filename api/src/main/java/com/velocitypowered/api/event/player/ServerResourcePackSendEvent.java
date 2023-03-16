/*
 * Copyright (C) 2022-2023 Velocity Contributors
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

import com.velocitypowered.api.event.ResultedEvent;
import com.velocitypowered.api.event.annotation.AwaitingEvent;
import com.velocitypowered.api.proxy.ServerConnection;
import com.velocitypowered.api.proxy.player.ResourcePackInfo;

/**
 * This event is fired when the downstream server tries to send a player a ResourcePack packet.
 * The proxy will wait on this event to finish before forwarding the resource pack to the user.
 * If this event is denied, it will retroactively send a DENIED status to the downstream
 * server in response.
 * If the downstream server has it set to "forced" it will forcefully disconnect the user.
 */
@AwaitingEvent
public class ServerResourcePackSendEvent implements ResultedEvent<ResultedEvent.GenericResult> {
  private GenericResult result;
  private final ResourcePackInfo receivedResourcePack;
  private ResourcePackInfo providedResourcePack;
  private final ServerConnection serverConnection;

  /**
   * Constructs a new ServerResourcePackSendEvent.
   *
   * @param receivedResourcePack The resource pack the server sent.
   * @param serverConnection The connection this occurred on.
   */
  public ServerResourcePackSendEvent(
      ResourcePackInfo receivedResourcePack,
      ServerConnection serverConnection
  ) {
    this.result = ResultedEvent.GenericResult.allowed();
    this.receivedResourcePack = receivedResourcePack;
    this.serverConnection = serverConnection;
    this.providedResourcePack = receivedResourcePack;
  }

  public ServerConnection getServerConnection() {
    return serverConnection;
  }

  public ResourcePackInfo getReceivedResourcePack() {
    return receivedResourcePack;
  }

  public ResourcePackInfo getProvidedResourcePack() {
    return providedResourcePack;
  }

  public void setProvidedResourcePack(ResourcePackInfo providedResourcePack) {
    this.providedResourcePack = providedResourcePack;
  }

  @Override
  public GenericResult getResult() {
    return this.result;
  }

  @Override
  public void setResult(GenericResult result) {
    this.result = result;
  }
}
