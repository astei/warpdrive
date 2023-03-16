/*
 * Copyright (C) 2021-2023 Velocity Contributors
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

package com.velocitypowered.api.proxy;

import com.velocitypowered.api.proxy.crypto.KeyIdentifiable;
import com.velocitypowered.api.proxy.messages.ChannelIdentifier;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents a connextion that is in the login phase. This is most useful in conjunction
 * for login plugin messages.
 */
public interface LoginPhaseConnection extends InboundConnection, KeyIdentifiable {

  /**
   * Sends a login plugin message to the client, and provides a consumer to react to the
   * response to the client. The login process will not continue until there are no more
   * login plugin messages that require responses.
   *
   * @param identifier the channel identifier to use
   * @param contents the message to send
   * @param consumer the consumer that will respond to the message
   */
  void sendLoginPluginMessage(ChannelIdentifier identifier, byte[] contents,
      MessageConsumer consumer);

  /**
   * Consumes the message.
   */
  interface MessageConsumer {

    /**
     * Consumes the message and responds to it.
     *
     * @param responseBody the message from the client, if any
     */
    void onMessageResponse(byte @Nullable [] responseBody);
  }
}
