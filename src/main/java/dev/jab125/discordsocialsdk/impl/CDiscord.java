// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.impl;

import dev.jab125.discordsocialsdk.api.$;

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
import static dev.jab125.discordsocialsdk.impl.cdiscord.Discord_Client.setupDiscordClient;

@SuppressWarnings({"removal", "CodeBlock2Expr"})
public class CDiscord {

	public static FunctionDescriptor _Discord_FreeFn;
	public static MethodHandle _Discord_FreeFn$handle;
	public static StructLayout _Discord_String;
	private static MethodHandle _Discord_AuthorizationArgs_Init;
	private static MethodHandle _Discord_AuthorizationArgs_SetClientId;
	private static MethodHandle _Discord_AuthorizationArgs_SetScopes;
	private static MethodHandle _Discord_AuthorizationArgs_SetCodeChallenge;
	private static MethodHandle _Discord_AuthorizationCodeVerifier_Challenge;
	private static MethodHandle _Discord_ClientResult_Successful;
	private static MethodHandle _Discord_ClientResult_Error;
	private static MethodHandle _Discord_AuthorizationCodeVerifier_Verifier;
	private static MethodHandle _Discord_Activity_Init;
	private static MethodHandle _Discord_Activity_SetType;
	private static MethodHandle _Discord_Activity_SetState;
	private static MethodHandle _Discord_Activity_SetDetails;
	private static MethodHandle _Discord_Activity_SetApplicationId;
	public static StructLayout _Discord_RelationshipHandleSpan;
	private static MethodHandle _Discord_RelationshipHandle_Id;
	private static MethodHandle _Discord_RelationshipHandle_User;
	private static MethodHandle _Discord_UserHandle_DisplayName;
	private static MethodHandle _Discord_RelationshipHandle_DiscordRelationshipType;
	private static MethodHandle _Discord_UserHandle_Id;
	public static StructLayout _Discord_MessageHandleSpan;
	public static StructLayout _Discord_UInt64Span;
	public static StructLayout _Discord_Properties;
	private static MethodHandle _Discord_RelationshipHandle_GameRelationshipType;

	static {
		try {
			createHandles();
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings({"UnusedLabel", "OptionalGetWithoutIsPresent"})
	private static void createHandles() throws NoSuchMethodException, IllegalAccessException {
		Arena arena = Arena.ofAuto();
		SymbolLookup lookup = lookup(arena);
		Discord_FreeFn: {
			_Discord_FreeFn = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_FreeFn$handle = MethodHandles.lookup().findVirtual(CDiscord.Discord_FreeFn.class, "call",
					MethodType.methodType(void.class, MemorySegment.class));
		}
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
		setupMessageHandles(arena, lookup);
		setupLobbyHandles(arena, lookup);
		setupLinkedChannels(arena, lookup);
		setupDiscordClient(arena, lookup);
	}

	// all ()V
	private static MethodHandle _Discord_ResetCallbacks;
	private static MethodHandle _Discord_RunCallbacks;
	private static MethodHandle _Discord_SetFreeThreaded;


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


	public interface Discord_FreeFn {
		void call(MemorySegment ptr);
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

	public static MemorySegment _DiscordStringFromJavaString(String value) {
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

	public static void Discord_AuthorizationCodeVerifier_Verifier(@$("Discord_AuthorizationCodeVerifier*") MemorySegment self, @$("Discord_String*") MemorySegment returnValue) {
		r(() -> {
			_Discord_AuthorizationCodeVerifier_Verifier.invokeExact(self, returnValue);
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


	public static void r(RunnableWithException o) {
		try {
			o.run();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings({"UnusedLabel", "unused", "OptionalGetWithoutIsPresent"})
	public static void setupMessageHandles(Arena arena, SymbolLookup lookup) {
		Discord_MessageHandle_Drop: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Drop").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_MessageHandle_Drop = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_MessageHandle_Clone: {
			MemorySegment functionAddress = lookup.find("Discord_MessageHandle_Clone").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
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
	public static void Discord_MessageHandle_Drop(@$("Discord_MessageHandle*") MemorySegment self) {
		r(() -> {
			_Discord_MessageHandle_Drop.invokeExact(self);
		});
	}
	private static MethodHandle _Discord_MessageHandle_Clone;
	public static void Discord_MessageHandle_Clone(@$("Discord_MessageHandle*") MemorySegment self, @$("Discord_MessageHandle const*") MemorySegment other) {
		r(() -> {
			_Discord_MessageHandle_Clone.invokeExact(self, other);
		});
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
	@SuppressWarnings({"UnusedLabel", "OptionalGetWithoutIsPresent"})
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
