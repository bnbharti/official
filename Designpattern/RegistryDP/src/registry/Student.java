package registry;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Student implements ProtoType<Student> {

	private String name;
	private String email;
	private String phoneNumber;
	private String yearOfEnrollment;
	private String batchName;
	private String moduleName;
	private String instructorName;
	private String moduleStartDate;
	private String moduleSchedule;
	private String moduleEndDate;

	public Student(String yearOfEnrollment, String batchName, String moduleName, String instructorName,
			String moduleStartDate, String moduleSchedule, String moduleEndDate) {
		this.yearOfEnrollment = yearOfEnrollment;
		this.batchName = batchName;
		this.moduleName = moduleName;
		this.instructorName = instructorName;
		this.moduleStartDate = moduleStartDate;
		this.moduleSchedule = moduleSchedule;
		this.moduleEndDate = moduleEndDate;
	}

	public Student(Student student) { // working as a copy constructor, and can be used to create deep copies for
										// fixed attributes
		this.yearOfEnrollment = student.yearOfEnrollment;
		this.batchName = student.batchName;
		this.moduleName = student.moduleName;
		this.instructorName = student.instructorName;
		this.moduleStartDate = student.moduleStartDate;
		this.moduleSchedule = student.moduleSchedule;
		this.moduleEndDate = student.moduleEndDate;
	}

	@Override
	public Student clone() {
		return new Student(this);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", yearOfEnrollment="
				+ yearOfEnrollment + ", batchName=" + batchName + ", moduleName=" + moduleName + ", instructorName="
				+ instructorName + ", moduleStartDate=" + moduleStartDate + ", moduleSchedule=" + moduleSchedule
				+ ", moduleEndDate=" + moduleEndDate + "]";
	}

	public Student(String name, String email, String phoneNumber, String yearOfEnrollment, String batchName,
			String moduleName, String instructorName, String moduleStartDate, String moduleSchedule,
			String moduleEndDate) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.yearOfEnrollment = yearOfEnrollment;
		this.batchName = batchName;
		this.moduleName = moduleName;
		this.instructorName = instructorName;
		this.moduleStartDate = moduleStartDate;
		this.moduleSchedule = moduleSchedule;
		this.moduleEndDate = moduleEndDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getYearOfEnrollment() {
		return yearOfEnrollment;
	}

	public void setYearOfEnrollment(String yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getModuleStartDate() {
		return moduleStartDate;
	}

	public void setModuleStartDate(String moduleStartDate) {
		this.moduleStartDate = moduleStartDate;
	}

	public String getModuleSchedule() {
		return moduleSchedule;
	}

	public void setModuleSchedule(String moduleSchedule) {
		this.moduleSchedule = moduleSchedule;
	}

	public String getModuleEndDate() {
		return moduleEndDate;
	}

	public void setModuleEndDate(String moduleEndDate) {
		this.moduleEndDate = moduleEndDate;
	}

}
