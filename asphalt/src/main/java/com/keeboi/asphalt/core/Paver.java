package com.keeboi.asphalt.core;

import android.view.View;
import android.view.ViewGroup;

import com.keeboi.asphalt.annotation.Form;
import com.keeboi.asphalt.core.exception.UnableToInstantiateException;
import com.keeboi.asphalt.core.handler.Binder;
import com.keeboi.asphalt.core.handler.basic.DefaultBinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by kdeloria on 7/3/2015.
 * <p/>
 * Main class in charge of reflection.
 */
public class Paver<K> {

    private Class<K> classType;

    private ViewGroup viewGroup;

    private Binder<K> binder;

    public Paver(Class<K> classType, ViewGroup viewGroup) {
        this.classType = classType;
        this.viewGroup = viewGroup;
        this.binder = new DefaultBinder<K>();
    }

    public Paver(Class<K> classType, ViewGroup viewGroup, Binder<K> binder) {
        this.classType = classType;
        this.viewGroup = viewGroup;
        this.binder = binder;
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
     * @throws UnableToInstantiateException if no basic constructor or unable to resolve view - field matching
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

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(com.keeboi.asphalt.annotation.Field.class)) {
                continue;
            } else {
                com.keeboi.asphalt.annotation.Field annotation = field.getAnnotation(com.keeboi.asphalt.annotation.Field.class);
                View view = viewGroup.findViewById(annotation.viewId());

                try {
                    binder.handle(object, view, field);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return object;
    }

}
