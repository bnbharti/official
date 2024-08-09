package facade.component.Impl;

import facade.component.DVDPlayer;
import facade.component.Projector;

public class LGProjector implements Projector {

	@Override
	public void on() {
		System.out.println("LgProjector is on");

	}

	@Override
	public void setInput(DVDPlayer dvdPlayer) {
		System.out.println("LGProject is playing with " + dvdPlayer);

	}

	@Override
	public void off() {
		System.out.println("LGProject is off now");

	}

}
