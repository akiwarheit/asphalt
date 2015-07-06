package com.keeboi.asphalt;

/**
 * Created by kdeloria on 7/3/2015.
 */
public class UserNonForm {
    private String name;

    private String surname;

    public UserNonForm(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
