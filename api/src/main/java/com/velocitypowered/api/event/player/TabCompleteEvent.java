/*
 * Copyright (C) 2019-2023 Velocity Contributors
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.velocitypowered.api.event.annotation.AwaitingEvent;
import com.velocitypowered.api.proxy.Player;
import java.util.ArrayList;
import java.util.List;

/**
 * This event is fired after a tab complete response is sent by the remote server, for clients on
 * 1.12.2 and below. You have the opportunity to modify the response sent to the remote player.
 * Velocity will wait for this event to finish firing before sending the tab complete results to
 * the client. Be sure to be as fast as possible, since the client will freeze while it waits for
 * the tab complete results.
 */
@AwaitingEvent
public class TabCompleteEvent {
  private final Player player;
  private final String partialMessage;
  private final List<String> suggestions;

  /**
   * Constructs a new TabCompleteEvent instance.
   *
   * @param player the player
   * @param partialMessage the partial message
   * @param suggestions the initial list of suggestions
   */
  public TabCompleteEvent(Player player, String partialMessage, List<String> suggestions) {
    this.player = checkNotNull(player, "player");
    this.partialMessage = checkNotNull(partialMessage, "partialMessage");
    this.suggestions = new ArrayList<>(checkNotNull(suggestions, "suggestions"));
  }

  /**
   * Returns the player requesting the tab completion.
   *
   * @return the requesting player
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * Returns the message being partially completed.
   *
   * @return the partial message
   */
  public String getPartialMessage() {
    return partialMessage;
  }

  /**
   * Returns all the suggestions provided to the user, as a mutable list.
   *
   * @return the suggestions
   */
  public List<String> getSuggestions() {
    return suggestions;
  }

  @Override
  public String toString() {
    return "TabCompleteEvent{"
        + "player=" + player
        + ", partialMessage='" + partialMessage + '\''
        + ", suggestions=" + suggestions
        + '}';
  }
}
