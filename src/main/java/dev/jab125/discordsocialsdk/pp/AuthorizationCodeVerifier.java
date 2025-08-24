package dev.jab125.discordsocialsdk.pp;

import dev.jab125.discordsocialsdk.$;
import dev.jab125.discordsocialsdk.CDiscord;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static dev.jab125.discordsocialsdk.CDiscord.*;

public class AuthorizationCodeVerifier implements PointerWrapper {
	private final @$("Discord_AuthorizationCodeVerifier*") MemorySegment instance;
	public AuthorizationCodeVerifier(@$("Discord_AuthorizationCodeVerifier*") MemorySegment instance) {
		this.instance = instance;
	}

	public AuthorizationCodeChallenge challenge() {
		@$("Discord_AuthorizationCodeChallenge*") MemorySegment challenge = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		Discord_AuthorizationCodeVerifier_Challenge(instance, challenge);
		return new AuthorizationCodeChallenge(challenge);
	}

	public String verifier() {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_String*") MemorySegment string = arena.allocate(CDiscord._Discord_String);
			Discord_AuthorizationCodeVerifier_Verifier(instance, string);
			return _String_Sugar(string);
		}
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
