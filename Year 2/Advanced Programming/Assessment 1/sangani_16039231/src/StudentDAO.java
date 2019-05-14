import java.sql.*;
import java.util.ArrayList;

/**
 * <b>Contains all methods for all CRUD (Create, Retrieve, Update and Delete) database operations.</b>
 *
 * @author Pritam Sangani (16039231)
 */
public class StudentDAO {

	/**
	 * Method to initiate the connection to the SQLite database
	 * @return the database Connection that has been created
	 */
	public Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			String dbURL = "jdbc:sqlite:studentdb.sqlite";
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	/**
	 * <b>Method to retrieve all the Students from the Student database</b>
	 * @return an ArrayList of Students containing all the Students that have been retrieved from the database
	 * @throws SQLException
	 */
	public ArrayList<Student> getAllStudents() throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet rs = null;
		Student temp;
		ArrayList<Student> studentsList = new ArrayList<>();
		String query = "SELECT * FROM students;";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("Query >> " + query);
			// execute SQL query
			rs = statement.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("Name");
				String gender = rs.getString("Gender");
				String dob = rs.getString("DOB");
				String address = rs.getString("Address");
				String postcode = rs.getString("Postcode");

				int stuID = rs.getInt("StudentNumber");
				String courseTitle = rs.getString("CourseTitle");
				String startDate = rs.getString("StartDate");
				Float bursary = rs.getFloat("Bursary");
				String email = rs.getString("Email");

				temp = new Student(name, gender, dob, address, postcode, stuID, courseTitle, startDate,bursary ,email);
				studentsList.add(temp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return studentsList;
	}

	/**
	 * Method to retrieve an indvidual Student based of StudentID
	 * @param studentID student id of Student
	 * @return Student object of retrieved Student
	 * @throws SQLException
	 */
	public Student getStudent(String studentID) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		Student temp = null;
		String query = "SELECT * FROM students WHERE StudentNumber = "+studentID+";";

		try {
			connection = getDBConnection();
			statement = connection.createStatement();
			System.out.println("Query >> "+query);
			rs = statement.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("Name");
				String gender = rs.getString("Gender");
				String dob = rs.getString("DOB");
				String address = rs.getString("Address");
				String postcode = rs.getString("Postcode");
				int stuID = rs.getInt("StudentNumber");
				String course = rs.getString("CourseTitle");
				String startDate = rs.getString("StartDate");
				float bursary = rs.getFloat("Bursary");
				String email = rs.getString("Email");

				temp = new Student(name,gender,dob,address,postcode,stuID,course,startDate,bursary,email);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs!=null) {
				rs.close();
			}
			if (statement!=null) {
				statement.close();
			}
			if (connection!=null) {
				connection.close();
			}
		}

		return temp;
	}

	/**
	 * Method to insert a Student into the Student database
	 * @param stu Student object of Student being inserted into the database
	 * @return a Boolean value (True representing a successful insertion of a Student, False otherwise)
	 * @throws SQLException
	 */
	public Boolean insertStu(Student stu) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		Boolean inserted = false;
		Validator validator = new Validator();

		String query = "INSERT INTO students (Name, Gender, DOB, Address, Postcode, StudentNumber, CourseTitle, StartDate, Bursary, Email)" +
				" VALUES(?,?,?,?,?,?,?,?,?,?);";

		try {
			connection = getDBConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, stu.getName());
			statement.setString(2, stu.getGender());
			statement.setString(3, stu.getDob());
			statement.setString(4, stu.getAddress());
			statement.setString(5, stu.getPostcode());
			statement.setInt(6, stu.getStudentNumber());
			statement.setString(7, stu.getCourseTitle());
			statement.setString(8, stu.getStartDate());
			statement.setDouble(9, stu.getBursary());
			statement.setString(10, stu.getEmail());

			System.out.println("Query >>> " + query);

			if(validator.validateName(stu.getName()) && validator.validateGender(stu.getGender()) && validator.validateEmail(stu.getEmail())
					&& validator.validatePostcode(stu.getPostcode()) && validator.validateStartDate(stu.getStartDate())
					&& validator.validateCourseTitle(stu.getCourseTitle()) && validator.validateBursary(stu.getBursary() + "")) {
				if (statement.executeUpdate() > 0) {
					inserted = true;
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return inserted;
	}

	/**
	 * Method to delete a Student from the Student database
	 * @param stuID student id of Student being deleted from the Student database
	 * @return a Boolean value (True representing a successful deletion of a Student, False otherwise)
	 * @throws SQLException
	 */
	public Boolean deleteStu(String stuID) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		Boolean deleted = false;

		String query = "DELETE FROM students WHERE StudentNumber = '"+stuID+"';";

		try {
			connection = getDBConnection();
			statement = connection.createStatement();
			System.out.println("Query >>> " + query);
			statement.executeUpdate(query);
			deleted = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return deleted;
	}

	/**
	 * Method to update the information of a Student already in the Student database
	 * @param stu Student object of Student being updated in the Student database
	 * @return a Boolean value (True representing a successful update of a Student, False otherwise)
	 * @throws SQLException
	 */
	public Boolean updateStu(Student stu) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		Boolean updated = false;

		String query = "UPDATE students " +
				"SET Name = ?, Gender = ?, DOB = ?, Address = ?, Postcode = ?, CourseTitle = ?, StartDate = ?, Bursary = ?, Email = ? " +
				" WHERE StudentNumber = ?;";

		try {
			connection = getDBConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, stu.getName());
			statement.setString(2, stu.getGender());
			statement.setString(3, stu.getDob());
			statement.setString(4, stu.getAddress());
			statement.setString(5, stu.getPostcode());
			statement.setString(6, stu.getCourseTitle());
			statement.setString(7, stu.getStartDate());
			statement.setDouble(8, stu.getBursary());
			statement.setString(9, stu.getEmail());
			statement.setInt(10, stu.getStudentNumber());
			System.out.println("Query >>> " + query);

			if(statement.executeUpdate() > 0) {
				updated = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return updated;
	}

	public Boolean checkLoginCredentials(String username, String password) {

		//put your code here
		return false;	
	}

	public boolean checkApiKey(String key) {
		
		//put your code here
		return false;
	}
}
