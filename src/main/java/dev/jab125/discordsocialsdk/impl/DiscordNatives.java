// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.impl;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Locale;

// Deprecated only to discourage usage
@Deprecated(forRemoval = true)
public class DiscordNatives {
	private static Path nativeLibraryPath;
	static final Linker LINKER = Linker.nativeLinker();

	@Deprecated(forRemoval = true)
	public static void loadNatives0() throws Throwable {
		nativeLibraryPath = Files.createTempFile("l", "." + name().split("\\.")[1]);
		try {
			Files.copy(DiscordNatives.class.getResourceAsStream(name()), nativeLibraryPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Throwable t) {
			throw new Error("Failed to find " + name() + "! Please compile the JAR with the natives bundled.");
		}
		System.load(nativeLibraryPath.toAbsolutePath().toString());
	}

	private static String name() {
		String property = System.getProperty("os.name");
		System.out.println(property);
		System.out.println(System.getProperty("os.arch"));
		if (property.toLowerCase(Locale.ROOT).contains("mac")) return "/osx/libdiscord_partner_sdk.dylib";
		if (property.toLowerCase(Locale.ROOT).contains("windows")) return (System.getProperty("os.arch").toLowerCase(Locale.ROOT).contains("arm") || System.getProperty("os.arch").toLowerCase(Locale.ROOT).contains("arch")) ? "/windows/discord_partner_sdk_arm.dll" : "/windows/discord_partner_sdk.dll";
		else return "/linux/libdiscord_partner_sdk.so";
	}

	@Deprecated(forRemoval = true)
	public static SymbolLookup lookup(Arena arena) {
		return SymbolLookup.libraryLookup(nativeLibraryPath, arena);
	}
}
