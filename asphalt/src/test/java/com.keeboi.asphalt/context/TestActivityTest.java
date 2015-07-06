package com.keeboi.asphalt.context;

import com.keeboi.asphalt.BuildConfig;
import com.keeboi.asphalt.activity.TestActivity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by kdeloria on 7/6/2015.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class TestActivityTest {

    TestActivity testActivity;

    @Before
    public void setup() {
        testActivity = Robolectric.setupActivity(TestActivity.class);
    }

    @Test
    public void activity() {
        Assert.assertNotNull(testActivity);
    }

}
