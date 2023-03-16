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
import com.velocitypowered.api.network.ProtocolVersion;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.player.ResourcePackInfo;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * This event is fired when the status of a resource pack sent to the player by the server is
 * changed. Depending on the result of this event (which Velocity will wait until completely fired),
 * the player may be kicked from the server.
 */
@AwaitingEvent
public class PlayerResourcePackStatusEvent {

  private final Player player;
  private final Status status;
  private final @MonotonicNonNull ResourcePackInfo packInfo;
  private boolean overwriteKick;

  /**
   * Instantiates this event.
   *
   * @deprecated Use {@link PlayerResourcePackStatusEvent#PlayerResourcePackStatusEvent
   *             (Player, Status, ResourcePackInfo)} instead.
   */
  @Deprecated
  public PlayerResourcePackStatusEvent(Player player, Status status) {
    this.player = Preconditions.checkNotNull(player, "player");
    this.status = Preconditions.checkNotNull(status, "status");
    this.packInfo = null;
  }

  /**
   * Instantiates this event.
   */
  public PlayerResourcePackStatusEvent(Player player, Status status, ResourcePackInfo packInfo) {
    this.player = Preconditions.checkNotNull(player, "player");
    this.status = Preconditions.checkNotNull(status, "status");
    this.packInfo = packInfo;
  }

  /**
   * Returns the player affected by the change in resource pack status.
   *
   * @return the player
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * Returns the new status for the resource pack.
   *
   * @return the new status
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Returns the {@link ResourcePackInfo} this response is for.
   *
   * @return the resource-pack info or null if no request was recorded
   */
  @Nullable
  public ResourcePackInfo getPackInfo() {
    return packInfo;
  }

  /**
   * Gets whether or not to override the kick resulting from
   * {@link ResourcePackInfo#getShouldForce()} being true.
   *
   * @return whether or not to overwrite the result
   */
  public boolean isOverwriteKick() {
    return overwriteKick;
  }

  /**
   * Set to true to prevent {@link ResourcePackInfo#getShouldForce()}
   * from kicking the player.
   * Overwriting this kick is only possible on versions older than 1.17,
   * as the client or server will enforce this regardless. Cancelling the resulting
   * kick-events will not prevent the player from disconnecting from the proxy.
   *
   * @param overwriteKick whether or not to cancel the kick
   * @throws IllegalArgumentException if the player version is 1.17 or newer
   */
  public void setOverwriteKick(boolean overwriteKick) {
    Preconditions.checkArgument(player.getProtocolVersion()
            .compareTo(ProtocolVersion.MINECRAFT_1_17) < 0,
            "overwriteKick is not supported on 1.17 or newer");
    this.overwriteKick = overwriteKick;
  }

  @Override
  public String toString() {
    return "PlayerResourcePackStatusEvent{"
        + "player=" + player
        + ", status=" + status
        + ", packInfo=" + packInfo
        + '}';
  }

  /**
   * Represents the possible statuses for the resource pack.
   */
  public enum Status {
    /**
     * The resource pack was applied successfully.
     */
    SUCCESSFUL,
    /**
     * The player declined to download the resource pack.
     */
    DECLINED,
    /**
     * The player could not download the resource pack.
     */
    FAILED_DOWNLOAD,
    /**
     * The player has accepted the resource pack and is now downloading it.
     */
    ACCEPTED
  }
}
