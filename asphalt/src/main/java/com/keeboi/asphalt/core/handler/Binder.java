package com.keeboi.asphalt.core.handler;

import android.view.View;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by kdeloria on 7/6/2015.
 */
public interface Binder<K> {

    public void bind(K object, List<View> views, Field[] fields, Matcher<K> matcher);

}
