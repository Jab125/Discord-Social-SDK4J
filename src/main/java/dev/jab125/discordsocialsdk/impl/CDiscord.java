// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.impl;

import dev.jab125.discordsocialsdk.$;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static dev.jab125.discordsocialsdk.impl.DiscordNatives.LINKER;
import static dev.jab125.discordsocialsdk.impl.DiscordNatives.lookup;

@SuppressWarnings("removal")
public class CDiscord {

	private static FunctionDescriptor _Discord_Client_OnStatusChanged;
	private static MethodHandle _Discord_Client_OnStatusChanged$handle;
	private static FunctionDescriptor _Discord_FreeFn;
	private static MethodHandle _Discord_FreeFn$handle;
	private static MethodHandle _Discord_Client_Init;
	private static MethodHandle _Discord_Client_CreateAuthorizationCodeVerifier;
	private static MethodHandle _Discord_Client_Authorize;
	private static FunctionDescriptor _Discord_Client_AuthorizationCallback;
	public static StructLayout _Discord_String;
	private static MethodHandle _Discord_Client_AuthorizationCallback$handle;
	private static MethodHandle _Discord_AuthorizationArgs_Init;
	private static MethodHandle _Discord_AuthorizationArgs_SetClientId;
	private static MethodHandle _Discord_AuthorizationArgs_SetScopes;
	private static MethodHandle _Discord_AuthorizationArgs_SetCodeChallenge;
	private static MethodHandle _Discord_AuthorizationCodeVerifier_Challenge;
	private static MethodHandle _Discord_ClientResult_Successful;
	private static MethodHandle _Discord_ClientResult_Error;
	private static MethodHandle _Discord_Client_AddLogCallback;
	private static FunctionDescriptor _Discord_Client_LogCallback;
	private static MethodHandle _Discord_Client_LogCallback$handle;
	private static MethodHandle _Discord_Client_GetToken;
	private static MethodHandle _Discord_Client_TokenExchangeCallback$handle;
	private static FunctionDescriptor _Discord_Client_TokenExchangeCallback;
	private static MethodHandle _Discord_AuthorizationCodeVerifier_Verifier;
	private static MethodHandle _Discord_Client_UpdateToken;
	private static MethodHandle _Discord_Client_UpdateTokenCallback$handle;
	private static FunctionDescriptor _Discord_Client_UpdateTokenCallback;
	private static MethodHandle _Discord_Client_Connect;
	private static MethodHandle _Discord_Activity_Init;
	private static MethodHandle _Discord_Activity_SetType;
	private static MethodHandle _Discord_Client_UpdateRichPresence;
	private static FunctionDescriptor _Discord_Client_UpdateRichPresenceCallback;
	private static MethodHandle _Discord_Client_UpdateRichPresenceCallback$handle;
	private static MethodHandle _Discord_Activity_SetState;
	private static MethodHandle _Discord_Activity_SetDetails;
	private static MethodHandle _Discord_Activity_SetApplicationId;
	private static MethodHandle _Discord_Client_SetApplicationId;
	private static MethodHandle _Discord_Client_GetApplicationId;
	private static MethodHandle _Discord_Client_GetRelationships;
	public static StructLayout _Discord_RelationshipHandleSpan;
	private static MethodHandle _Discord_RelationshipHandle_Id;
	private static MethodHandle _Discord_RelationshipHandle_User;
	private static MethodHandle _Discord_UserHandle_DisplayName;
	private static MethodHandle _Discord_RelationshipHandle_DiscordRelationshipType;
	private static MethodHandle _Discord_UserHandle_Id;
	private static MethodHandle _Discord_Client_CreateOrJoinLobby;
	private static FunctionDescriptor _Discord_Client_CreateOrJoinLobbyCallback;
	private static MethodHandle _Discord_Client_CreateOrJoinLobbyCallback$handle;
	private static MethodHandle _Discord_Client_LinkChannelToLobby;
	private static FunctionDescriptor _Discord_Client_LinkOrUnlinkChannelCallback;
	private static MethodHandle _Discord_Client_LinkOrUnlinkChannelCallback$handle;
	private static MethodHandle _Discord_Client_SendLobbyMessage;
	private static FunctionDescriptor _Discord_Client_SendUserMessageCallback;
	private static MethodHandle _Discord_Client_SendUserMessageCallback$handle;
	private static MethodHandle _Discord_Client_SetMessageCreatedCallback;
	private static FunctionDescriptor _Discord_Client_MessageCreatedCallback;
	private static MethodHandle _Discord_Client_MessageCreatedCallback$handle;
	private static StructLayout _Discord_MessageHandleSpan;
	private static MethodHandle _Discord_Client_GetLobbyMessagesCallback$handle;
	private static FunctionDescriptor _Discord_Client_GetLobbyMessagesCallback;
	private static MethodHandle _Discord_Client_GetLobbyMessagesWithLimit;
	private static MethodHandle _Discord_Client_GetLobbyIds;
	public static StructLayout _Discord_UInt64Span;
	public static StructLayout _Discord_Properties;
	private static MethodHandle _Discord_RelationshipHandle_GameRelationshipType;
	private static MethodHandle _Discord_Client_GetRelationshipsByGroup;
	private static MethodHandle _Discord_Client_GetLobbyHandle;

	static {
		try {
			createHandles();
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("UnusedLabel")
	private static void createHandles() throws NoSuchMethodException, IllegalAccessException {
		Arena arena = Arena.ofAuto();
		SymbolLookup lookup = lookup(arena);
		Discord_String: {
			_Discord_String = MemoryLayout.structLayout(
					ValueLayout.ADDRESS.withName("ptr"),
					ValueLayout.JAVA_LONG.withName("size")
			);
		}
		// Discord_RelationshipHandle is a pointer to some impl stuff on discord's size
		// typedef struct Discord_RelationshipHandleSpan {
		//    Discord_RelationshipHandle* ptr;
		//    size_t size;
		//} Discord_RelationshipHandleSpan;
		Discord_RelationshipHandleSpan: {
			_Discord_RelationshipHandleSpan = MemoryLayout.structLayout(ValueLayout.ADDRESS.withName("ptr"), ValueLayout.JAVA_LONG.withName("size"));
		}
		// typedef struct Discord_MessageHandleSpan {
		//    Discord_MessageHandle* ptr;
		//    size_t size;
		//} Discord_MessageHandleSpan;
		Discord_UInt64Span: {
			_Discord_UInt64Span = MemoryLayout.structLayout(ValueLayout.ADDRESS.withName("ptr"), ValueLayout.JAVA_LONG.withName("size"));
		}
		// typedef struct Discord_UInt64Span {
		//    uint64_t* ptr;
		//    size_t size;
		//} Discord_UInt64Span;
		//
		Discord_Properties: {
			_Discord_Properties = MemoryLayout.structLayout(ValueLayout.JAVA_LONG.withName("size"), ValueLayout.ADDRESS.withName("keys"), ValueLayout.ADDRESS.withName("values"));
		}
//		typedef struct Discord_Properties {
//			size_t size;
//			struct Discord_String* keys;
//			struct Discord_String* values;
//		} Discord_Properties;
		//
		Discord_MessageHandleSpan: {
			_Discord_MessageHandleSpan = MemoryLayout.structLayout(ValueLayout.ADDRESS.withName("ptr"), ValueLayout.JAVA_LONG.withName("size"));
		}
		Discord_RelationshipHandle_Id: {
			MemorySegment functionAddress = lookup.find("Discord_RelationshipHandle_Id").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_RelationshipHandle_Id = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_RelationshipHandle_User: {
			MemorySegment functionAddress = lookup.find("Discord_RelationshipHandle_User").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_RelationshipHandle_User = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_RelationshipHandle_DiscordRelationshipType: {
			MemorySegment functionAddress = lookup.find("Discord_RelationshipHandle_DiscordRelationshipType").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS);
			_Discord_RelationshipHandle_DiscordRelationshipType = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_RelationshipHandle_GameRelationshipType: {
			MemorySegment functionAddress = lookup.find("Discord_RelationshipHandle_GameRelationshipType").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS);
			_Discord_RelationshipHandle_GameRelationshipType = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_UserHandle_DisplayName: {
			MemorySegment functionAddress = lookup.find("Discord_UserHandle_DisplayName").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_UserHandle_DisplayName = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetRelationshipsByGroup: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetRelationshipsByGroup").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.ADDRESS);
			_Discord_Client_GetRelationshipsByGroup = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_SetFreeThreaded: {
			MemorySegment functionAddress = lookup.find("Discord_SetFreeThreaded").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid();
			_Discord_SetFreeThreaded = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_ResetCallbacks: {
			MemorySegment functionAddress = lookup.find("Discord_ResetCallbacks").get();
			//var layout = MemoryLayout.sequenceLayout(Long.MAX_VALUE, JAVA_BYTE);
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid();
			_Discord_ResetCallbacks = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_RunCallbacks: {
			MemorySegment functionAddress = lookup.find("Discord_RunCallbacks").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid();
			_Discord_RunCallbacks = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Activity_Init: {
			MemorySegment functionAddress = lookup.find("Discord_Activity_Init").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_Activity_Init = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Activity_SetType: {
			MemorySegment functionAddress = lookup.find("Discord_Activity_SetType").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_INT);
			_Discord_Activity_SetType = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Activity_SetApplicationId: {
			MemorySegment functionAddress = lookup.find("Discord_Activity_SetApplicationId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Activity_SetApplicationId = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_Init: {
			MemorySegment functionAddress = lookup.find("Discord_Client_Init").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_Client_Init = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetRelationships: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetRelationships").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_GetRelationships = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetLobbyIds: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetLobbyIds").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_GetLobbyIds = LINKER.downcallHandle(functionAddress, functionSignature);
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
		Discord_Client_GetApplicationId: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetApplicationId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_Client_GetApplicationId = LINKER.downcallHandle(functionAddress, functionSignature);
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

			_Discord_FreeFn = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_FreeFn$handle = MethodHandles.lookup().findVirtual(Discord_FreeFn.class, "call",
					MethodType.methodType(void.class, MemorySegment.class));

			_Discord_SetStatusChangedCallback = methodHandle;
		}
		Discord_Client_CreateAuthorizationCodeVerifier: {
			MemorySegment functionAddress = lookup.find("Discord_Client_CreateAuthorizationCodeVerifier").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Client_CreateAuthorizationCodeVerifier = LINKER.downcallHandle(functionAddress, functionSignature);
		}// MemorySegment result, String code, String redirectUri, MemorySegment userData
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
		Discord_AuthorizationArgs_Init: {
			MemorySegment functionAddress = lookup.find("Discord_AuthorizationArgs_Init").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_AuthorizationArgs_Init = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_AuthorizationArgs_SetClientId: {
			MemorySegment functionAddress = lookup.find("Discord_AuthorizationArgs_SetClientId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG);
			_Discord_AuthorizationArgs_SetClientId = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_AuthorizationArgs_SetScopes: {
			MemorySegment functionAddress = lookup.find("Discord_AuthorizationArgs_SetScopes").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, _Discord_String);
			_Discord_AuthorizationArgs_SetScopes = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_AuthorizationArgs_SetCodeChallenge: {
			MemorySegment functionAddress = lookup.find("Discord_AuthorizationArgs_SetCodeChallenge").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_AuthorizationArgs_SetCodeChallenge = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_AuthorizationCodeVerifier_Challenge: {
			MemorySegment functionAddress = lookup.find("Discord_AuthorizationCodeVerifier_Challenge").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_AuthorizationCodeVerifier_Challenge = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_ClientResult_Successful: {
			MemorySegment functionAddress = lookup.find("Discord_ClientResult_Successful").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS);
			_Discord_ClientResult_Successful = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_ClientResult_Error: {
			MemorySegment functionAddress = lookup.find("Discord_ClientResult_Error").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_ClientResult_Error = LINKER.downcallHandle(functionAddress, functionSignature);
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
		Discord_Client_GetToken: {
			//Discord_Client_GetToken();
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
		Discord_AuthorizationCodeVerifier_Verifier: {
			MemorySegment functionAddress = lookup.find("Discord_AuthorizationCodeVerifier_Verifier").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_AuthorizationCodeVerifier_Verifier = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_UserHandle_Id: {
			MemorySegment functionAddress = lookup.find("Discord_UserHandle_Id").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_UserHandle_Id = LINKER.downcallHandle(functionAddress, functionSignature);
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
		Discord_Activity_SetState: {
			MemorySegment functionAddress = lookup.find("Discord_Activity_SetState").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Activity_SetState = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Activity_SetDetails: {
			MemorySegment functionAddress = lookup.find("Discord_Activity_SetDetails").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_Activity_SetDetails = LINKER.downcallHandle(functionAddress, functionSignature);
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
		Discord_Client_GetMessageHandle: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetMessageHandle").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_Client_GetMessageHandle = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_GetLobbyHandle: {
			MemorySegment functionAddress = lookup.find("Discord_Client_GetLobbyHandle").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_Client_GetLobbyHandle = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_Client_StartCall: {
			MemorySegment functionAddress = lookup.find("Discord_Client_StartCall").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_Client_StartCall = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		setupMessageHandles(arena, lookup);
		setupLobbyHandles(arena, lookup);
		setupLinkedChannels(arena, lookup);
	}

	// all ()V
	private static MethodHandle _Discord_ResetCallbacks;
	private static MethodHandle _Discord_RunCallbacks;
	private static MethodHandle _Discord_SetFreeThreaded;
	private static MethodHandle _Discord_SetStatusChangedCallback;

//	void DISCORD_API Discord_Client_GetRelationships(Discord_Client* self,
//                                                 Discord_RelationshipHandleSpan* returnValue);
	public static void Discord_Client_GetRelationships(@$("Discord_Client*") MemorySegment self, @$("Discord_RelationshipHandleSpan*") MemorySegment returnValue) {
		r(() -> {
			_Discord_Client_GetRelationships.invokeExact(self, returnValue);
		});
	}

	public static void Discord_Client_GetLobbyIds(@$("Discord_Client*") MemorySegment self, @$("Discord_UInt64Span*") MemorySegment returnValue) {
		r(() -> {
			_Discord_Client_GetLobbyIds.invokeExact(self, returnValue);
		});
	}
	// void DISCORD_API Discord_Client_GetLobbyIds(Discord_Client* self, Discord_UInt64Span* returnValue);

	public static void Discord_SetFreeThreaded() {
		r(() -> {
			_Discord_SetFreeThreaded.invokeExact();
		});
	}
	public static void Discord_ResetCallbacks() {
		r(() -> {
			_Discord_ResetCallbacks.invokeExact();
		});
	}
	public static void Discord_RunCallbacks() {
		r(() -> {
			_Discord_RunCallbacks.invokeExact();
		});
	}

	public static void Discord_Activity_Init(MemorySegment self) {
		r(() -> {
			_Discord_Activity_Init.invokeExact(self);
		});
	}

	public static void Discord_Activity_SetType(MemorySegment self, @$("Discord_ActivityTypes") int value) {
		r(() -> {
			_Discord_Activity_SetType.invokeExact(self, value);
		});
	}

	public static void Discord_Activity_SetApplicationId(MemorySegment self, MemorySegment value) {
		r(() -> {
			_Discord_Activity_SetApplicationId.invokeExact(self, value);
		});
	}
	private static MethodHandle _Discord_Client_GetMessageHandle;
	public static boolean Discord_Client_GetMessageHandle(@$("Discord_Client*") MemorySegment self, long messageId, @$("Discord_MessageHandle*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_Client_GetMessageHandle.invokeExact(self, messageId, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	//bool DISCORD_API Discord_Client_GetMessageHandle(Discord_Client* self,
	//                                                 uint64_t messageId,
	//                                                 Discord_MessageHandle* returnValue);
	public static void Discord_Client_SetApplicationId(MemorySegment self, MemorySegment value) {
		r(() -> {
			_Discord_Client_SetApplicationId.invokeExact(self, value);
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

	public static void Discord_Activity_SetState(MemorySegment self, String value) {
		r(() -> {
			_Discord_Activity_SetState.invokeExact(self, _DiscordStringFromJavaString(value));
		});
	}

	public static void Discord_Activity_SetDetails(MemorySegment self, String value) {
		r(() -> {
			_Discord_Activity_SetDetails.invokeExact(self, _DiscordStringFromJavaString(value));
		});
	}

	public static void Discord_Client_Init(MemorySegment self) {
		r(() -> {
			_Discord_Client_Init.invokeExact(self);
			System.out.println("ran discord client init");
		});
	}
	public static void Discord_Client_Connect(MemorySegment self) {
		r(() -> {
			_Discord_Client_Connect.invokeExact(self);
		});
	}


	public interface Discord_Client_OnStatusChanged {
		void call(int status, int error, int errorDetail, MemorySegment userData);
	}

	public interface Discord_FreeFn {
		void call(MemorySegment ptr);
	}
	public static void Discord_Client_SetStatusChangedCallback(MemorySegment self, Discord_Client_OnStatusChanged cb,
															   Discord_FreeFn cb__userDataFree,
															   MemorySegment cb__userData) {

		MethodHandle o1 = _Discord_Client_OnStatusChanged$handle.bindTo(cb);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(cb__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_OnStatusChanged, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_SetStatusChangedCallback.invokeExact(self, cb0, cb1, cb__userData);
		});
	}

	public static void Discord_Client_CreateAuthorizationCodeVerifier(MemorySegment self, MemorySegment returnValue) {
		r(() -> {
			_Discord_Client_CreateAuthorizationCodeVerifier.invokeExact(self, returnValue);
		});
	}

	//void DISCORD_API Discord_Client_Authorize(Discord_Client* self,
	//                                          Discord_AuthorizationArgs* args,
	//                                          Discord_Client_AuthorizationCallback callback,
	//                                          Discord_FreeFn callback__userDataFree,
	//                                          void* callback__userData);

	public interface Discord_Client_GetLobbyMessagesCallback {
		void call(@$("Discord_ClientResult*") MemorySegment result, @$("Discord_MessageHandleSpan")/*Discord_MessageHandleSpan struct*/ MemorySegment messages, @$("void*") MemorySegment userData);
		// Discord_ClientResult* result,
		//                                                        Discord_MessageHandleSpan messages,
		//                                                        void* userData
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

	// void DISCORD_API
	//Discord_Client_GetLobbyMessagesWithLimit(Discord_Client* self,
	//                                         uint64_t lobbyId,
	//                                         int32_t limit,
	//                                         Discord_Client_GetLobbyMessagesCallback cb,
	//                                         Discord_FreeFn cb__userDataFree,
	//                                         void* cb__userData);

	public interface Discord_Client_AuthorizationCallback {
		void call(@$("Discord_ClientResult*")MemorySegment result, String code, String redirectUri, @$("void*")MemorySegment userData);
		default void call0(MemorySegment result, MemorySegment code, MemorySegment redirectUri, MemorySegment userData) {
			call(result, _String_Sugar(code), _String_Sugar(redirectUri), userData);
		}


	}
	public static String _String_Sugar(MemorySegment code) {
		VarHandle ptr = _Discord_String.varHandle(MemoryLayout.PathElement.groupElement("ptr"));
		VarHandle size = _Discord_String.varHandle(MemoryLayout.PathElement.groupElement("size"));
		//System.out.println(size);
		long strSize = (long) size.get(code, 0); // if a string is larger than 2^31-1, we are not handling that
		MemorySegment segment = (MemorySegment) ptr.get(code, 0);
		MemorySegment reinterpret = segment.reinterpret(strSize);
		return StandardCharsets.UTF_8.decode(reinterpret.asByteBuffer()).toString();
	}

	public static List<MemorySegment> _unpack__Discord_RelationshipHandleSpan(MemorySegment code) {
		VarHandle ptr = _Discord_RelationshipHandleSpan.varHandle(MemoryLayout.PathElement.groupElement("ptr"));
		VarHandle size = _Discord_RelationshipHandleSpan.varHandle(MemoryLayout.PathElement.groupElement("size"));
		long size2 = (long) size.get(code,0);
		MemorySegment segment = (MemorySegment) ptr.get(code, 0);
		ArrayList<MemorySegment> objects = new ArrayList<>();
		for (long l = 0; l < size2; l++) {
			long address = segment.address();
			MemorySegment memorySegment = MemorySegment.ofAddress(address+(l*ValueLayout.ADDRESS.byteSize()));
			objects.add(memorySegment);
		}
		return List.copyOf(objects);
	}
	public static List<MemorySegment> _unpack__Discord_MessageHandleSpan(MemorySegment code) {
		VarHandle ptr = _Discord_MessageHandleSpan.varHandle(MemoryLayout.PathElement.groupElement("ptr"));
		VarHandle size = _Discord_MessageHandleSpan.varHandle(MemoryLayout.PathElement.groupElement("size"));
		long size2 = (long) size.get(code,0);
		MemorySegment segment = (MemorySegment) ptr.get(code, 0);
		ArrayList<MemorySegment> objects = new ArrayList<>();
		for (long l = 0; l < size2; l++) {
			long address = segment.address();
			MemorySegment memorySegment = MemorySegment.ofAddress(address+(l*ValueLayout.ADDRESS.byteSize()));
			objects.add(memorySegment);
		}
		return List.copyOf(objects);
	}

	// when valhalla?
	public static List<Long> _unpack__Discord_UInt64Span(MemorySegment code) {
		VarHandle ptr = _Discord_UInt64Span.varHandle(MemoryLayout.PathElement.groupElement("ptr"));
		VarHandle size = _Discord_UInt64Span.varHandle(MemoryLayout.PathElement.groupElement("size"));
		long size2 = (long) size.get(code,0);
		MemorySegment segment = (MemorySegment) ptr.get(code, 0);

		MemorySegment reinterpret = segment.reinterpret(size2 * ValueLayout.JAVA_LONG.byteSize());
		ArrayList<Long> objects = new ArrayList<>();
		for (long index = 0; index < size2; index++) {
			objects.add(reinterpret.getAtIndex(ValueLayout.JAVA_LONG, index));
		}

		return List.copyOf(objects);
	}

	public static Map<String, String> _unpack__Discord_Properties(MemorySegment code) {
		VarHandle size = _Discord_Properties.varHandle(MemoryLayout.PathElement.groupElement("size"));
		VarHandle keys = _Discord_Properties.varHandle(MemoryLayout.PathElement.groupElement("keys"));
		VarHandle values = _Discord_Properties.varHandle(MemoryLayout.PathElement.groupElement("values"));
		long size2 = (long) size.get(code,0);
		MemorySegment keysSegment = (MemorySegment) keys.get(code, 0);
		MemorySegment valuesSegment = (MemorySegment) values.get(code, 0);
		LinkedHashMap<String, String> objects = new LinkedHashMap<>();
		for (long l = 0; l < size2; l++) {
			long address = keysSegment.address();
			long address2 = valuesSegment.address();
			MemorySegment memorySegment = MemorySegment.ofAddress(address+(l*_Discord_String.byteSize()));
			MemorySegment memorySegment2 = MemorySegment.ofAddress(address2+(l*_Discord_String.byteSize()));
			objects.put(_String_Sugar(memorySegment), _String_Sugar(memorySegment2));
		}
		return Map.copyOf(objects);
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

	public static void Discord_AuthorizationArgs_Init(MemorySegment self) {
		r(() -> {
			_Discord_AuthorizationArgs_Init.invokeExact(self);
			System.out.println("ran discord auth args init");
		});
	}

	public static void Discord_AuthorizationArgs_SetClientId(@$("Discord_AuthorizationArgs*")MemorySegment self, long value) {
		r(() -> {
			_Discord_AuthorizationArgs_SetClientId.invokeExact(self, value);
		});
	}
	public static void Discord_AuthorizationArgs_SetScopes(@$("Discord_AuthorizationArgs*") MemorySegment self, String value) {

		MemorySegment memorySegment = _DiscordStringFromJavaString(value);
		r(() -> {
			_Discord_AuthorizationArgs_SetScopes.invokeExact(self, memorySegment);
		});
	}

	private static MemorySegment _DiscordStringFromJavaString(String value) {
		MemorySegment allocate = Arena.ofAuto().allocate(_Discord_String);
		byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
		MemorySegment seg = Arena.ofAuto().allocate(bytes.length);
		seg.asByteBuffer().put(bytes);
		_Discord_String.varHandle(MemoryLayout.PathElement.groupElement("ptr")).set(allocate, 0, seg);
		_Discord_String.varHandle(MemoryLayout.PathElement.groupElement("size")).set(allocate, 0, (long)bytes.length);
		return allocate;
	}

	public static void Discord_AuthorizationArgs_SetCodeChallenge(@$("Discord_AuthorizationArgs*")MemorySegment self, @$("Discord_AuthorizationCodeChallenge*")MemorySegment value) {
		r(() -> {
			_Discord_AuthorizationArgs_SetCodeChallenge.invokeExact(self, value);
		});
	} //
	public static void Discord_AuthorizationCodeVerifier_Challenge(@$("Discord_AuthorizationCodeVerifier*")MemorySegment self, @$("Discord_AuthorizationCodeChallenge*") MemorySegment returnValue) {
		r(() -> {
			_Discord_AuthorizationCodeVerifier_Challenge.invokeExact(self, returnValue);
		});
	}
	public static boolean Discord_ClientResult_Successful(@$("Discord_ClientResult*") MemorySegment self) {
		boolean[] q = new boolean[1];
		r(() -> {
			boolean b = (boolean) _Discord_ClientResult_Successful.invokeExact(self);
			q[0] = b;
		});
		return q[0];
	}

	public static void Discord_ClientResult_Error(@$("Discord_ClientResult*") MemorySegment self, @$("Discord_String*") MemorySegment returnValue) {
		r(() -> {
			_Discord_ClientResult_Error.invokeExact(self, returnValue);
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

//	void DISCORD_API Discord_Client_UpdateRichPresence(Discord_Client* self,
//                                                   Discord_Activity* activity,
//                                                   Discord_Client_UpdateRichPresenceCallback cb,
//                                                   Discord_FreeFn cb__userDataFree,
//                                                   void* cb__userData);

	public interface Discord_Client_TokenExchangeCallback {
//Discord_ClientResult* result,
//                                                     Discord_String accessToken,
//                                                     Discord_String refreshToken,
//                                                     Discord_AuthorizationTokenType tokenType,
//                                                     int32_t expiresIn,
//                                                     Discord_String scopes,
//                                                     void* userData
		void call(@$("Discord_ClientResult*") MemorySegment result, String accessToken, String refreshToken, @$("Discord_AuthorizationTokenType") int tokenType,
				  int expiresIn, String scopes, @$("void*") MemorySegment userData);
		default void call0(MemorySegment result, MemorySegment accessToken, MemorySegment refreshToken, int tokenType,
				  int expiresIn, MemorySegment scopes, MemorySegment userData) {
			call(result, _String_Sugar(accessToken), _String_Sugar(refreshToken), tokenType, expiresIn, _String_Sugar(scopes), userData);
		}
	}
	public static void Discord_Client_GetToken(@$("Discord_Client*") MemorySegment self, long applicationId, String code, String codeVerifier, String redirectUri, Discord_Client_TokenExchangeCallback callback, Discord_FreeFn callback__userDataFree, @$("void*") MemorySegment callback__userData) {
		__Discord_Client_GetToken0(self, applicationId, _DiscordStringFromJavaString(code), _DiscordStringFromJavaString(codeVerifier), _DiscordStringFromJavaString(redirectUri), callback, callback__userDataFree, callback__userData);
	}

	private static void __Discord_Client_GetToken0(MemorySegment self, long applicationId, MemorySegment code, MemorySegment codeVerifier, MemorySegment redirectUri, Discord_Client_TokenExchangeCallback callback, Discord_FreeFn callback__userDataFree, MemorySegment callback__userData) {
		MethodHandle o1 = _Discord_Client_TokenExchangeCallback$handle.bindTo(callback);
		MethodHandle o2 = _Discord_FreeFn$handle.bindTo(callback__userDataFree);
		MemorySegment cb0 = LINKER.upcallStub(o1, _Discord_Client_TokenExchangeCallback, Arena.global());
		MemorySegment cb1 = LINKER.upcallStub(o2, _Discord_FreeFn, Arena.global());
		r(() -> {
			_Discord_Client_GetToken.invokeExact(self, applicationId, code, codeVerifier, redirectUri, cb0, cb1, callback__userData);
		});
	}
	public static void Discord_AuthorizationCodeVerifier_Verifier(@$("Discord_AuthorizationCodeVerifier*") MemorySegment self, @$("Discord_String*") MemorySegment returnValue) {
		r(() -> {
			_Discord_AuthorizationCodeVerifier_Verifier.invokeExact(self, returnValue);
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
	// uint64_t DISCORD_API Discord_RelationshipHandle_Id(Discord_RelationshipHandle* self);
	public static long Discord_RelationshipHandle_Id(@$("Discord_RelationshipHandle*") MemorySegment self) {
		long[] r = new long[1];
		r(() -> {
			long e = (long) _Discord_RelationshipHandle_Id.invokeExact(self);
			r[0] = e;
		});
		return r[0];
	}

	/// @return whether the user is null or not
	public static boolean Discord_RelationshipHandle_User(@$("Discord_RelationshipHandle*") MemorySegment self, @$("Discord_UserHandle*") MemorySegment returnValue) {
		boolean[] r = new boolean[1];
		r(() -> {
			boolean b = (boolean) _Discord_RelationshipHandle_User.invokeExact(self, returnValue);
			r[0] = b;
		});
		return r[0];
	}

	public static int Discord_RelationshipHandle_DiscordRelationshipType(@$("Discord_RelationshipHandle*") MemorySegment self) {
		int[] r = new int[1];
		r(() -> {
			int b = (int) _Discord_RelationshipHandle_DiscordRelationshipType.invokeExact(self);
			r[0] = b;
		});
		return r[0];
	}

	public static int Discord_RelationshipHandle_GameRelationshipType(@$("Discord_RelationshipHandle*") MemorySegment self) {
		int[] r = new int[1];
		r(() -> {
			int b = (int) _Discord_RelationshipHandle_GameRelationshipType.invokeExact(self);
			r[0] = b;
		});
		return r[0];
	}
	// Discord_Client_GetRelationshipsByGroup(Discord_Client* self,
	//                                       Discord_RelationshipGroupType groupType,
	//                                       Discord_RelationshipHandleSpan* returnValue);
	public static void Discord_Client_GetRelationshipsByGroup(@$("Discord_Client*") MemorySegment self, @$("Discord_RelationshipGroupType") int groupType, @$("Discord_RelationshipHandleSpan*") MemorySegment returnValue) {
		r(() -> {
			_Discord_Client_GetRelationshipsByGroup.invokeExact(self, groupType, returnValue);
		});
	}

	public static void Discord_UserHandle_DisplayName(@$("Discord_UserHandle*") MemorySegment self, @$("Discord_String*") MemorySegment returnValue) {
		r(() -> {
			_Discord_UserHandle_DisplayName.invokeExact(self, returnValue);
		});
	}

	public static long Discord_UserHandle_Id(@$("Discord_UserHandle*") MemorySegment self) {
		long[] r = new long[1];
		r(() -> {
			long e = (long) _Discord_UserHandle_Id.invokeExact(self);
			r[0] = e;
		});
		return r[0];
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
	private static MethodHandle _Discord_Client_StartCall;
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
	public interface Discord_Client_MessageCreatedCallback {
		void call(long messageId, @$("void*") MemorySegment userData);
		// typedef void (*Discord_Client_MessageCreatedCallback)(uint64_t messageId, void* userData);
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
	public static boolean Discord_Client_GetLobbyHandle(@$("Discord_Client*") MemorySegment self, long lobbyId, @$("Discord_LobbyHandle*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_Client_GetLobbyHandle.invokeExact(self, lobbyId, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	// bool DISCORD_API Discord_Client_GetLobbyHandle(Discord_Client* self,
	//                                               uint64_t lobbyId,
	//                                               Discord_LobbyHandle* returnValue);
	// void DISCORD_API Discord_Client_SetMessageCreatedCallback(Discord_Client* self,
	//                                                          Discord_Client_MessageCreatedCallback cb,
	//                                                          Discord_FreeFn cb__userDataFree,
	//                                                          void* cb__userData);
	// void DISCORD_API Discord_Client_SendLobbyMessage(Discord_Client* self,
	//                                                 uint64_t lobbyId,
	//                                                 Discord_String content,
	//                                                 Discord_Client_SendUserMessageCallback cb,
	//                                                 Discord_FreeFn cb__userDataFree,
	//                                                 void* cb__userData);
	// Discord_Client_LinkChannelToLobby(Discord_Client* self,
	//                                  uint64_t lobbyId,
	//                                  uint64_t channelId,
	//                                  Discord_Client_LinkOrUnlinkChannelCallback callback,
	//                                  Discord_FreeFn callback__userDataFree,
	//                                  void* callback__userData);
	// void DISCORD_API Discord_Client_CreateOrJoinLobby(Discord_Client* self,
	//                                                  Discord_String secret,
	//                                                  Discord_Client_CreateOrJoinLobbyCallback callback,
	//                                                  Discord_FreeFn callback__userDataFree,
	//                                                  void* callback__userData);
	// uint64_t DISCORD_API Discord_UserHandle_Id(Discord_UserHandle* self);

	// Discord_RelationshipType DISCORD_API
	//Discord_RelationshipHandle_DiscordRelationshipType(Discord_RelationshipHandle* self);
	// void DISCORD_API Discord_UserHandle_DisplayName(Discord_UserHandle* self,
	//                                                Discord_String* returnValue);
//	bool DISCORD_API Discord_RelationshipHandle_User(Discord_RelationshipHandle* self,
//                                                 Discord_UserHandle* returnValue);
	// void DISCORD_API Discord_Client_UpdateToken(Discord_Client* self,
	//                                            Discord_AuthorizationTokenType tokenType,
	//                                            Discord_String token,
	//                                            Discord_Client_UpdateTokenCallback callback,
	//                                            Discord_FreeFn callback__userDataFree,
	//                                            void* callback__userData);
	// void DISCORD_API Discord_AuthorizationCodeVerifier_Verifier(Discord_AuthorizationCodeVerifier* self,
	//                                                            Discord_String* returnValue);

//	void DISCORD_API Discord_Client_GetToken(Discord_Client* self,
//                                         uint64_t applicationId,
//                                         Discord_String code,
//                                         Discord_String codeVerifier,
//                                         Discord_String redirectUri,
//                                         Discord_Client_TokenExchangeCallback callback,
//                                         Discord_FreeFn callback__userDataFree,
//                                         void* callback__userData);
	// Discord_Client_AddLogCallback
	//bool DISCORD_API Discord_ClientResult_Successful(Discord_ClientResult* self);
	//void DISCORD_API
	//Discord_AuthorizationCodeVerifier_Challenge(Discord_AuthorizationCodeVerifier* self,
	//                                            Discord_AuthorizationCodeChallenge* returnValue);
	// void DISCORD_API Discord_AuthorizationArgs_SetScopes(Discord_AuthorizationArgs* self,
	//                                                     Discord_String value);

//	void DISCORD_API Discord_AuthorizationArgs_SetClientId(Discord_AuthorizationArgs* self,
//                                                       uint64_t value);

	private static void r(RunnableWithException o) {
		try {
			o.run();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	// void DISCORD_API Discord_Client_SetStatusChangedCallback(Discord_Client* self,
	//                                                         Discord_Client_OnStatusChanged cb,
	//                                                         Discord_FreeFn cb__userDataFree,
	//                                                         void* cb__userData);
	@SuppressWarnings({"UnusedLabel", "unused"})
	public static void setupMessageHandles(Arena arena, SymbolLookup lookup) {
		Discord_MessageHandle_Drop: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Drop").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS);
			_Discord_MessageHandle_Drop = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_Clone: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Clone").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_Clone = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_AdditionalContent: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_AdditionalContent").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_AdditionalContent = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_ApplicationId: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_ApplicationId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_ApplicationId = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_Author: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Author").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_Author = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_AuthorId: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_AuthorId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_MessageHandle_AuthorId = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_Channel: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Channel").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_Channel = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_ChannelId: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_ChannelId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_MessageHandle_ChannelId = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_Content: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Content").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_Content = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_DisclosureType: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_DisclosureType").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_DisclosureType = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_EditedTimestamp: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_EditedTimestamp").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_MessageHandle_EditedTimestamp = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_Id: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Id").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_MessageHandle_Id = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_Lobby: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Lobby").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_Lobby = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_Metadata: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Metadata").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_Metadata = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_RawContent: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_RawContent").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_RawContent = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_Recipient: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Recipient").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_MessageHandle_Recipient = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_RecipientId: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_RecipientId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_MessageHandle_RecipientId = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_SentFromGame: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_SentFromGame").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS);
			_Discord_MessageHandle_SentFromGame = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_SentTimestamp: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_SentTimestamp").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_MessageHandle_SentTimestamp = LINKER.downcallHandle(functionAddress, functionSignature);
		}
	}

	private static MethodHandle _Discord_MessageHandle_Drop;
	public static boolean Discord_MessageHandle_Drop(@$("Discord_MessageHandle*") MemorySegment self) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_MessageHandle_Drop.invokeExact(self);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_Clone;
	public static boolean Discord_MessageHandle_Clone(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_MessageHandle const*") MemorySegment other) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_MessageHandle_Clone.invokeExact(self, other);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_AdditionalContent;
	public static boolean Discord_MessageHandle_AdditionalContent(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_AdditionalContent*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_MessageHandle_AdditionalContent.invokeExact(self, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_ApplicationId;
	public static boolean Discord_MessageHandle_ApplicationId(@$("Discord_MessageHandle*") MemorySegment self, @$("uint64_t*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_MessageHandle_ApplicationId.invokeExact(self, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_Author;
	public static boolean Discord_MessageHandle_Author(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_UserHandle*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_MessageHandle_Author.invokeExact(self, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_AuthorId;
	public static long Discord_MessageHandle_AuthorId(@$("Discord_MessageHandle*") MemorySegment self) {
		long[] b = new long[1];
		r(() -> {
			long c = (long) _Discord_MessageHandle_AuthorId.invokeExact(self);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_Channel;
	public static boolean Discord_MessageHandle_Channel(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_ChannelHandle*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_MessageHandle_Channel.invokeExact(self, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_ChannelId;
	public static long Discord_MessageHandle_ChannelId(@$("Discord_MessageHandle*") MemorySegment self) {
		long[] b = new long[1];
		r(() -> {
			long c = (long) _Discord_MessageHandle_ChannelId.invokeExact(self);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_Content;
	public static void Discord_MessageHandle_Content(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_String*") MemorySegment returnValue) {
		r(() -> {
			_Discord_MessageHandle_Content.invokeExact(self, returnValue);
		});
	}
	private static MethodHandle _Discord_MessageHandle_DisclosureType;
	public static boolean Discord_MessageHandle_DisclosureType(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_DisclosureTypes*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_MessageHandle_DisclosureType.invokeExact(self, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_EditedTimestamp;
	public static long Discord_MessageHandle_EditedTimestamp(@$("Discord_MessageHandle*") MemorySegment self) {
		long[] b = new long[1];
		r(() -> {
			long c = (long) _Discord_MessageHandle_EditedTimestamp.invokeExact(self);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_Id;
	public static long Discord_MessageHandle_Id(@$("Discord_MessageHandle*") MemorySegment self) {
		long[] b = new long[1];
		r(() -> {
			long c = (long) _Discord_MessageHandle_Id.invokeExact(self);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_Lobby;
	public static boolean Discord_MessageHandle_Lobby(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_LobbyHandle*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_MessageHandle_Lobby.invokeExact(self, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_Metadata;
	public static void Discord_MessageHandle_Metadata(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_LobbyHandle*") MemorySegment returnValue) {
		r(() -> {
			_Discord_MessageHandle_Metadata.invokeExact(self, returnValue);
		});
	}
	private static MethodHandle _Discord_MessageHandle_RawContent;
	public static void Discord_MessageHandle_RawContent(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_String*") MemorySegment returnValue) {
		r(() -> {
			_Discord_MessageHandle_RawContent.invokeExact(self, returnValue);
		});
	}
	private static MethodHandle _Discord_MessageHandle_Recipient;
	public static boolean Discord_MessageHandle_Recipient(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_UserHandle*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_MessageHandle_Recipient.invokeExact(self, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_RecipientId;
	public static long Discord_MessageHandle_RecipientId(@$("Discord_MessageHandle*") MemorySegment self) {
		long[] b = new long[1];
		r(() -> {
			long c = (long) _Discord_MessageHandle_RecipientId.invokeExact(self);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_SentFromGame;
	public static boolean Discord_MessageHandle_SentFromGame(@$("Discord_MessageHandle*") MemorySegment self) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_MessageHandle_SentFromGame.invokeExact(self);
			b[0] = c;
		});
		return b[0];
	}
	private static MethodHandle _Discord_MessageHandle_SentTimestamp;
	public static long Discord_MessageHandle_SentTimestamp(@$("Discord_MessageHandle*") MemorySegment self) {
		long[] b = new long[1];
		r(() -> {
			long c = (long) _Discord_MessageHandle_SentTimestamp.invokeExact(self);
			b[0] = c;
		});
		return b[0];
	}
	@SuppressWarnings("UnusedLabel")
	public static void setupLobbyHandles(Arena arena, SymbolLookup lookup) {
		Discord_LobbyHandle_Id: {
			MemorySegment functionAddress = lookup.find("Discord_LobbyHandle_Id").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_LobbyHandle_Id = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_LobbyHandle_Metadata: {
			MemorySegment functionAddress = lookup.find("Discord_LobbyHandle_Metadata").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_LobbyHandle_Metadata = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_LobbyHandle_LinkedChannel: {
			MemorySegment functionAddress = lookup.find("Discord_LobbyHandle_LinkedChannel").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_LobbyHandle_LinkedChannel = LINKER.downcallHandle(functionAddress, functionSignature);
		}

		// uint64_t DISCORD_API Discord_LobbyHandle_Id(Discord_LobbyHandle* self);
	}
	private static MethodHandle _Discord_LobbyHandle_Id;
	public static long Discord_LobbyHandle_Id(@$("Discord_LobbyHandle*") MemorySegment self) {
		long[] b = new long[1];
		r(() -> {
			long c = (long) _Discord_LobbyHandle_Id.invokeExact(self);
			b[0] = c;
		});
		return b[0];
	}
	// void DISCORD_API Discord_LobbyHandle_Metadata(Discord_LobbyHandle* self,
	//                                              Discord_Properties* returnValue);
	private static MethodHandle _Discord_LobbyHandle_Metadata;
	public static void Discord_LobbyHandle_Metadata(@$("Discord_LobbyHandle*") MemorySegment self, @$("Discord_Properties*") MemorySegment returnValue) {
		r(() -> {
			_Discord_LobbyHandle_Metadata.invokeExact(self, returnValue);
		});
	}
	private static MethodHandle _Discord_LobbyHandle_LinkedChannel;
	public static boolean Discord_LobbyHandle_LinkedChannel(@$("Discord_LobbyHandle*") MemorySegment self, @$("Discord_LinkedChannel*") MemorySegment returnValue) {
		boolean[] b = new boolean[1];
		r(() -> {
			boolean c = (boolean) _Discord_LobbyHandle_LinkedChannel.invokeExact(self, returnValue);
			b[0] = c;
		});
		return b[0];
	}
	@SuppressWarnings("UnusedLabel")
	private static void setupLinkedChannels(Arena arena, SymbolLookup lookup) {
		Discord_LinkedChannel_Name: {
			MemorySegment functionAddress = lookup.find("Discord_LinkedChannel_Name").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_LinkedChannel_Name = LINKER.downcallHandle(functionAddress, functionSignature);
		}
	}

	private static MethodHandle _Discord_LinkedChannel_Name;
	public static void Discord_LinkedChannel_Name(@$("Discord_LinkedChannel*") MemorySegment self, @$("Discord_String*") MemorySegment returnValue) {
		r(() -> {
			_Discord_LinkedChannel_Name.invokeExact(self, returnValue);
		});
	}


	// void DISCORD_API Discord_LinkedChannel_Name(Discord_LinkedChannel* self,
	//                                            Discord_String* returnValue);
}
