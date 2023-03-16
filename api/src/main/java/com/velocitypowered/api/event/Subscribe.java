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

package com.velocitypowered.api.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation that indicates that this method can be used to listen for an event from the proxy.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {

  /**
   * The order events will be posted to this listener.
   *
   * @return the order
   */
  PostOrder order() default PostOrder.NORMAL;

  /**
   * Whether the handler must be called asynchronously.
   *
   * <p><strong>This option currently has no effect, but in the future it will. In Velocity 3.0.0,
   * all event handlers run asynchronously by default. You are encouraged to determine whether or
   * not to enable it now. This option is being provided as a migration aid.</strong></p>
   *
   * <p>If this method returns {@code true}, the method is guaranteed to be executed
   * asynchronously. Otherwise, the handler may be executed on the current thread or
   * asynchronously. <strong>This still means you must consider thread-safety in your
   * event listeners</strong> as the "current thread" can and will be different each time.</p>
   *
   * <p>If any method handler targeting an event type is marked with {@code true}, then every
   * handler targeting that event type will be executed asynchronously.</p>
   *
   * @return Requires async
   */
  boolean async() default true;

}
