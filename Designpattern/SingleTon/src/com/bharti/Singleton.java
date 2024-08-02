package com.bharti;

public class Singleton {

	private Singleton() { // private so, it cannot instantiated from anywhere else
	}

	private static volatile Singleton singleton;// to hold the instance

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
