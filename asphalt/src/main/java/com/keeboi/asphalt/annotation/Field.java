package com.keeboi.asphalt.annotation;

import com.keeboi.asphalt.core.handler.Binder;
import com.keeboi.asphalt.core.handler.basic.DefaultBinder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by kdeloria on 7/3/2015.
 * <p/>
 * Annotation to mark a particular class that can be bound to a FormLayout
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface Field {
    int viewId();

    Class<? extends Binder> binder() default DefaultBinder.class;
}
