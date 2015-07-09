package com.keeboi.test;

import com.keeboi.asphalt.annotation.Field;
import com.keeboi.asphalt.annotation.Form;

/**
 * Created by kdeloria on 7/6/2015.
 */
@Form
public class Person {

    @Field(viewId = R.id.name)
    private String name;

    @Field(viewId = R.id.occupation)
    private String occupation;

    @Field(viewId = R.id.married)
    private Boolean married;

    @Field(viewId = R.id.spinner)
    private Status status;

    @Field(viewId = R.id.radio_group)
    private Gender gender;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public enum Status {
        AVAILABLE, BUSY, AWAY
    }

    public enum Gender {
        FEMALE, MALE
    }

}
