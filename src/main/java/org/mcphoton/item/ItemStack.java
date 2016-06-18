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
package org.mcphoton.item;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.mcphoton.Photon;
import org.mcphoton.network.ProtocolOutputStream;
import org.mcphoton.network.ProtocolWriteable;

/**
 * A stack of items.
 *
 * @author TheElectronWill
 */
public class ItemStack implements ProtocolWriteable {

	protected final ItemType type;
	protected final int maxSize;
	protected AtomicInteger size, damage;

	public ItemStack(ItemType type, int maxSize, int size, int damage) {
		this.type = type;
		this.maxSize = maxSize;
		this.size = new AtomicInteger(size);
		this.damage = new AtomicInteger(damage);
	}

	/**
	 * Checks if the stack is empty.
	 */
	boolean isEmpty() {
		return size.get() == 0;
	}

	/**
	 * Checks if the stack is full, ie if its size is equal to its max size.
	 */
	boolean isFull() {
		return size.get() == maxSize;
	}

	/**
	 * Gets the stack's size.
	 */
	int getSize() {
		return size.get();
	}

	/**
	 * Atomically adds the given value to the current size value.
	 *
	 * @param delta the value to add
	 * @return the previous value
	 */
	int getAndAddSize(int delta) {
		return size.getAndAdd(delta);
	}

	/**
	 * Sets the stack's size.
	 */
	void setSize(int size) {
		this.size.set(size);
	}

	/**
	 * Gets the max stack's size.
	 */
	int getMaxSize() {
		return maxSize;
	}

	/**
	 * Gets the item type.
	 */
	ItemType getType() {
		return type;
	}

	/**
	 * Gets the stack's damage.
	 */
	int getDamage() {
		return damage.get();
	}

	/**
	 * Atomically adds the given value to the current damage value.
	 *
	 * @param delta the value to add
	 * @return the previous value
	 */
	int getAndAddDamage(int delta) {
		return damage.getAndAdd(delta);
	}

	/**
	 * Sets the stack's damage.
	 */
	void setDamage(int damage) {
		this.damage.set(damage);
	}

	@Override
	public void writeTo(ProtocolOutputStream out) throws IOException {
		int capturedSize = size.get(), capturedDamage = damage.get();//capture the values here to make sure that the written values don't change during the write operation.
		if (capturedSize == 0) {//empty
			out.writeShort(-1);
		} else {
			out.writeShort(type.getUniqueId());
			out.writeByte(capturedSize);
			out.writeShort(capturedDamage);
			out.writeByte(0);//TODO write NBT data like enchantments
		}
	}

	public static ItemStack readFrom(ByteBuffer buff) throws IOException {
		int typeId = buff.getShort();
		if (typeId == -1) {
			return new ItemStack(Photon.getItemRegistry().getRegistered(0), 64, 0, 0);
		} else {
			int size = buff.get();
			int damage = buff.getShort();
			//TODO read NBT data like enchantments
			return new ItemStack(Photon.getItemRegistry().getRegistered(size), 64, size, damage);
		}
	}

	@Override
	public String toString() {
		return "ItemStack{" + "type=" + type + ", maxSize=" + maxSize + ", size=" + size + ", damage=" + damage + '}';
	}

}
