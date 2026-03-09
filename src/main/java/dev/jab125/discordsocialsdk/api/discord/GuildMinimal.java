// Copyright 2025-2026 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api.discord;

import dev.jab125.discordsocialsdk.api.$;
import dev.jab125.discordsocialsdk.api.PointerWrapper;
import dev.jab125.discordsocialsdk.impl.CrosshairUtils;
import dev.jab125.discordsocialsdk.impl.c.Discord_String;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static dev.jab125.discordsocialsdk.impl.c.cdiscord_h.*;
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
			MemorySegment returnValue = arena.allocate(Discord_String.layout());
			Discord_GuildMinimal_Name(instance, returnValue);
			return CrosshairUtils.toJavaString(returnValue);
		}
	}
	public void setName(String name) {
		Discord_GuildMinimal_SetName(instance, CrosshairUtils.toDiscordString(name));
	}
}