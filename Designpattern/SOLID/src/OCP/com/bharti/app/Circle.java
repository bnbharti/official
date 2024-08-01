package OCP.com.bharti.app;

public class Circle implements Shape{
	private double radiou=22.22;
	@Override
	public double areaCalculator() {
		return 22/7*radiou*radiou;
	}
}
