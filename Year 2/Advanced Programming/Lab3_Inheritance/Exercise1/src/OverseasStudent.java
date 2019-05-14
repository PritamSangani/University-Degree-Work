/**
 * Created by Pritam Sangani on 09/10/2017.
 */
public class OverseasStudent extends Student{
    private String homeCountry;
    private String[] possibleCountries = {"Spain", "Nigeria", "France", "Germany"};

    OverseasStudent(String name,int stuNumber,String homeCountry) {
        super(name, stuNumber);
        setHomeCountry(homeCountry);
    }

    public String getHomeCountry() {
        return homeCountry;
    }

    public void setHomeCountry(String homeCountry) {
        boolean fromPossibleCountry = false;
        for(int i = 0; i < possibleCountries.length; i++) {
            if(possibleCountries[i].equals(homeCountry)) {
                this.homeCountry = homeCountry;
                fromPossibleCountry = true;
                break;
            }
        }
        if (fromPossibleCountry == false) {
            this.homeCountry = homeCountry;
            System.out.println(" " + super.getName() + ": Please check that student is from an eligible country.");
        }
    }
}
