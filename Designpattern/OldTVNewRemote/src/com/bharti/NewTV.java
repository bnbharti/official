package com.bharti;

public class NewTV extends OldTV {

	@Override
	public void switchOn() {
		System.out.println("New TV is on");
	}

	@Override
	public void switchOf() {
		System.out.println("New TV is off");
	}

	public void changeChannel() {
		System.out.println("New TV change channle");
	}

}
