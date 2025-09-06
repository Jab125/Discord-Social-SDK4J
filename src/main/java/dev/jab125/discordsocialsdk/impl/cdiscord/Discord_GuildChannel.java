// Copyright 2025 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.impl.cdiscord;

import dev.jab125.discordsocialsdk.api.$;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

import static dev.jab125.discordsocialsdk.impl.CDiscord.*;
import static dev.jab125.discordsocialsdk.impl.DiscordNatives.LINKER;

@SuppressWarnings({"removal", "CodeBlock2Expr"})
public class Discord_GuildChannel {
	public static MethodHandle _Discord_GuildChannel_Drop;
	public static MethodHandle _Discord_GuildChannel_Clone;
	public static MethodHandle _Discord_GuildChannel_SetId;
	public static MethodHandle _Discord_GuildChannel_Id;
	public static MethodHandle _Discord_GuildChannel_SetName;
	public static MethodHandle _Discord_GuildChannel_Name;
	public static MethodHandle _Discord_GuildChannel_SetIsLinkable;
	public static MethodHandle _Discord_GuildChannel_IsLinkable;
	public static MethodHandle _Discord_GuildChannel_SetIsViewableAndWriteableByAllMembers;
	public static MethodHandle _Discord_GuildChannel_IsViewableAndWriteableByAllMembers;
	public static MethodHandle _Discord_GuildChannel_SetLinkedLobby;
	public static MethodHandle _Discord_GuildChannel_LinkedLobby;

	@SuppressWarnings({"UnusedLabel", "OptionalGetWithoutIsPresent", "unused"})
	public static void setupGuildChannels(Arena arena, SymbolLookup lookup) {
		Discord_GuildChannel_Drop: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_Drop").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_GuildChannel_Drop = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_Clone: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_Clone").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_GuildChannel_Clone = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_SetId: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_SetId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG);
			_Discord_GuildChannel_SetId = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_Id: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_Id").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_GuildChannel_Id = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_SetName: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_SetName").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, _Discord_String);
			_Discord_GuildChannel_SetName = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_Name: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_Name").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_GuildChannel_Name = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_SetIsLinkable: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_SetIsLinkable").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_BOOLEAN);
			_Discord_GuildChannel_SetIsLinkable = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_IsLinkable: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_IsLinkable").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS);
			_Discord_GuildChannel_IsLinkable = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_SetIsViewableAndWriteableByAllMembers: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_SetIsViewableAndWriteableByAllMembers").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_BOOLEAN);
			_Discord_GuildChannel_SetIsViewableAndWriteableByAllMembers = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_IsViewableAndWriteableByAllMembers: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_IsViewableAndWriteableByAllMembers").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS);
			_Discord_GuildChannel_IsViewableAndWriteableByAllMembers = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_SetLinkedLobby: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_SetLinkedLobby").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_GuildChannel_SetLinkedLobby = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildChannel_LinkedLobby: {
			MemorySegment functionAddress = lookup.find("Discord_GuildChannel_LinkedLobby").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_BOOLEAN, ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_GuildChannel_LinkedLobby = LINKER.downcallHandle(functionAddress, functionSignature);
		}
	}

	public static void Discord_GuildChannel_Drop(@$("Discord_GuildChannel*") MemorySegment self) {
		r(() -> {
			_Discord_GuildChannel_Drop.invokeExact(self);
		});
	}
	public static void Discord_GuildChannel_Clone(@$("Discord_GuildChannel*") MemorySegment self, @$("Discord_GuildChannel*") MemorySegment arg0) {
		r(() -> {
			_Discord_GuildChannel_Clone.invokeExact(self, arg0);
		});
	}
	public static void Discord_GuildChannel_SetId(@$("Discord_GuildChannel*") MemorySegment self, long value) {
		r(() -> {
			_Discord_GuildChannel_SetId.invokeExact(self, value);
		});
	}
	public static long Discord_GuildChannel_Id(@$("Discord_GuildChannel*") MemorySegment self) {
		long[] r = new long[1];
		r(() -> {
			long r0 = (long) _Discord_GuildChannel_Id.invokeExact(self);
			r[0] = r0;
		});
		return r[0];
	}
	public static void Discord_GuildChannel_SetName(@$("Discord_GuildChannel*") MemorySegment self, String value) {
		r(() -> {
			_Discord_GuildChannel_SetName.invokeExact(self, _DiscordStringFromJavaString(value));
		});
	}
	public static void Discord_GuildChannel_Name(@$("Discord_GuildChannel*") MemorySegment self, @$("Discord_String*") MemorySegment value) {
		r(() -> {
			_Discord_GuildChannel_Name.invokeExact(self, value);
		});
	}
	public static void Discord_GuildChannel_SetIsLinkable(@$("Discord_GuildChannel*") MemorySegment self, boolean value) {
		r(() -> {
			_Discord_GuildChannel_SetIsLinkable.invokeExact(self, value);
		});
	}
	public static boolean Discord_GuildChannel_IsLinkable(@$("Discord_GuildChannel*") MemorySegment self) {
		boolean[] r = new boolean[1];
		r(() -> {
			boolean r0 = (boolean) _Discord_GuildChannel_IsLinkable.invokeExact(self);
			r[0] = r0;
		});
		return r[0];
	}
	public static void Discord_GuildChannel_SetIsViewableAndWriteableByAllMembers(@$("Discord_GuildChannel*") MemorySegment self, boolean value) {
		r(() -> {
			_Discord_GuildChannel_SetIsViewableAndWriteableByAllMembers.invokeExact(self, value);
		});
	}
	public static boolean Discord_GuildChannel_IsViewableAndWriteableByAllMembers(@$("Discord_GuildChannel*") MemorySegment self) {
		boolean[] r = new boolean[1];
		r(() -> {
			boolean r0 = (boolean) _Discord_GuildChannel_IsViewableAndWriteableByAllMembers.invokeExact(self);
			r[0] = r0;
		});
		return r[0];
	}
	public static void Discord_GuildChannel_SetLinkedLobby(@$("Discord_GuildChannel*") MemorySegment self, @$("Discord_LinkedLobby*") MemorySegment value) {
		r(() -> {
			_Discord_GuildChannel_SetLinkedLobby.invokeExact(self, value);
		});
	}
	public static boolean Discord_GuildChannel_LinkedLobby(@$("Discord_GuildChannel*") MemorySegment self, @$("Discord_LinkedLobby*") MemorySegment returnValue) {
		boolean[] r = new boolean[1];
		r(() -> {
			boolean r0 = (boolean) _Discord_GuildChannel_LinkedLobby.invokeExact(self, returnValue);
			r[0] = r0;
		});
		return r[0];
	}
}
