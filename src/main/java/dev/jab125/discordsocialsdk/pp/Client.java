package dev.jab125.discordsocialsdk.pp;

import dev.jab125.discordsocialsdk.$;
import dev.jab125.discordsocialsdk.CDiscord;

import static dev.jab125.discordsocialsdk.CDiscord.*;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.List;
import java.util.Optional;

public class Client implements PointerWrapper {
	private final @$("Discord_Client*") MemorySegment instance;
	public Client() {
		this.instance = Arena.global().allocate(ValueLayout.ADDRESS);
		Discord_Client_Init(instance);
	}

	public Client(@$("Discord_Client*") MemorySegment instance) {
		this.instance = instance;
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
		Discord_Client_AddLogCallback(instance, (message, severity, userData) -> callback.call(message, LoggingSeverity.values()[severity]), ptr -> {}, MemorySegment.NULL, minSeverity.ordinal());
	}

	public void connect() {
		Discord_Client_Connect(instance);
	}

	public void setStatusChangedCallback(OnStatusChanged callback) {
		Discord_Client_SetStatusChangedCallback(instance, (status, error, errorDetail, userData) -> callback.call(Status.values()[status], Error.values()[error], errorDetail), ptr -> {
		}, MemorySegment.NULL);
	}

	public List<RelationshipHandle> getRelationships() {
		@$("Discord_RelationshipHandleSpan*") MemorySegment memorySegment = Arena.ofAuto().allocate(CDiscord._Discord_RelationshipHandleSpan);
		Discord_Client_GetRelationships(instance, memorySegment);
		return _unpack__Discord_RelationshipHandleSpan(memorySegment).stream().map(RelationshipHandle::new).toList();
	}

	public interface CreateOrJoinLobbyCallback {
		void call(ClientResult result, long lobbyId);
	}
	public interface LinkOrUnlinkChannelCallback {
		void call(ClientResult result);
	}
	public void createOrJoinLobby(String secret, CreateOrJoinLobbyCallback callback) {
		Discord_Client_CreateOrJoinLobby(instance, secret, (result, lobbyId, userData) -> callback.call(new ClientResult(result), lobbyId), ptr -> {}, MemorySegment.NULL);
	}

	public void linkChannelToLobby(long lobbyId, long channelId, LinkOrUnlinkChannelCallback callback) {
		Discord_Client_LinkChannelToLobby(instance, lobbyId, channelId, (result, userData) -> callback.call(new ClientResult(result)), ptr -> {}, MemorySegment.NULL);
	}

	public interface SendUserMessageCallback {
		void call(ClientResult result, long messageId);
	}
	public void sendLobbyMessage(long lobbyId, String message, SendUserMessageCallback cb) {
		Discord_Client_SendLobbyMessage(instance, lobbyId, message, (result, messageId, userData) -> cb.call(new ClientResult(result), messageId), ptr -> {}, MemorySegment.NULL);
	}

	public enum AuthorizationTokenType {
		USER,
		BEARER
	}
	public AuthorizationCodeVerifier createAuthorizationCodeVerifier() {
		@$("Discord_AuthorizationCodeVerifier*") MemorySegment verifier = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		Discord_Client_CreateAuthorizationCodeVerifier(instance, verifier);
		return new AuthorizationCodeVerifier(verifier);
	}

	public interface TokenExchangeCallback {
		void call(ClientResult result, String accessToken, String refreshToken, AuthorizationTokenType tokenType, int expiresIn, String scopes);
	}

	public void getToken(long applicationId, String code, String codeVerifier, String redirectUri, TokenExchangeCallback callback) {
		Discord_Client_GetToken(instance, applicationId, code, codeVerifier, redirectUri, (result, accessToken, refreshToken, tokenType, expiresIn, scopes, userData) -> callback.call(new ClientResult(result), accessToken, refreshToken, AuthorizationTokenType.values()[tokenType], expiresIn, scopes), ptr -> {}, MemorySegment.NULL);
	}

	public interface UpdateTokenCallback {
		void call(ClientResult result);
	}

	public void updateToken(AuthorizationTokenType tokenType, String token, UpdateTokenCallback callback) {
		Discord_Client_UpdateToken(instance, tokenType.ordinal(), token, (result, userData) -> callback.call(new ClientResult(result)), ptr -> {}, MemorySegment.NULL);
	}

	public interface AuthorizationCallback {
		void call(ClientResult result, String code, String redirectUri);
	}

	public void authorize(AuthorizationArgs args, AuthorizationCallback callback) {
		Discord_Client_Authorize(instance, args.getSegment(), (result, code, redirectUri, userData) -> callback.call(new ClientResult(result), code, redirectUri), ptr -> {}, MemorySegment.NULL);
	}

	public void updateRichPresence(Activity activity, UpdateRichPresenceCallback cb) {
		Discord_Client_UpdateRichPresence(instance, activity.getSegment(), (result, userData) -> cb.call(new ClientResult(result)), ptr -> {}, MemorySegment.NULL);
	}

	public List<Long> getLobbyIds() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment allocated = arena.allocate(_Discord_UInt64Span);
			Discord_Client_GetLobbyIds(instance, allocated);
			return _unpack__Discord_UInt64Span(allocated);
		}
	}
	// GetRelationshipsByGroup
	// std::vector<discordpp::RelationshipHandle> Client::GetRelationshipsByGroup(
	//  discordpp::RelationshipGroupType groupType) const
	//{
	public enum RelationshipGroupType {
		ONLINE_PLAYING_GAME,
		ONLINE_ELSEWHERE,
		OFFLINE
	}
	public List<RelationshipHandle> getRelationshipsByGroup(RelationshipGroupType groupType) {
		@$("Discord_RelationshipHandleSpan*") MemorySegment memorySegment = Arena.ofAuto().allocate(CDiscord._Discord_RelationshipHandleSpan);
		Discord_Client_GetRelationshipsByGroup(instance, groupType.ordinal(), memorySegment);
		return _unpack__Discord_RelationshipHandleSpan(memorySegment).stream().map(RelationshipHandle::new).toList();
	}

	public interface MessageCreatedCallback {
		void call(long messageId);
	}

	public void setMessageCreatedCallback(MessageCreatedCallback cb) {
		Discord_Client_SetMessageCreatedCallback(instance, (messageId, userData) -> cb.call(messageId), ptr -> {}, MemorySegment.NULL);
	}

	public Optional<MessageHandle> getMessageHandle(long messageId) {
		@$("Discord_MessageHandle*") MemorySegment handle = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		if (!Discord_Client_GetMessageHandle(instance, messageId, handle)) return Optional.empty();
		return Optional.of(new MessageHandle(handle));
	}

	public Optional<LobbyHandle> getLobbyHandle(long lobbyId) {
		@$("Discord_LobbyHandle*") MemorySegment handle = Arena.ofAuto().allocate(ValueLayout.ADDRESS);
		if (!Discord_Client_GetLobbyHandle(instance, lobbyId, handle)) return Optional.empty();
		return Optional.of(new LobbyHandle(handle));
	}

	// GetLobbyMessagesWithLimit
	// discordpp::ClientResult result,
	//                         std::vector<discordpp::MessageHandle> messages)
	public interface GetLobbyMessagesCallback {
		void call(ClientResult result, List<MessageHandle> messages);
	}
	public void getLobbyMessagesWithLimit(long lobbyId, int limit, GetLobbyMessagesCallback cb) {
		Discord_Client_GetLobbyMessagesWithLimit(instance, lobbyId, limit, (result, messages, userData) -> cb.call(new ClientResult(result), _unpack__Discord_MessageHandleSpan(messages).stream().map(MessageHandle::new).toList()), ptr -> {}, MemorySegment.NULL);
	}

	public interface UpdateRichPresenceCallback {
		void call(ClientResult result);
	}

	public interface OnStatusChanged {
		void call(Status status, Error error, int errorDetail);
	}

	public enum Error {
		NONE,
		CONNECTION_FAILED,
		UNEXPECTED_CLOSE,
		CONNECTION_CANCELLED
	};

	public enum Status {
		DISCONNECTED,
		CONNECTING,
		CONNECTED,
		READY,
		RECONNECTING,
		DISCONNECTING,
		HTTP_WAIT
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
