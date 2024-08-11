package flyweight;

public class Main {
	public static void main(String[] args) {
		Shape circle = ShapeFactory.createShape("blue", ShapeType.CIRCLE);
		circle.draw();
		Shape circle2 = ShapeFactory.createShape("blue", ShapeType.CIRCLE);
		circle2.draw();
		System.out.println(circle2 == circle);
		Shape rectangle = ShapeFactory.createShape("blue", ShapeType.RECTANGLE);
		rectangle.draw();
		Shape rectangle2 = ShapeFactory.createShape("blue", ShapeType.RECTANGLE);
		rectangle2.draw();
		System.out.println(rectangle == rectangle2);
		Shape square = ShapeFactory.createShape("blue", ShapeType.SQUARE);
		square.draw();
		Shape square2 = ShapeFactory.createShape("blue", ShapeType.SQUARE);
		square2.draw();
		System.out.println(square == square2);
	}
}
