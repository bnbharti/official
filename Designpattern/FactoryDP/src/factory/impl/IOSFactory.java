package factory.impl;

import factory.UIFactory;
import factory.component.button.IOSButton;
import factory.component.dropdownmenu.IOSDropDownMenu;

public class IOSFactory implements UIFactory {

	@Override
	public IOSButton createButtion() {
		System.out.println("IOS button created");
		return new IOSButton();
	}

	@Override
	public IOSDropDownMenu createDropDownMenu() {
		System.out.println("IOS DropdownMenu created");
		return new IOSDropDownMenu();
	}

}
