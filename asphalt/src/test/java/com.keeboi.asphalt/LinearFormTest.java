package com.keeboi.asphalt;

import android.content.Context;

import com.keeboi.asphalt.view.LinearForm;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by kdeloria on 7/6/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class LinearFormTest {

    @Mock
    Context context;

    LinearForm<User> linearForm;

    @Before
    public void setup() {
        linearForm = new LinearForm<User>(context);
    }

    @Test
    public void testConstructor() {
        System.out.println("testConstructor");
        Assert.assertNotNull(linearForm);
    }

}
