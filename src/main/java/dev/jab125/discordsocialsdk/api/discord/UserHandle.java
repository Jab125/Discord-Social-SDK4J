// Copyright 2025-2026 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api.discord;

import dev.jab125.discordsocialsdk.api.$;
import dev.jab125.discordsocialsdk.api.PointerWrapper;
import dev.jab125.discordsocialsdk.impl.CrosshairUtils;
import dev.jab125.discordsocialsdk.impl.c.Discord_Activity;
import dev.jab125.discordsocialsdk.impl.c.Discord_RelationshipHandle;
import dev.jab125.discordsocialsdk.impl.c.Discord_String;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Optional;

import static dev.jab125.discordsocialsdk.impl.c.cdiscord_h.*;

public class UserHandle implements PointerWrapper {
	private final @$("Discord_UserHandle*") MemorySegment instance;
	private final Arena arena;
	@Deprecated(forRemoval = true)
	public UserHandle(@$("Discord_UserHandle*") MemorySegment instance) {
		this(instance, null);
	}
	public UserHandle(@$("Discord_UserHandle*") MemorySegment instance, Arena arena) {
		this.instance = instance;
		this.arena = arena;
	}

	public enum AvatarType {
		GIF,
		WEBP,
		PNG,
		JPEG
	}
	public Optional<String> avatar() {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_String*") MemorySegment displayName = arena.allocate(Discord_String.layout());
			if (!Discord_UserHandle_Avatar(instance, displayName)) return Optional.empty();
			return Optional.of(CrosshairUtils.toJavaString(displayName));
		}
	}
	public static String avatarTypeToString(AvatarType type) {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_String*") MemorySegment segment = arena.allocate(Discord_String.layout());
			Discord_UserHandle_AvatarTypeToString(type.ordinal(), segment);
			return CrosshairUtils.toJavaString(segment);
		}
	}
	public String avatarUrl(AvatarType animatedType, AvatarType staticType) {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_String*") MemorySegment segment = arena.allocate(Discord_String.layout());
			Discord_UserHandle_AvatarUrl(instance, animatedType.ordinal(), staticType.ordinal(), segment);
			return CrosshairUtils.toJavaString(segment);
		}
	}
	public String displayName() {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_String*") MemorySegment displayName = arena.allocate(Discord_String.layout());
			Discord_UserHandle_DisplayName(instance, displayName);
			return CrosshairUtils.toJavaString(displayName);
		}
	}
	public Optional<Activity> gameActivity() {
		MemorySegment memorySegment = Arena.ofAuto().allocate(Discord_Activity.layout());
		if (Discord_UserHandle_GameActivity(instance, memorySegment)) return Optional.of(new Activity(memorySegment));
		return Optional.empty();
	}
	public Optional<String> globalName() {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_String*") MemorySegment string = arena.allocate(Discord_String.layout());
			if (Discord_UserHandle_GlobalName(instance, string)) return Optional.of(CrosshairUtils.toJavaString(string));
			return Optional.empty();
		}
	}
	public long id() {
		return Discord_UserHandle_Id(instance);
	}
	public boolean isProvisional() {
		return Discord_UserHandle_IsProvisional(instance);
	}
	public RelationshipHandle relationship() {
		MemorySegment memorySegment = Arena.ofAuto().allocate(Discord_RelationshipHandle.layout());
		Discord_UserHandle_Relationship(instance, memorySegment);
		return new RelationshipHandle(memorySegment);
	}
	// TODO Status, UserApplicationProfiles
	public String username() {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_String*") MemorySegment string = arena.allocate(Discord_String.layout());
			Discord_UserHandle_Username(instance, string);
			return CrosshairUtils.toJavaString(string);
		}
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
