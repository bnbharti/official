package com.bharti;

public enum Singleton {
	INSTANCE;

	public Singleton getInstance() {

		System.out.println(
				"Using an enum for the Singleton implementation provides thread-safety, serialization handling, and a simple syntax.");
		return INSTANCE;
	}
}
