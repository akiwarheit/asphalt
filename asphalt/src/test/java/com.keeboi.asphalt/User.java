package com.keeboi.asphalt;

import com.keeboi.asphalt.annotation.Field;
import com.keeboi.asphalt.annotation.Form;

/**
 * Created by kdeloria on 7/3/2015.
 */
@Form
public class User {

    @Field
    private String name;

    @Field
    private String surname;

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
