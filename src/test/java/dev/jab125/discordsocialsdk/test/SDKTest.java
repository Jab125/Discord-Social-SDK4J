// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.test;
import dev.jab125.discordsocialsdk.api.DiscordNatives;
import dev.jab125.discordsocialsdk.api.NativesDiscoverer;
import dev.jab125.discordsocialsdk.api.Platform;
import dev.jab125.discordsocialsdk.api.discord.Client;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SDKTest {
	NativesDiscoverer FIND_TESTING_NATIVES = new NativesDiscoverer() {
		@Override
		public Path getLibraryPath(Platform platform) throws Throwable {
			String path = switch (platform) {
				case MACOS -> "/osx/libdiscord_partner_sdk.dylib";
				case WINDOWS_X86 -> "/windows/discord_partner_sdk.dll";
				case WINDOWS_ARM -> "/windows/discord_partner_sdk_arm.dll";
				case LINUX_X86, LINUX_ARM ->
						"/linux/libdiscord_partner_sdk.so"; // TODO someone let me know if it doesn't work on ARM
				default -> throw new Exception("Library for " + platform + " not supported!");
			};
			return Path.of("testingnatives" + path);
		}

		@Override
		public void error(Throwable t) {
			throw new RuntimeException(t);
		}
	};
	@Test
	public void test() {
		try {
			if (!DiscordNatives.loadNatives(FIND_TESTING_NATIVES)) throw new Error("Failed to initialize natives!");
		} catch (Throwable e) {
			throw new Error("Failed to initialize natives!", e);
		}

		System.out.println("🚀 Initializing Discord SDK...");
		Client client = new Client();
		String socialSdkVersion = "%s.%s.%s".formatted(client.getVersionMajor(), client.getVersionMinor(), client.getVersionPatch());
		System.out.println("Discord Social SDK version is: " + socialSdkVersion);
		assertEquals("1.5.10839", socialSdkVersion);
	}
}
