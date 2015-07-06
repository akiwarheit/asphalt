package com.keeboi.asphalt;

import android.content.Context;

import com.keeboi.asphalt.core.Paver;
import com.keeboi.asphalt.core.exception.UnableToInstantiateException;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by kdeloria on 7/3/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class PaverTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testPaverWithFormAnnotation() {
        System.out.println("testPaverWithFormAnnotation");
        Paver<User> paver = new Paver<User>(User.class, null);
        Assert.assertTrue(paver.isFormAnnotated());
    }

    @Test
    public void testPaverWithoutFormAnnotation() {
        System.out.println("testPaverWithoutFormAnnotation");
        Paver<UserNonForm> paver = new Paver<UserNonForm>(UserNonForm.class, null);
        Assert.assertFalse(paver.isFormAnnotated());
    }

    @Test
    public void testPaverObjectInstantiation() throws UnableToInstantiateException {
        System.out.println("testPaverObjectInstantiation");
        Paver<User> paver = new Paver<User>(User.class, null);
        User user = paver.instantiate();
        Assert.assertNotNull(user);
    }

    @Test
    public void testPaverObjectInstantiationWithException() throws UnableToInstantiateException {
        thrown.expect(UnableToInstantiateException.class);
        System.out.println("testPaverObjectInstantiationWithException");
        Paver<UserNonForm> paver = new Paver<UserNonForm>(UserNonForm.class, null);
        UserNonForm userNonForm = paver.instantiate();
    }

}
