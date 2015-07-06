package com.keeboi.asphalt.core.exception;

/**
 * Created by kdeloria on 7/6/2015.
 */
public class UnableToInstantiateException extends Exception {

    private Exception underlyingException;

    public UnableToInstantiateException(Exception underlyingException) {
        this.underlyingException = underlyingException;
    }

    public Exception getUnderlyingException() {
        return underlyingException;
    }

    @Override
    public String toString() {
        return "Underlying exception is  " + underlyingException.toString() + " " + super.toString();
    }
}
