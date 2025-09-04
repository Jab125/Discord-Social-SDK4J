// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.impl.cdiscord;

import dev.jab125.discordsocialsdk.api.$;
import dev.jab125.discordsocialsdk.impl.CDiscord.Discord_FreeFn;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static dev.jab125.discordsocialsdk.impl.CDiscord.*;
import static dev.jab125.discordsocialsdk.impl.DiscordNatives.LINKER;

//void DISCORD_API Discord_Client_Init(Discord_Client* self);
//void DISCORD_API Discord_Client_InitWithBases(Discord_Client* self,
//void DISCORD_API Discord_Client_InitWithOptions(Discord_Client* self,
//void DISCORD_API Discord_Client_Drop(Discord_Client* self);
//void DISCORD_API Discord_Client_ErrorToString(Discord_Client_Error type,
//uint64_t DISCORD_API Discord_Client_GetApplicationId(Discord_Client* self);
//void DISCORD_API Discord_Client_GetDefaultAudioDeviceId(Discord_String* returnValue);
//void DISCORD_API Discord_Client_GetDefaultCommunicationScopes(Discord_String* returnValue);
//void DISCORD_API Discord_Client_GetDefaultPresenceScopes(Discord_String* returnValue);
//void DISCORD_API Discord_Client_GetVersionHash(Discord_String* returnValue);
//int32_t DISCORD_API Discord_Client_GetVersionMajor();
//int32_t DISCORD_API Discord_Client_GetVersionMinor();
//int32_t DISCORD_API Discord_Client_GetVersionPatch();
//void DISCORD_API Discord_Client_SetHttpRequestTimeout(Discord_Client* self,
//void DISCORD_API Discord_Client_StatusToString(Discord_Client_Status type,
//void DISCORD_API Discord_Client_ThreadToString(Discord_Client_Thread type,
//void DISCORD_API Discord_Client_EndCall(Discord_Client* self,
//void DISCORD_API Discord_Client_EndCalls(Discord_Client* self,
//bool DISCORD_API Discord_Client_GetCall(Discord_Client* self,
//void DISCORD_API Discord_Client_GetCalls(Discord_Client* self, Discord_CallSpan* returnValue);
//void DISCORD_API Discord_Client_GetCurrentInputDevice(Discord_Client* self,
//void DISCORD_API Discord_Client_GetCurrentOutputDevice(Discord_Client* self,
//void DISCORD_API Discord_Client_GetInputDevices(Discord_Client* self,
//float DISCORD_API Discord_Client_GetInputVolume(Discord_Client* self);
//void DISCORD_API Discord_Client_GetOutputDevices(Discord_Client* self,
//float DISCORD_API Discord_Client_GetOutputVolume(Discord_Client* self);
//bool DISCORD_API Discord_Client_GetSelfDeafAll(Discord_Client* self);
//bool DISCORD_API Discord_Client_GetSelfMuteAll(Discord_Client* self);
//void DISCORD_API Discord_Client_SetAecDump(Discord_Client* self, bool on);
//void DISCORD_API Discord_Client_SetAutomaticGainControl(Discord_Client* self, bool on);
//void DISCORD_API Discord_Client_SetDeviceChangeCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetEchoCancellation(Discord_Client* self, bool on);
//void DISCORD_API Discord_Client_SetEngineManagedAudioSession(Discord_Client* self,
//void DISCORD_API Discord_Client_SetInputDevice(Discord_Client* self,
//void DISCORD_API Discord_Client_SetInputVolume(Discord_Client* self, float inputVolume);
//void DISCORD_API Discord_Client_SetNoAudioInputCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetNoAudioInputThreshold(Discord_Client* self, float dBFSThreshold);
//void DISCORD_API Discord_Client_SetNoiseSuppression(Discord_Client* self, bool on);
//void DISCORD_API Discord_Client_SetOpusHardwareCoding(Discord_Client* self,
//void DISCORD_API Discord_Client_SetOutputDevice(Discord_Client* self,
//void DISCORD_API Discord_Client_SetOutputVolume(Discord_Client* self, float outputVolume);
//void DISCORD_API Discord_Client_SetSelfDeafAll(Discord_Client* self, bool deaf);
//void DISCORD_API Discord_Client_SetSelfMuteAll(Discord_Client* self, bool mute);
//bool DISCORD_API Discord_Client_SetSpeakerMode(Discord_Client* self, bool speakerMode);
//void DISCORD_API Discord_Client_SetThreadPriority(Discord_Client* self,
//void DISCORD_API Discord_Client_SetVoiceParticipantChangedCallback(Discord_Client* self,
//bool DISCORD_API Discord_Client_ShowAudioRoutePicker(Discord_Client* self);
//bool DISCORD_API Discord_Client_StartCall(Discord_Client* self,
//bool DISCORD_API Discord_Client_StartCallWithAudioCallbacks(Discord_Client* self,
//void DISCORD_API Discord_Client_AbortAuthorize(Discord_Client* self);
//void DISCORD_API Discord_Client_AbortGetTokenFromDevice(Discord_Client* self);
//void DISCORD_API Discord_Client_Authorize(Discord_Client* self,
//void DISCORD_API Discord_Client_CloseAuthorizeDeviceScreen(Discord_Client* self);
//void DISCORD_API Discord_Client_CreateAuthorizationCodeVerifier(Discord_Client* self,
//void DISCORD_API Discord_Client_ExchangeChildToken(Discord_Client* self,
//void DISCORD_API Discord_Client_FetchCurrentUser(Discord_Client* self,
//void DISCORD_API Discord_Client_GetProvisionalToken(Discord_Client* self,
//void DISCORD_API Discord_Client_GetToken(Discord_Client* self,
//void DISCORD_API Discord_Client_GetTokenFromDevice(Discord_Client* self,
//void DISCORD_API Discord_Client_GetTokenFromDeviceProvisionalMerge(
//void DISCORD_API Discord_Client_GetTokenFromProvisionalMerge(Discord_Client* self,
//bool DISCORD_API Discord_Client_IsAuthenticated(Discord_Client* self);
//void DISCORD_API Discord_Client_OpenAuthorizeDeviceScreen(Discord_Client* self,
//void DISCORD_API Discord_Client_ProvisionalUserMergeCompleted(Discord_Client* self, bool success);
//void DISCORD_API Discord_Client_RefreshToken(Discord_Client* self,
//void DISCORD_API Discord_Client_RevokeToken(Discord_Client* self,
//void DISCORD_API Discord_Client_SetAuthorizeDeviceScreenClosedCallback(
//void DISCORD_API Discord_Client_SetGameWindowPid(Discord_Client* self, int32_t pid);
//void DISCORD_API Discord_Client_SetTokenExpirationCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_UnmergeIntoProvisionalAccount(
//void DISCORD_API Discord_Client_UpdateProvisionalAccountDisplayName(
//void DISCORD_API Discord_Client_UpdateToken(Discord_Client* self,
//bool DISCORD_API Discord_Client_CanOpenMessageInDiscord(Discord_Client* self, uint64_t messageId);
//void DISCORD_API Discord_Client_DeleteUserMessage(Discord_Client* self,
//void DISCORD_API Discord_Client_EditUserMessage(Discord_Client* self,
//bool DISCORD_API Discord_Client_GetChannelHandle(Discord_Client* self,
//void DISCORD_API Discord_Client_GetLobbyMessagesWithLimit(Discord_Client* self,
//bool DISCORD_API Discord_Client_GetMessageHandle(Discord_Client* self,
//void DISCORD_API Discord_Client_GetUserMessageSummaries(Discord_Client* self,
//void DISCORD_API Discord_Client_GetUserMessagesWithLimit(Discord_Client* self,
//void DISCORD_API Discord_Client_OpenMessageInDiscord(
//void DISCORD_API Discord_Client_SendLobbyMessage(Discord_Client* self,
//void DISCORD_API Discord_Client_SendLobbyMessageWithMetadata(Discord_Client* self,
//void DISCORD_API Discord_Client_SendUserMessage(Discord_Client* self,
//void DISCORD_API Discord_Client_SendUserMessageWithMetadata(Discord_Client* self,
//void DISCORD_API Discord_Client_SetMessageCreatedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetMessageDeletedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetMessageUpdatedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetShowingChat(Discord_Client* self, bool showingChat);
//void DISCORD_API Discord_Client_AddLogCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_AddVoiceLogCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_Connect(Discord_Client* self);
//void DISCORD_API Discord_Client_Disconnect(Discord_Client* self);
//Discord_Client_Status DISCORD_API Discord_Client_GetStatus(Discord_Client* self);
//void DISCORD_API Discord_Client_OpenConnectedGamesSettingsInDiscord(
//void DISCORD_API Discord_Client_SetApplicationId(Discord_Client* self, uint64_t applicationId);
//bool DISCORD_API Discord_Client_SetLogDir(Discord_Client* self,
//void DISCORD_API Discord_Client_SetStatusChangedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetVoiceLogDir(Discord_Client* self,
//void DISCORD_API Discord_Client_CreateOrJoinLobby(Discord_Client* self,
//void DISCORD_API Discord_Client_CreateOrJoinLobbyWithMetadata(Discord_Client* self,
//void DISCORD_API Discord_Client_GetGuildChannels(Discord_Client* self,
//bool DISCORD_API Discord_Client_GetLobbyHandle(Discord_Client* self,
//void DISCORD_API Discord_Client_GetLobbyIds(Discord_Client* self, Discord_UInt64Span* returnValue);
//void DISCORD_API Discord_Client_GetUserGuilds(Discord_Client* self,
//void DISCORD_API Discord_Client_JoinLinkedLobbyGuild(
//void DISCORD_API Discord_Client_LeaveLobby(Discord_Client* self,
//void DISCORD_API Discord_Client_LinkChannelToLobby(Discord_Client* self,
//void DISCORD_API Discord_Client_SetLobbyCreatedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetLobbyDeletedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetLobbyMemberAddedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetLobbyMemberRemovedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetLobbyMemberUpdatedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetLobbyUpdatedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_UnlinkChannelFromLobby(Discord_Client* self,
//void DISCORD_API Discord_Client_AcceptActivityInvite(Discord_Client* self,
//void DISCORD_API Discord_Client_ClearRichPresence(Discord_Client* self);
//bool DISCORD_API Discord_Client_RegisterLaunchCommand(Discord_Client* self,
//bool DISCORD_API Discord_Client_RegisterLaunchSteamApplication(Discord_Client* self,
//void DISCORD_API Discord_Client_SendActivityInvite(Discord_Client* self,
//void DISCORD_API Discord_Client_SendActivityJoinRequest(Discord_Client* self,
//void DISCORD_API Discord_Client_SendActivityJoinRequestReply(Discord_Client* self,
//void DISCORD_API Discord_Client_SetActivityInviteCreatedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetActivityInviteUpdatedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetActivityJoinCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetActivityJoinWithApplicationCallback(
//void DISCORD_API Discord_Client_SetOnlineStatus(Discord_Client* self,
//void DISCORD_API Discord_Client_UpdateRichPresence(Discord_Client* self,
//void DISCORD_API Discord_Client_AcceptDiscordFriendRequest(Discord_Client* self,
//void DISCORD_API Discord_Client_AcceptGameFriendRequest(Discord_Client* self,
//void DISCORD_API Discord_Client_BlockUser(Discord_Client* self,
//void DISCORD_API Discord_Client_CancelDiscordFriendRequest(Discord_Client* self,
//void DISCORD_API Discord_Client_CancelGameFriendRequest(Discord_Client* self,
//void DISCORD_API Discord_Client_GetRelationshipHandle(Discord_Client* self,
//void DISCORD_API Discord_Client_GetRelationships(Discord_Client* self,
//void DISCORD_API Discord_Client_GetRelationshipsByGroup(Discord_Client* self,
//void DISCORD_API Discord_Client_RejectDiscordFriendRequest(Discord_Client* self,
//void DISCORD_API Discord_Client_RejectGameFriendRequest(Discord_Client* self,
//void DISCORD_API Discord_Client_RemoveDiscordAndGameFriend(Discord_Client* self,
//void DISCORD_API Discord_Client_RemoveGameFriend(Discord_Client* self,
//void DISCORD_API Discord_Client_SearchFriendsByUsername(Discord_Client* self,
//void DISCORD_API Discord_Client_SendDiscordFriendRequest(Discord_Client* self,
//void DISCORD_API Discord_Client_SendDiscordFriendRequestById(Discord_Client* self,
//void DISCORD_API Discord_Client_SendGameFriendRequest(Discord_Client* self,
//void DISCORD_API Discord_Client_SendGameFriendRequestById(Discord_Client* self,
//void DISCORD_API Discord_Client_SetRelationshipCreatedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_SetRelationshipDeletedCallback(Discord_Client* self,
//void DISCORD_API Discord_Client_UnblockUser(Discord_Client* self,
//void DISCORD_API Discord_Client_GetCurrentUser(Discord_Client* self,
//bool DISCORD_API Discord_Client_GetCurrentUserV2(Discord_Client* self,
//void DISCORD_API Discord_Client_GetDiscordClientConnectedUser(
//bool DISCORD_API Discord_Client_GetUser(Discord_Client* self,
//void DISCORD_API Discord_Client_SetRelationshipGroupsUpdatedCallback(
//void DISCORD_API Discord_Client_SetUserUpdatedCallback(Discord_Client* self,
@SuppressWarnings({"removal", "CodeBlock2Expr"})
public class Discord_Client {
	public static MethodHandle _Discord_Client_Init;
	public static MethodHandle _Discord_Client_GetApplicationId;
	public static MethodHandle _Discord_Client_GetVersionMajor;
	public static MethodHandle _Discord_Client_GetVersionMinor;
	public static MethodHandle _Discord_Client_GetVersionPatch;
	public static MethodHandle _Discord_Client_StartCall;
	public static MethodHandle _Discord_Client_Authorize;
	public static MethodHandle _Discord_Client_CreateAuthorizationCodeVerifier;
	public static MethodHandle _Discord_Client_GetToken;
	public static MethodHandle _Discord_Client_UpdateToken;
	public static MethodHandle _Discord_Client_GetLobbyMessagesWithLimit;
	public static MethodHandle _Discord_Client_GetMessageHandle;
	public static MethodHandle _Discord_Client_GetUserMessagesWithLimit;
	public static MethodHandle _Discord_Client_SendLobbyMessage;
	public static MethodHandle _Discord_Client_SendUserMessage;
	public static MethodHandle _Discord_Client_SetMessageCreatedCallback;
	public static MethodHandle _Discord_Client_SetMessageDeletedCallback;
	public static MethodHandle _Discord_Client_SetMessageUpdatedCallback;
	public static MethodHandle _Discord_Client_AddLogCallback;
	public static MethodHandle _Discord_Client_Connect;
	public static MethodHandle _Discord_Client_SetApplicationId;
	public static MethodHandle _Discord_Client_SetStatusChangedCallback;
	public static MethodHandle _Discord_Client_CreateOrJoinLobby;
	public static MethodHandle _Discord_Client_GetLobbyHandle;
	public static MethodHandle _Discord_Client_GetLobbyIds;
	public static MethodHandle _Discord_Client_LinkChannelToLobby;
	public static MethodHandle _Discord_Client_UpdateRichPresence;
	public static MethodHandle _Discord_Client_GetRelationships;
	public static MethodHandle _Discord_Client_GetRelationshipsByGroup;
	public static MethodHandle _Discord_Client_GetUser;

	private static FunctionDescriptor _Discord_Client_AuthorizationCallback;
	private static MethodHandle _Discord_Client_AuthorizationCallback$handle;
	private static FunctionDescriptor _Discord_Client_TokenExchangeCallback;
	private static MethodHandle _Discord_Client_TokenExchangeCallback$handle;
	private static FunctionDescriptor _Discord_Client_UpdateTokenCallback;
	private static MethodHandle _Discord_Client_UpdateTokenCallback$handle;
	private static FunctionDescriptor _Discord_Client_GetLobbyMessagesCallback;
	private static MethodHandle _Discord_Client_GetLobbyMessagesCallback$handle;
	private static FunctionDescriptor _Discord_Client_UserMessagesCallback;
	private static MethodHandle _Discord_Client_UserMessagesCallback$handle;
	private static FunctionDescriptor _Discord_Client_SendUserMessageCallback;
	private static MethodHandle _Discord_Client_SendUserMessageCallback$handle;
	private static FunctionDescriptor _Discord_Client_MessageCreatedCallback;
	private static MethodHandle _Discord_Client_MessageCreatedCallback$handle;
	private static FunctionDescriptor _Discord_Client_MessageDeletedCallback;
	private static MethodHandle _Discord_Client_MessageDeletedCallback$handle;
	private static FunctionDescriptor _Discord_Client_MessageUpdatedCallback;
	private static MethodHandle _Discord_Client_MessageUpdatedCallback$handle;
	private static FunctionDescriptor _Discord_Client_LogCallback;
	private static MethodHandle _Discord_Client_LogCallback$handle;
	private static FunctionDescriptor _Discord_Client_OnStatusChanged;
	private static MethodHandle _Discord_Client_OnStatusChanged$handle;
	private static FunctionDescriptor _Discord_Client_CreateOrJoinLobbyCallback;
	private static MethodHandle _Discord_Client_CreateOrJoinLobbyCallback$handle;
	private static FunctionDescriptor _Discord_Client_LinkOrUnlinkChannelCallback;
	private static MethodHandle _Discord_Client_LinkOrUnlinkChannelCallback$handle;
	private static FunctionDescriptor _Discord_Client_UpdateRichPresenceCallback;
	private static MethodHandle _Discord_Client_UpdateRichPresenceCallback$handle;

	@SuppressWarnings({"UnusedLabel", "OptionalGetWithoutIsPresent"})
	public static void setupDiscordClient(Arena arena, SymbolLookup lookup) throws NoSuchMethodException, IllegalAccessException {
		Discord_Client_Init: {
			MemorySegment functionAddress = lookup.find("Discord_Client_Init").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_Client_Init = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetApplicationId: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetApplicationId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_Client_GetApplicationId = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetVersionMajor: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetVersionMajor").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_INT);
			_Discord_Client_GetVersionMajor = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetVersionMinor: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetVersionMinor").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_INT);
			_Discord_Client_GetVersionMinor = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetVersionPatch: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetVersionPatch").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_INT);
			_Discord_Client_GetVersionPatch = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_StartCall: {
			MemorySegment functionAddress = lookup.find("Discord_Client_StartCall").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_Client_StartCall = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_Authorize: {
			MemorySegment functionAddress = lookup.find("Discord_Client_Authorize").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS
			);
			_Discord_Client_AuthorizationCallback = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					_Discord_String,
					_Discord_String,
					ValueLayout.ADDRESS);
			_Discord_Client_AuthorizationCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_AuthorizationCallback.class, "call0",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class, MemorySegment.class, MemorySegment.class));
			_Discord_Client_Authorize = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_CreateAuthorizationCodeVerifier: {
			MemorySegment functionAddress = lookup.find("Discord_Client_CreateAuthorizationCodeVerifier").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_CreateAuthorizationCodeVerifier = LINKER.downcallHandle(functionAddress, functionSignature);
		}// MemorySegment result, String code, String redirectUri, MemorySegment userData
		Discord_Client_GetToken: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetToken").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					ValueLayout.JAVA_LONG,
					_Discord_String,
					_Discord_String,
					_Discord_String,
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS
			);

			_Discord_Client_TokenExchangeCallback = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					_Discord_String,
					_Discord_String,
					ValueLayout.JAVA_INT,
					ValueLayout.JAVA_INT,
					_Discord_String,
					ValueLayout.ADDRESS);
			_Discord_Client_TokenExchangeCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_TokenExchangeCallback.class, "call0",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class, MemorySegment.class, int.class, int.class, MemorySegment.class, MemorySegment.class));

			_Discord_Client_GetToken = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_UpdateToken: {
			_Discord_Client_UpdateTokenCallback = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS);
			_Discord_Client_UpdateTokenCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_UpdateTokenCallback.class, "call",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class));


			MemorySegment functionAddress = lookup.find("Discord_Client_UpdateToken").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, _Discord_String, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_UpdateToken = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetLobbyMessagesWithLimit: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetLobbyMessagesWithLimit").get();
			_Discord_Client_GetLobbyMessagesCallback = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					_Discord_MessageHandleSpan,
					ValueLayout.ADDRESS);
			_Discord_Client_GetLobbyMessagesCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_GetLobbyMessagesCallback.class, "call",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class, MemorySegment.class));

			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_GetLobbyMessagesWithLimit = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetMessageHandle: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetMessageHandle").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_Client_GetMessageHandle = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetUserMessagesWithLimit: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetUserMessagesWithLimit").get();
			_Discord_Client_UserMessagesCallback = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					_Discord_MessageHandleSpan,
					ValueLayout.ADDRESS);
			_Discord_Client_UserMessagesCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_UserMessagesWithLimitCallback.class, "call",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class, MemorySegment.class));

			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_GetUserMessagesWithLimit = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_SendLobbyMessage: {
			_Discord_Client_SendUserMessageCallback = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					ValueLayout.JAVA_LONG,
					ValueLayout.ADDRESS);
			_Discord_Client_SendUserMessageCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_SendUserMessageCallback.class, "call",
					MethodType.methodType(void.class, MemorySegment.class, long.class, MemorySegment.class));
			MemorySegment functionAddress = lookup.find("Discord_Client_SendLobbyMessage").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, _Discord_String, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_SendLobbyMessage = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_SendUserMessage: {
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, _Discord_String, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			MemorySegment functionAddress = lookup.find("Discord_Client_SendUserMessage").get();
			_Discord_Client_SendUserMessage = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_SetMessageCreatedCallback: {
			_Discord_Client_MessageCreatedCallback = FunctionDescriptor.ofVoid(
					ValueLayout.JAVA_LONG,
					ValueLayout.ADDRESS);
			_Discord_Client_MessageCreatedCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_MessageCreatedCallback.class, "call",
					MethodType.methodType(void.class, long.class, MemorySegment.class));
			MemorySegment functionAddress = lookup.find("Discord_Client_SetMessageCreatedCallback").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_SetMessageCreatedCallback = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_SetMessageDeletedCallback: {
			_Discord_Client_MessageDeletedCallback = FunctionDescriptor.ofVoid(
					ValueLayout.JAVA_LONG,
					ValueLayout.JAVA_LONG,
					ValueLayout.ADDRESS);
			_Discord_Client_MessageDeletedCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_MessageDeletedCallback.class, "call",
					MethodType.methodType(void.class, long.class, long.class, MemorySegment.class));
			MemorySegment functionAddress = lookup.find("Discord_Client_SetMessageDeletedCallback").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_SetMessageDeletedCallback = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_SetMessageUpdatedCallback: {
			_Discord_Client_MessageUpdatedCallback = FunctionDescriptor.ofVoid(
					ValueLayout.JAVA_LONG,
					ValueLayout.ADDRESS);
			_Discord_Client_MessageUpdatedCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_MessageUpdatedCallback.class, "call",
					MethodType.methodType(void.class, long.class, MemorySegment.class));
			MemorySegment functionAddress = lookup.find("Discord_Client_SetMessageUpdatedCallback").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_SetMessageUpdatedCallback = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_AddLogCallback: {
			MemorySegment functionAddress = lookup.find("Discord_Client_AddLogCallback").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT);

			_Discord_Client_LogCallback = FunctionDescriptor.ofVoid(
					_Discord_String,
					ValueLayout.JAVA_INT,
					ValueLayout.ADDRESS);
			_Discord_Client_LogCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_LogCallback.class, "call0",
					MethodType.methodType(void.class, MemorySegment.class, int.class, MemorySegment.class));

			_Discord_Client_AddLogCallback = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_Connect: {
			MemorySegment functionAddress = lookup.find("Discord_Client_Connect").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_Client_Connect = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_SetApplicationId: {
			MemorySegment functionAddress = lookup.find("Discord_Client_SetApplicationId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_SetApplicationId = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_SetStatusChangedCallback: {
			MemorySegment functionAddress = lookup.find("Discord_Client_SetStatusChangedCallback").get();
			//var layout = MemoryLayout.sequenceLayout()
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS
			);

			// typedef void (*Discord_Client_OnStatusChanged)(Discord_Client_Status status,
			//                                               Discord_Client_Error error,
			//                                               int32_t errorDetail,
			//                                               void* userData);

			MethodHandle methodHandle = LINKER.downcallHandle(functionAddress, functionSignature);
			_Discord_Client_OnStatusChanged = FunctionDescriptor.ofVoid(
					ValueLayout.JAVA_INT,
					ValueLayout.JAVA_INT,
					ValueLayout.JAVA_INT,
					ValueLayout.ADDRESS);
			_Discord_Client_OnStatusChanged$handle = MethodHandles.lookup().findVirtual(Discord_Client_OnStatusChanged.class, "call",
					MethodType.methodType(void.class, int.class, int.class, int.class, MemorySegment.class));

			_Discord_Client_SetStatusChangedCallback = methodHandle;
		}
		Discord_Client_CreateOrJoinLobby: {
			_Discord_Client_CreateOrJoinLobbyCallback = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					ValueLayout.JAVA_LONG,
					ValueLayout.ADDRESS);
			_Discord_Client_CreateOrJoinLobbyCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_CreateOrJoinLobbyCallback.class, "call",
					MethodType.methodType(void.class, MemorySegment.class, long.class, MemorySegment.class));

			MemorySegment functionAddress = lookup.find("Discord_Client_CreateOrJoinLobby").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, _Discord_String, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_CreateOrJoinLobby = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetLobbyHandle: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetLobbyHandle").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_Client_GetLobbyHandle = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetLobbyIds: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetLobbyIds").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_GetLobbyIds = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_LinkChannelToLobby: {

			_Discord_Client_LinkOrUnlinkChannelCallback = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS);
			_Discord_Client_LinkOrUnlinkChannelCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_LinkOrUnlinkChannelCallback.class, "call",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class));
			MemorySegment functionAddress = lookup.find("Discord_Client_LinkChannelToLobby").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_LinkChannelToLobby = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_UpdateRichPresence: {
			_Discord_Client_UpdateRichPresenceCallback = FunctionDescriptor.ofVoid(
					ValueLayout.ADDRESS,
					ValueLayout.ADDRESS);
			_Discord_Client_UpdateRichPresenceCallback$handle = MethodHandles.lookup().findVirtual(Discord_Client_UpdateRichPresenceCallback.class, "call",
					MethodType.methodType(void.class, MemorySegment.class, MemorySegment.class));

			MemorySegment functionAddress = lookup.find("Discord_Client_UpdateRichPresence").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS,ValueLayout.ADDRESS,ValueLayout.ADDRESS,ValueLayout.ADDRESS,ValueLayout.ADDRESS);
			_Discord_Client_UpdateRichPresence = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetRelationships: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetRelationships").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_GetRelationships = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetRelationshipsByGroup: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetRelationshipsByGroup").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS);
			_Discord_Client_GetRelationshipsByGroup = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetUser: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetUser").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_Client_GetUser = LINKER.downcallHandle(functionAddress, functionSignature);
		}
	}

	public static void Discord_Client_Init(MemorySegment self) {
		r(() -> {
			_Discord_Client_Init.invokeExact(self);
			System.out.println("ran discord client init");
		});
	}
	public static long Discord_Client_GetApplicationId(MemorySegment self) {
		long[] q = new long[1];
		r(() -> {
			long r = (long) _Discord_Client_GetApplicationId.invokeExact(self);
			q[0] =r;
		});
		return q[0];
	}
	public static int Discord_Client_GetVersionMajor() {
		int[] q = new int[1];
		r(() -> {
			int r = (int) _Discord_Client_GetVersionMajor.invokeExact();
			q[0] =r;
		});
		return q[0];
	}
	public static int Discord_Client_GetVersionMinor() {
		int[] q = new int[1];
		r(() -> {
			int r = (int) _Discord_Client_GetVersionMinor.invokeExact();
			q[0] =r;
		});
		return q[0];
	}
	public static int Discord_Client_GetVersionPatch() {
		int[] q = new int[1];
		r(() -> {
			int r = (int) _Discord_Client_GetVersionPatch.invokeExact();
			q[0] =r;
		});
		return q[0];
	}
	public static boolean Discord_Client_StartCall(@$("Discord_Client*") MemorySegment self,
												   long channelId,
												   @$("Discord_Call*") MemorySegment returnValue) {
		boolean[] r = new boolean[1];
		r(() -> {
			boolean e = (boolean) _Discord_Client_StartCall.invokeExact(self, channelId, returnValue);
			r[0] = e;
		});
		return r[0];
	}
	public interface Discord_Client_AuthorizationCallback {
		void call(@$("Discord_ClientResult*")MemorySegment result, String code, String redirectUri, @$("void*")MemorySegment userData);
		default void call0(MemorySegment result, MemorySegment code, MemorySegment redirectUri, MemorySegment userData) {
			call(result, _String_Sugar(code), _String_Sugar(redirectUri), userData);
		}
	}
	public static void Discord_Client_Authorize(@$("Discord_Client*") MemorySegment self, @$("Discord_AuthorizationArgs*") MemorySegment args, Discord_Client_AuthorizationCallback callback,
												Discord_FreeFn callback__userDataFree, MemorySegment callback__userData) {
		MethodHandle o1 = _Discord_Client_AuthorizationCallback$handle.bindTo(callback);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(callback__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_AuthorizationCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_Authorize.invokeExact(self, args, cb0, cb1, callback__userData);
		});
	}
	public static void Discord_Client_CreateAuthorizationCodeVerifier(MemorySegment self, MemorySegment returnValue) {
		r(() -> {
			_Discord_Client_CreateAuthorizationCodeVerifier.invokeExact(self, returnValue);
		});
	}
	public interface Discord_Client_TokenExchangeCallback {
		void call(@$("Discord_ClientResult*") MemorySegment result, String accessToken, String refreshToken, @$("Discord_AuthorizationTokenType") int tokenType,
				  int expiresIn, String scopes, @$("void*") MemorySegment userData);
		default void call0(MemorySegment result, MemorySegment accessToken, MemorySegment refreshToken, int tokenType,
						   int expiresIn, MemorySegment scopes, MemorySegment userData) {
			call(result, _String_Sugar(accessToken), _String_Sugar(refreshToken), tokenType, expiresIn, _String_Sugar(scopes), userData);
		}
	}
	public static void Discord_Client_GetToken(@$("Discord_Client*") MemorySegment self, long applicationId, String code, String codeVerifier, String redirectUri, Discord_Client_TokenExchangeCallback callback, Discord_FreeFn callback__userDataFree, @$("void*") MemorySegment callback__userData) {
		MethodHandle o1 = _Discord_Client_TokenExchangeCallback$handle.bindTo(callback);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(callback__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_TokenExchangeCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_GetToken.invokeExact(self, applicationId, _DiscordStringFromJavaString(code), _DiscordStringFromJavaString(codeVerifier),  _DiscordStringFromJavaString(redirectUri), cb0, cb1, callback__userData);
		});
	}
	public interface Discord_Client_UpdateTokenCallback {
		void call(@$("Discord_ClientResult*") MemorySegment result, @$("void*") MemorySegment userData);
	}
	public static void Discord_Client_UpdateToken(@$("Discord_Client*") MemorySegment self,
												  @$("Discord_AuthorizationTokenType") int tokenType,
												  String token,
												  Discord_Client_UpdateTokenCallback callback,
												  Discord_FreeFn callback__userDataFree,
												  @$("void*") MemorySegment callback__user_data) {
		MethodHandle o1 = _Discord_Client_UpdateTokenCallback$handle.bindTo(callback);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(callback__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_UpdateTokenCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_UpdateToken.invokeExact(self, tokenType, _DiscordStringFromJavaString(token), cb0, cb1, callback__user_data);
		});
	}
	public interface Discord_Client_GetLobbyMessagesCallback {
		void call(@$("Discord_ClientResult*") MemorySegment result, @$("Discord_MessageHandleSpan") MemorySegment messages, @$("void*") MemorySegment userData);
	}
	public static void Discord_Client_GetLobbyMessagesWithLimit(@$("Discord_Client*") MemorySegment self, long lobbyId, int limit, Discord_Client_GetLobbyMessagesCallback cb, Discord_FreeFn cb__userDataFree, @$("void*") MemorySegment cb__userData) {
		MethodHandle o1 = _Discord_Client_GetLobbyMessagesCallback$handle.bindTo(cb);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(cb__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_GetLobbyMessagesCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_GetLobbyMessagesWithLimit.invokeExact(self, lobbyId, limit, cb0, cb1, cb__userData);
		});
	}
	public static boolean Discord_Client_GetMessageHandle(@$("Discord_Client*") MemorySegment self, long messageId, @$("Discord_MessageHandle*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_Client_GetMessageHandle.invokeExact(self, messageId, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	public interface Discord_Client_UserMessagesWithLimitCallback {
		void call(@$("Discord_ClientResult*") MemorySegment result, @$("Discord_MessageHandleSpan") MemorySegment messages, @$("void*") MemorySegment userData);
	}
	public static void Discord_Client_GetUserMessagesWithLimit(@$("Discord_Client*") MemorySegment self, long recipientId, int limit, Discord_Client_UserMessagesWithLimitCallback cb, Discord_FreeFn cb__userDataFree, @$("void*") MemorySegment cb__userData) {
		MethodHandle o1 = _Discord_Client_UserMessagesCallback$handle.bindTo(cb);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(cb__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_UserMessagesCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_GetUserMessagesWithLimit.invokeExact(self, recipientId, limit, cb0, cb1, cb__userData);
		});
	}
	public interface Discord_Client_SendUserMessageCallback {
		void call(@$("Discord_ClientResult*") MemorySegment result,
				  @$("uint64_t") long messageId,
				  @$("void*") MemorySegment userData);
	}
	public static void Discord_Client_SendLobbyMessage(@$("Discord_Client*") MemorySegment self, long lobbyId, String content, Discord_Client_SendUserMessageCallback cb, Discord_FreeFn cb__userDataFree, @$("void*") MemorySegment cb__userData) {
		MethodHandle o1 = _Discord_Client_SendUserMessageCallback$handle.bindTo(cb);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(cb__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_SendUserMessageCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {

			_Discord_Client_SendLobbyMessage.invokeExact(self, lobbyId, _DiscordStringFromJavaString(content), cb0, cb1, cb__userData);
		});
	}
	public static void Discord_Client_SendUserMessage(@$("Discord_Client*") MemorySegment self, long recipientId, String content, Discord_Client_SendUserMessageCallback cb, Discord_FreeFn cb__userDataFree, @$("void*") MemorySegment cb__userData) {
		MethodHandle o1 = _Discord_Client_SendUserMessageCallback$handle.bindTo(cb);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(cb__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_SendUserMessageCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {

			_Discord_Client_SendUserMessage.invokeExact(self, recipientId, _DiscordStringFromJavaString(content), cb0, cb1, cb__userData);
		});
	}
	public interface Discord_Client_MessageCreatedCallback {
		void call(long messageId, @$("void*") MemorySegment userData);
	}
	public static void Discord_Client_SetMessageCreatedCallback(@$("Discord_Client*") MemorySegment self, Discord_Client_MessageCreatedCallback cb, Discord_FreeFn cb__userDataFree, @$("void*") MemorySegment cb__userData) {
		MethodHandle o1 = _Discord_Client_MessageCreatedCallback$handle.bindTo(cb);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(cb__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_MessageCreatedCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_SetMessageCreatedCallback.invokeExact(self, cb0, cb1, cb__userData);
		});
	}
	public interface Discord_Client_MessageDeletedCallback {
		void call(long messageId, long channelId, @$("void*") MemorySegment userData);
	}
	public static void Discord_Client_SetMessageDeletedCallback(@$("Discord_Client*") MemorySegment self, Discord_Client_MessageDeletedCallback cb, Discord_FreeFn cb__userDataFree, @$("void*") MemorySegment cb__userData) {
		MethodHandle o1 = _Discord_Client_MessageDeletedCallback$handle.bindTo(cb);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(cb__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_MessageDeletedCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_SetMessageDeletedCallback.invokeExact(self, cb0, cb1, cb__userData);
		});
	}
	public interface Discord_Client_MessageUpdatedCallback {
		void call(long messageId, @$("void*") MemorySegment userData);
	}
	public static void Discord_Client_SetMessageUpdatedCallback(@$("Discord_Client*") MemorySegment self, Discord_Client_MessageUpdatedCallback cb, Discord_FreeFn cb__userDataFree, @$("void*") MemorySegment cb__userData) {
		MethodHandle o1 = _Discord_Client_MessageUpdatedCallback$handle.bindTo(cb);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(cb__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_MessageUpdatedCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_SetMessageUpdatedCallback.invokeExact(self, cb0, cb1, cb__userData);
		});
	}
	public interface Discord_Client_LogCallback {
		void call(String message, int severity, MemorySegment userData);
		default void call0(MemorySegment message, int severity, MemorySegment userData) {
			call(_String_Sugar(message), severity, userData);
		}
	}
	public static void Discord_Client_AddLogCallback(@$("Discord_Client*") MemorySegment self, Discord_Client_LogCallback callback, Discord_FreeFn callback__userDataFree, MemorySegment callback__userData, int minSeverity) {

		MethodHandle o1 = _Discord_Client_LogCallback$handle.bindTo(callback);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(callback__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_LogCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_AddLogCallback.invokeExact(self, cb0, cb1, callback__userData, minSeverity);
		});
	}
	public static void Discord_Client_Connect(MemorySegment self) {
		r(() -> {
			_Discord_Client_Connect.invokeExact(self);
		});
	}
	public static void Discord_Client_SetApplicationId(MemorySegment self, MemorySegment value) {
		r(() -> {
			_Discord_Client_SetApplicationId.invokeExact(self, value);
		});
	}
	public interface Discord_Client_OnStatusChanged {
		void call(int status, int error, int errorDetail, MemorySegment userData);
	}
	public static void Discord_Client_SetStatusChangedCallback(MemorySegment self, Discord_Client_OnStatusChanged cb,
															   Discord_FreeFn cb__userDataFree,
															   MemorySegment cb__userData) {

		MethodHandle o1 = _Discord_Client_OnStatusChanged$handle.bindTo(cb);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(cb__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_OnStatusChanged, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_SetStatusChangedCallback.invokeExact(self, cb0, cb1, cb__userData);
		});
	}
	public interface Discord_Client_CreateOrJoinLobbyCallback {
		void call(@$("Discord_ClientResult*") MemorySegment result, long lobbyId, MemorySegment userData);
	}
	public static void Discord_Client_CreateOrJoinLobby(@$("Discord_Client*") MemorySegment self, String secret, Discord_Client_CreateOrJoinLobbyCallback callback, Discord_FreeFn callback__userDataFree, MemorySegment callback__userData) {
		MethodHandle o1 = _Discord_Client_CreateOrJoinLobbyCallback$handle.bindTo(callback);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(callback__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_CreateOrJoinLobbyCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_CreateOrJoinLobby.invokeExact(self, _DiscordStringFromJavaString(secret), cb0, cb1, callback__userData);
		});
	}
	public static boolean Discord_Client_GetLobbyHandle(@$("Discord_Client*") MemorySegment self, long lobbyId, @$("Discord_LobbyHandle*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_Client_GetLobbyHandle.invokeExact(self, lobbyId, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	public static void Discord_Client_GetLobbyIds(@$("Discord_Client*") MemorySegment self, @$("Discord_UInt64Span*") MemorySegment returnValue) {
		r(() -> {
			_Discord_Client_GetLobbyIds.invokeExact(self, returnValue);
		});
	}
	public interface Discord_Client_LinkOrUnlinkChannelCallback{
		void call(@$("Discord_ClientResult*") MemorySegment result, MemorySegment userData);
	}
	public static void Discord_Client_LinkChannelToLobby(@$("Discord_Client*") MemorySegment self, long lobbyId, long channelId, Discord_Client_LinkOrUnlinkChannelCallback callback, Discord_FreeFn callback__userDataFree, MemorySegment callback__userData) {
		MethodHandle o1 = _Discord_Client_LinkOrUnlinkChannelCallback$handle.bindTo(callback);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(callback__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_LinkOrUnlinkChannelCallback, Arena.ofAuto());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.ofAuto());
		r(() -> {
			_Discord_Client_LinkChannelToLobby.invokeExact(self, lobbyId, channelId, cb0, cb1, callback__userData);
		});
	}
	public interface Discord_Client_UpdateRichPresenceCallback {
		void call(@$("Discord_ClientResult*") MemorySegment result, @$("void*") MemorySegment userData);
	}
	public static void Discord_Client_UpdateRichPresence(MemorySegment self, MemorySegment activity, Discord_Client_UpdateRichPresenceCallback cb, Discord_FreeFn cb__userDataFree, MemorySegment cb__userData) {
		MethodHandle o1 = _Discord_Client_UpdateRichPresenceCallback$handle.bindTo(cb);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(cb__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_UpdateRichPresenceCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_UpdateRichPresence.invokeExact(self, activity, cb0, cb1, cb__userData);
		});
	}
	public static void Discord_Client_GetRelationships(@$("Discord_Client*") MemorySegment self, @$("Discord_RelationshipHandleSpan*") MemorySegment returnValue) {
		r(() -> {
			_Discord_Client_GetRelationships.invokeExact(self, returnValue);
		});
	}
	public static void Discord_Client_GetRelationshipsByGroup(@$("Discord_Client*") MemorySegment self, @$("Discord_RelationshipGroupType") int groupType, @$("Discord_RelationshipHandleSpan*") MemorySegment returnValue) {
		r(() -> {
			_Discord_Client_GetRelationshipsByGroup.invokeExact(self, groupType, returnValue);
		});
	}
	public static boolean Discord_Client_GetUser(@$("Discord_Client*") MemorySegment self, long userId, @$("Discord_UserHandle*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_Client_GetUser.invokeExact(self, userId, returnValue);
			b[0] = c;
		});
		return b[0];
	}
}
