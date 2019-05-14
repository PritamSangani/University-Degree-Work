/**
 * Created by Pritam Sangani on 16/10/2017.
 */
public class Person implements Comparable {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + getFirstName() + " " + getLastName() + ", Age: " + getAge();
    }

    @Override
    public int compareTo(Object anotherPerson) throws ClassCastException {
        if (!(anotherPerson instanceof Person)){
            throw new ClassCastException("A Person object is expected");
        }
        int anotherPersonAge = ((Person)anotherPerson).getAge();

        return this.age - anotherPersonAge;
    }
}
