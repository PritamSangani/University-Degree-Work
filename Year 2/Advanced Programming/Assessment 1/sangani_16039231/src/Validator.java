import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  @author Pritam Sangani (16039231)
 *  Acts as a validator to check that information entered into the database is in a valid format prior to inserting a Student into the database.
 */
public class Validator {

    /**
     * Validates name to ensure that it only contains letters and one space.
     * @param name name of Student
     * @return a boolean value stating whether the name of the Student matches the regex format.
     */
    public Boolean validateName(String name) {
        Pattern p;
        Matcher m;
        final String pattern = "[A-Z^0-9]{1,}\\s[A-Z]{1,}";

        p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        m = p.matcher(name);

        if (m.matches() == false) {
            System.out.println("The name you are entering is in the wrong format. It can only contain letters and only one space.");
        }
        return m.matches();
    }

    /**
     * Validates gender to ensure that it only contains the letters M or F
     * @param gender gender of Student
     * @return a boolean value stating whether the name of the Student matches the regex format.
     */
    public Boolean validateGender(String gender) {
        Pattern p;
        Matcher m;
        final String pattern = "[FM]";

        p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        m = p.matcher(gender);

        if (m.matches() == false) {
            System.out.println("The gender you are entering is in the wrong format. It can only contain the following letters: M, F, m, f.");
        }
        return m.matches();
    }

    /**
     * Validates email address to ensure that it is in a valid email address format.
     * @param email email address of Student
     * @return a boolean value stating whether the name of the Student matches the regex format.
     */
    public Boolean validateEmail(String email) {
        Pattern p;
        Matcher m;
        final String pattern = "[A-Z]{1,}[.]?[A-Z]{1,}[@][A-Z]{1,}[.][A-Z]{2,}";

        p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        m = p.matcher(email);

        if (m.matches() == false) {
            System.out.println("The email address you are entering is in the wrong format. Please check the format before entering an email address again");
        }
        return m.matches();
    }

    /**
     * Validates postcode of Student to ensure that it is in a Valid UK Postcode format
     * @param postcode postcode of Student
     * @return a boolean value stating whether the name of the Student matches the regex format.
     */
    public Boolean validatePostcode(String postcode) {
        Pattern p;
        Matcher m;
        final String pattern = "[A-Z^0-9]{1,2}[0-9]{1,2}\\s[0-9][A-Z][A-Z]";

        p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        m = p.matcher(postcode);

        if (m.matches() == false) {
            System.out.println("Postcode is in wrong format");
        }
        return m.matches();
    }

    /**
     * Validates the start date of the Student's course to ensure that it is in the MM-YYYY format.
     * @param startDate date the Student starts his/her course
     * @return a boolean value stating whether the name of the Student matches the regex format.
     */
    public Boolean validateStartDate(String startDate) {
        Pattern p;
        Matcher m;
        final String pattern = "[0-9]{2}[-][0-9]{4}";

        p = Pattern.compile(pattern);
        m = p.matcher(startDate);

        if (m.matches()) {
            return true;
        } else {
            System.out.println("The date you have entered is in the wrong format. Ensure that it is in the following format: MM-YYYY.");
            return false;
        }
    }

    /**
     * Validates the title of the Student's course to ensure that it only contains letters and spaces.
     * @param courseTitle the title of the Student's course
     * @return a boolean value stating whether the name of the Student matches the regex format.
     */
    public Boolean validateCourseTitle(String courseTitle) {
        Pattern p;
        Matcher m;
        final String pattern = "[A-Z\\s]{0,}";

        p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        m = p.matcher(courseTitle);

        if (m.matches()) {
            return true;
        } else {
            System.out.println("The course title that you have entered is in the wrong format. Ensure that the title only contains letters");
            return false;
        }
    }

    /**
     * Validates the bursary amount to ensure that it is a float value with a maximum of 2 decimal places
     * @param bursary the amount of bursary the Student receives
     * @return a boolean value stating whether the name of the Student matches the regex format.
     */
    public Boolean validateBursary(String bursary) {
        Pattern p;
        Matcher m;
        final String pattern = "[0-9]{1,}[.][0-9]{1,}";

        p = Pattern.compile(pattern);
        m = p.matcher(bursary);

        if (m.matches()) {
            return true;
        } else {
            System.out.println("The bursary amount you have entered is in the wrong format. Ensure that it has a decimal point in it.");
            return false;
        }
    }
}
