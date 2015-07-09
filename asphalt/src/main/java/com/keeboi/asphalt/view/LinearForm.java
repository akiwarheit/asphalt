package com.keeboi.asphalt.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.keeboi.asphalt.core.Paver;
import com.keeboi.asphalt.core.exception.UnableToInstantiateException;

/**
 * Created by kdeloria on 7/3/2015.
 */
public class LinearForm extends LinearLayout {

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

    public <K> K bind(Class<K> clazz) throws UnableToInstantiateException {
        Paver<K> paver = new Paver<K>(clazz, this);
        return paver.instantiate();
    }
}
