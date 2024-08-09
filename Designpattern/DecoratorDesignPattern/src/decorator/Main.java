package decorator;

public class Main {
	public static void main(String[] args) {
		IceCream iceCream = new OrangeCone(new ChocoScope(new ChocoCone()));
		System.out.println(iceCream.getDetails());
		System.out.println(iceCream.getPrice());
	}
}
