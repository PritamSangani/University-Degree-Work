
public class Student {
	String name;
	int age = 19;
	float mark1, mark2;
	
	Student()
	{
		name = "";
		mark1 = (float)0.0;
		mark2 = (float)0.0;
	}
	
	Student(String name, int age, float mark1, float mark2)
	{
		this.name = name;
		this.age = age;
		this.mark1 = mark1;
		this.mark2 = mark2;
	}
	
	void displayConsole()
	{
		System.out.println("name: " + name + ", " +"age: " + age );
		System.out.println("mark1: " + mark1 + ", " + "mark2: " + mark2 );
	}
}
