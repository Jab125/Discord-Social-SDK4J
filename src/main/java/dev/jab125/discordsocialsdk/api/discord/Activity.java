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
import java.lang.foreign.ValueLayout;

import static dev.jab125.discordsocialsdk.impl.CDiscord.*;

public class Activity implements PointerWrapper {
	private final @$("Discord_Activity*") MemorySegment instance;
	public Activity() {
		this.instance = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		Discord_Activity_Init(instance);
	}

	/// @deprecated
	public void setApplicationId(long applicationId) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment allocate1 = arena.allocate(ValueLayout.JAVA_LONG);
			allocate1.set(ValueLayout.JAVA_LONG, 0, applicationId);
			Discord_Activity_SetApplicationId(instance, allocate1);
		}
	}

	public void setType(ActivityTypes type) {
		Discord_Activity_SetType(instance, type.ordinal());
	}

	public void setState(String state) {
		Discord_Activity_SetState(instance, state);
	}

	public void setDetails(String details) {
		Discord_Activity_SetDetails(instance, details);
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}

	public enum ActivityTypes {
		PLAYING,
		STREAMING,
		LISTENING,
		WATCHING,
		CUSTOM_STATUS,
		COMPETING,
		HANG_STATUS
	}
}
