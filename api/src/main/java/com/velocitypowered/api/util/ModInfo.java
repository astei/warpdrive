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

package com.velocitypowered.api.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/**
 * Represents the information for a Forge mod list.
 */
public final class ModInfo {

  public static final ModInfo DEFAULT = new ModInfo("FML", ImmutableList.of());

  private final String type;
  private final List<Mod> modList;

  /**
   * Constructs a new ModInfo instance.
   *
   * @param type the Forge server list version to use
   * @param modList the mods to present to the client
   */
  public ModInfo(String type, List<Mod> modList) {
    this.type = Preconditions.checkNotNull(type, "type");
    this.modList = ImmutableList.copyOf(modList);
  }

  public String getType() {
    return type;
  }

  public List<Mod> getMods() {
    return modList;
  }

  @Override
  public String toString() {
    return "ModInfo{"
        + "type='" + type + '\''
        + ", modList=" + modList
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModInfo modInfo = (ModInfo) o;
    return type.equals(modInfo.type) && modList.equals(modInfo.modList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, modList);
  }

  /**
   * Represents a mod to send to the client.
   */
  public static final class Mod {

    @SerializedName("modid")
    private final String id;
    private final String version;

    public Mod(String id, String version) {
      this.id = Preconditions.checkNotNull(id, "id");
      this.version = Preconditions.checkNotNull(version, "version");
    }

    public String getId() {
      return id;
    }

    public String getVersion() {
      return version;
    }

    @Override
    public String toString() {
      return "Mod{"
          + "id='" + id + '\''
          + ", version='" + version + '\''
          + '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Mod mod = (Mod) o;
      return id.equals(mod.id) && version.equals(mod.version);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, version);
    }
  }
}