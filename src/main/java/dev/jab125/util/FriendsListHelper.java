// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.util;

import dev.jab125.discordsocialsdk.$;
import dev.jab125.discordsocialsdk.pp.Client;
import dev.jab125.discordsocialsdk.pp.RelationshipHandle;
import dev.jab125.discordsocialsdk.pp.RelationshipType;
import dev.jab125.discordsocialsdk.pp.UserHandle;

import static dev.jab125.discordsocialsdk.CDiscord.*;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.ArrayList;
import java.util.List;

public class FriendsListHelper {
	public static void displayFriendsList(Client client) {
		ArrayList<String> strings = new ArrayList<>();
		List<RelationshipHandle> relationshipHandles = client.getRelationships();
		for (RelationshipHandle relationship : relationshipHandles) {
			UserHandle user = relationship.user();
			boolean foundUser = user != null;
			if (!foundUser) {
				continue;
			}
			//System.out.println("A USER WAS FOUND");
			StringBuilder stringBuilder = new StringBuilder();
			{
				stringBuilder.append("DiscordName: ").append(user.displayName()).append(' ');
			}
			{
				stringBuilder.append("DiscordId: ").append(user.id()).append(' ');
			}
			{
				stringBuilder.append("DiscordRelationshipType: ").append(relationTypeToString(relationship.discordRelationshipType()));
			}
			strings.add(stringBuilder.toString());
		}
		for (String string : strings) {
			System.out.println(string);
		}
	}

	private static String relationTypeToString(RelationshipType relationType) {
		return switch (relationType) {
			case NONE -> "None";
			case FRIEND -> "Friend";
			case BLOCKED -> "Blocked";
			case PENDING_INCOMING -> "PendingIncoming";
			case PENDING_OUTGOING -> "PendingOutgoing";
			case IMPLICIT -> "Implicit";
			case SUGGESTION -> "Suggestion";
			default -> "unknown";
		};
	}
	//str += " DiscordName: " + user->DisplayName();
	//        str += " DiscordId: " + std::to_string(user->Id());
	//        // Provisional users don't have a Discord icon shown next to them:
	//        str += " IsProvisional: " + std::to_string(user->IsProvisional());
	//        // Whether the relationship is for a friend, a friend request, or because the user is blocked:
	//        // For a friends list you'll want to filter out blocked users
	//        // And likely display friend requests in a different section
	//        str += " DiscordRelationshipType: " + std::string(discordpp::EnumToString(relationship.DiscordRelationshipType()));
	//        str += " GameRelationshipType: " + std::string(discordpp::EnumToString(relationship.GameRelationshipType()));
	//        // Whether the user is online/offline/etc:
	//        str += " IsOnlineAnywhere: " + std::to_string(user->Status() != discordpp::StatusType::Offline);
	//        str += " IsOnlineInGame: " + std::to_string(user->GameActivity() != std::nullopt);
	//inline const char* EnumToString(discordpp::RelationshipType value)
	//{
	//    switch (value) {
	//    case discordpp::RelationshipType::None:
	//        return "None";
	//    case discordpp::RelationshipType::Friend:
	//        return "Friend";
	//    case discordpp::RelationshipType::Blocked:
	//        return "Blocked";
	//    case discordpp::RelationshipType::PendingIncoming:
	//        return "PendingIncoming";
	//    case discordpp::RelationshipType::PendingOutgoing:
	//        return "PendingOutgoing";
	//    case discordpp::RelationshipType::Implicit:
	//        return "Implicit";
	//    case discordpp::RelationshipType::Suggestion:
	//        return "Suggestion";
	//    default:
	//        return "unknown";
	//    }
	//}
}
