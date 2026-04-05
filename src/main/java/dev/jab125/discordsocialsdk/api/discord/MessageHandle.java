// Copyright 2025-2026 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api.discord;

import dev.jab125.discordsocialsdk.api.$;
import dev.jab125.discordsocialsdk.api.PointerWrapper;
import dev.jab125.discordsocialsdk.impl.CrosshairUtils;
import dev.jab125.discordsocialsdk.impl.c.Discord_String;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Optional;

import static dev.jab125.discordsocialsdk.impl.c.cdiscord_h.*;

public class MessageHandle implements PointerWrapper {
	private final @$("Discord_MessageHandle*") MemorySegment instance;
	public MessageHandle(@$("Discord_MessageHandle*") MemorySegment instance) {
		this.instance = instance;
	}

	public void drop() {
		Discord_MessageHandle_Drop(instance);
	}
	// TODO additionalContent()
	public long applicationId() {
		try (Arena arena = Arena.ofConfined()) {
			@$("uint64_t*") MemorySegment returnValue = arena.allocate(ValueLayout.JAVA_LONG);
			Discord_MessageHandle_ApplicationId(instance, returnValue);
			return returnValue.get(ValueLayout.JAVA_LONG, 0);
		}
	}
	public Optional<UserHandle> author() {
		Arena arena = Arena.ofAuto();
		@$("Discord_UserHandle*") MemorySegment returnValue = arena.allocate(ValueLayout.ADDRESS);
		boolean b = Discord_MessageHandle_Author(instance, returnValue);
		if (!b) return Optional.empty();
		return Optional.of(new UserHandle(returnValue, arena));
	}
	public long authorId() {
		return Discord_MessageHandle_AuthorId(instance);
	}
	// TODO channel
	public long channelId() {
		return Discord_MessageHandle_ChannelId(instance);
	}
	public String content() {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_String*") MemorySegment string = arena.allocate(Discord_String.layout());
			Discord_MessageHandle_Content(instance, string);
			return CrosshairUtils.toJavaString(string);
		}
	}
	// TODO disclosureTypes
	public long editedTimestamp() {
		return Discord_MessageHandle_EditedTimestamp(instance);
	}
	public long id() {
		return Discord_MessageHandle_Id(instance);
	}
	public Optional<LobbyHandle> lobby() {
		@$("Discord_LobbyHandle*") MemorySegment lobby = Arena.ofAuto().allocate(Discord_String.layout());
		boolean b = Discord_MessageHandle_Lobby(instance, lobby);
		if (!b) return Optional.empty();
		return Optional.of(new LobbyHandle(lobby));
	}
	// todo metadata
	public String rawContent() {
		try (Arena arena = Arena.ofConfined()) {
			@$("Discord_String*") MemorySegment string = arena.allocate(Discord_String.layout());
			Discord_MessageHandle_RawContent(instance, string);
			return CrosshairUtils.toJavaString(string);
		}
	}
	public Optional<UserHandle> recipient() {
		Arena arena = Arena.ofAuto();
		@$("Discord_UserHandle*") MemorySegment returnValue = arena.allocate(ValueLayout.ADDRESS);
		boolean b = Discord_MessageHandle_Recipient(instance, returnValue);
		if (!b) return Optional.empty();
		return Optional.of(new UserHandle(returnValue, arena));
	}
	public long recipientId() {
		return Discord_MessageHandle_RecipientId(instance);
	}
	public boolean sentFromGame() {
		return Discord_MessageHandle_SentFromGame(instance);
	}
	public long sentTimestamp() {
		return Discord_MessageHandle_SentTimestamp(instance);
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
//    /// \cond
//    void Drop();
//    /// \endcond
//
//    /// \brief If the message contains non-text content, such as images, videos, embeds, polls, etc,
//    /// this method will return information about that content.
//    std::optional<discordpp::AdditionalContent> AdditionalContent() const;
//
//    /// \brief Returns the application ID associated with this message, if any. You can use
//    /// this to identify if the mesage was sent from another child application in
//    /// your catalog.
//    ///
//    /// Note: Parent / child applications are in limited access and the SentFromGame
//    /// field should be relied on for the common case.
//    std::optional<uint64_t> ApplicationId() const;
//
//    /// \brief Returns the UserHandle for the author of this message.
//    std::optional<discordpp::UserHandle> Author() const;
//
//    /// \brief Returns the user ID of the user who sent this message.
//    uint64_t AuthorId() const;
//
//    /// \brief Returns the ChannelHandle for the channel this message was sent in.
//    std::optional<discordpp::ChannelHandle> Channel() const;
//
//    /// \brief Returns the channel ID this message was sent in.
//    uint64_t ChannelId() const;
//
//    /// \brief Returns the content of this message, if any.
//    ///
//    /// A message can be blank if it was sent from Discord but only contains content such as image
//    /// attachments. Certain types of markup, such as markup for emojis and mentions, will be auto
//    /// replaced with a more human readable form, such as `@username` or `:emoji_name:`.
//    std::string Content() const;
//
//    /// \brief If this is an auto-generated message that is explaining some integration behavior to
//    /// users, this method will return the type of disclosure so you can customize it.
//    std::optional<discordpp::DisclosureTypes> DisclosureType() const;
//
//    /// \brief The timestamp in millis since the epoch when the message was most recently edited.
//    ///
//    /// Returns 0 if the message has not been edited yet.
//    uint64_t EditedTimestamp() const;
//
//    /// \brief Returns the ID of this message.
//    uint64_t Id() const;
//
//    /// \brief Returns the LobbyHandle this message was sent in, if it was sent in a lobby.
//    std::optional<discordpp::LobbyHandle> Lobby() const;
//
//    /// \brief Returns any metadata the developer included with this message.
//    ///
//    /// Metadata is just a set of simple string key/value pairs.
//    /// An example use case might be to include a character name so you can customize how a message
//    /// renders in game.
//    std::unordered_map<std::string, std::string> Metadata() const;
//
//    /// \brief Returns the content of this message, if any, but without replacing any markup from
//    /// emojis and mentions.
//    ///
//    /// A message can be blank if it was sent from Discord but only contains content such as image
//    /// attachments.
//    std::string RawContent() const;
//
//    /// \brief Returns the UserHandle for the other participant in a DM, if this message was sent in
//    /// a DM.
//    std::optional<discordpp::UserHandle> Recipient() const;
//
//    /// \brief When this message was sent in a DM or Ephemeral DM, this method will return the ID of
//    /// the other user in that DM.
//    uint64_t RecipientId() const;
//
//    /// \brief Returns true if this message was sent in-game, otherwise false (i.e. from Discord
//    /// itself). If you are using parent / child applications, this will be true if the message was
//    /// sent from any child application.
//    bool SentFromGame() const;
//
//    /// \brief The timestamp in millis since the epoch when the message was sent.
//    uint64_t SentTimestamp() const;