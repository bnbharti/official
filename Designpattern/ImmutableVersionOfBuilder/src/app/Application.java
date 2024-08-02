package app;

import model.Employee;

public class Application {
	public static void main(String[] args) {
		// Employee employee = new Employee.Builder().id(1).name("narendra").salary(100.0).build();
		Employee employee = Employee.builder().id(2).name("Bharti").salary(200.0).build();
		System.out.println(employee);
	}
}
