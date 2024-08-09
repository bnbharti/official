package decorator;

public class ChocoScope implements IceCream{
	private IceCream iceCream;
	
	public ChocoScope(IceCream iceCream) {
		super();
		this.iceCream = iceCream;
	}

	@Override
	public String getDetails() {
		return iceCream.getDetails()+", ChocoScope Added";
	}

	@Override
	public int getPrice() {
		return iceCream.getPrice()+20;
	}
	

}
