package com.keeboi.asphalt.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by kdeloria on 7/3/2015.
 */
public class LinearForm<K> extends LinearLayout {

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
}
