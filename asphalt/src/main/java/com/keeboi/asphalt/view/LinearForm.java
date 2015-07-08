package com.keeboi.asphalt.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.keeboi.asphalt.core.Paver;
import com.keeboi.asphalt.core.exception.NoFormAnnotationException;
import com.keeboi.asphalt.core.exception.UnableToInstantiateException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kdeloria on 7/3/2015.
 */
public class LinearForm<K> extends LinearLayout {

    private Paver<K> paver;

    public LinearForm(Context context) {
        super(context);
    }

    public LinearForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LinearForm(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * Iterate over all the child views and assign it to the constructor of Paver
     *
     * @param clazz the output object
     * @throws NoFormAnnotationException throws if the class being passed does not have @Form annotation
     */
    public void bind(Class<K> clazz) throws NoFormAnnotationException {
        List<View> childViews = new ArrayList<View>();

        for (int x = 0; x < getChildCount(); x += 1) {
            childViews.add(getChildAt(x));
        }

        Collections.sort(childViews, new Comparator<View>() {
            @Override
            public int compare(View view, View t1) {
                if(view.getTop() == t1.getTop()) {
                    return 1;
                }

                return view.getTop() > t1.getTop() ? 1 : -1;
            }
        });

        paver = new Paver<K>(clazz, childViews);
        if (!paver.isFormAnnotated()) {
            throw new NoFormAnnotationException(clazz);
        }
    }

    /**
     * Get the instantiated object
     *
     * @return the instantiated object
     * @throws UnableToInstantiateException something went wrong with instantiation
     * @throws IllegalAccessException
     */
    public K getObject() throws UnableToInstantiateException, IllegalAccessException {
        K object = paver.instantiate();
        return object;
    }

}
