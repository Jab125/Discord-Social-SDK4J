// Copyright 2026 Jab125
// This file is part of Discord-Social-SDK4J.
// Discord-Social-SDK4J is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
// Discord-Social-SDK4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// You should have received a copy of the GNU Lesser General Public License along with Discord-Social-SDK4J. If not, see <https://www.gnu.org/licenses/>.
package dev.jab125.discordsocialsdk.api.holder;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public interface BooleanHolder {
	boolean get();
	void set(boolean value);
	static BooleanHolder of(BooleanSupplier getter, Consumer<Boolean> setter) {
		return new BooleanHolder() {
			@Override
			public boolean get() {
				return getter.getAsBoolean();
			}

			@Override
			public void set(boolean value) {
				setter.accept(value);
			}
		};
	}
}
