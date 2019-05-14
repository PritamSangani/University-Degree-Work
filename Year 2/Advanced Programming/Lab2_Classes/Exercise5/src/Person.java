/**
 * Created by Pritam Sangani on 03/10/2017.
 */
public class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public static Person newInstance(Person person) {
        return new Person(person.getName(), person.getAge());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name = "+this.getName()+" Age = "+this.getAge();
    }


}
