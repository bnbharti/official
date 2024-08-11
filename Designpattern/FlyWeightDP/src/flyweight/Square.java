package flyweight;

public class Square implements Shape{
	private String color;

	public Square(String color) {
		super();
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println("Draw shape of Square");
	}

}
