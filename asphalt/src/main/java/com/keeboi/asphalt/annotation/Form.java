package com.keeboi.asphalt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by kdeloria on 7/3/2015.
 * <p/>
 * Annotation to mark a particular field that gets parsed
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface Form {
}
