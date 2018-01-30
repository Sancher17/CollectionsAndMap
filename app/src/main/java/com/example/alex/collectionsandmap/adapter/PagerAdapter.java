package com.example.alex.collectionsandmap.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.alex.collectionsandmap.view.FragmentTab1;
import com.example.alex.collectionsandmap.view.FragmentTab2;


public class PagerAdapter extends FragmentStatePagerAdapter {

    int numOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentTab1 tab1 = new FragmentTab1();
                return tab1;
            case 1:
                FragmentTab2 tab2 = new FragmentTab2();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
