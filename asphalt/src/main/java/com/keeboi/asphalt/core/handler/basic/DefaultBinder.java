package com.keeboi.asphalt.core.handler.basic;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.keeboi.asphalt.core.handler.Binder;

import java.lang.reflect.Field;

/**
 * Created by kdeloria on 7/6/2015.
 */
public class DefaultBinder<K> implements Binder<K> {

    @Override
    public void handle(K instance, View view, Field field) throws IllegalAccessException {
        if (view instanceof EditText && field.getType().equals(String.class)) {
            Log.i("binding", "EditText - String");
            // EdiText to String
            field.setAccessible(true);
            field.set(instance, ((EditText) view).getText().toString());
        } else if (view instanceof CheckBox && (field.getType().equals(boolean.class) || field.getType().equals(Boolean.class))) {
            Log.i("binding", "CheckBox - Boolean");
            // CheckBox to boolean values
            field.setAccessible(true);
            field.set(instance, ((CheckBox) view).isChecked());
        } else if (view instanceof Spinner && field.getType().isEnum()) {
            Log.i("binding", "Spiner - enum");
            // Basic binding of Spinner to an enum based on the selected child's position
            field.setAccessible(true);
            Spinner spinner = (Spinner) view;
            field.set(instance, ((Class<Enum>) field.getType()).getEnumConstants()[spinner.getSelectedItemPosition()]);
        } else if (view instanceof RadioGroup && field.getType().isEnum()) {
            Log.i("binding", "RadioGroup - enum");
            // Basic binding of RadioGroup to an enum based on the selected child's position
            RadioGroup radioGroup = (RadioGroup) view;
            if (radioGroup.getCheckedRadioButtonId() != -1) {
                field.setAccessible(true);
                int index = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
                field.set(instance, ((Class<Enum>) field.getType()).getEnumConstants()[index]);
            } else {
                Log.i("binding", "RadioGroup no selection");
            }
        }
    }
}
