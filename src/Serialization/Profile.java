package Serialization;

import java.io.Serializable;

public class Profile implements Serializable {
    private String name ,suretname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuretname() {
        return suretname;
    }

    public void setSuretname(String suretname) {
        this.suretname = suretname;
    }
}
