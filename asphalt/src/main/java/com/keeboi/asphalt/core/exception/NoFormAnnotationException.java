package com.keeboi.asphalt.core.exception;

/**
 * Created by kdeloria on 7/6/2015.
 */
public class NoFormAnnotationException extends Exception {

    Class clazz;

    public NoFormAnnotationException(Class clazz) {
        this.clazz = clazz;
    }


    @Override
    public String toString() {
        return "Object " + clazz.getName() + " not annotated. " + super.toString();
    }
}
