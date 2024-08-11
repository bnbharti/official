package flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
	static Map<String, Shape> SHAPE_STORE = new HashMap<>();

	public static Shape createShape(String color, ShapeType shapeType) {
		String key = color + shapeType;
		Shape shape = SHAPE_STORE.get(key);
		if (shape == null) {
			shape = createNewShape(color, shapeType);
			SHAPE_STORE.put(key, shape);
		}
		return shape;
	}

	private static Shape createNewShape(String color, ShapeType shapeType) {
		return switch (shapeType) {
		case CIRCLE -> new Circle(color);
		case SQUARE -> new Square(color);
		case RECTANGLE -> new Rectangle(color);
		default -> throw new IllegalArgumentException(" Unknow type share " + shapeType);
		};
	}
}
