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

package com.velocitypowered.api.proxy.messages;

/**
 * Represents an interface to register and unregister {@link ChannelIdentifier}s for the proxy to
 * listen on.
 */
public interface ChannelRegistrar {

  /**
   * Registers the specified message identifiers to listen on so you can intercept plugin messages
   * on the channel using {@link com.velocitypowered.api.event.connection.PluginMessageEvent}.
   *
   * @param identifiers the channel identifiers to register
   */
  void register(ChannelIdentifier... identifiers);

  /**
   * Removes the intent to listen for the specified channel.
   *
   * @param identifiers the identifiers to unregister
   */
  void unregister(ChannelIdentifier... identifiers);
}
