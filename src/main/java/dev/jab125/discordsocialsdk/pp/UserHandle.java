package dev.jab125.discordsocialsdk.pp;

import dev.jab125.discordsocialsdk.$;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static dev.jab125.discordsocialsdk.CDiscord.*;

public class UserHandle implements PointerWrapper {
	private final @$("Discord_UserHandle*") MemorySegment instance;
	public UserHandle(@$("Discord_UserHandle*") MemorySegment instance) {
		this.instance = instance;
	}

	public String displayName() {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_String*") MemorySegment displayName = arena.allocate(_Discord_String);
			Discord_UserHandle_DisplayName(instance, displayName);
			return _String_Sugar(displayName);
		}
	}

	public long id() {
		return Discord_UserHandle_Id(instance);
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
