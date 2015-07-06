package com.keeboi.asphalt.core;

import android.view.View;
import android.widget.EditText;

import com.keeboi.asphalt.annotation.Form;
import com.keeboi.asphalt.core.exception.UnableToInstantiateException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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
     * @throws UnableToInstantiateException if no default constructor or unable to resolve view - field matching
     */
    public K instantiate() throws UnableToInstantiateException, IllegalAccessException {
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

        for (int x = 0; x < views.size(); x += 1) {
            View view = views.get(x); // First View in this layout

            for (int y = x; y < fields.length; y += 1) {
                Field field = fields[y]; // Iterating over all the fields based on the current View index

                if (field.isAnnotationPresent(com.keeboi.asphalt.annotation.Field.class)) {
                    handle(object, view, field);
                    break;
                } else {
                    System.out.println("Non-annotated");
                    continue;
                }
            }
        }

        return object;
    }

    private void handle(K instance, View view, Field field) throws IllegalAccessException {
        if (view instanceof EditText && field.getType().equals(String.class)) {
            field.setAccessible(true);
            field.set(instance, ((EditText) view).getText().toString());
        }
    }
}
