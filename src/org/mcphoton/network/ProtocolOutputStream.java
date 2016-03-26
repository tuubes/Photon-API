package org.mcphoton.network;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * Extensible and not Thread-safe OutputStream that provides methods for writing common data types found in the
 * Minecraft's protocol.
 * 
 * @author TheElectronWill
 * 		
 */
public final class ProtocolOutputStream extends OutputStream {
	
	private byte[] buff;
	private int count = 0;
	
	/**
	 * Creates a new stream with the initial capacity of 32 bytes.
	 */
	public ProtocolOutputStream() {
		buff = new byte[32];
	}
	
	/**
	 * Creates a new stream with the specified initial capacity.
	 */
	public ProtocolOutputStream(int initialCapacity) {
		buff = new byte[initialCapacity];
	}
	
	/**
	 * Creates a new stream with the specified data.
	 */
	public ProtocolOutputStream(byte[] data) {
		buff = data;
	}
	
	public ByteBuffer asBuffer() {
		return ByteBuffer.wrap(buff, 0, count);
	}
	
	public int size() {
		return count;
	}
	
	public int capacity() {
		return buff.length;
	}
	
	/**
	 * Clears this ProtocolOutputStream, that is, sets it size (internal counter) to 0. The capacity does not change.
	 */
	public void clear() {
		count = 0;
	}
	
	/**
	 * Resets this ProcotolOutputStream, that is, delete the internal buffer and create a new one with the default
	 * capacity (32 bytes).
	 */
	public void reset() {
		buff = new byte[32];
	}
	
	/**
	 * Resets this ProcotolOutputStream, that is, delete the internal buffer and create a new one with the specified
	 * capacity.
	 */
	public void reset(int newCapacity) {
		buff = new byte[newCapacity];
	}
	
	private void ensureCapacity(int cap) {
		if (buff.length < cap) {
			byte[] buff2 = new byte[buff.length * 2];
			System.arraycopy(buff, 0, buff2, 0, count);
			buff = buff2;
		}
	}
	
	private void directWrite(int b) {
		buff[count++] = (byte) b;
	}
	
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
	
	public void writeByte(int b) {
		ensureCapacity(buff.length + 1);
		directWrite(b);
	}
	
	public void writeShort(int s) {
		ensureCapacity(buff.length + 2);
		directWrite(s >> 8);
		directWrite(s);
	}
	
	public void writeChar(int c) {
		ensureCapacity(buff.length + 2);
		directWrite(c >> 8);
		directWrite(c);
	}
	
	public void writeInt(int i) {
		ensureCapacity(buff.length + 4);
		directWrite(i >> 24);
		directWrite(i >> 16);
		directWrite(i >> 8);
		directWrite(i);
	}
	
	public void writeLong(long l) {
		ensureCapacity(buff.length + 8);
		directWrite((byte) (l >> 56));
		directWrite((byte) (l >> 48));
		directWrite((byte) (l >> 40));
		directWrite((byte) (l >> 32));
		directWrite((byte) (l >> 24));
		directWrite((byte) (l >> 16));
		directWrite((byte) (l >> 8));
		directWrite((byte) l);
	}
	
	public void writeFloat(float f) {
		writeInt(Float.floatToIntBits(f));
	}
	
	public void writeDouble(double d) {
		writeLong(Double.doubleToLongBits(d));
	}
	
	/**
	 * Writes a String with the UTF-8 charset, prefixed with its size (in bytes) as a VarInt.
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
	public void write(byte[] b, int off, int len) {
		ensureCapacity(buff.length + len);
		System.arraycopy(b, off, buff, count, len);
	}
	
	@Override
	public void write(byte[] b) {
		write(b, 0, b.length);
	}
	
	/**
	 * Does nothing.
	 */
	@Override
	public void close() {}
	
	/**
	 * Does nothing.
	 */
	@Override
	public void flush() {}
	
}
