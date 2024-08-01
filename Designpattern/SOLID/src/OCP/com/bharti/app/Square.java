package OCP.com.bharti.app;

public class Square implements Shape{
	private double side=22.22;
	@Override
	public double areaCalculator() {
		return side*side;
	}
}
