package com.mintedtech.deviceidlookup;

import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.snackbar.Snackbar;
import com.mintedtech.deviceidlookup.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding binding;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);

        binding = ActivityMainBinding.inflate (getLayoutInflater ());
        setContentView (binding.getRoot ());

        setSupportActionBar (binding.toolbar);

        String deviceID = Settings.Secure.getString(this.getContentResolver(),
                                                    Settings.Secure.ANDROID_ID);
        binding.contentMain.etDeviceId.setText (deviceID);

        binding.fab.setOnClickListener (view ->
                                                Snackbar.make (view,
                                                               "The Device ID is shown above.",
                                                               Snackbar.LENGTH_LONG).show ());
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate (R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            Snackbar.make (binding.getRoot (), getString (R.string.about_body),
                           Snackbar.LENGTH_INDEFINITE).show ();
            return true;
        }

        return super.onOptionsItemSelected (item);
    }

}