import java.io.Serializable;

/**
 * Created by Pritam Sangani on 17/02/2018.
 */

public class Cheese implements Serializable {
    private String name;
    private String details;

    public Cheese(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
