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

package com.velocitypowered.api.plugin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.velocitypowered.api.plugin.meta.PluginDependency;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Represents metadata for a specific version of a plugin.
 */
public interface PluginDescription {

  /**
   * The pattern plugin IDs must match. Plugin IDs may only contain alphanumeric characters, dashes
   * or underscores, must start with an alphabetic character and cannot be longer than 64
   * characters.
   */
  Pattern ID_PATTERN = Pattern.compile("[a-z][a-z0-9-_]{0,63}");

  /**
   * Gets the qualified ID of the {@link Plugin} within this container.
   *
   * @return the plugin ID
   * @see Plugin#id()
   */
  String getId();

  /**
   * Gets the name of the {@link Plugin} within this container.
   *
   * @return an {@link Optional} with the plugin name, may be empty
   * @see Plugin#name()
   */
  default Optional<String> getName() {
    return Optional.empty();
  }

  /**
   * Gets the version of the {@link Plugin} within this container.
   *
   * @return an {@link Optional} with the plugin version, may be empty
   * @see Plugin#version()
   */
  default Optional<String> getVersion() {
    return Optional.empty();
  }

  /**
   * Gets the description of the {@link Plugin} within this container.
   *
   * @return an {@link Optional} with the plugin description, may be empty
   * @see Plugin#description()
   */
  default Optional<String> getDescription() {
    return Optional.empty();
  }

  /**
   * Gets the url or website of the {@link Plugin} within this container.
   *
   * @return an {@link Optional} with the plugin url, may be empty
   * @see Plugin#url()
   */
  default Optional<String> getUrl() {
    return Optional.empty();
  }

  /**
   * Gets the authors of the {@link Plugin} within this container.
   *
   * @return the plugin authors, may be empty
   * @see Plugin#authors()
   */
  default List<String> getAuthors() {
    return ImmutableList.of();
  }

  /**
   * Gets a {@link Collection} of all dependencies of the {@link Plugin} within this container.
   *
   * @return the plugin dependencies, can be empty
   * @see Plugin#dependencies()
   */
  default Collection<PluginDependency> getDependencies() {
    return ImmutableSet.of();
  }

  default Optional<PluginDependency> getDependency(String id) {
    return Optional.empty();
  }

  /**
   * Returns the source the plugin was loaded from.
   *
   * @return the source the plugin was loaded from or {@link Optional#empty()} if unknown
   */
  default Optional<Path> getSource() {
    return Optional.empty();
  }
}
