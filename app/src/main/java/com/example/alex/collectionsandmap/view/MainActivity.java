package com.example.alex.collectionsandmap.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.adapter.PagerAdapter;
import com.example.alex.collectionsandmap.utils.Logger;

public class MainActivity extends AppCompatActivity {

    private static Logger LOGGER = new Logger(MainActivity.class);

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.pager)
    ViewPager viewPager;

    @BindView(R.id.button_calculate)
    Button buttonCalculate;

    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_2));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        adapter = new PagerAdapter (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        /**As you can see that, above we have used the Android Toolbar instead of action bar and tabs are further added in the TabLayout through code with text. Then you can see that ViewPager is attached with an adapter using the ViewPager.setAdapter(adapter) method. Next Android ViewPager is attached to a page change listener of TabLayout by using the method ViewPager.addOnPageChangeListener. Further the Android TabLayout is attached to a tab selected listener using the TabLayout.setOnTabSelectedListener method, in which ViewPager’s page is set when a tab is selected.*/

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toolbar.setTitle(tab.getText());
                LOGGER.log("onTabSelected // setTitle " + tab.getText());
                viewPager.setCurrentItem(tab.getPosition());
                LOGGER.log("onTabSelected // getPosition " + String.valueOf(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                LOGGER.log("onTabUnselected // getPosition " + String.valueOf(tab.getPosition()) );
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                LOGGER.log("onTabReselected");
            }
        });

    }

    @OnClick(R.id.button_calculate)
    void onSaveClick() {
        Toast.makeText(this, "Hi", Toast.LENGTH_LONG).show();
    }
}