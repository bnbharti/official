package strategy;

public class WalkPathCalculator implements PathCalculator {

	@Override
	public void findPath(String source, String destination) {
		System.out.println("Via Walk "+source+" to "+destination);
	}

}
