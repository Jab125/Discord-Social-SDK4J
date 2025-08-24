package dev.jab125.discordsocialsdk.pp;

import dev.jab125.discordsocialsdk.$;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static dev.jab125.discordsocialsdk.CDiscord.*;

public class LinkedChannel implements PointerWrapper {
	private final @$("Discord_LinkedChannel*") MemorySegment instance;
	public LinkedChannel(@$("Discord_LinkedChannel*") MemorySegment instance) {
		this.instance = instance;
	}

	public String name() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment returnValue = arena.allocate(_Discord_String);
			Discord_LinkedChannel_Name(instance, returnValue);
			return _String_Sugar(returnValue);
		}
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
