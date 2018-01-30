package com.example.alex.collectionsandmap.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.adapter.PagerAdapter;
import com.example.alex.collectionsandmap.presenter.Presenter;
import com.example.alex.collectionsandmap.utils.Logger;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    private static Logger LOGGER = new Logger(MainActivity.class);

    private Presenter presenter = new Presenter();

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.pager)
    ViewPager viewPager;

    @BindView(R.id.button_calculate)
    Button buttonCalculate;

    @BindView(R.id.editText_input)
    EditText input;

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
        LOGGER.log("onSaveClick");
        Presenter.INPUT_NUMBER = parseInt(input.getText().toString());
        LOGGER.log("onSaveClick / Presenter.INPUT_NUMBER " + Presenter.INPUT_NUMBER);
        presenter.inputData();
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null){
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}