/*
 * Copyright (C) 2021-2022 Velocity Contributors
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

package com.velocitypowered.api.event.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Marks an event as an event the proxy will wait on to completely fire (including any
 * {@link com.velocitypowered.api.event.EventTask}s) before continuing handling it. Annotated
 * classes are suitable candidates for using EventTasks for handling complex asynchronous
 * operations in a non-blocking matter.
 */
@Target(ElementType.TYPE)
@Documented
public @interface AwaitingEvent {

}
