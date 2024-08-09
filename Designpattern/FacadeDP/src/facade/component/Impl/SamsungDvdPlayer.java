package facade.component.Impl;

import facade.component.DVDPlayer;

public class SamsungDvdPlayer implements DVDPlayer {

	@Override
	public void on() {
		System.out.println("SamsungDvdPlayer is on");
	}

	@Override
	public void playMovie(String movie) {
		System.out.println("SamsungDvdPlayer is playing " + movie);

	}

	@Override
	public void off() {
		System.out.println("SamsungDvdPlayer is off");

	}

}
