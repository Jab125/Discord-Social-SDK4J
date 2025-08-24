package dev.jab125.discordsocialsdk.pp;

import dev.jab125.discordsocialsdk.$;

import java.lang.foreign.MemorySegment;

import static dev.jab125.discordsocialsdk.CDiscord.*;

public class AuthorizationCodeChallenge implements PointerWrapper {
	private final @$("Discord_AuthorizationCodeChallenge*") MemorySegment instance;
	public AuthorizationCodeChallenge(@$("Discord_AuthorizationCodeChallenge*") MemorySegment instance) {
		this.instance = instance;
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
