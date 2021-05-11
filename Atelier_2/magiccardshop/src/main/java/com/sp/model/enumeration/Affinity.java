package com.sp.model.enumeration;

public enum Affinity {
	NORMAL("Normal"), 
	FIRE("Fire"), 
	WATER("Water"), 
	GRASS("Grass"), 
	ELECTRIC("Electric"), 
	ICE("Ice"), 
	FIGHTING("Fighting"),
	POISON("Poison"),
	GROUND("Ground"),
	FLYING("Flying"),
	PSYCHIC("Psychic"), 
	BUG("Bug"),
	ROCK("Rock"),
	GHOST("Ghost"),
	DRAGON("Dragon"),
	DARK("Dark"),
	STEEL("Steel"),
	FAIRY("Fairy");
	
	private final String text;
	
	Affinity(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
