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
public class Discord_GuildMinimal {
	public static MethodHandle _Discord_GuildMinimal_Drop;
	public static MethodHandle _Discord_GuildMinimal_Clone;
	public static MethodHandle _Discord_GuildMinimal_SetId;
	public static MethodHandle _Discord_GuildMinimal_Id;
	public static MethodHandle _Discord_GuildMinimal_SetName;
	public static MethodHandle _Discord_GuildMinimal_Name;

	@SuppressWarnings({"UnusedLabel", "OptionalGetWithoutIsPresent", "unused"})
	public static void setupGuildMinimals(Arena arena, SymbolLookup lookup) {
		Discord_GuildMinimal_Drop: {
			MemorySegment functionAddress = lookup.find("Discord_GuildMinimal_Drop").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_GuildMinimal_Drop = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildMinimal_Clone: {
			MemorySegment functionAddress = lookup.find("Discord_GuildMinimal_Clone").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS);
			_Discord_GuildMinimal_Clone = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildMinimal_SetId: {
			MemorySegment functionAddress = lookup.find("Discord_GuildMinimal_SetId").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.JAVA_LONG);
			_Discord_GuildMinimal_SetId = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildMinimal_Id: {
			MemorySegment functionAddress = lookup.find("Discord_GuildMinimal_Id").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);
			_Discord_GuildMinimal_Id = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildMinimal_SetName: {
			MemorySegment functionAddress = lookup.find("Discord_GuildMinimal_SetName").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, _Discord_String);
			_Discord_GuildMinimal_SetName = LINKER.downcallHandle(functionAddress, functionSignature);
		}
		Discord_GuildMinimal_Name: {
			MemorySegment functionAddress = lookup.find("Discord_GuildMinimal_Name").get();
			FunctionDescriptor functionSignature = FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS);
			_Discord_GuildMinimal_Name = LINKER.downcallHandle(functionAddress, functionSignature);
		}
	}

	public static void Discord_GuildMinimal_Drop(@$("Discord_GuildMinimal*") MemorySegment self) {
		r(() -> {
			_Discord_GuildMinimal_Drop.invokeExact(self);
		});
	}
	public static void Discord_GuildMinimal_Clone(@$("Discord_GuildMinimal*") MemorySegment self) {
		r(() -> {
			_Discord_GuildMinimal_Clone.invokeExact(self);
		});
	}
	public static void Discord_GuildMinimal_SetId(@$("Discord_GuildMinimal*") MemorySegment self, long value) {
		r(() -> {
			_Discord_GuildMinimal_SetId.invokeExact(self, value);
		});
	}
	public static long Discord_GuildMinimal_Id(@$("Discord_GuildMinimal*") MemorySegment self) {
		long[] r = new long[1];
		r(() -> {
			long r0 = (long) _Discord_GuildMinimal_Id.invokeExact(self);
			r[0] = r0;
		});
		return r[0];
	}
	public static void Discord_GuildMinimal_SetName(@$("Discord_GuildMinimal*") MemorySegment self, String value) {
		r(() -> {
			_Discord_GuildMinimal_SetName.invokeExact(self, _DiscordStringFromJavaString(value));
		});
	}
	public static void Discord_GuildMinimal_Name(@$("Discord_GuildMinimal*") MemorySegment self, @$("Discord_String*") MemorySegment value) {
		r(() -> {
			_Discord_GuildMinimal_Name.invokeExact(self, value);
		});
	}
}
