package com.example.alex.collectionsandmap.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alex.collectionsandmap.R;


public class FragmentTab1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        GridLayout grid = new GridLayout(3, 3, 10, 10);
//https://www.journaldev.com/13792/android-gridlayoutmanager-example

        return inflater.inflate(R.layout.fragment_tab1, container, false);
    }

}
