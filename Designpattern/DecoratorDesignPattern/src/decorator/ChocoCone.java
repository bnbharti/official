package decorator;

public class ChocoCone implements IceCream{
    private IceCream iceCream;
    public ChocoCone() {
    	super();
	//// when ChocoCone is base
	}
	public ChocoCone(IceCream iceCream) {
		super();
		this.iceCream = iceCream;
	}

	@Override
	public String getDetails() {
		if(iceCream!=null) {
		return iceCream.getDetails()+", ChocoCone added as base";
		}else {
			return "ChocoCone added";
		}
	}

	@Override
	public int getPrice() {
		if(iceCream!=null) {
			return iceCream.getPrice()+50;
		}else {
			return 50;
		}
	}
	

}
