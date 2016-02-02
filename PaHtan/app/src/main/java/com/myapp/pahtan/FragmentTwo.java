package com.myapp.pahtan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 25-00058 on 2016/01/28.
 */
public class FragmentTwo extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_detail, container, false);

        TextView tv = (TextView) v.findViewById(R.id.txtView);
        String fragmentTwoString = getResources().getString(R.string.fragment_two_string);
        tv.setText(fragmentTwoString);

        return v;
    }
    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.app_name);
    }
    public static FragmentTwo newInstance(String text) {

        FragmentTwo f = new FragmentTwo();
        Bundle b = new Bundle();
        b.putString("msgggg", text);

        f.setArguments(b);

        return f;
    }
}
