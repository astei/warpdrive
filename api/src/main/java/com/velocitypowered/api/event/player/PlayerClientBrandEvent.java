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

package com.velocitypowered.api.event.player;

import com.google.common.base.Preconditions;
import com.velocitypowered.api.proxy.Player;

/**
 * Fired when a {@link Player} sends the <code>minecraft:brand</code> plugin message. Velocity will
 * not wait on the result of this event.
 */
public final class PlayerClientBrandEvent {
  private final Player player;
  private final String brand;

  /**
   * Creates a new instance.
   *
   * @param player the {@link Player} of the sent client brand
   * @param brand the sent client brand
   */
  public PlayerClientBrandEvent(Player player, String brand) {
    this.player = Preconditions.checkNotNull(player);
    this.brand = Preconditions.checkNotNull(brand);
  }

  public Player getPlayer() {
    return player;
  }

  public String getBrand() {
    return brand;
  }

  @Override
  public String toString() {
    return "PlayerClientBrandEvent{"
      + "player=" + player
      + ", brand='" + brand + '\''
      + '}';
  }
}

