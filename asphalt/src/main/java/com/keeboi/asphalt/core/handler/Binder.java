package com.keeboi.asphalt.core.handler;

import android.view.View;

/**
 * Created by kdeloria on 7/6/2015.
 */
public interface Binder<K extends View, J> {

    public void bind(K view, J field);

}
