package com.myapp.pahtan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

public class PaHtanSummaryListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pahtan_summary_list);
        mRecyclerView=(RecyclerView)findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<String> myDataset = new ArrayList<String>();
        myDataset.add(" ဟေတု ပစ္စယော");
        myDataset.add(" အရမ္မဏ ပစ္စယော");
        myDataset.add(" အဓိပတိ ပစ္စယော");
        myDataset.add(" အနန္တရ ပစ္စယော");
        myDataset.add(" သမနန္တရ ပစ္စယော");
        myDataset.add(" သဟဇာတ ပစ္စယော");
        myDataset.add(" အညမည ပစ္စယော");
        myDataset.add(" နိဿယ ပစ္စယော");
        myDataset.add(" ဥပနိဿယ ပစ္စယော");
        myDataset.add(" ပုရေဇာတ ပစ္စယော");
        myDataset.add(" ပစ္ဆာဇာတ ပစ္စယော");
        myDataset.add(" အာသေဝန ပစ္စယော");
        myDataset.add(" ကမ္မ ပစ္စယော");
        myDataset.add(" ဝိပါက ပစ္စယော");
        myDataset.add(" အာဟာရ ပစ္စယော");
        myDataset.add(" ဣန္ဒြိယ ပစ္စယော");
        myDataset.add(" စျာန ပစ္စယော");
        myDataset.add(" မဂ္ဂ ပစ္စယော");
        myDataset.add(" သမ္ပယုတ္တ ပစ္စယော");
        myDataset.add(" ဝိပ္ပယုတ္တ ပစ္စယော");
        myDataset.add(" အတ္ထိ ပစ္စယော");
        myDataset.add(" နတ္ထိ ပစ္စယော");
        myDataset.add(" ဝိဂတ ပစ္စယော");
        myDataset.add(" အဝိဂတ ပစ္စယောတိ");
        String [] number ={"၁","၂","၃","၄","၅","၆","၇","၈","၉","၁၀","၁၁","၁၂","၁၃","၁၄","၁၅","၁၆","၁၇","၁၈","၁၉","၂၀","၂၁","၂၂","၂၃","၂၄"};
        mAdapter = new MyAdapter(myDataset,number,this.getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
        Toolbar toolbar = (Toolbar)findViewById(R.id.list_toolbar);
        CustomTextView summaryTitle = (CustomTextView)findViewById(R.id.summaryTitle);
        String summaryNameString = getResources().getString(R.string.summary_title);
        summaryTitle.setText(summaryNameString);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        /*ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }*/

//        getSupportActionBar().setHomeButtonEnabled(true);
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
