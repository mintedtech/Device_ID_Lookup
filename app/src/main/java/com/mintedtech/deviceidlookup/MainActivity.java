package com.mintedtech.deviceidlookup;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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

        setContentView ();

        setSupportActionBar (binding.toolbar);

        binding.fab.setOnClickListener (view -> copyToClipboard ());

        outputDeviceID ();
    }

    private void setContentView ()
    {
        binding = ActivityMainBinding.inflate (getLayoutInflater ());
        setContentView (binding.getRoot ());
    }

    private void outputDeviceID ()
    {
        String deviceID = Settings.Secure.getString(this.getContentResolver(),
                                                    Settings.Secure.ANDROID_ID);
        binding.contentMain.tvDeviceId.setText (deviceID);
    }

    private void copyToClipboard()
    {
        String deviceId = binding.contentMain.tvDeviceId.getText ().toString ();
        ClipboardManager cm = (ClipboardManager)getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData cData = ClipData.newPlainText("Device ID", deviceId);
        cm.setPrimaryClip (cData);
        Toast.makeText(getApplicationContext(), "Copied the Device ID to the Clipboard", Toast.LENGTH_SHORT).show();
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