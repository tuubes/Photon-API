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
package org.mcphoton.entity.living;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.mcphoton.block.BlockEntity;
import org.mcphoton.block.BlockType;
import org.mcphoton.entity.Entity;
import org.mcphoton.inventory.EntityInventory;
import org.mcphoton.world.Location;

public interface Living{
	
	void setInvulnerable(boolean invulnerable);
	
	boolean isInvulnerable();
	
	float getHealth();
	
	float getMaxHealth();

	void setHealth(float health);
	
	void setMaxHealth(float maxHealth);

	void damage(float damage);

	void kill();
	
	Optional<Entity> getKiller();

	default boolean isAlive() {
		return getHealth() > 0;
	}
	
	int getRemainingAir();
	
	void setRemainingAir(int remainingAir);
	
	int getMaxAir();
	
	void setMaxAir(int maxAir);
	
	void setGliding(boolean gliding);
	
	boolean isGliding();
	
	float getEyeHeight();
	
	float getEyeHeight(boolean ignoreSneak);
	
	Location getEyeLocation();
	
	Collection<BlockEntity> getBlockInSight(Optional<Set<BlockType>> transparent, int maxDistance);
	
	BlockEntity getTargetBlock(Optional<Set<BlockType>>  transparent, int maxDistance);
	
	boolean isDispawnFarFromPlayer();
	
	void setdispawnFarFromPlayer(boolean dispawn);
	
	boolean canPickupItems();
	
	void setCanPickItems(boolean pickup);
	
	boolean isLeashed();
	
	Optional<Entity> getLeashHolder();
	
	boolean setLeashHolder(Entity holder);
	
	EntityInventory getEquipment();
	
}
