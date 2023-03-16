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

package com.velocitypowered.api.scheduler;

import org.jetbrains.annotations.NotNull;

/**
 * Represents a task that is scheduled to run on the proxy.
 */
public interface ScheduledTask {

  /**
   * Returns the plugin that scheduled this task.
   *
   * @return the plugin that scheduled this task
   */
  @NotNull Object plugin();

  /**
   * Returns the current status of this task.
   *
   * @return the current status of this task
   */
  TaskStatus status();

  /**
   * Cancels this task. If the task is already running, the thread in which it is running will be
   * interrupted. If the task is not currently running, Velocity will terminate it safely.
   */
  void cancel();
}
