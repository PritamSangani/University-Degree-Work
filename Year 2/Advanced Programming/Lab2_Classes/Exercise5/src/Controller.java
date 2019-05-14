/**
 * Created by Pritam Sangani on 03/10/2017.
 */
public class Controller {
    public static void main(String[] args) {
        Person p1 = new Person("John", 25);
        System.out.println("Person p1: "+p1);

        //Clone 1
        Person p1CopyOne = p1.newInstance(p1);
        p1CopyOne.setAge(35);
        System.out.println("Clone1 Person p1: "+p1CopyOne);

        //Clone 2
        Person p1CopyTwo = p1.newInstance(p1);
        p1CopyTwo.setAge(40);
        System.out.println("Clone2 Person p1: "+p1CopyTwo);
    }
}
