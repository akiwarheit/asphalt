package com.keeboi.asphalt.core;

import com.keeboi.asphalt.annotation.Form;

import java.lang.annotation.Annotation;

/**
 * Created by kdeloria on 7/3/2015.
 *
 * Main class in charge of reflection.
 */
public class Paver<K> {

    Class<K> classType;

    public Paver(Class<K> classType) {
        this.classType = classType;
    }

    public boolean isFormAnnotated() {
        Annotation annotation = classType.getAnnotation(Form.class);
        return annotation == null ? false : true;
    }

}
