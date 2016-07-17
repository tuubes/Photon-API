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

import org.mcphoton.utils.ArtType;

/**
 * A painting hanged on a wall.
 * 
 * @author DJmaxZPLAY
 */
public interface Painting extends Entity, Hangeable {

	/**
	 * Set the art to show on this painting.
	 * 
	 * @param art The art to show.
	 * @return False if the art won't fit.
	 */
	boolean setArt(ArtType art);
	/**
	 * Set the art to show on this painting.
	 * 
	 * @param art The art to show.
	 * @param force Force the art to fit on.
	 * @return False if the art won't fit.
	 */
	boolean setArt(ArtType art, boolean force);
	
	/**
	 * Get the art showed on this painting.
	 * 
	 * @return The art.
	 */
	ArtType getArt(ArtType art);	
	
}
