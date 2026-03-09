// Copyright 2026 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.impl;

import dev.jab125.discordsocialsdk.impl.c.Discord_GuildChannelSpan;
import dev.jab125.discordsocialsdk.impl.c.Discord_GuildMinimalSpan;
import dev.jab125.discordsocialsdk.impl.c.Discord_MessageHandleSpan;
import dev.jab125.discordsocialsdk.impl.c.Discord_Properties;
import dev.jab125.discordsocialsdk.impl.c.Discord_RelationshipHandleSpan;
import dev.jab125.discordsocialsdk.impl.c.Discord_String;
import dev.jab125.discordsocialsdk.impl.c.Discord_UInt64Span;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.VarHandle;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CrosshairUtils {
	public static MemorySegment toDiscordString(String value) {
		MemorySegment allocate = Discord_String.allocate(Arena.ofAuto());
		byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
		MemorySegment seg = Arena.ofAuto().allocate(bytes.length);
		seg.asByteBuffer().put(bytes);
		Discord_String.layout().varHandle(MemoryLayout.PathElement.groupElement("ptr")).set(allocate, 0, seg);
		Discord_String.layout().varHandle(MemoryLayout.PathElement.groupElement("size")).set(allocate, 0, (long) bytes.length);
		return allocate;
	}

	public static String toJavaString(MemorySegment code) {
		VarHandle ptr = Discord_String.layout().varHandle(MemoryLayout.PathElement.groupElement("ptr"));
		VarHandle size = Discord_String.layout().varHandle(MemoryLayout.PathElement.groupElement("size"));
		long strSize = (long) size.get(code, 0);
		MemorySegment segment = (MemorySegment) ptr.get(code, 0);
		MemorySegment reinterpret = segment.reinterpret(strSize);
		return StandardCharsets.UTF_8.decode(reinterpret.asByteBuffer()).toString();
	}

	public static List<MemorySegment> unpackMessageHandleSpan(MemorySegment code) {
		VarHandle ptr = Discord_MessageHandleSpan.layout().varHandle(MemoryLayout.PathElement.groupElement("ptr"));
		VarHandle size = Discord_MessageHandleSpan.layout().varHandle(MemoryLayout.PathElement.groupElement("size"));
		long size2 = (long) size.get(code,0);
		MemorySegment segment = (MemorySegment) ptr.get(code, 0);
		ArrayList<MemorySegment> objects = new ArrayList<>();
		for (long l = 0; l < size2; l++) {
			long address = segment.address();
			MemorySegment memorySegment = MemorySegment.ofAddress(address + (l * ValueLayout.ADDRESS.byteSize()));
			objects.add(memorySegment);
		}
		return List.copyOf(objects);
	}

	public static List<MemorySegment> unpackGuildChannelSpan(MemorySegment code) {
		VarHandle ptr = Discord_GuildChannelSpan.layout().varHandle(MemoryLayout.PathElement.groupElement("ptr"));
		VarHandle size = Discord_GuildChannelSpan.layout().varHandle(MemoryLayout.PathElement.groupElement("size"));
		long size2 = (long) size.get(code,0);
		MemorySegment segment = (MemorySegment) ptr.get(code, 0);
		ArrayList<MemorySegment> objects = new ArrayList<>();
		for (long l = 0; l < size2; l++) {
			long address = segment.address();
			MemorySegment memorySegment = MemorySegment.ofAddress(address + (l * ValueLayout.ADDRESS.byteSize()));
			objects.add(memorySegment);
		}
		return List.copyOf(objects);
	}

	public static List<MemorySegment> unpackGuildMinimalSpan(MemorySegment code) {
		VarHandle ptr = Discord_GuildMinimalSpan.layout().varHandle(MemoryLayout.PathElement.groupElement("ptr"));
		VarHandle size = Discord_GuildMinimalSpan.layout().varHandle(MemoryLayout.PathElement.groupElement("size"));
		long size2 = (long) size.get(code,0);
		MemorySegment segment = (MemorySegment) ptr.get(code, 0);
		ArrayList<MemorySegment> objects = new ArrayList<>();
		for (long l = 0; l < size2; l++) {
			long address = segment.address();
			MemorySegment memorySegment = MemorySegment.ofAddress(address + (l * ValueLayout.ADDRESS.byteSize()));
			objects.add(memorySegment);
		}
		return List.copyOf(objects);
	}

	public static List<MemorySegment> unpackRelationshipHandleSpan(MemorySegment code) {
		VarHandle ptr = Discord_RelationshipHandleSpan.layout().varHandle(MemoryLayout.PathElement.groupElement("ptr"));
		VarHandle size = Discord_RelationshipHandleSpan.layout().varHandle(MemoryLayout.PathElement.groupElement("size"));
		long size2 = (long) size.get(code,0);
		MemorySegment segment = (MemorySegment) ptr.get(code, 0);
		ArrayList<MemorySegment> objects = new ArrayList<>();
		for (long l = 0; l < size2; l++) {
			long address = segment.address();
			MemorySegment memorySegment = MemorySegment.ofAddress(address + (l * ValueLayout.ADDRESS.byteSize()));
			objects.add(memorySegment);
		}
		return List.copyOf(objects);
	}

	public static List<Long> unpackUInt64Span(MemorySegment code) {
		VarHandle ptr = Discord_UInt64Span.layout().varHandle(MemoryLayout.PathElement.groupElement("ptr"));
		VarHandle size = Discord_UInt64Span.layout().varHandle(MemoryLayout.PathElement.groupElement("size"));
		long size2 = (long) size.get(code,0);
		MemorySegment segment = (MemorySegment) ptr.get(code, 0);

		MemorySegment reinterpret = segment.reinterpret(size2 * ValueLayout.JAVA_LONG.byteSize());
		ArrayList<Long> objects = new ArrayList<>();
		for (long index = 0; index < size2; index++) {
			objects.add(reinterpret.getAtIndex(ValueLayout.JAVA_LONG, index));
		}

		return List.copyOf(objects);
	}

	public static Map<String, String> unpackDiscordProperties(MemorySegment code) {
		VarHandle size = Discord_Properties.layout().varHandle(MemoryLayout.PathElement.groupElement("size"));
		VarHandle keys = Discord_Properties.layout().varHandle(MemoryLayout.PathElement.groupElement("keys"));
		VarHandle values = Discord_Properties.layout().varHandle(MemoryLayout.PathElement.groupElement("values"));
		long size2 = (long) size.get(code,0);
		MemorySegment keysSegment = (MemorySegment) keys.get(code, 0);
		MemorySegment valuesSegment = (MemorySegment) values.get(code, 0);
		LinkedHashMap<String, String> objects = new LinkedHashMap<>();
		for (long l = 0; l < size2; l++) {
			long address = keysSegment.address();
			long address2 = valuesSegment.address();
			MemorySegment memorySegment = MemorySegment.ofAddress(address+(l*Discord_String.sizeof()));
			MemorySegment memorySegment2 = MemorySegment.ofAddress(address2+(l*Discord_String.sizeof()));
			objects.put(toJavaString(memorySegment), toJavaString(memorySegment2));
		}
		return Map.copyOf(objects);
	}
}
