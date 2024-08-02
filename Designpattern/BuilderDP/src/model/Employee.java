package model;

import exception.InvalidNameException;

public class Employee {
	private int id;
	private String name;
	private double salary;

	private Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	} 

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {// task -> take inputs, validate inputs and create Student object
		private int id;
		private String name;
		private double salary;

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}
		public void validate() {
			if(name==null) {
				throw new InvalidNameException("Name is not valid");
			}
		}

		public Builder salary(double salary) {
			this.salary = salary;
			return this;
		}

		public Employee build() {
			validate();
			return new Employee(this.id, this.name, this.salary);
		}

	}

}
