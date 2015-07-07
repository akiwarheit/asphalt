package com.keeboi.asphalt.core.handler.basic;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.keeboi.asphalt.core.handler.Binder;

import java.lang.reflect.Field;

/**
 * Created by kdeloria on 7/6/2015.
 */
public class DefaultBinder<K> implements Binder<K> {

    @Override
    public void handle(K instance, View view, Field field) throws IllegalAccessException {
        if (view instanceof EditText && field.getType().equals(String.class)) {
            field.setAccessible(true);
            field.set(instance, ((EditText) view).getText().toString());
        } else if (view instanceof CheckBox && (field.getType().equals(boolean.class) || field.getType().equals(Boolean.class))) {
            field.setAccessible(true);
            field.set(instance, ((CheckBox) view).isChecked());
        }
    }
}
