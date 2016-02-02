package com.myapp.pahtan;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        CustomTextView detailTitle = (CustomTextView)findViewById(R.id.detailTitle);
        String detailNameString = getResources().getString(R.string.detail_title);
        detailTitle.setText(detailNameString);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

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
    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return new FragmentOne();
                case 1: return new FragmentTwo();
                case 2: return new FragmentThree();
                case 3: return new FragmentFour();
                case 4: return new FragmentFive();
                case 5: return new FragmentSix();
                case 6: return new FragmentSeven();
                case 7: return new FragmentEight();
                case 8: return new FragmentNine();
                case 9: return new FragmentTen();
                case 10: return new FragmentEleven();
                case 11: return new FragmentTwelve();
                case 12: return new FragmentThirdTeen();
                case 13: return new FragmentFourTeen();
                case 14: return new FragmentFifthTeen();
                case 15: return new FragmentSixTeen();
                case 16: return new FragmentSevenTeen();
                case 17: return new FragmentEightTeen();
                case 18: return new FragmentNineTeen();
                case 19: return new FragmentTwenty();
                case 20: return new FragmentTwentyOne();
                case 21: return new FragmentTwentyTwo();
                case 22: return new FragmentTwentyThree();
                case 23: return new FragmentTwentyFour();
                default:return new FragmentOne();
            }
        }

        @Override
        public int getCount() {
            return 24;
        }
    }

}
