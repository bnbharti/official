package facade;

import facade.component.Amplifier;
import facade.component.DVDPlayer;
import facade.component.Projector;
import facade.component.Screen;
import facade.component.TheaterLight;
import facade.component.Impl.LGProjector;
import facade.component.Impl.LGScreen;
import facade.component.Impl.LGThreaterLight;
import facade.component.Impl.PhilipsAmplifier;
import facade.component.Impl.SamsungDvdPlayer;

public class Main {
	public static void main(String[] args) {
		String movieName="DHOM-4";
		String lightColor="white";
		String lightLevel="low";
		Amplifier amplifier = new PhilipsAmplifier();
		DVDPlayer dvdPlayer = new SamsungDvdPlayer();
		Projector projector = new LGProjector();
		Screen screen = new LGScreen();
		TheaterLight theaterLight = new LGThreaterLight();
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amplifier, dvdPlayer, projector, screen,
				theaterLight);
		homeTheaterFacade.watchMovi(movieName, lightColor, lightLevel);
		homeTheaterFacade.endMovi();
	}
}
