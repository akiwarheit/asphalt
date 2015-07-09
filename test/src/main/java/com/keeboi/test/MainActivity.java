package com.keeboi.test;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.keeboi.asphalt.core.exception.UnableToInstantiateException;
import com.keeboi.asphalt.view.LinearForm;


public class MainActivity extends ActionBarActivity {

    LinearForm userLinearForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.status, android.R.layout.simple_spinner_item);
        ((Spinner) findViewById(R.id.spinner)).setAdapter(adapter);

        ((Spinner) findViewById(R.id.spinner)).setSelection(1); // Select the first element of the spinner (which should be BUSY)
        ((RadioGroup) findViewById(R.id.radio_group)).check(R.id.male); // Set this radio group to Male

        userLinearForm = (LinearForm) findViewById(R.id.linear_form);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_ok) {
            Person person = null;
            try {
                person = userLinearForm.bind(Person.class);

                System.out.println("" + person.getName());
                System.out.println("" + person.getOccupation());
                System.out.println("" + person.getMarried());
                System.out.println("" + person.getStatus());
                System.out.println("" + person.getGender());

            } catch (UnableToInstantiateException e) {
                Log.e("error", e.toString());
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
