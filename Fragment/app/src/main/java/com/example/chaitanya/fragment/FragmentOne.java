package com.example.chaitanya.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chaitanya on 12-Jul-17.
 */

public class FragmentOne extends Fragment {
    TextView t1;
    public FragmentOne(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.fragment_one_layout,container, false);
    }

}