// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api.discord;

import dev.jab125.discordsocialsdk.api.$;
import dev.jab125.discordsocialsdk.api.PointerWrapper;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static dev.jab125.discordsocialsdk.impl.CDiscord.*;
import static dev.jab125.discordsocialsdk.impl.cdiscord.Discord_GuildMinimal.*;

public class GuildMinimal implements PointerWrapper {
	private final @$("Discord_GuildMinimal*") MemorySegment instance;
	public GuildMinimal(@$("Discord_GuildMinimal*") MemorySegment instance) {
		this.instance = instance;
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}

	public void drop() {
		Discord_GuildMinimal_Drop(instance);
	}
	public long id() {
		return Discord_GuildMinimal_Id(instance);
	}
	public void setId(long id) {
		Discord_GuildMinimal_SetId(instance, id);
	}
	public String name() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment returnValue = arena.allocate(_Discord_String);
			Discord_GuildMinimal_Name(instance, returnValue);
			return _String_Sugar(returnValue);
		}
	}
	public void setName(String name) {
		Discord_GuildMinimal_SetName(instance, name);
	}
}