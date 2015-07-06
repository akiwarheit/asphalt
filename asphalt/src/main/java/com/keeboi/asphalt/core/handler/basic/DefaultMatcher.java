package com.keeboi.asphalt.core.handler.basic;

import android.view.View;
import android.widget.EditText;

import com.keeboi.asphalt.core.handler.Matcher;

import java.lang.reflect.Field;

/**
 * Created by kdeloria on 7/6/2015.
 */
public class DefaultMatcher<K> implements Matcher<K> {

    @Override
    public void handle(K instance, View view, Field field) throws IllegalAccessException {
        if (view instanceof EditText && field.getType().equals(String.class)) {
            field.setAccessible(true);
            field.set(instance, ((EditText) view).getText().toString());
        }
    }
}
