package factory.impl;

import factory.UIFactory;
import factory.component.button.AndriodButton;
import factory.component.button.Button;
import factory.component.dropdownmenu.AndrioDropDownMenu;
import factory.component.dropdownmenu.DropDownMenu;

public class AndriodFactory implements UIFactory {

	@Override
	public Button createButtion() {
		System.out.println("Andriod button created");
		return new AndriodButton();
	}

	@Override
	public DropDownMenu createDropDownMenu() {
	System.out.println("Andriod DropDownMenu created");
		return new AndrioDropDownMenu();
	}

}
