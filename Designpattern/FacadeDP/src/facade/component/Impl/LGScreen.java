package facade.component.Impl;

import facade.component.Screen;

public class LGScreen implements Screen {

	@Override
	public void up() {
		System.out.println("LGScreen is un-folded now");

	}

	@Override
	public void down() {
		System.out.println("LGScreen is folded now");

	}

}
