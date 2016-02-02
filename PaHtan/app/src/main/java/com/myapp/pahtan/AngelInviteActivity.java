package com.myapp.pahtan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class AngelInviteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angel_invite);
        CustomTextView customTextView = (CustomTextView)findViewById(R.id.inviteTextView);
        String inviteString = getResources().getString(R.string.angel_invite_string);
        customTextView.setText(inviteString);
        String inviteName = getResources().getString(R.string.invite_title);
        CustomTextView title = (CustomTextView)findViewById(R.id.inviteTitle);
        title.setText(inviteName);
        Toolbar toolbar = (Toolbar) findViewById(R.id.invite_toolbar);
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
