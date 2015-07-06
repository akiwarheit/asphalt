package com.keeboi.asphalt.core;

import android.view.View;

import com.keeboi.asphalt.annotation.Form;
import com.keeboi.asphalt.core.exception.UnableToInstantiateException;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by kdeloria on 7/3/2015.
 * <p/>
 * Main class in charge of reflection.
 */
public class Paver<K> {

    private Class<K> classType;

    private List<View> views;

    public Paver(Class<K> classType, List<View> views) {
        this.classType = classType;
        this.views = views;
    }

    /**
     * Check if the object passed is annotated with @Form
     *
     * @return true if annotated, false otherwise
     */
    public boolean isFormAnnotated() {
        Annotation annotation = classType.getAnnotation(Form.class);
        return annotation == null ? false : true;
    }

    /**
     * Instantiate the object
     *
     * @return the constructed object
     * @throws UnableToInstantiateException is thrown when there is no default public constructor
     */
    public K instantiate() throws UnableToInstantiateException {
        K object = null;

        try {
            object = classType.getConstructor().newInstance();
        } catch (InvocationTargetException e) {
            throw new UnableToInstantiateException(e);
        } catch (NoSuchMethodException e) {
            throw new UnableToInstantiateException(e);
        } catch (InstantiationException e) {
            throw new UnableToInstantiateException(e);
        } catch (IllegalAccessException e) {
            throw new UnableToInstantiateException(e);
        }

        return object;
    }
}
