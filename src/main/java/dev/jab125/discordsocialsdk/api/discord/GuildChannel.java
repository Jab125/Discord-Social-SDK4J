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
import static dev.jab125.discordsocialsdk.impl.cdiscord.Discord_GuildChannel.*;

public class GuildChannel implements PointerWrapper {
	private final @$("Discord_GuildChannel*") MemorySegment instance;
	public GuildChannel(@$("Discord_GuildChannel*") MemorySegment instance) {
		this.instance = instance;
	}

	public void drop() {
		Discord_GuildChannel_Drop(instance);
	}
	public long id() {
		return Discord_GuildChannel_Id(instance);
	}
	public void setId(long id) {
		Discord_GuildChannel_SetId(instance, id);
	}
	public String name() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment returnValue = arena.allocate(_Discord_String);
			Discord_GuildChannel_Name(instance, returnValue);
			return _String_Sugar(returnValue);
		}
	}
	public void setName(String name) {
		Discord_GuildChannel_SetName(instance, name);
	}
	public boolean isLinkable() {
		return Discord_GuildChannel_IsLinkable(instance);
	}
	public void setIsLinkable(boolean isLinkable) {
		Discord_GuildChannel_SetIsLinkable(instance, isLinkable);
	}
	public boolean isViewableAndWriteableByAllMembers() {
		return Discord_GuildChannel_IsViewableAndWriteableByAllMembers(instance);
	}
	public void setIsViewableAndWriteableByAllMembers(boolean isViewableAndWriteableByAllMembers) {
		Discord_GuildChannel_SetIsViewableAndWriteableByAllMembers(instance, isViewableAndWriteableByAllMembers);
	}
	// todo Optional<LinkedLobby> linkedLobby();
	// todo void setLinkedLobby(Optional<LinkedLobby> linkedLobby);

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}