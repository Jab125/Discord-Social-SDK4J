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
