import java.util.Arrays;

/**
 * Created by Pritam Sangani on 16/10/2017.
 */
public class Controller {
    public static void main(String[] args) {
       Person[] people = new Person[5];

       people[0] = new Person("John", "Doe", 35);
       people[1] = new Person("Jane", "Doe", 40);
       people[2] = new Person("John", "Smith", 25);
       people[3] = new Person("Jack", "Jones", 20);
       people[4] = new Person("Jim", "Smith", 55);

        Arrays.sort(people);

       for (int i = 0; i < people.length; i++){
           System.out.println(people[i].toString());
       }
    }
}
