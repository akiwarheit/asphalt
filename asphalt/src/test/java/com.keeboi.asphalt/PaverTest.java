package com.keeboi.asphalt;

import com.keeboi.asphalt.core.Paver;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by kdeloria on 7/3/2015.
 */
public class PaverTest {

    @Test
    public void testPaverWithFormAnnotation() {
        System.out.println("testPaverWithFormAnnotation");
        Paver<User> paver = new Paver<User>(User.class);
        Assert.assertTrue(paver.isFormAnnotated());
    }

    @Test
    public void testPaverWithoutFormAnnotation() {
        System.out.println("testPaverWithoutFormAnnotation");
        Paver<UserNonForm> paver = new Paver<UserNonForm>(UserNonForm.class);
        Assert.assertFalse(paver.isFormAnnotated());
    }

}
