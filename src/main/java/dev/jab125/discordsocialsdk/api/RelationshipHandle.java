// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api;

import dev.jab125.discordsocialsdk.$;
import org.jetbrains.annotations.Nullable;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static dev.jab125.discordsocialsdk.impl.CDiscord.*;

public class RelationshipHandle implements PointerWrapper {
	private final @$("Discord_RelationshipHandle*") MemorySegment instance;
	public RelationshipHandle(@$("Discord_RelationshipHandle*") MemorySegment instance) {
		this.instance = instance;
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}

	public long id() {
		return Discord_RelationshipHandle_Id(instance);
	}

	@Nullable
	public UserHandle user() {
		@$("Discord_UserHandle*") MemorySegment user = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		boolean b = Discord_RelationshipHandle_User(instance, user);
		return b ? new UserHandle(user) : null;
	}

	public RelationshipType discordRelationshipType() {
		return RelationshipType.values()[Discord_RelationshipHandle_DiscordRelationshipType(instance)];
	}
	public RelationshipType gameRelationshipType() {
		return RelationshipType.values()[Discord_RelationshipHandle_GameRelationshipType(instance)];
	}
}
