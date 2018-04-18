package com.example.alex.collectionsandmap;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;

import com.example.alex.collectionsandmap.utils.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static Logger LOGGER = new Logger(MainActivity.class);

    String TAG = "life";

    public static int GET_POSITION_TAB = 0;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.pager)
    ViewPager viewPager;

    PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_2));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toolbar.setTitle(tab.getText());
                LOGGER.log("onTabSelected // Title: " + tab.getText());
                viewPager.setCurrentItem(tab.getPosition());
                GET_POSITION_TAB = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }



    // lifecycle
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: MainActivity" );
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: MainActivity ");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: MainActivity");

        // TODO: 16.04.2018 tried to resolve changing resourses
        if (viewPager != null) {
            ViewGroup parent = (ViewGroup) viewPager.getParent();
            if (parent != null) {
                parent.removeAllViews();
            }
        }
    }

   
    @Override
    public void onStart() {
        Log.d(TAG, "onStart: MainActivity");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop: MainActivity");
        super.onStop();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.d(TAG, "onAttachFragment: MainActivity");
    }
}