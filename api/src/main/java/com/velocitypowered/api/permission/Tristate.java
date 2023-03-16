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

package com.velocitypowered.api.permission;

import net.kyori.adventure.util.TriState;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Represents three different states of a setting.
 *
 * <p>Possible values:</p>
 * <p></p>
 * <ul>
 * <li>{@link #TRUE} - a positive setting</li>
 * <li>{@link #FALSE} - a negative (negated) setting</li>
 * <li>{@link #UNDEFINED} - a non-existent setting</li>
 * </ul>
 */
public enum Tristate {

  /**
   * A value indicating a positive setting.
   */
  TRUE(true),

  /**
   * A value indicating a negative (negated) setting.
   */
  FALSE(false),

  /**
   * A value indicating a non-existent setting.
   */
  UNDEFINED(false);

  /**
   * Returns a {@link Tristate} from a boolean.
   *
   * @param val the boolean value
   * @return {@link #TRUE} or {@link #FALSE}, if the value is <code>true</code> or
   *     <code>false</code>, respectively.
   */
  public static Tristate fromBoolean(boolean val) {
    return val ? TRUE : FALSE;
  }

  /**
   * Returns a {@link Tristate} from a nullable boolean.
   *
   * <p>Unlike {@link #fromBoolean(boolean)}, this method returns {@link #UNDEFINED}
   * if the value is null.</p>
   *
   * @param val the boolean value
   * @return {@link #UNDEFINED}, {@link #TRUE} or {@link #FALSE}, if the value is <code>null</code>,
   *     <code>true</code> or <code>false</code>, respectively.
   */
  public static Tristate fromNullableBoolean(@Nullable Boolean val) {
    if (val == null) {
      return UNDEFINED;
    }
    return val ? TRUE : FALSE;
  }

  private final boolean booleanValue;

  Tristate(boolean booleanValue) {
    this.booleanValue = booleanValue;
  }

  /**
   * Returns the value of the Tristate as a boolean.
   *
   * <p>A value of {@link #UNDEFINED} converts to false.</p>
   *
   * @return a boolean representation of the Tristate.
   */
  public boolean asBoolean() {
    return this.booleanValue;
  }

  /**
   * Returns the equivalent Adventure {@link TriState}.
   *
   * @return equivalent Adventure TriState
   */
  public TriState toAdventureTriState() {
    if (this == Tristate.TRUE) {
      return TriState.TRUE;
    } else if (this == Tristate.UNDEFINED) {
      return TriState.NOT_SET;
    } else if (this == Tristate.FALSE) {
      return TriState.FALSE;
    } else {
      throw new IllegalArgumentException();
    }
  }
}
