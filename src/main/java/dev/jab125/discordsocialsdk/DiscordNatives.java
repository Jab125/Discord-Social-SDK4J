package dev.jab125.discordsocialsdk;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.SymbolLookup;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Locale;

public class DiscordNatives {
	private static Path nativeLibraryPath;
	static final Linker LINKER = Linker.nativeLinker();

	public static void loadNatives() throws Throwable {
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

	public static SymbolLookup lookup(Arena arena) {
		return SymbolLookup.libraryLookup(nativeLibraryPath, arena);
	}
}
