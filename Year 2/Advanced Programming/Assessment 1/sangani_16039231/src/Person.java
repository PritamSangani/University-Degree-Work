/**
 * @author Pritam Sangani (16039231)
 *
 */
public class Person {

    private String name;
    private String gender;
    private String dob;
    private String address;
    private String postcode;

    /**
     * <b>Constructs and initiates a new instance of a Person</b>
     * @param name name of Person
     * @param gender gender of Person
     * @param dob date of birth of Person
     * @param address address of Person
     * @param postcode postcode of Person
     */
    Person(String name, String gender, String dob, String address, String postcode) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.postcode = postcode;
    }

    /**
     * Getter to get name of Person
     * @return name of Person
     */
    public String getName() {
        return name;
    }

    /**
     * Getter to get the gender of Person
     * @return gender of Person
     */
    public String getGender() {
        return gender;
    }

    /**
     * Getter to get Date of Birth of Person
     * @return date of birth of Person
     */
    public String getDob() {
        return dob;
    }

    /**
     * Getter to get address of Person
     * @return address of Person
     */
    public String getAddress() {
        return address;
    }

    /**
     * Getter to get postcode of Person
     * @return postcode of Person
     */
    public String getPostcode() {
        return postcode;
    }

}
