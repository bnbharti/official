package facade;

import facade.component.Amplifier;
import facade.component.DVDPlayer;
import facade.component.Projector;
import facade.component.Screen;
import facade.component.TheaterLight;

public class HomeTheaterFacade {
	private Amplifier amplifier;
	private DVDPlayer dvdPlayer;
	private Projector projector;
	private Screen screen;
	private TheaterLight theaterLight;

	public HomeTheaterFacade(Amplifier amplifier, DVDPlayer dvdPlayer, Projector projector, Screen screen,
			TheaterLight theaterLight) {
		super();
		this.amplifier = amplifier;
		this.dvdPlayer = dvdPlayer;
		this.projector = projector;
		this.screen = screen;
		this.theaterLight = theaterLight;
	}

	public void watchMovi(String moviName, String lightColor, String lightLevel) {
		amplifier.on();
		amplifier.setVolumLeve(4);
		dvdPlayer.on();
		dvdPlayer.playMovie(moviName);
		projector.on();
		projector.setInput(dvdPlayer);
		theaterLight.on();
		theaterLight.setLightColor(lightColor);
		theaterLight.setLightLevel(lightLevel);
	}

	public void endMovi() {
		amplifier.off();
		dvdPlayer.off();
		projector.off();
		theaterLight.off();
	}
}
