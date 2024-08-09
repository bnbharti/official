package factory;

import factory.component.button.Button;
import factory.component.dropdownmenu.DropDownMenu;

public interface UIFactory {
	Button createButtion();

	DropDownMenu createDropDownMenu();
}
