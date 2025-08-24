package dev.jab125.discordsocialsdk.pp;

import java.lang.foreign.MemorySegment;

public interface PointerWrapper {
	MemorySegment getSegment();
}
