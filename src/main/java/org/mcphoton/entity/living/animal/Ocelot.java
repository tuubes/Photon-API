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
package org.mcphoton.entity.living.animal;

/**
 * 
 * @author DJmaxZPLAY
 */
public interface Ocelot extends TameableAnimal {

	/**
	 * Get the type of the cat. 0:Wild, 1:Black, 2:Red, 3:Siamese.
	 * 
	 * @return Type of the cat. 0:Wild, 1:Black, 2:Red, 3:Siamese.
	 */
	int getCatType();
	
	/**
	 * Set the type of the cat. 0:Wild, 1:Black, 2:Red, 3:Siamese.
	 * 
	 * @param type The new type of the cat. 0:Wild, 1:Black, 2:Red, 3:Siamese.
	 */
	void setCatType(int type);
	
	boolean isSitting();
	
	void setSitting(boolean sitting);
	
}
