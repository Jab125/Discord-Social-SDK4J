package dev.jab125.discordsocialsdk.pp;

import dev.jab125.discordsocialsdk.$;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Map;
import java.util.Optional;

import static dev.jab125.discordsocialsdk.CDiscord.*;

public class LobbyHandle implements PointerWrapper {
	private final @$("Discord_LobbyHandle*") MemorySegment instance;
	public LobbyHandle(@$("Discord_LobbyHandle*") MemorySegment instance) {
		this.instance = instance;
	}

	public long id() {
		return Discord_LobbyHandle_Id(instance);
	}

	public Map<String, String> metadata() {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_Properties*") MemorySegment properties = arena.allocate(_Discord_Properties);
			Discord_LobbyHandle_Metadata(instance, properties);
			return _unpack__Discord_Properties(properties);
		}
	}

	public Optional<LinkedChannel> linkedChannel() {
		@$("Discord_LinkedChannel*") MemorySegment returnValue = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		boolean b = Discord_LobbyHandle_LinkedChannel(instance, returnValue);
		if (!b) return Optional.empty();
		return Optional.of(new LinkedChannel(returnValue));
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
