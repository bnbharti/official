package strategy;

public class Maps {
	public void findPath(String source, String destination, Mode mode) {
		PathCalculator pathCalculator=PathCalculatorFactor.getPathCalculator(mode);
		pathCalculator.findPath(source, destination);
	}
}
