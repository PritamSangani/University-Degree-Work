import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Pritam Sangani (16039231)
 * <b>Acts as a Tester class to test all CRUD (Create, Retrieve, Update, Delete) database operations developed in the StudentDAO class to check functionality.</b>
 */
public class DatabaseTester {

	/**
	 * <b>Main method runs all CRUD functionality tests</b>
	 * <i>Note: you will need access to the source code to ensure that an SQL Error is not thrown when inserting or deleting a student from the database.</i>
	 * Two Students are created for the purpose of testing the methods to insert and updating a Student in the Student Database
	 * @param args takes in console arguments as is defined of a main method
	 */
	public static void main(String[] args) {
		//change the parameters of the two Student objects to ensure that SQL errors are not thrown,
		// for example if a Student with the same Student Number already exists in the database.
		Student stu = new Student("Pritam Sangani", "M", "23-04-1998", "Stockport", "SK5 6TY", 1000, "Computer Sci2ence", "09-2016", 0, "pritam.sangani@pritam.com");
		Student stu1 = new Student("Pritam Sangani", "M", "23-04-1998", "Manchester", "SK5", 1000, "Computer Science", "10-2016", 500, "pritam@pritamsangani.com");

		try {
			getAllStudents();
			insertStudent(stu);
			getAllStudents();
			updateStudent(stu1);
			getAllStudents();
			//quotation marks concatenated with the Student Number so can be converted to String format
			deleteStudent(""+stu.getStudentNumber());
			getAllStudents();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * <b>Method to test the database operation to insert a student into the Student database.</b>
	 * A StudentDAO object is created before the method to insert a Student, as defined in the StudentDAO class, is called, with the result being printed to the console.
	 * @param stu the Student object being inserted into the database
	 * @throws SQLException
	 */
	public static void insertStudent(Student stu) throws SQLException{
		StudentDAO dao = new StudentDAO();
		System.out.println("Inserted Student? >> "+dao.insertStu(stu));
	}

	/**
	 * <b>Method to test the database operation to retrieve all the Students from the database and return the result as JSON output.</b>
	 * A StudentDAO and a Gson object is created before the method to retrieve all the students is called, with the result being stored in an ArrayList of Student objects.
	 * The Gson object is then used to convert the ArrayList to a JSON object.
	 * <i>Note: The Gson library is an external library so will have to be downloaded and then added to the src folder.</i>
	 * @throws SQLException
	 */
	public static void getAllStudents() throws SQLException{
		StudentDAO dao = new StudentDAO();
		Gson gson = new Gson();
		ArrayList<Student> allStudents;
		allStudents = dao.getAllStudents();
		System.out.println(gson.toJson(allStudents));
	}

	/**
	 * <b>Method to test the database operation to update an individual student in the database.</b>
	 * A StudentDAO object is created before the method to update a Student, as defined in the StudentDAO class, is called, with the result being printed to the console.
	 * @param stu the Student object being updated in the database
	 * @throws SQLException
	 */
	public static void updateStudent(Student stu) throws SQLException {
		StudentDAO dao = new StudentDAO();
		System.out.println("Updated Student? >> "+dao.updateStu(stu));
	}

	/**
	 * <b>Method to test the database operation to delete an individual student from the database.</b>
	 * A StudentDAO object is created before the method to delete a Student, as defined in the StudentDAO class, is called, with the result being printed to the console.
	 * @param stuID the Student Number/ID of the student being deleted from the Student Database.
	 * @throws SQLException
	 */
	public static void deleteStudent(String stuID) throws SQLException {
		StudentDAO dao = new StudentDAO();
		System.out.println("Deleted Student? >> "+dao.deleteStu(stuID));
	}
}
