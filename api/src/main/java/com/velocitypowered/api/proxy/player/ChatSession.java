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

package com.velocitypowered.api.proxy.player;

import com.velocitypowered.api.proxy.crypto.KeyIdentifiable;
import java.util.UUID;

/**
 * Represents a chat session held by a player.
 */
public interface ChatSession extends KeyIdentifiable {
  /**
   * Returns the {@link UUID} of the session.
   *
   * @return the session UUID
   */
  UUID getSessionId();
}
