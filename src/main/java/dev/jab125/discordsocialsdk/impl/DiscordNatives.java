// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.impl;

import dev.jab125.discordsocialsdk.api.NativesDiscoverer;
import dev.jab125.discordsocialsdk.api.Platform;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.nio.file.Path;
import java.util.Locale;

// Deprecated only to discourage usage
@SuppressWarnings("DeprecatedIsStillUsed")
@Deprecated(forRemoval = true)
public class DiscordNatives {
	private static Path nativeLibraryPath;
	static final Linker LINKER = Linker.nativeLinker();
	private static final Platform platform;

	@Deprecated(forRemoval = true)
	public static boolean loadNatives0(NativesDiscoverer discoverer) {
		try {
			nativeLibraryPath = discoverer.getLibraryPath(platform);
			System.load(nativeLibraryPath.toAbsolutePath().toString());
			return true;
		} catch (Throwable t) {
			discoverer.error(t);
			return false;
		}
	}

	@Deprecated(forRemoval = true)
	public static SymbolLookup lookup(Arena arena) {
		return SymbolLookup.libraryLookup(nativeLibraryPath, arena);
	}

	static {
		String osName = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
		String arch = System.getProperty("os.arch", "").toLowerCase(Locale.ROOT);
		if (osName.contains("mac")) platform = Platform.MACOS;
		else if (osName.contains("windows")) platform = arch.contains("arm") ? Platform.WINDOWS_ARM : Platform.WINDOWS_X86;
		else if (osName.contains("linux")) platform = arch.contains("arm") ? Platform.LINUX_ARM : Platform.LINUX_X86;
		else platform = Platform.OTHER;
	}

}
