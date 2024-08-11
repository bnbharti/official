package flyweight;

public class Circle implements Shape {
	private String color;

	public Circle(String color) {
		super();
		this.color = color;
	}

	@Override
	public void draw() {
		System.out.println("Draw shape of circle");
	}

}
