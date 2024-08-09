package facade.component.Impl;

import facade.component.Amplifier;

public class PhilipsAmplifier implements Amplifier {

	@Override
	public void on() {
		System.out.println("PhilipsAmplifier is on");

	}

	@Override
	public void setVolumLeve(int level) {
		System.out.println("PhilipsAmplifier volum leve:-" + level);

	}

	@Override
	public void off() {
		System.out.println("PhilipsAmplifier is off");

	}

}
