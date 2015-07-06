import com.keeboi.asphalt.view.LinearForm;
import com.keeboi.test.BuildConfig;
import com.keeboi.test.MainActivity;
import com.keeboi.test.Person;
import com.keeboi.test.R;

import junit.framework.Assert;

import org.junit.Test;
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

    @Test
    public void testActivity() {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        LinearForm<Person> userLinearForm = (LinearForm<Person>) mainActivity.findViewById(R.id.linear_form);
        Assert.assertNotNull(userLinearForm);
    }

}
