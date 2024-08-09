package factory;

import factory.enums.SupportedPlatForms;
import factory.impl.AndriodFactory;
import factory.impl.IOSFactory;

public class UIFactoryFactory {
	public static UIFactory createUiFactory(SupportedPlatForms spoortedPlatForms) {
		switch(spoortedPlatForms) {
		case IOS: return new IOSFactory();
		case ANDRIO: return new AndriodFactory();
		}
		return null;
		
	}
}
