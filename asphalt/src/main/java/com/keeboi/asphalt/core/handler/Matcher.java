package com.keeboi.asphalt.core.handler;

import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by kdeloria on 7/6/2015.
 */
public interface Matcher<K> {

    public void handle(K instance, View view, Field field) throws IllegalAccessException;

}
