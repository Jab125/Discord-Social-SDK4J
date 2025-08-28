// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api;

import dev.jab125.discordsocialsdk.$;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Map;
import java.util.Optional;

import static dev.jab125.discordsocialsdk.impl.CDiscord.*;

public class LobbyHandle implements PointerWrapper {
	private final @$("Discord_LobbyHandle*") MemorySegment instance;
	public LobbyHandle(@$("Discord_LobbyHandle*") MemorySegment instance) {
		this.instance = instance;
	}

	public long id() {
		return Discord_LobbyHandle_Id(instance);
	}

	public Map<String, String> metadata() {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_Properties*") MemorySegment properties = arena.allocate(_Discord_Properties);
			Discord_LobbyHandle_Metadata(instance, properties);
			return _unpack__Discord_Properties(properties);
		}
	}

	public Optional<LinkedChannel> linkedChannel() {
		@$("Discord_LinkedChannel*") MemorySegment returnValue = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		boolean b = Discord_LobbyHandle_LinkedChannel(instance, returnValue);
		if (!b) return Optional.empty();
		return Optional.of(new LinkedChannel(returnValue));
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
