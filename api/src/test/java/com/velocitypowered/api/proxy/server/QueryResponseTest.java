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

package com.velocitypowered.api.proxy.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.collect.ImmutableList;
import com.velocitypowered.api.proxy.server.QueryResponse.PluginInformation;
import org.junit.jupiter.api.Test;

class QueryResponseTest {

  @Test
  void toBuilderConsistency() {
    QueryResponse response = new QueryResponse("test", "test", "test",
        1, 2, "test", 1234, ImmutableList.of("tuxed"),
        "0.0.1", ImmutableList.of(new PluginInformation("test", "1.0.0"),
          new PluginInformation("test2", null)));
    assertEquals(response, response.toBuilder().build());
  }
}
