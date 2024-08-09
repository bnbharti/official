
package facade.component.Impl;

import facade.component.TheaterLight;

public class LGThreaterLight implements TheaterLight{ 

	@Override
	public void on() {
		System.out.println("LGTheater light is on ");
		
	}

	@Override
	public void setLightColor(String color) {
        System.out.println("Light color set to "+color);
		
	}

	@Override
	public void setLightLevel(String lightLevel) {
		System.out.println("Light level set to "+lightLevel);
		
	}

	@Override
	public void off() {
		System.out.println("LGThreater light is off now.");
		
	}

}
