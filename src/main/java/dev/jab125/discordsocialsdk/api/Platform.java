// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api;

public enum Platform {
	WINDOWS_X86,
	WINDOWS_ARM,
	MACOS,
	LINUX_X86,
	LINUX_ARM,
	PLAYSTATION_5,
	XBOX_SERIES_X,
	XBOX_SERIES_S,
	ANDROID,
	IOS,
	OTHER;

	public boolean isWindows() {
		return this == WINDOWS_X86 || this == WINDOWS_ARM;
	}

	public boolean isLinux() {
		return this == LINUX_X86 || this == LINUX_ARM;
	}

	public boolean isMacOS() {
		return this == MACOS;
	}
}
