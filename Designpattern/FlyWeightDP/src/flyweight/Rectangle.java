package flyweight;

public class Rectangle implements Shape{
	private String color;

	public Rectangle(String color) {
		super();
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println("Draw shape of Rectangle");
	}
}
