package org.mcphoton.entity.living;

public abstract class AgeableEntity extends LivingEntity implements Ageable {
	
	protected volatile int age = 0;
	
	@Override
	public int getAge() {
		return age;
	}
	
	@Override
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean isAdult() {
		return age > 0;
	}
	
	@Override
	public void setAdult(boolean adult) {
		if (adult) {
			if (age <= 0)
				age = 1;
		} else {
			if (age > 0)
				age = -1;
		}
	}
	
}
