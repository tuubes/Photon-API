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

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * Utility class for reading and writing some data types that are used in the Minecraft protocol.
 *
 * @author TheElectronWill
 *
 */
public final class ProtocolHelper {

	private ProtocolHelper() {
	}

	public static final int ENTITY_META_BYTE = 0;
	public static final int ENTITY_META_SHORT = 1;
	public static final int ENTITY_META_INT = 2;
	public static final int ENTITY_META_FLOAT = 3;
	public static final int ENTITY_META_STRING = 4;
	public static final int ENTITY_META_SLOT = 5;
	public static final int ENTITY_META_3INT = 6;
	public static final int ENTITY_META_3FLOAT = 7;

	/**
	 * Reads one byte as a boolean. Its value is true if 1 and false if 0
	 */
	public static boolean readBoolean(ByteBuffer buff) {
		return buff.get() == 1;
	}

	/**
	 * Calculates the size (in bytes) that would take the given number in the "VarInt"
	 * format.
	 */
	public static int varIntSize(int n) {
		int size = 1;
		while ((n & 0xFFFF_FF80) != 0) {
			size++;
			n >>>= 7;
		}
		return size;
	}

	/**
	 * Writes a signed integer with the "VarInt" format.
	 *
	 * @param n the int to encode
	 * @param buff where to write the bytes
	 */
	public static void writeVarInt(int n, ByteBuffer buff) {
		while ((n & 0xFFFF_FF80) != 0) {// While we have more than 7 bits (0b0xxxxxxx)
			byte data = (byte) (n | 0x80);// Discard bit sign and set msb to 1 (VarInt byte prefix).
			buff.put(data);
			n >>>= 7;
		}
		buff.put((byte) n);
	}

	/**
	 * Reads a VarInt.
	 *
	 * @return the int value
	 */
	public static int readVarInt(ByteBuffer buff) {
		int shift = 0, i = 0;
		while (true) {
			byte b = (byte) buff.get();
			i |= (b & 0x7F) << shift;// Remove sign bit and shift to get the next 7 bits
			shift += 7;
			if (b >= 0) {// VarInt byte prefix is 0, it means that we just decoded the last 7 bits, therefore we've finished.
				return i;
			}
		}
	}

	/**
	 * Writes a signed long with the "VarInt" format.
	 *
	 * @param n the long to encode
	 */
	public static void writeVarLong(long n, ByteBuffer buff) {
		while ((n & 0xFFFF_FFFF_FFFF_FF80l) != 0) {// While we have more than 7 bits (0b0xxxxxxx)
			byte data = (byte) (n | 0x80);// Discard bit sign and set msb to 1 (VarInt byte prefix).
			buff.put(data);
			n >>>= 7;
		}
		buff.put((byte) n);
	}

	/**
	 * Reads a VarLong.
	 *
	 * @return the long value
	 */
	public static long readVarLong(ByteBuffer buff) {
		int shift = 0;
		long l = 0;
		while (true) {
			byte b = (byte) buff.get();
			l |= (long) (b & 0x7F) << shift;// Remove sign bit and shift to get the next 7 bits
			shift += 7;
			if (b >= 0) {// VarInt byte prefix is 0, it means that we just decoded the last 7 bits, therefore we've finished.
				return l;
			}
		}
	}

	/**
	 * Writes a String to a ByteBuffer. The length of the string is written as a varInt, and then the content
	 * of the string is written with the UTF-8 charset.
	 */
	public static void writeString(String s, ByteBuffer buff) {
		byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
		writeVarInt(bytes.length, buff);
		buff.put(bytes);
	}

	/**
	 * Reads a String from a ByteBuffer. The length of the string is read as a varInt, and then the content of
	 * the string is read with the UTF-8 charset.
	 */
	public static String readString(ByteBuffer buff) {
		int size = readVarInt(buff);
		byte[] bytes = new byte[size];
		buff.get(bytes);
		return new String(bytes, StandardCharsets.UTF_8);
	}

	/**
	 * Reads a unsigned byte.
	 *
	 * @param b the unsigned byte
	 * @return a positive integer with the value of the unsigned byte
	 */
	public static int readUnsignedByte(byte b) {
		return (int) (b & 0x000000ff);
	}

	public static byte encodeEntityMetadataByte(int type, int index) {
		return (byte) (type << 5 | (index & 0x1F));
	}

	/**
	 * Encodes 3D coordinates in a 64 bytes value like this: 26 bytes for X, 12 for Y, 26 for Z.
	 *
	 * @param x X coordinate, points East in game
	 * @param y Y coordinate, points Upward in game
	 * @param z Z coordinate, points South in game
	 * @return an unsigned 64 bytes value containing the 3D position
	 */
	public static long encodePosition(int x, int y, int z) {
		return ((long) x << 38) | ((long) y << 26) | (z & 0x3FFFFFF);
	}

	/**
	 * Decodes the X coordinate of a 64 bytes value contaning 3D coordinates.
	 */
	public static int decodePositionX(long pos) {
		return (int) (pos >> 38);
	}

	/**
	 * Decodes the Y coordinate of a 64 bytes value contaning 3D coordinates.
	 */
	public static int decodePositionY(long pos) {
		return (int) ((pos >> 26) & 0xFFF);
	}

	/**
	 * Decodes the Z coordinate of a 64 bytes value contaning 3D coordinates.
	 */
	public static int decodePositionZ(long pos) {
		return (int) (pos << 38 >> 38);
	}

	/**
	 * Converts an integer to a 32 bits fixed-point number.
	 */
	public static int toFixedPoint(int i) {
		return i << 5;
	}

	/**
	 * Converts a double to a 32 bits fixed-point number.
	 */
	public static int toFixedPoint(double d) {
		return (int) (d * 32d);// 32 because 32 = 2⁵, and the fixed-point used by minecraft has a 5 bits fractional part.
		//d*32 is basically equivalent to d << 5
	}

	/**
	 * Converts an angle in degrees to an angle in steps of 1/256 of a full turn.
	 *
	 * @param degrees the angle, in degrees, as a float.
	 * @return the angle, in steps of 1/256 of a full turn, as an unsigned byte.
	 */
	public static int toRotationStep(float degrees) {
		return (int) ((degrees * 256.0) / 360.0);
	}

	/**
	 * Converts an angle in steps of 1/256 of a full turn to an angle in degrees.
	 *
	 * @param steps the angle, in steps of 1/256 of a full turn, as an unsigned byte
	 * @return the angle, in degrees, as a float.
	 */
	public static float toDegrees(int steps) {
		return (float) ((steps * 360.0) / 256.0);
	}

	/**
	 * Converts a fixed-point number to a double.
	 */
	public static double fixedPointToDouble(int fixedPoint) {
		return fixedPoint / 32d;
	}

	/**
	 * Converts a fixed-point number to a float.
	 */
	public static float fixedPointToFloat(int fixedPoint) {
		return fixedPoint / 32f;
	}

	/**
	 * Converts a fixed-point number to an integer. The resulting integer does not contains the fractional
	 * part.
	 */
	public static int fixedPointToInt(int fixedPoint) {
		return fixedPoint >>> 5;
	}

	/**
	 * Encodes a float into a short with the "Velocity" format.
	 *
	 * @param v a velocity, in unit of 1 block per 50ms.
	 * @return a velocity, in units of 1/8000 of a block per 50ms.
	 */
	public static short encodeVelocity(double v) {
		return (short) (v * 8000f);
	}

}
