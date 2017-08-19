package data;

import java.io.Serializable;

public class User implements Serializable {

    private long day ;

    public void setDay(long day) {
        this.day = day;
    }

    public User() {
    }

    public long getDay() {
        return day;
    }

    public User(long day) {
        this.day = day;
    }

}
