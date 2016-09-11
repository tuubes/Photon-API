/*
 * Copyright (c) 2016 MCPhoton <http://mcphoton.org> and contributors.
 *
 * This file is part of the Photon API <https://github.com/mcphoton/Photon-API>.
 *
 * The Photon API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Photon API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mcphoton.network;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * An OutputStream with methods for writing common data types of the Minecraft protocol. A
 * ProtocolOutputStream automatically increases its size when needed.
 *
 * @author TheElectronWill
 *
 */
public abstract class ProtocolOutputStream extends OutputStream {

	/**
	 * Gets the size of this OutputStream.
	 */
	public abstract int size();

	/**
	 * Gets the current capacity of this OutputStream.
	 */
	public abstract int capacity();

	/**
	 * Discards the stream's data. The capacity does not change.
	 */
	public abstract void clear();

	/**
	 * Resets the stream's size and position to 0. The capacity does not change.
	 */
	public abstract void reset();

	@Override
	public void write(int b) {
		writeByte(b);
	}

	/**
	 * Writes a boolean as a single byte. Its value is 1 if true and 0 if false.
	 */
	public void writeBoolean(boolean b) {
		writeByte(b ? 1 : 0);
	}

	public abstract void writeByte(int b);

	public abstract void writeShort(int s);

	public abstract void writeChar(int c);

	public abstract void writeInt(int i);

	public abstract void writeLong(long l);

	public void writeFloat(float f) {
		writeInt(Float.floatToIntBits(f));
	}

	public void writeDouble(double d) {
		writeLong(Double.doubleToLongBits(d));
	}

	/**
	 * Writes a String with the UTF-8 charset, prefixed with its size (in bytes) encoded as a VarInt.
	 */
	public void writeString(String s) {
		byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
		writeVarInt(bytes.length);
		write(bytes);
	}

	public void writeVarInt(int i) {
		while ((i & 0xFFFF_FF80) != 0) {// While we have more than 7 bits (0b0xxxxxxx)
			byte data = (byte) (i | 0x80);// Discard bit sign and set msb to 1 (VarInt byte prefix).
			writeByte(data);
			i >>>= 7;
		}
		writeByte((byte) i);
	}

	public void writeVarLong(long l) {
		while ((l & 0xFFFF_FFFF_FFFF_FF80l) != 0) {// While we have more than 7 bits (0b0xxxxxxx)
			byte data = (byte) (l | 0x80);// Discard bit sign and set msb to 1 (VarInt byte prefix).
			writeByte(data);
			l >>>= 7;
		}
		writeByte((byte) l);
	}

	@Override
	public abstract void write(byte[] b, int off, int len);

	@Override
	public void write(byte[] b) {
		write(b, 0, b.length);
	}

}
