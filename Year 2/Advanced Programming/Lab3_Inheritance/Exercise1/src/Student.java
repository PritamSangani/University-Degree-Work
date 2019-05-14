/**
 * Created by Pritam Sangani on 09/10/2017.
 */
public class Student {
    private String name;
    private int stuNumber;

    Student(String name, int stuNumber) {
        this.name = name;
        setStuNumber(stuNumber);
    }

    public int getStuNumber() {
        return stuNumber;
    }

    public String getName() {
        return name;
    }

    public void setStuNumber(int stuNumber) {
        if (stuNumber >= 1 && stuNumber <= 10000) {
            this.stuNumber = stuNumber;
        }
        else {
            System.out.println(" " + getName() + ": Please choose a Student Number between 1 and 10000. ");
        }
    }
}
