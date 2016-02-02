package com.myapp.pahtan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class AngelSendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angel_send);
        CustomTextView customTextView = (CustomTextView)findViewById(R.id.sendTextView);
        String sendString = getResources().getString(R.string.angel_send_string);
        customTextView.setText(sendString);
        String inviteName = getResources().getString(R.string.send_title);
        CustomTextView title = (CustomTextView)findViewById(R.id.sendTitle);
        title.setText(inviteName);
        Toolbar toolbar = (Toolbar) findViewById(R.id.send_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

