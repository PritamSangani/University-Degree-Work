/**
 * Created by Pritam Sangani on 09/10/2017.
 */

public class Controller {
    public static void main(String[] args) {
        Student homeStud1 = new Student("Alan",1);
        System.out.println(homeStud1.getName() + " number " + homeStud1.getStuNumber());

        Student homeStud2 = new Student("Jenny",2);
        System.out.println(homeStud2.getName() + " number " + homeStud2.getStuNumber());

        Student homeStud3 = new Student("Jane",0);
        System.out.println(homeStud3.getName() + " number " + homeStud3.getStuNumber());

        Student homeStud4 = new Student("James",10001);
        System.out.println(homeStud4.getName() + " number " + homeStud4.getStuNumber());

        OverseasStudent overStud1 = new OverseasStudent("Pierre",1235,"France");
        System.out.print(overStud1.getName() + " number " + overStud1.getStuNumber() + " ");
        System.out.println("Country " + overStud1.getHomeCountry());

        OverseasStudent overStud2 = new OverseasStudent("Klaus",1234,"Germany");
        System.out.print(overStud2.getName() + " number " + overStud2.getStuNumber() + " ");
        System.out.println("Country " + overStud2.getHomeCountry());

        OverseasStudent overStud3 = new OverseasStudent("John",1236,"USA");
        System.out.print(overStud3.getName() + " number " + overStud3.getStuNumber() + " ");
        System.out.println("Country " + overStud3.getHomeCountry());
    }
}
