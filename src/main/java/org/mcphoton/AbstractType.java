/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mcphoton;

import com.electronwill.utils.IntConstant;

/**
 * Abstract class for types (block types, item types, etc.)
 *
 * @author TheElectronWill
 */
public abstract class AbstractType implements Type {

	private final IntConstant id = new IntConstant();

	@Override
	public int getUniqueId() {
		return id.get();
	}

	/**
	 * Initializes the unique id of this type. This method may only be called once.
	 */
	public void initializeId(int id) {
		this.id.init(id);
	}

}