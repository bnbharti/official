package factory.app;

import factory.Flutter;
import factory.UIFactory;
import factory.component.button.Button;
import factory.component.dropdownmenu.DropDownMenu;
import factory.enums.SupportedPlatForms;

public class Application {
	public static void main(String[] args) {
		Flutter flutter = new Flutter(SupportedPlatForms.ANDRIO);
		UIFactory uiFactory = flutter.createUIFactory();
		Button buttion = uiFactory.createButtion();
		DropDownMenu dropDownMenu = uiFactory.createDropDownMenu();
		System.out.println("");
	}
}
