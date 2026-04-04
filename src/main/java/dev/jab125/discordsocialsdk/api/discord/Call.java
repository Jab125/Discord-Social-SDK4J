// Copyright 2026 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api.discord;

import dev.jab125.discordsocialsdk.api.$;
import dev.jab125.discordsocialsdk.api.PointerWrapper;
import org.jetbrains.annotations.Nullable;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public class Call implements PointerWrapper {
	private final @Nullable Arena arena;
	private final @$("Discord_Call*") MemorySegment instance;
	public Call(MemorySegment segment, Arena arena) {
		this.instance = segment;
		this.arena = arena;
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
