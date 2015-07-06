package com.keeboi.asphalt.core;

import android.view.View;

import com.keeboi.asphalt.annotation.Form;
import com.keeboi.asphalt.core.exception.UnableToInstantiateException;
import com.keeboi.asphalt.core.handler.Binder;
import com.keeboi.asphalt.core.handler.Matcher;
import com.keeboi.asphalt.core.handler.basic.DefaultBinder;
import com.keeboi.asphalt.core.handler.basic.DefaultMatcher;

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

    Matcher<K> matcher;

    Binder<K> binder;

    public Paver(Class<K> classType, List<View> views) {
        this.classType = classType;
        this.views = views;
        this.matcher = new DefaultMatcher<K>();
        this.binder = new DefaultBinder<K>();
    }

    public Paver(Class<K> classType, List<View> views, Matcher<K> matcher, Binder<K> binder) {
        this.classType = classType;
        this.views = views;
        this.matcher = matcher;
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
        binder.bind(object, views, fields, matcher);

        return object;
    }

}
