package com.keeboi.asphalt.core.handler.basic;

import android.view.View;

import com.keeboi.asphalt.core.handler.Matcher;
import com.keeboi.asphalt.core.handler.Binder;

import java.lang.reflect.Field;
import java.util.List;


/**
 * Created by kdeloria on 7/6/2015.
 */
public class DefaultMatcher<K> implements Matcher<K> {

    @Override
    public void bind(K object, List<View> views, Field[] fields, Binder<K> binder) {
        for (int x = 0; x < views.size(); x += 1) {
            View view = views.get(x); // First View in this layout

            for (int y = x; y < fields.length; y += 1) {
                Field field = fields[y]; // Iterating over all the fields based on the current View index
                if (field.isAnnotationPresent(com.keeboi.asphalt.annotation.Field.class)) {
                    try {
                        binder.handle(object, view, field);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    continue;
                }
            }
        }
    }


}
