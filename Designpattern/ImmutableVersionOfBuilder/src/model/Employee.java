package model;

public class Employee {
	private final int id;
	private final String name;
	private final double salary;

	public Employee(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.salary = builder.salary;
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public static class Builder {
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

		public Builder salary(double salary) {
			this.salary = salary;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}
	public static Builder builder() {
		return new Builder();
	}

}
