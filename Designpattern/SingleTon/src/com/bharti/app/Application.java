package com.bharti.app;

import com.bharti.Singleton;

public class Application {

	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
	}
}
