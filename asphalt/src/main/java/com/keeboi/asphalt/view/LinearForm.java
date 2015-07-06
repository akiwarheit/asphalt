package com.keeboi.asphalt.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.keeboi.asphalt.core.Paver;
import com.keeboi.asphalt.core.exception.NoFormAnnotationException;

import java.util.ArrayList;
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

    public void bind(Class<K> clazz) throws NoFormAnnotationException {
        if (paver.isFormAnnotated()) {
            throw new NoFormAnnotationException(clazz);
        }

        List<View> childViews = new ArrayList<View>();

        for (int x = 0; x < getChildCount(); x += 1) {
            childViews.add(getChildAt(0));
        }

        paver = new Paver<K>(clazz, childViews);
    }

}
