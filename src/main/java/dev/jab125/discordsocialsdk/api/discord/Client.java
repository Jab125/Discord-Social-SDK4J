// Copyright 2025-2026 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api.discord;

import dev.jab125.discordsocialsdk.api.$;
import dev.jab125.discordsocialsdk.api.Discouraged;
import dev.jab125.discordsocialsdk.api.PointerWrapper;
import dev.jab125.discordsocialsdk.api.holder.BooleanHolder;
import dev.jab125.discordsocialsdk.impl.CrosshairUtils;
import dev.jab125.discordsocialsdk.impl.c.*;

import static dev.jab125.discordsocialsdk.impl.c.cdiscord_h.*;

import java.lang.foreign.AddressLayout;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO uses of `auto` arenas
public class Client implements PointerWrapper {
	public interface EndCallCallback { void call(); }
	public interface EndCallsCallback { void call(); }
	public interface GetCurrentInputDeviceCallback { void call(AudioDevice device); }
	public interface GetCurrentOutputDeviceCallback { void call(AudioDevice device); }
	public interface GetInputDevicesCallback { void call(List<AudioDevice> devices); }
	public interface GetOutputDevicesCallback { void call(List<AudioDevice> devices); }
	public interface DeviceChangeCallback { void call(List<AudioDevice> inputDevices, List<AudioDevice> outputDevices); }
	public interface SetInputDeviceCallback { void call(ClientResult result); }
	public interface NoAudioInputCallback { void call(boolean inputDetected); }
	public interface SetOutputDeviceCallback { void call(ClientResult result); }
	public interface VoiceParticipantChangedCallback { void call(long lobbyId, long memberId, boolean added); }
	public interface UserAudioReceivedCallback { void call(long userId, ShortBuffer /*TODO ShortBuffer or short[]?*/ data, long samplesPerChannel, int sampleRate, long channels, BooleanHolder outShouldMute); }
	public interface UserAudioCapturedCallback { void call(ShortBuffer /*TODO ShortBuffer or short[]?*/ data, long samplesPerChannel, int sampleRate, long channels); }
	public interface AuthorizationCallback { void call(ClientResult result, String code, String redirectUri); }
	public interface ExchangeChildTokenCallback { void call(ClientResult result, String accessToken, AuthorizationTokenType tokenType, int expiresIn, String scopes); }
	public interface FetchCurrentUserCallback{ void call(ClientResult result, long id, String name); }
	public interface TokenExchangeCallback { void call(ClientResult result, String accessToken, String refreshToken, AuthorizationTokenType tokenType, int expiresIn, String scopes); }
	public interface RevokeTokenCallback { void call(ClientResult result); }
	public interface AuthorizationScreenClosedCallback { void call(); }
	public interface TokenExpirationCallback { void call(); }
	public interface UnmergeIntoProvisionalAccountCallback { void call(ClientResult result); }
	public interface UpdateProvisionalAccountDisplayNameCallback { void call(ClientResult result); }
	public interface UpdateTokenCallback { void call(ClientResult result); }
	public interface DeleteUserMessageCallback { void call(ClientResult result); }
	public interface EditUserMessageCallback { void call(ClientResult result); }
	public interface GetLobbyMessagesCallback { void call(ClientResult result, List<MessageHandle> messages); }
	public interface UserMessageSummariesCallback { void call(ClientResult result, List<UserMessageSummary> summaries); }
	public interface UserMessagesWithLimitCallback { void call(ClientResult result, List<MessageHandle> messages); }
	public interface ProvisionalUserMergeRequiredCallback { void call(); }
	public interface OpenMessageInDiscordCallback { void call(ClientResult result); }
	public interface SendUserMessageCallback { void call(ClientResult result, long messageId); }
	public interface MessageCreatedCallback { void call(long messageId); }
	public interface MessageDeletedCallback { void call(long messageId, long channelId); }
	public interface MessageUpdatedCallback { void call(long messageId); }
	public interface LogCallback { void call(String message, LoggingSeverity severity); }
	public interface OpenConnectedGamesSettingsInDiscordCallback { void call(ClientResult result); }
	public interface OnStatusChanged { void call(Status status, Error error, int errorDetail); }
	public interface CreateOrJoinLobbyCallback { void call(ClientResult result, long lobbyId); }
	public interface GetGuildChannelsCallback { void call(ClientResult result, List<GuildChannel> guildChannels); }
	public interface GetUserGuildsCallback { void call(ClientResult result, List<GuildMinimal> guilds); }
	public interface JoinLinkedLobbyGuildCallback { void call(ClientResult result, String inviteUrl); }
	public interface LeaveLobbyCallback { void call(ClientResult result); }
	public interface LinkOrUnlinkChannelCallback { void call(ClientResult result); }
	public interface LobbyCreatedCallback { void call(long lobbyId); }
	public interface LobbyDeletedCallback { void call(long lobbyId); }
	public interface LobbyMemberAddedCallback { void call(long lobbyId, long memberId); }
	public interface LobbyMemberRemovedCallback { void call(long lobbyId, long memberId); }
	public interface LobbyMemberUpdatedCallback { void call(long lobbyId, long memberId); }
	public interface LobbyUpdatedCallback { void call(long lobbyId); }
	public interface AcceptActivityInviteCallback { void call(ClientResult result, String joinSecret); }
	public interface SendActivityInviteCallback { void call(ClientResult result); }






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
	public void endCall(long channelId, EndCallCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_EndCallCallback.allocate(userData -> {
			callback.call();
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());

		Discord_Client_EndCall(instance, channelId, callback__native, userDataFree, MemorySegment.NULL);
	}
	public void endCalls(EndCallsCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_EndCallsCallback.allocate(userData -> {
			callback.call();
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());

		Discord_Client_EndCalls(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public Call getCall(long channelId) {
		Arena arena = Arena.ofAuto();
		MemorySegment memorySegment = arena.allocate(Discord_Call.layout());
		boolean returnIsNonNull = Discord_Client_GetCall(instance, channelId, memorySegment);
		return returnIsNonNull ? new Call(memorySegment, arena) : null; // TODO
	}
	public List<Call> getCalls() {
		MemorySegment returnValueNative__ = Arena.ofAuto().allocate(Discord_CallSpan.layout());
		Discord_Client_GetCalls(instance, returnValueNative__);
		List<Call> returnValue = new ArrayList<>();
		long size = Discord_CallSpan.size(returnValueNative__);
		for (long i = 0; i < size; i++) {
			MemorySegment trueSegment = Discord_CallSpan.ptr(returnValueNative__).asSlice(i * Discord_Call.layout().byteSize(), Discord_Call.layout());
			Arena arena = Arena.ofAuto();
			MemorySegment copiedSegment = Discord_Call.allocate(arena);
			copiedSegment.copyFrom(trueSegment);
			returnValue.add(new Call(copiedSegment, arena));
		}
		Discord_Free(Discord_CallSpan.ptr(returnValueNative__));
		return returnValue;
	}
	public void getCurrentInputDevice(GetCurrentInputDeviceCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_GetCurrentInputDeviceCallback.allocate((device, userData) -> {
			cb.call(new AudioDevice(device, null));
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());

		Discord_Client_GetCurrentInputDevice(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public void getCurrentOutputDevice(GetCurrentOutputDeviceCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_GetCurrentOutputDeviceCallback.allocate((device, userData) -> {
			cb.call(new AudioDevice(device, null));
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());

		Discord_Client_GetCurrentOutputDevice(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public void getInputDevices(GetInputDevicesCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_GetInputDevicesCallback.allocate((devices, userData) -> {
			List<AudioDevice> audioDevices = new ArrayList<>();
			for (long i = 0; i < Discord_AudioDeviceSpan.size(devices); i++) {
				Arena arena1 = Arena.ofAuto();
				MemorySegment slice = Discord_Call.asSlice(Discord_AudioDeviceSpan.ptr(devices), i);
				MemorySegment allocate = arena1.allocate(Discord_Call.layout());
				allocate.copyFrom(slice);
				audioDevices.add(new AudioDevice(allocate, arena1));
			}
			Discord_Free(Discord_AudioDeviceSpan.ptr(devices));
			cb.call(audioDevices);
		}, arena);

		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());

		Discord_Client_GetInputDevices(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public float getInputVolume() {
		return Discord_Client_GetInputVolume(instance);
	}
	public void getOutputDevices(GetInputDevicesCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_GetOutputDevicesCallback.allocate((devices, userData) -> {
			List<AudioDevice> audioDevices = new ArrayList<>();
			for (long i = 0; i < Discord_AudioDeviceSpan.size(devices); i++) {
				Arena arena1 = Arena.ofAuto();
				MemorySegment slice = Discord_Call.asSlice(Discord_AudioDeviceSpan.ptr(devices), i);
				MemorySegment allocate = arena1.allocate(Discord_Call.layout());
				allocate.copyFrom(slice);
				audioDevices.add(new AudioDevice(allocate, arena1));
			}
			Discord_Free(Discord_AudioDeviceSpan.ptr(devices));
			cb.call(audioDevices);
		}, arena);

		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());

		Discord_Client_GetOutputDevices(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
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
	public void setDeviceChangeCallback(DeviceChangeCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_DeviceChangeCallback.allocate((inputDevices, outputDevices, userData) -> {
			List<AudioDevice> inputDevicesList = new ArrayList<>();
			for (long i = 0; i < Discord_AudioDeviceSpan.size(inputDevices); i++) {
				Arena arena1 = Arena.ofAuto();
				MemorySegment newSegment = Discord_AudioDevice.allocate(arena1);
				newSegment.copyFrom(Discord_AudioDevice.asSlice(Discord_AudioDeviceSpan.ptr(inputDevices), i));
				inputDevicesList.add(new AudioDevice(newSegment, arena1));
			}
			Discord_Free(Discord_AudioDeviceSpan.ptr(inputDevices));
			List<AudioDevice> outputDevicesList = new ArrayList<>();
			for (long i = 0; i < Discord_AudioDeviceSpan.size(outputDevices); i++) {
				Arena arena1 = Arena.ofAuto();
				MemorySegment newSegment = Discord_AudioDevice.allocate(arena1);
				newSegment.copyFrom(Discord_AudioDevice.asSlice(Discord_AudioDeviceSpan.ptr(outputDevices), i));
				outputDevicesList.add(new AudioDevice(newSegment, arena1));
			}
			Discord_Free(Discord_AudioDeviceSpan.ptr(outputDevices));
			callback.call(inputDevicesList, outputDevicesList);
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetDeviceChangeCallback(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public void setEchoCancellation(boolean on) {
		Discord_Client_SetEchoCancellation(instance, on);
	}
	public void setInputDevice(String deviceId, SetInputDeviceCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment deviceId__str = CrosshairUtils.toDiscordString(deviceId);
		MemorySegment callback__native = Discord_Client_SetInputDeviceCallback.allocate((result, userData) -> cb.call(new ClientResult(result)), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetInputDevice(instance, deviceId__str, callback__native, userDataFree, MemorySegment.NULL);
	}
	public void setInputVolume(float inputVolume) {
		Discord_Client_SetInputVolume(instance, inputVolume);
	}
	public void setNoAudioInputCallback(NoAudioInputCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_NoAudioInputCallback.allocate((inputDetected, userData) -> callback.call(inputDetected), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetNoAudioInputCallback(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public void setNoAudioInputThreshold(float dBFSThreshold) {
		Discord_Client_SetNoAudioInputThreshold(instance, dBFSThreshold);
	}
	public void setNoiseSuppression(boolean on) {
		Discord_Client_SetNoiseSuppression(instance, on);
	}
	public void setOpusHardwareCoding(boolean encode, boolean decode) {
		Discord_Client_SetOpusHardwareCoding(instance, encode, decode);
	}
	public void setOutputDevice(String deviceId, SetOutputDeviceCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment deviceId__str = CrosshairUtils.toDiscordString(deviceId);
		MemorySegment callback__native = Discord_Client_SetOutputDeviceCallback.allocate((result, userData) -> cb.call(new ClientResult(result)), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetOutputDevice(instance, deviceId__str, callback__native, userDataFree, MemorySegment.NULL);
	}
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
	public void setThreadPriority(Thread thread, int priority) {
		Discord_Client_SetThreadPriority(instance, thread.ordinal(), priority);
	}
	public void setVoiceParticipantChangedCallback(VoiceParticipantChangedCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_VoiceParticipantChangedCallback.allocate((lobbyId, memberId, added, userData) -> cb.call(lobbyId, memberId, added), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetVoiceParticipantChangedCallback(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public boolean showAudioRoutePicker() {
		return Discord_Client_ShowAudioRoutePicker(instance);
	}
	public Call startCall(long channelId) {
		Arena arena = Arena.ofAuto();
		boolean returnIsNonNull__;
		@$("Discord_Call") MemorySegment returnValueNative__ = Discord_Call.allocate(arena);
		returnIsNonNull__ = Discord_Client_StartCall(instance, channelId, returnValueNative__);
		return returnIsNonNull__ ? new Call(returnValueNative__, arena) : null /*TODO DiscordObjectState*/;
	}
	public Call startCallWithAudioCallbacks(long lobbyId, UserAudioReceivedCallback receivedCb, UserAudioCapturedCallback capturedCb) {
		boolean returnIsNonNull__;
		Arena autoArena = Arena.ofAuto();
		@$("Discord_Call") MemorySegment returnValueNative__ = Discord_Call.allocate(autoArena);
		Arena receivedArena = Arena.ofShared();
		@$("Discord_Client_UserAudioReceivedCallback") MemorySegment receivedCb__native = Discord_Client_UserAudioReceivedCallback.allocate((userId, data, samplesPerChannel, sampleRate, channels, outShouldMute, userData) -> receivedCb.call(userId, data.asByteBuffer().asShortBuffer(), samplesPerChannel, sampleRate, channels, BooleanHolder.of(() -> outShouldMute.get(AddressLayout.JAVA_BOOLEAN, 0), b -> outShouldMute.set(AddressLayout.JAVA_BOOLEAN, 0, b))), receivedArena);
		MemorySegment receivedUserDataFree = Discord_FreeFn.allocate(ptr -> receivedArena.close(), Arena.global());
		Arena capturedArena = Arena.ofShared();
		@$("Discord_Client_UserAudioCapturedCallback") MemorySegment capturedCb__native = Discord_Client_UserAudioCapturedCallback.allocate((data, samplesPerChannel, sampleRate, channels, userData) -> capturedCb.call(data.asByteBuffer().asShortBuffer(), samplesPerChannel, sampleRate, channels), capturedArena);
		MemorySegment capturedUserDataFree = Discord_FreeFn.allocate(ptr -> capturedArena.close(), Arena.global());
		returnIsNonNull__ = Discord_Client_StartCallWithAudioCallbacks(instance, lobbyId, receivedCb__native, receivedUserDataFree, MemorySegment.NULL, capturedCb__native, capturedUserDataFree, MemorySegment.NULL, returnValueNative__);
		return returnIsNonNull__ ? new Call(returnValueNative__, autoArena) : null /*TODO DiscordObjectState*/;
	}
	public void abortAuthorize() {
		Discord_Client_AbortAuthorize(instance);
	}
	public void abortGetTokenFromDevice() {
		Discord_Client_AbortGetTokenFromDevice(instance);
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
	public void exchangeClientToken(String parentApplicationToken, long childApplicationId, ExchangeChildTokenCallback callback) {
		Arena arena = Arena.ofShared();
		@$("Discord_String") MemorySegment parentApplicationToken__str = CrosshairUtils.toDiscordString(parentApplicationToken);
		@$("Discord_Client_ExchangeChildTokenCallback") MemorySegment callback__native = Discord_Client_ExchangeChildTokenCallback.allocate((result, accessToken, tokenType, expiresIn, scopes, userData) -> {
			callback.call(new ClientResult(result), CrosshairUtils.toJavaString(accessToken), AuthorizationTokenType.values()[tokenType], expiresIn, CrosshairUtils.toJavaString(scopes));
			Discord_Free(Discord_String.ptr(scopes));
			Discord_Free(Discord_String.ptr(accessToken));
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_ExchangeChildToken(instance, parentApplicationToken__str, childApplicationId, callback__native, userDataFree, MemorySegment.NULL);
	}
	public void fetchCurrentUser(AuthorizationTokenType tokenType, String token, FetchCurrentUserCallback callback) {
		Arena arena = Arena.ofShared();
		@$("Discord_String") MemorySegment token__str = CrosshairUtils.toDiscordString(token);
		@$("Discord_Client_FetchCurrentUserCallback") MemorySegment callback__native = Discord_Client_FetchCurrentUserCallback.allocate((result, id, name, userData) -> {
			ClientResult result__obj = new ClientResult(result);
			String name__str = CrosshairUtils.toJavaString(name);
			callback.call(result__obj, id, name__str);
			Discord_Free(Discord_String.ptr(name));
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_FetchCurrentUser(instance, tokenType.ordinal(), token__str, callback__native, userDataFree, MemorySegment.NULL);
	}
	public enum AuthenticationExternalAuthType {
		OIDC,
		EPIC_ONLINE_SERVICES_ACCESS_TOKEN,
		EPIC_ONLINE_SERVICES_ID_TOKEN,
		STEAM_SESSION_TICKET,
		UNITY_SERVICES_ID_TOKEN
	}
	public void getProvisionalToken(long applicationId, AuthenticationExternalAuthType externalAuthType, String externalAuthToken, TokenExchangeCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_TokenExchangeCallback.allocate((result, accessToken, refreshToken, tokenType, expiresIn, scopes, userData) -> {
			callback.call(new ClientResult(result), CrosshairUtils.toJavaString(accessToken), CrosshairUtils.toJavaString(refreshToken), AuthorizationTokenType.values()[tokenType], expiresIn, CrosshairUtils.toJavaString(scopes));
			Discord_Free(Discord_String.ptr(scopes));
			Discord_Free(Discord_String.ptr(refreshToken));
			Discord_Free(Discord_String.ptr(accessToken));
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetProvisionalToken(instance, applicationId, externalAuthType.ordinal(), CrosshairUtils.toDiscordString(externalAuthToken), callback__native, userDataFree, MemorySegment.NULL);
	}
	public void getToken(long applicationId, String code, String codeVerifier, String redirectUri, TokenExchangeCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_TokenExchangeCallback.allocate((result, accessToken, refreshToken, tokenType, expiresIn, scopes, userData) -> callback.call(new ClientResult(result), CrosshairUtils.toJavaString(accessToken), CrosshairUtils.toJavaString(refreshToken), AuthorizationTokenType.values()[tokenType], expiresIn, CrosshairUtils.toJavaString(scopes)), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetToken(instance, applicationId, CrosshairUtils.toDiscordString(code), CrosshairUtils.toDiscordString(codeVerifier), CrosshairUtils.toDiscordString(redirectUri), callback__native, userDataFree, MemorySegment.NULL);
	}
	public void getTokenFromDevice(DeviceAuthorizationArgs args, TokenExchangeCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_TokenExchangeCallback.allocate((result, accessToken, refreshToken, tokenType, expiresIn, scopes, userData) -> {
			callback.call(new ClientResult(result), CrosshairUtils.toJavaString(accessToken), CrosshairUtils.toJavaString(refreshToken), AuthorizationTokenType.values()[tokenType], expiresIn, CrosshairUtils.toJavaString(scopes));
			Discord_Free(Discord_String.ptr(scopes));
			Discord_Free(Discord_String.ptr(refreshToken));
			Discord_Free(Discord_String.ptr(accessToken));
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetTokenFromDevice(instance, args.getSegment(), callback__native, userDataFree, MemorySegment.NULL);
	}
	public void getTokenFromDeviceProvisionalMerge(DeviceAuthorizationArgs args, AuthenticationExternalAuthType externalAuthType, String externalAuthToken, TokenExchangeCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment externalAuthToken__str = CrosshairUtils.toDiscordString(externalAuthToken);
		MemorySegment callback__native = Discord_Client_TokenExchangeCallback.allocate((result, accessToken, refreshToken, tokenType, expiresIn, scopes, userData) -> {
			callback.call(new ClientResult(result), CrosshairUtils.toJavaString(accessToken), CrosshairUtils.toJavaString(refreshToken), AuthorizationTokenType.values()[tokenType], expiresIn, CrosshairUtils.toJavaString(scopes));
			Discord_Free(Discord_String.ptr(scopes));
			Discord_Free(Discord_String.ptr(refreshToken));
			Discord_Free(Discord_String.ptr(accessToken));
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetTokenFromDeviceProvisionalMerge(instance, args.getSegment(), externalAuthType.ordinal(), externalAuthToken__str, callback__native, userDataFree, MemorySegment.NULL);
	}
	public void getTokenFromProvisionalMerge(long applicationId, String code, String codeVerifier, String redirectUri, AuthenticationExternalAuthType externalAuthType, String externalAuthToken, TokenExchangeCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment code__str = CrosshairUtils.toDiscordString(externalAuthToken);
		MemorySegment codeVerifier__str = CrosshairUtils.toDiscordString(externalAuthToken);
		MemorySegment redirectUri__str = CrosshairUtils.toDiscordString(externalAuthToken);
		MemorySegment externalAuthToken__str = CrosshairUtils.toDiscordString(externalAuthToken);
		MemorySegment callback__native = Discord_Client_TokenExchangeCallback.allocate((result, accessToken, refreshToken, tokenType, expiresIn, scopes, userData) -> {
			callback.call(new ClientResult(result), CrosshairUtils.toJavaString(accessToken), CrosshairUtils.toJavaString(refreshToken), AuthorizationTokenType.values()[tokenType], expiresIn, CrosshairUtils.toJavaString(scopes));
			Discord_Free(Discord_String.ptr(scopes));
			Discord_Free(Discord_String.ptr(refreshToken));
			Discord_Free(Discord_String.ptr(accessToken));
		}, arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetTokenFromProvisionalMerge(instance, applicationId, code__str, codeVerifier__str, redirectUri__str, externalAuthType.ordinal(), externalAuthToken__str, callback__native, userDataFree, MemorySegment.NULL);
	}
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
	public void getUserMessagesWithLimit(long recipientId, int limit, UserMessagesWithLimitCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_UserMessagesWithLimitCallback.allocate((result, messages, userData) -> cb.call(new ClientResult(result), CrosshairUtils.unpackMessageHandleSpan(messages).stream().map(MessageHandle::new).toList()), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_GetUserMessagesWithLimit(instance, recipientId, limit, callback__native, userDataFree, MemorySegment.NULL);
	}
	// TODO OpenMessageInDiscord
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
	public void setMessageCreatedCallback(MessageCreatedCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_MessageCreatedCallback.allocate((messageId, userData) -> cb.call(messageId), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetMessageCreatedCallback(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	public void setMessageDeletedCallback(MessageDeletedCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_MessageDeletedCallback.allocate((messageId, channelId, userData) -> cb.call(messageId, channelId), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_SetMessageDeletedCallback(instance, callback__native, userDataFree, MemorySegment.NULL);
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
	public void createOrJoinLobby(String secret, CreateOrJoinLobbyCallback callback) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_CreateOrJoinLobbyCallback.allocate((result, lobbyId, userData) -> callback.call(new ClientResult(result), lobbyId), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());
		Discord_Client_CreateOrJoinLobby(instance, CrosshairUtils.toDiscordString(secret), callback__native, userDataFree, MemorySegment.NULL);
	}
	// TODO CreateOrJoinLobbyWithMetadata
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
	public void getUserGuilds(GetUserGuildsCallback cb) {
		Arena arena = Arena.ofShared();
		MemorySegment callback__native = Discord_Client_GetUserGuildsCallback.allocate((result, guilds, userData) -> cb.call(new ClientResult(result), CrosshairUtils.unpackGuildChannelSpan(guilds).stream().map(GuildMinimal::new).toList()), arena);
		MemorySegment userDataFree = Discord_FreeFn.allocate(ptr -> arena.close(), Arena.global());

		Discord_Client_GetUserGuilds(instance, callback__native, userDataFree, MemorySegment.NULL);
	}
	// TODO JoinLinkedLobbyGuild
	//  LeaveLobby
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
	///  @deprecated use {@link Client#getCurrentUserV2()} instead
	@Deprecated(forRemoval = true)
	public UserHandle getCurrentUser() {
		Arena arena = Arena.ofAuto();
		@$("UserHandle*") MemorySegment handle = arena.allocate(ValueLayout.ADDRESS);
		Discord_Client_GetCurrentUser(instance, handle);
		return new UserHandle(handle, arena);
	}
	public Optional<UserHandle> getCurrentUserV2() {
		Arena arena = Arena.ofAuto();
		MemorySegment handle = arena.allocate(Discord_UserHandle.layout());
		boolean isNonNull = Discord_Client_GetCurrentUserV2(instance, handle);
		return isNonNull ? Optional.of(new UserHandle(handle, arena)) : Optional.empty();
	}
	public Optional<UserHandle> getUser(long userId) {
		Arena arena = Arena.ofAuto();
		@$("Discord_UserHandle*") MemorySegment handle = arena.allocate(ValueLayout.ADDRESS);
		if (!Discord_Client_GetUser(instance, userId, handle)) return Optional.empty();
		return Optional.of(new UserHandle(handle, arena));
	}

	@Override
	public MemorySegment getSegment() {
		return instance;
	}
}
