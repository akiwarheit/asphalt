import com.keeboi.asphalt.core.exception.NoFormAnnotationException;
import com.keeboi.asphalt.core.exception.UnableToInstantiateException;
import com.keeboi.asphalt.view.LinearForm;
import com.keeboi.test.BuildConfig;
import com.keeboi.test.MainActivity;
import com.keeboi.test.Person;
import com.keeboi.test.R;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by kdeloria on 7/6/2015.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 18)
public class MainActivityTest {

    MainActivity mainActivity;

    LinearForm<Person> userLinearForm;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        userLinearForm = (LinearForm<Person>) mainActivity.findViewById(R.id.linear_form);
    }

    @Test
    public void testForm() {
        System.out.println("testForm");
        Assert.assertNotNull(userLinearForm);
    }

    @Test
    public void testBind() throws UnableToInstantiateException, NoFormAnnotationException, IllegalAccessException {
        System.out.println("testBind");
        Person person = null;
        userLinearForm.bind(Person.class);
        person = userLinearForm.getObject();
        Assert.assertNotNull(person);

        Assert.assertEquals(person.getName(), "Kevin Jude Deloria");
        Assert.assertEquals(person.getOccupation(), "Programmer");
        Assert.assertEquals(person.getMarried(), Boolean.TRUE);
        System.out.println(person.getStatus());
        Assert.assertNotNull(person.getStatus());

    }

}
