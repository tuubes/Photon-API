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
package org.mcphoton.entity;

public interface Rotateable {

	/**
	 * Gets the pitch of the entity in radian.
	 * 
	 * @return pitch in radian
	 */
	int getPitch();

	/**
	 * Sets the pitch of the entity in radian.
	 * 
	 * @param pitch in radian
	 */
	void setPitch(int pitch);

	/**
	 * Gets the yaw of the entity in radian.
	 * 
	 * @return yaw in radian
	 */
	int getYaw();

	/**
	 * Sets the yaw of the entity in radian.
	 * 
	 * @param yaw in radian
	 */
	void setYaw(int yaw);

}
