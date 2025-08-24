package dev.jab125.discordsocialsdk.pp;

import dev.jab125.discordsocialsdk.$;
import org.jetbrains.annotations.Nullable;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

import static dev.jab125.discordsocialsdk.CDiscord.*;

public class RelationshipHandle implements PointerWrapper {
	private final @$("Discord_RelationshipHandle*") MemorySegment instance;
	public RelationshipHandle(@$("Discord_RelationshipHandle*") MemorySegment instance) {
		this.instance = instance;
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}

	public long id() {
		return Discord_RelationshipHandle_Id(instance);
	}

	@Nullable
	public UserHandle user() {
		@$("Discord_UserHandle*") MemorySegment user = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		boolean b = Discord_RelationshipHandle_User(instance, user);
		return b ? new UserHandle(user) : null;
	}

	public RelationshipType discordRelationshipType() {
		return RelationshipType.values()[Discord_RelationshipHandle_DiscordRelationshipType(instance)];
	}
	public RelationshipType gameRelationshipType() {
		return RelationshipType.values()[Discord_RelationshipHandle_GameRelationshipType(instance)];
	}
}
