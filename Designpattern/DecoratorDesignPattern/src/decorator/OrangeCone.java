package decorator;

public class OrangeCone implements IceCream {
	private IceCream iceCream;
public OrangeCone() {
	// when orangeCone is base
}
	public OrangeCone(IceCream iceCream) {
		super();
		this.iceCream = iceCream;
	}

	@Override
	public String getDetails() {
		if(iceCream!=null) {
		return iceCream.getDetails()+", Orange cone added as base";
		}else {
			return "Orange cone added";
		}
	}

	@Override
	public int getPrice() {
		if(iceCream!=null) {
			return iceCream.getPrice()+60;
		}else {
			return 60;
		}
	}

}
