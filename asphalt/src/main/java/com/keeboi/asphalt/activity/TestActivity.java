package com.keeboi.asphalt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.keeboi.asphalt.R;

/**
 * Created by kdeloria on 7/6/2015.
 */
public class TestActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.form_test_layout);
    }

}
