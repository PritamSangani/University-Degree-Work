import java.util.Random;

/**
 * Created by Pritam Sangani on 25/09/2018.
 */
public class Controller {
    public static void main(String[] args) {
        /* Ex. 1a - Hello World Program */
        System.out.println("Hello World!");

        System.out.println();

        /* Ex. 1b - FizzBuzz Problem (Numbers 1 to 200) */
        for (int i = 1; i <= 200; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        System.out.println();

        /* Ex. 2 - Grid of * 10 x 10 */
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        /* Ex. 3 - Triangle grid of * (10 in row 1 reducing by 1 for each row with row 10 containing 1) */
        for (int i = 10; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        /* Ex. 4a - Interface (Animal) that has method (speak()). Three Classes (Dog, Cat and Cow) that implements Interface. */
        Animal[] animals = new Animal[10];
        //fill array with random selection of Animals
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int num = r.nextInt(3) + 1;

            if (num == 1) animals[i] = new Cat();
            else if (num == 2) animals[i] = new Cow();
            else animals[i] = new Dog();
        }

        for (int i = 0; i < animals.length; i++) {
            System.out.println("Animal "+(i+1)+" goes "+animals[i].speak());
        }

        System.out.println();

        /* Ex. 4b - Reimplement Ex. 4 with abstract class adding an age property */
        Animal_One[] animal_one = new Animal_One[10];

        //fill array with random selection of Animals
        for (int i = 0; i < 10; i++) {
            Random a = new Random();
            int num = a.nextInt(3) + 1;

            if (num == 1) animal_one[i] = new Cat_One();
            else if (num == 2) animal_one[i] = new Cow_One();
            else animal_one[i] = new Dog_One();

            Random r = new Random();
            int anAge = r.nextInt(14) + 1;

            animal_one[i].age = anAge;
        }

        for (int i = 0; i < animal_one.length; i++) {
            System.out.println("Animal "+(i+1)+" is "+animal_one[i].age+" years old and goes "+animals[i].speak());
        }

        System.out.println();

        /* Ex. 4c - Difference between Interfaces and Classes */

        /*
        Interfaces - used when unrelated classes want to use the interface
        Classes - used when closely related classes want to make use of the code (methods, properties etc.) [e.g Human (Abstract Class)
        extended by Mother and Father classes]
         */

        System.out.println();

        /* Ex. 5 - Explain why following code outputs :
                ```
                    Inside methodA: value = 15
                    After MethodA: x = 10
                    Inside methodB: n.value = 16
                    After MethodB: y = 16
                ```
         */

        /*
        For MethodA: n is a local variable only available within the method. After the method is complete the value of the variable
            is out of scope.

        For MethodB: as y is a Number object the value is always within scope so both values (Before and after are the same)
         */
    }
}
