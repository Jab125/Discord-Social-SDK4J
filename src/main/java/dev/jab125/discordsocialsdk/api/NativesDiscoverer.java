package dev.jab125.discordsocialsdk.api;


import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@FunctionalInterface
public interface NativesDiscoverer {
	NativesDiscoverer FIND_WITHIN_THIS_LIBRARY = platform -> {
		String path = switch (platform) {
			case MACOS -> "/osx/libdiscord_partner_sdk.dylib";
			case WINDOWS_X86 -> "/windows/discord_partner_sdk.dll";
			case WINDOWS_ARM -> "/windows/discord_partner_sdk_arm.dll";
			case LINUX_X86, LINUX_ARM -> "/linux/libdiscord_partner_sdk.so"; // TODO someone let me know if it doesn't work on ARM
			default -> throw new Exception("Library for " + platform + " not supported!");
		};
		Path tempFile = Files.createTempFile("l", "." + path.split("\\.")[1]);
		try {
			Files.copy(Objects.requireNonNull(NativesDiscoverer.class.getResourceAsStream(path)), tempFile, StandardCopyOption.REPLACE_EXISTING);
		} catch (Throwable t) {
			throw new Error("Failed to find " + platform + "! Please compile the JAR with the natives bundled.");
		}
		return tempFile;
	};

	@NotNull Path getLibraryPath(@NotNull Platform platform) throws Throwable;

	@SuppressWarnings("CallToPrintStackTrace")
	default void error(Throwable t) {
		t.printStackTrace();
	}

	// 	private static String name() {
	//		String property = System.getProperty("os.name");
	//		System.out.println(property);
	//		System.out.println(System.getProperty("os.arch"));
	//		if (property.toLowerCase(Locale.ROOT).contains("mac")) return "/osx/libdiscord_partner_sdk.dylib";
	//		if (property.toLowerCase(Locale.ROOT).contains("windows")) return (System.getProperty("os.arch").toLowerCase(Locale.ROOT).contains("arm") || System.getProperty("os.arch").toLowerCase(Locale.ROOT).contains("arch")) ? "/windows/discord_partner_sdk_arm.dll" : "/windows/discord_partner_sdk.dll";
	//		else return "/linux/libdiscord_partner_sdk.so";
	//	}
}
