package com.myapp.pahtan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class HayTuActivity1 extends AppCompatActivity {
private CustomTextView myTextView;
    private boolean isTouch = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        myTextView = (CustomTextView) findViewById(R.id.txtView);
        myTextView.setText("ဟေတု ပစ္စယ\n" +
                "ဟေတူ ဟေတုသမ္ပယုတ္တကာနံ ဓမ္မာနံ\n" +
                "တံတမုဌာနာနဉ္စ ရူပါနံ\n" +
                "ဟေတုပစ္စယေနပစ္စယော");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        myTextView.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            public void onSwipeTop() {
                Toast.makeText(HayTuActivity1.this, "top", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRight() {

            }

            public void onSwipeLeft() {
                Intent i = new Intent(getApplicationContext(), AraMaNaActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(i);
            }

            public void onSwipeBottom() {
                Toast.makeText(HayTuActivity1.this, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, PaHtanSummaryListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
