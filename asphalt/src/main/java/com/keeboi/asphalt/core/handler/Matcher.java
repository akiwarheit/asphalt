package com.keeboi.asphalt.core.handler;

import android.view.View;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by kdeloria on 7/6/2015.
 */
public interface Matcher<K> {

    public void bind(K object, List<View> views, Field[] fields, Binder<K> binder);

}
