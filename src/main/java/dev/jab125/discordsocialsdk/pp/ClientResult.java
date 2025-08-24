package dev.jab125.discordsocialsdk.pp;

import dev.jab125.discordsocialsdk.$;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

import static dev.jab125.discordsocialsdk.CDiscord.*;

public class ClientResult implements PointerWrapper {
	private final @$("Discord_ClientResult*") MemorySegment instance;
	public ClientResult(@$("Discord_ClientResult*") MemorySegment instance) {
		this.instance = instance;
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}

	public boolean successful() {
		return Discord_ClientResult_Successful(instance);
	}

	public String error() {
		@$("Discord_String*") MemorySegment error = Arena.ofAuto().allocate(_Discord_String);
		Discord_ClientResult_Error(instance, error);
		return _String_Sugar(error);
	}
}
