/**
 * Created by Pritam Sangani on 10/10/2017.
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends Person{
    private String department;
    private double salary;
    private Date startDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy");

    Employee(){

    }

    Employee(String name, String address, int phoneNumber, String emailAddress){
        super(name, address, phoneNumber, emailAddress);
    }

    Employee(String department, double salary, Date startDate) {
        this.department = department;
        this.salary = salary;
        this.startDate = startDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
