package registry;

import java.util.HashMap;
import java.util.Map;

public class Registry {

	Map<String, Student> studentRegistry;

	public Registry() {
		this.studentRegistry = new HashMap<>();
	}

	public void add(Student student) {
		studentRegistry.put(student.getBatchName(), student);
	}

	public void remove(String batchName) {
		studentRegistry.remove(batchName);
	}

	Student get(String batchName) {
		return studentRegistry.get(batchName);
	}
}
