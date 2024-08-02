package com.bharti.app;

import com.bharti.Singleton;

public class Application {
	public static void main(String[] args) {
		Singleton singleton = Singleton.INSTANCE;
		 singleton.getInstance();
		 System.out.println(Singleton.INSTANCE.getInstance());
		 System.out.println(Singleton.INSTANCE.getInstance());
		 System.out.println(Singleton.INSTANCE.getInstance());
		 System.out.println(Singleton.INSTANCE.getInstance());
		 System.out.println(Singleton.INSTANCE);
	}
}
