package prototype;

public class Main {
	public static void main(String[] args) {
		Student student = new Student("Narendra", "bnbharti@gmail.com", "999999999", "2023", "BatchA", "DSA", "Sandeep",
				"2023", "Morning", "2024");
		Student copyStudent = student.clone();
		System.out.println(student);
		 
		System.out.println(student.equals(copyStudent)); // its returning false because in clone we have not copy name,email,phoneno
	}
}
