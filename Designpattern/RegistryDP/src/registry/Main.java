package registry;

public class Main {
	public static void main(String[] args) {
		System.out.println(4%3);
		Student student = new Student("Narendra", "bnbharti@gmail.com", "999999999", "2023", "BatchA", "DSA", "Sandeep",
				"2023", "Morning", "2024");
		 Student studentPrototypeBatchA = new Student("2023", "BatchA", "HLD", "Sandeep", "12-June-23", "MWF", "30-Apr-2024");
	        Student studentPrototypeBatchB = new Student("2023", "BatchB", "LLD", "naman", "12-Dec-23", "TTS", "30-June-2024");
		Student studentPrototypeBatchC = new Student("2024", "BatchC", "DSA", "mohit", "12-Jan-24", "MWF Morning",
				"30-Dec-2024");
		Registry registry = new Registry();
		Student studentForBatchA = registry.get("BatchA").clone();
		studentForBatchA.setName("Narendra");
	}
}
