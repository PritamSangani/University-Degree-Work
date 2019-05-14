import java.util.ArrayList;

public class Unit {
	String unitName;
	String lecturerName;
	float aveMark1, aveMark2;
	float aveUnitMark = 0;
	int classSize = 0;
	ArrayList<Student>studentList;
	
	Unit()
	{
		studentList = new ArrayList<Student>(); //create an empty Array List
	}
	
	Unit(String unitName, String lecturerName)
	{
		this.unitName = unitName;
		this.lecturerName = lecturerName;
		studentList = new ArrayList<Student>();
	}
	
	void addStudent(Student students)
	{
		studentList.add(students);
		classSize++;
	}
	
	void displayConsole()
	{
		System.out.println("unit name: " + unitName + " " + "taught by " + lecturerName);
		
		for(Student students: studentList)
		{
			students.displayConsole();
		}
		
		System.out.println(aveUnitMark);
	}
	
	float unitAverages()
	{
		float totalUnit1 = (float)0;
		float totalUnit2 = (float)0;
		for(Student students: studentList)
		{
			totalUnit1+=students.mark1;
			totalUnit2+=students.mark2;
		}
		aveMark1 = totalUnit1/(float)classSize;
		aveMark2 = totalUnit2/(float)classSize;
		aveUnitMark = (aveMark1 + aveMark2)/(float)2;
		
		return aveUnitMark;
	}
}
