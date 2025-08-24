package dev.jab125.discordsocialsdk.pp;

import dev.jab125.discordsocialsdk.$;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static dev.jab125.discordsocialsdk.CDiscord.*;

public class AuthorizationArgs implements PointerWrapper {
	private final @$("Discord_AuthorizationArgs*") MemorySegment instance;
	public AuthorizationArgs() {
		this.instance = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		Discord_AuthorizationArgs_Init(instance);
	}

	public void setClientId(long clientId) {
		Discord_AuthorizationArgs_SetClientId(instance, clientId);
	}

	public void setScopes(String scopes) {
		Discord_AuthorizationArgs_SetScopes(instance, scopes);
	}

	public void setCodeChallenge(AuthorizationCodeChallenge challenge) {
		Discord_AuthorizationArgs_SetCodeChallenge(instance, challenge.getSegment());
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
