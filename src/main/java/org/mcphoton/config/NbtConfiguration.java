/*
 * Copyright (c) 2016 MCPhoton <http://mcphoton.org> and contributors.
 *
 * This file is part of the Photon Server Implementation <https://github.com/mcphoton/Photon-Server>.
 *
 * The Photon Server Implementation is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Photon Server Implementation is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mcphoton.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * A NBT configuration.
 *
 * @see http://wiki.vg/NBT
 * @author TheElectronWill
 */
public class NbtConfiguration extends BaseConfiguration {

	public NbtConfiguration() {
		// defined by the photon's implementation
	}

	public NbtConfiguration(Map<String, Object> data) {
		// defined by the photon's implementation
	}

	public boolean containsByteArray(String key) {
		return false;
		// defined by the photon's implementation
	}

	public boolean containsIntArray(String key) {
		return false;
		// defined by the photon's implementation
	}

	public byte[] getByteArray(String key) {
		return null;
		// defined by the photon's implementation
	}

	public int[] getIntArray(String key) {
		return null;
		// defined by the photon's implementation
	}

	@Override
	public void readFrom(InputStream in) throws IOException {
		// defined by the photon's implementation
	}

	@Override
	public void writeTo(OutputStream out) throws IOException {
		// defined by the photon's implementation
	}

}
