package dev.jab125.discordsocialsdk.pp;

import dev.jab125.discordsocialsdk.$;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static dev.jab125.discordsocialsdk.CDiscord.*;

public class Activity implements PointerWrapper {
	private final @$("Discord_Activity*") MemorySegment instance;
	public Activity() {
		this.instance = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		Discord_Activity_Init(instance);
	}

	/// @deprecated
	public void setApplicationId(long applicationId) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment allocate1 = arena.allocate(ValueLayout.JAVA_LONG);
			allocate1.set(ValueLayout.JAVA_LONG, 0, applicationId);
			Discord_Activity_SetApplicationId(instance, allocate1);
		}
	}

	public void setType(ActivityTypes type) {
		Discord_Activity_SetType(instance, type.ordinal());
	}

	public void setState(String state) {
		Discord_Activity_SetState(instance, state);
	}

	public void setDetails(String details) {
		Discord_Activity_SetDetails(instance, details);
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}

	public enum ActivityTypes {
		PLAYING,
		STREAMING,
		LISTENING,
		WATCHING,
		CUSTOM_STATUS,
		COMPETING,
		HANG_STATUS
	}
}
