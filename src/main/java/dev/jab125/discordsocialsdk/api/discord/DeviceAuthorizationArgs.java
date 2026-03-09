// Copyright 2025-2026 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api.discord;

import dev.jab125.discordsocialsdk.api.$;
import dev.jab125.discordsocialsdk.api.PointerWrapper;
import dev.jab125.discordsocialsdk.impl.CrosshairUtils;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static dev.jab125.discordsocialsdk.impl.c.cdiscord_h.Discord_DeviceAuthorizationArgs_Init;

public class DeviceAuthorizationArgs implements PointerWrapper {
	private final @$("Discord_DeviceAuthorizationArgs*") MemorySegment instance;
	public DeviceAuthorizationArgs() {
		this.instance = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		Discord_DeviceAuthorizationArgs_Init(instance);
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
