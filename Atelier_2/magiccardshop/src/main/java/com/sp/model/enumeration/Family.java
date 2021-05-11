package com.sp.model.enumeration;

public enum Family {
	ETOILE1("1 Etoile"), ETOILES2("2 Etoiles"), ETOILES3("3 Etoiles");
		
	private final String text;
	
	Family(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
