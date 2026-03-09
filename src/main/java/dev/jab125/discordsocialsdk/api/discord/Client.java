// Copyright 2025-2026 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api.discord;

import dev.jab125.discordsocialsdk.api.$;
import dev.jab125.discordsocialsdk.api.Discouraged;
import dev.jab125.discordsocialsdk.api.PointerWrapper;
import dev.jab125.discordsocialsdk.impl.CrosshairUtils;
import dev.jab125.discordsocialsdk.impl.c.*;

import static dev.jab125.discordsocialsdk.impl.c.cdiscord_h.*;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.List;
import java.util.Optional;

// TODO uses of `auto`
public class Client implements PointerWrapper {
	private final @$("Discord_Client*") MemorySegment instance;
	public Client() {
		this.instance = Arena.global().allocate(ValueLayout.ADDRESS);
		Discord_Client_Init(instance);
	}

	public Client(@$("Discord_Client*") MemorySegment instance) {
		this.instance = instance;
	}

	@Discouraged("use Error#toString()")
	public static String errorToString(Error type) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment allocate = arena.allocate(Discord_String.layout());
			Discord_Client_ErrorToString(type.ordinal(), allocate);
			return CrosshairUtils.toJavaString(allocate);
		}
	}
	public long getApplicationId() {
		return Discord_Client_GetApplicationId(instance);
	}
	///  @deprecated use {@link Client#getCurrentUserV2()} instead
	@Deprecated(forRemoval = true)
	public UserHandle getCurrentUser() {
		@$("UserHandle*") MemorySegment handle = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		Discord_Client_GetCurrentUser(instance, handle);
		return new UserHandle(handle);
	}
	public static String getDefaultAudioDeviceId() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment allocate = arena.allocate(Discord_String.layout());
			Discord_Client_GetDefaultAudioDeviceId(allocate);
			return CrosshairUtils.toJavaString(allocate);
		}
	}
	public static String getDefaultPresenceScopes() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment allocate = arena.allocate(Discord_String.layout());
			Discord_Client_GetDefaultPresenceScopes(allocate);
			return CrosshairUtils.toJavaString(allocate);
		}
	}
	public static String getVersionHash() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment allocate = arena.allocate(Discord_String.layout());
			Discord_Client_GetVersionHash(allocate);
			return CrosshairUtils.toJavaString(allocate);
		}
	}
	public static int getVersionMajor() {
		return Discord_Client_GetVersionMajor.makeInvoker().apply();
	}
	public static int getVersionMinor() {
		return Discord_Client_GetVersionMinor.makeInvoker().apply();
	}
	public static int getVersionPatch() {
		return Discord_Client_GetVersionPatch.makeInvoker().apply();
	}
	public void setHttpRequestTimeout(int httpTimeoutInMilliseconds) {
		Discord_Client_SetHttpRequestTimeout(instance, httpTimeoutInMilliseconds);
	}
	@Discouraged("use Status#toString()")
	public static String statusToString(Status type) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment allocate = arena.allocate(Discord_String.layout());
			Discord_Client_StatusToString(type.ordinal(), allocate);
			return CrosshairUtils.toJavaString(allocate);
		}
	}
	@Discouraged("use Thread#toString()")
	public static String threadToString(Thread type) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment allocate = arena.allocate(Discord_String.layout());
			Discord_Client_ThreadToString(type.ordinal(), allocate);
			return CrosshairUtils.toJavaString(allocate);
		}
	}
	// TODO EndCall
	//  EndCalls
	//  GetCall
	//  GetCalls
	//  GetCurrentInputDevice
	//  GetCurrentOutputDevice
	//  GetInputDevices
	public float getInputVolume() {
		return Discord_Client_GetInputVolume(instance);
	}
	// TODO GetOutputDevices
	public float getOutputVolume() {
		return Discord_Client_GetOutputVolume(instance);
	}
	public boolean getSelfDeafAll() {
		return Discord_Client_GetSelfDeafAll(instance);
	}
	public boolean getSelfMuteAll() {
		return Discord_Client_GetSelfMuteAll(instance);
	}
	public void setAecDump(boolean on) {
		Discord_Client_SetAecDump(instance, on);
	}
	public void setAutomaticGainControl(boolean on) {
		Discord_Client_SetAutomaticGainControl(instance, on);
	}
	// TODO SetDeviceChangeCallback
	public void setEchoCancellation(boolean on) {
		Discord_Client_SetEchoCancellation(instance, on);
	}
	// TODO SetInputDevice
	public void setInputVolume(float inputVolume) {
		Discord_Client_SetInputVolume(instance, inputVolume);
	}
	// TODO SetNoAudioInputCallback
	public void setNoAudioInputThreshold(float dBFSThreshold) {
		Discord_Client_SetNoAudioInputThreshold(instance, dBFSThreshold);
	}
	public void setNoiseSuppresion(boolean on) {
		Discord_Client_SetNoiseSuppression(instance, on);
	}
	public void setOpusHardwareCoding(boolean encode, boolean decode) {
		Discord_Client_SetOpusHardwareCoding(instance, encode, decode);
	}
	// TODO SetOutputDevice
	public void setOutputVolume(float outputVolume) {
		Discord_Client_SetOutputVolume(instance, outputVolume);
	}
	public void setSelfDeafAll(boolean deaf) {
		Discord_Client_SetSelfDeafAll(instance, deaf);
	}
	public void setSelfMuteAll(boolean mute) {
		Discord_Client_SetSelfMuteAll(instance, mute);
	}
	@Deprecated
	public boolean setSpeakerMode(boolean speakerMode) {
		return Discord_Client_SetSpeakerMode(instance, speakerMode);
	}
	// TODO SetThreadPriority
	//  SetVoiceParticipantChangedCallback
	public boolean showAudioRoutePicker() {
		return Discord_Client_ShowAudioRoutePicker(instance);
	}
	// TODO StartCall
	//  StartCallWithAudioCallbacks
	public void abortAuthorize() {
		Discord_Client_AbortAuthorize(instance);
	}
	public void abortGetTokenFromDevice() {
		Discord_Client_AbortGetTokenFromDevice(instance);
	}
	public interface AuthorizationCallback {
		void call(ClientResult result, String code, String redirectUri);
	}
	public void authorize(AuthorizationArgs args, AuthorizationCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_AuthorizationCallback.allocate((result, code, redirectUri, userData) -> {
			callback.call(new ClientResult(result), CrosshairUtils.toJavaString(code), CrosshairUtils.toJavaString(redirectUri));
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_Authorize(instance, args.getSegment(), callback__native, userDataFree, MemorySegment.NULL);
	}
	public void closeAuthorizeDeviceScreen() {
		Discord_Client_CloseAuthorizeDeviceScreen(instance);
	}
	public AuthorizationCodeVerifier createAuthorizationCodeVerifier() {
		@$("Discord_AuthorizationCodeVerifier*") MemorySegment verifier = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		Discord_Client_CreateAuthorizationCodeVerifier(instance, verifier);
		return new AuthorizationCodeVerifier(verifier);
	}
	// TODO ExchangeChildToken
	//  FetchCurrentUser
	//  GetProvisionalToken
	public interface TokenExchangeCallback {
		void call(ClientResult result, String accessToken, String refreshToken, AuthorizationTokenType tokenType, int expiresIn, String scopes);
	}
	public void getToken(long applicationId, String code, String codeVerifier, String redirectUri, TokenExchangeCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_TokenExchangeCallback.allocate((result, accessToken, refreshToken, tokenType, expiresIn, scopes, userData) -> callback.call(new ClientResult(result), CrosshairUtils.toJavaString(accessToken), CrosshairUtils.toJavaString(refreshToken), AuthorizationTokenType.values()[tokenType], expiresIn, CrosshairUtils.toJavaString(scopes)), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetToken(instance, applicationId, CrosshairUtils.toDiscordString(code), CrosshairUtils.toDiscordString(codeVerifier), CrosshairUtils.toDiscordString(redirectUri), callback__native, userDataFree, MemorySegment.NULL);
	}
	public void getTokenFromDevice(DeviceAuthorizationArgs args, TokenExchangeCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_TokenExchangeCallback.allocate((result, accessToken, refreshToken, tokenType, expiresIn, scopes, userData) -> callback.call(new ClientResult(result), CrosshairUtils.toJavaString(accessToken), CrosshairUtils.toJavaString(refreshToken), AuthorizationTokenType.values()[tokenType], expiresIn, CrosshairUtils.toJavaString(scopes)), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetTokenFromDevice(instance, args.getSegment(), callback__native, userDataFree, MemorySegment.NULL);
	}
	// TODO GetTokenFromDeviceProvisionalMerge
	//  GetTokenFromProvisionalMerge
	public boolean isAuthenticated() {
		return Discord_Client_IsAuthenticated(instance);
	}
	public void openDeviceAuthorizeScreen(long clientId, String userCode) {
		Discord_Client_OpenAuthorizeDeviceScreen(instance, clientId, CrosshairUtils.toDiscordString(userCode));
	}
	public void provisionalUserMergeCompleted(boolean success) {
		Discord_Client_ProvisionalUserMergeCompleted(instance, success);
	}
	// TODO RefreshToken
	//  RegisterAuthorizeRequestCallback
	public void removeAuthorizeRequestCallback() {
		Discord_Client_RemoveAuthorizeRequestCallback(instance);
	}
	// TODO RevokeToken
	//  SetAuthorizeDeviceScreenClosedCallback
	public void setGameWindowPid(int pid) {
		Discord_Client_SetGameWindowPid(instance, pid);
	}
	// TODO SetTokenExpirationCallback
	//  UnmergeIntoProvisionalAccount
	//  UpdateProvisionalAccountDisplayName
	public enum AuthorizationTokenType {
		USER,
		BEARER
	}
	public interface UpdateTokenCallback {
		void call(ClientResult result);
	}
	public void updateToken(AuthorizationTokenType tokenType, String token, UpdateTokenCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_UpdateTokenCallback.allocate((result, userData) -> callback.call(new ClientResult(result)), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_UpdateToken(instance, tokenType.ordinal(), CrosshairUtils.toDiscordString(token), callback__native, userDataFree, MemorySegment.NULL);
	}
	public boolean canOpenMessageInDiscord(long messageId) {
		return Discord_Client_CanOpenMessageInDiscord(instance, messageId);
	}
	// TODO DeleteUserMessage
	//  EditUserMessage
	//  GetChannelHandle
	public interface GetLobbyMessagesCallback {
		void call(ClientResult result, List<MessageHandle> messages);
	}
	public void getLobbyMessagesWithLimit(long lobbyId, int limit, GetLobbyMessagesCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_GetLobbyMessagesCallback.allocate((result, messages, userData) -> cb.call(new ClientResult(result), CrosshairUtils.unpackMessageHandleSpan(messages).stream().map(MessageHandle::new).toList()), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetLobbyMessagesWithLimit(instance, lobbyId, limit, callback__native, userDataFree, MemorySegment.NULL);
	}
	public Optional<MessageHandle> getMessageHandle(long messageId) {
		@$("Discord_MessageHandle*") MemorySegment handle = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		if (!Discord_Client_GetMessageHandle(instance, messageId, handle)) return Optional.empty();
		return Optional.of(new MessageHandle(handle));
	}
	// TODO GetUserMessageSummaries
	public interface UserMessagesWithLimitCallback {
		void call(ClientResult result, List<MessageHandle> messages);
	}
	public void getUserMessagesWithLimit(long recipientId, int limit, UserMessagesWithLimitCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_UserMessagesWithLimitCallback.allocate((result, messages, userData) -> cb.call(new ClientResult(result), CrosshairUtils.unpackMessageHandleSpan(messages).stream().map(MessageHandle::new).toList()), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetUserMessagesWithLimit(instance, recipientId, limit, callback__native, userDataFree, MemorySegment.NULL);
	}
	// TODO OpenMessageInDiscord
	public interface SendUserMessageCallback {
		void call(ClientResult result, long messageId);
	}
	public void sendLobbyMessage(long lobbyId, String message, SendUserMessageCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_SendUserMessageCallback.allocate((result, messageId, userData) -> cb.call(new ClientResult(result), messageId), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SendLobbyMessage(instance, lobbyId, CrosshairUtils.toDiscordString(message), callback__native, userDataFree, MemorySegment.NULL);
	}
	// TODO SendLobbyMessageWithMetadata
	public void sendUserMessage(long recipientId, String message, SendUserMessageCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_SendUserMessageCallback.allocate((result, messageId, userData) -> cb.call(new ClientResult(result), messageId), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SendUserMessage(instance, recipientId, CrosshairUtils.toDiscordString(message), callback__native, userDataFree, MemorySegment.NULL);
	}
	// TODO SendUserMessageWithMetadata
	public interface MessageCreatedCallback {
		void call(long messageId);
	}
	public void setMessageCreatedCallback(MessageCreatedCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_MessageCreatedCallback.allocate((messageId, userData) -> cb.call(messageId), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetMessageCreatedCallback(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public interface MessageDeletedCallback {
		void call(long messageId, long channelId);
	}
	public void setMessageDeletedCallback(MessageDeletedCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_MessageDeletedCallback.allocate((messageId, channelId, userData) -> cb.call(messageId, channelId), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetMessageDeletedCallback(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public interface MessageUpdatedCallback {
		void call(long messageId);
	}
	public void setMessageUpdatedCallback(MessageUpdatedCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_MessageUpdatedCallback.allocate((messageId, userData) -> cb.call(messageId), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetMessageUpdatedCallback(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public void setShowingChat(boolean showingChat) {
		Discord_Client_SetShowingChat(instance, showingChat);
	}
	public enum LoggingSeverity {
		VERBOSE,
		INFO,
		WARNING,
		ERROR,
		NONE
	}
	public interface LogCallback {
		void call(String message, LoggingSeverity severity);
	}
	public void addLogCallback(LogCallback callback, LoggingSeverity minSeverity) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_LogCallback.allocate((message, severity, userData) -> {
			callback.call(CrosshairUtils.toJavaString(message), LoggingSeverity.values()[severity]);
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_AddLogCallback(instance, callback__native, userDataFree, MemorySegment.NULL, minSeverity.ordinal());
	}
	// TODO AddVoiceLogCallback
	public void connect() {
		Discord_Client_Connect(instance);
	}
	public void disconnect() {
		Discord_Client_Disconnect(instance);
	}
	// TODO GetStatus
	//  OpenConnectedGamesSettingsInDiscord
	public void setApplicationId(long applicationId) {
		Discord_Client_SetApplicationId(instance, applicationId);
	}
	// TODO SetLogDir
	public enum Status {
		DISCONNECTED,
		CONNECTING,
		CONNECTED,
		READY,
		RECONNECTING,
		DISCONNECTING,
		HTTP_WAIT
	}
	public interface OnStatusChanged {
		void call(Status status, Error error, int errorDetail);
	}
	public enum Error {
		NONE,
		CONNECTION_FAILED,
		UNEXPECTED_CLOSE,
		CONNECTION_CANCELLED
	}
	public void setStatusChangedCallback(OnStatusChanged callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_OnStatusChanged.allocate((status, error, errorDetail, userData) -> callback.call(Status.values()[status], Error.values()[error], errorDetail), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetStatusChangedCallback(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public interface CreateOrJoinLobbyCallback {
		void call(ClientResult result, long lobbyId);
	}
	public void createOrJoinLobby(String secret, CreateOrJoinLobbyCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_CreateOrJoinLobbyCallback.allocate((result, lobbyId, userData) -> callback.call(new ClientResult(result), lobbyId), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_CreateOrJoinLobby(instance, CrosshairUtils.toDiscordString(secret), callback__native, userDataFree, MemorySegment.NULL);
	}
	// TODO CreateOrJoinLobbyWithMetadata
	public interface GetGuildChannelsCallback {
		void call(ClientResult result, List<GuildChannel> guildChannels);
	}
	public void getGuildChannels(long guildId, GetGuildChannelsCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_GetGuildChannelsCallback.allocate((result, guildChannels, userData) -> cb.call(new ClientResult(result), CrosshairUtils.unpackGuildChannelSpan(guildChannels).stream().map(GuildChannel::new).toList()), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetGuildChannels(instance, guildId, callback__native, userDataFree, MemorySegment.NULL);
	}
	public Optional<LobbyHandle> getLobbyHandle(long lobbyId) {
		@$("Discord_LobbyHandle*") MemorySegment handle = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		if (!Discord_Client_GetLobbyHandle(instance, lobbyId, handle)) return Optional.empty();
		return Optional.of(new LobbyHandle(handle));
	}
	public List<Long> getLobbyIds() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment allocated = Discord_UInt64Span.allocate(arena);
			Discord_Client_GetLobbyIds(instance, allocated);
			return CrosshairUtils.unpackUInt64Span(allocated);
		}
	}
	public interface GetUserGuildsCallback {
		void call(ClientResult result, List<GuildMinimal> guilds);
	}
	public void getUserGuilds(GetUserGuildsCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_GetUserGuildsCallback.allocate((result, guilds, userData) -> cb.call(new ClientResult(result), CrosshairUtils.unpackGuildChannelSpan(guilds).stream().map(GuildMinimal::new).toList()), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());

		Discord_Client_GetUserGuilds(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	// TODO JoinLinkedLobbyGuild
	//  LeaveLobby
	public interface LinkOrUnlinkChannelCallback {
		void call(ClientResult result);
	}
	public void linkChannelToLobby(long lobbyId, long channelId, LinkOrUnlinkChannelCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_LinkOrUnlinkChannelCallback.allocate((result, userData) -> callback.call(new ClientResult(result)), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_LinkChannelToLobby(instance, lobbyId, channelId, callback__native, userDataFree, MemorySegment.NULL);
	}
	// TODO SetLobbyCreatedCallback
	//  SetLobbyDeletedCallback
	//  SetLobbyMemberAddedCallback
	//  SetLobbyMemberRemovedCallback
	//  SetLobbyMemberUpdatedCallback
	//  SetLobbyUpdatedCallback
	//  UnlinkChannelFromLobby
	//  IsDiscordAppInstalled
	//  AcceptActivityInvite
	public void clearRichPresence() {
		Discord_Client_ClearRichPresence(instance);
	}
	public boolean registerLaunchCommand(long applicationId, String command) {
		return Discord_Client_RegisterLaunchCommand(instance, applicationId, CrosshairUtils.toDiscordString(command));
	}
	public boolean registerLaunchSteamApplication(long applicationId, int steamAppId) {
		return Discord_Client_RegisterLaunchSteamApplication(instance, applicationId, steamAppId);
	}
	// TODO SendActivityJoinRequest
	//  SendActivityJoinRequestReply
	//  SetActivityInviteCreatedCallback
	//  SetActivityInviteUpdatedCallback
	//  SetActivityJoinCallback
	//  SetActivityJoinWithApplicationCallback
	//  SetOnlineStatus
	public interface UpdateRichPresenceCallback {
		void call(ClientResult result);
	}
	public void updateRichPresence(Activity activity, UpdateRichPresenceCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_UpdateRelationshipCallback.allocate((result, userData) -> cb.call(new ClientResult(result)), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_UpdateRichPresence(instance, activity.getSegment(), callback__native, userDataFree, MemorySegment.NULL);
	}
	public List<RelationshipHandle> getRelationships() {
		@$("Discord_RelationshipHandleSpan*") MemorySegment memorySegment = Arena.ofAuto().allocate(Discord_RelationshipHandleSpan.layout());
		Discord_Client_GetRelationships(instance, memorySegment);
		return CrosshairUtils.unpackRelationshipHandleSpan(memorySegment).stream().map(RelationshipHandle::new).toList();
	}
	public enum RelationshipGroupType {
		ONLINE_PLAYING_GAME,
		ONLINE_ELSEWHERE,
		OFFLINE
	}
	public List<RelationshipHandle> getRelationshipsByGroup(RelationshipGroupType groupType) {
		@$("Discord_RelationshipHandleSpan*") MemorySegment memorySegment = Arena.ofAuto().allocate(Discord_RelationshipHandleSpan.layout());
		Discord_Client_GetRelationshipsByGroup(instance, groupType.ordinal(), memorySegment);
		return CrosshairUtils.unpackRelationshipHandleSpan(memorySegment).stream().map(RelationshipHandle::new).toList();
	}
	public Optional<UserHandle> getUser(long userId) {
		@$("Discord_UserHandle*") MemorySegment handle = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		if (!Discord_Client_GetUser(instance, userId, handle)) return Optional.empty();
		return Optional.of(new UserHandle(handle));
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
