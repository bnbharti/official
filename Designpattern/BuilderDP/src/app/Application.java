package app;

import model.Employee;

public class Application {
	public static void main(String[] args) {
		Employee employee = Employee.builder().id(1)/* .name("Narendra") */.salary(100.0d).build();
		System.out.println(employee);
	}
}
