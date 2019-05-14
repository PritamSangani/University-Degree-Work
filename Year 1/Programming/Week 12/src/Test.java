
public class Test {

	public static void main(String[] args) {
		Student Fred = new Student("Fred", 18, 69,80);
		//Student John = new Student();
		
		//Fred.displayConsole();
		//John.displayConsole();
		
		Unit prog = new Unit("Programming", "Dr Dave");
		prog.addStudent(Fred);
		prog.addStudent(new Student("Ryan", 18, 70,82));
		prog.addStudent(new Student("Jim", 18, 50,60));
		
		prog.displayConsole();
	}

}
