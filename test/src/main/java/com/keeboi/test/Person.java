package com.keeboi.test;

import com.keeboi.asphalt.annotation.Field;
import com.keeboi.asphalt.annotation.Form;

/**
 * Created by kdeloria on 7/6/2015.
 */
@Form
public class Person {

    @Field
    private String name;

    @Field
    private String occupation;

    @Field
    private Boolean married;

    @Field
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        AVAILABLE, BUSY, AWAY
    }
}
