package factory;

import factory.enums.SupportedPlatForms;

public class Flutter {
	SupportedPlatForms spoortedPlatForms;

	public Flutter(SupportedPlatForms spoortedPlatForms) {
		this.spoortedPlatForms = spoortedPlatForms;
	}

	public UIFactory createUIFactory() {
		return UIFactoryFactory.createUiFactory(spoortedPlatForms);
	}
}
