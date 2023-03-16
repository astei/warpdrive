/*
 * Copyright (C) 2021 Velocity Contributors
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

package com.velocitypowered.api.event;

/**
 * Represents a continuation of a paused event handler. Any of the resume methods
 * may only be called once otherwise an {@link IllegalStateException} is expected.
 */
public interface Continuation {

  /**
   * Resumes the continuation.
   */
  void resume();

  /**
   * Resumes the continuation after the executed task failed.
   */
  void resumeWithException(Throwable exception);
}