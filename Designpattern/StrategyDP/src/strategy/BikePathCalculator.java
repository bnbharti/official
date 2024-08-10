package strategy;

public class BikePathCalculator implements PathCalculator {

	@Override
	public void findPath(String source, String destination) {
		System.out.println("Via Bike "+source+" to "+destination);
	}

}
