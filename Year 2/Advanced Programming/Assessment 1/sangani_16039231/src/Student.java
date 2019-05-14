/**
 * @author Pritam Sangani (16039231)
 * @see Person
 *
 */
public class Student extends Person{
	
	private int studentNumber; 
	private String courseTitle; 
	private String startDate; 
	private double bursary;
	private String email;

	/**
	 * <b>Constructs and initiates a new instance of a Student</b>
	 * @param name name of Student
	 * @param gender gender of Student
	 * @param dob Date of Birth of Student
	 * @param address address of Student
	 * @param postcode postcode of Student
	 * @param studentNumber Student Number/ID of Student
	 * @param courseTitle Course Title of Student
	 * @param startDate Start Date of Student's course
	 * @param bursary Bursary amount that the Student receives
	 * @param email email address of Student
	 */
	public Student(String name, String gender, String dob, String address, String postcode, int studentNumber, String courseTitle, String startDate, float bursary, String email) {
		super(name, gender, dob, address, postcode);
		
		this.studentNumber = studentNumber;
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.bursary = bursary;
		this.email = email;
	}

	/**
	 * Getter to get Student Number of Student
	 * @return Student Number of Student
	 */
	public int getStudentNumber() {
		return studentNumber;
	}

	/**
	 * Getter to get course title of Student
	 * @return course title of Student
	 */
	public String getCourseTitle() {
		return courseTitle;
	}

	/**
	 * Getter to get start date of Student's course
	 * @return start date of Student's course
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Getter to get the bursary amount that the Student receives
	 * @return bursary amount that the Student receives
	 */
	public double getBursary() {
		return bursary;
	}

	/**
	 * Getter to get the email address of Student
	 * @return email address of Student
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Overrides the toString() method so that information related to a Student is printed in String format
	 * @return information related to Student in String format
	 */
	@Override
	public String toString() {
		String stuInfo;
		stuInfo = getName() + ", " + getGender() + ", " + getDob() + ", " + getAddress() + ", " + getPostcode() + ", " + getStudentNumber() + ", " + getCourseTitle() + ", " + getStartDate() + ", " + getBursary() + ", " + getEmail();

		return stuInfo;
	}
}
