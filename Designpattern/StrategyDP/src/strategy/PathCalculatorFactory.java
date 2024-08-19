package strategy;

public class PathCalculatorFactory {

	public static PathCalculator getPathCalculator(Mode mode) {
		return switch (mode) {
		case CAR -> new CarPathCalculator();
		case WALK -> new WalkPathCalculator();
		case BIKE -> new BikePathCalculator();
		default -> null;
		};
	}
}
