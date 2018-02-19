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

import com.example.alex.collectionsandmap.R;
import com.example.alex.collectionsandmap.adapters.PagerAdapter;
import com.example.alex.collectionsandmap.presenter.Presenter;
import com.example.alex.collectionsandmap.utils.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static Logger LOGGER = new Logger(MainActivity.class);
    private Presenter presenter = new Presenter();
    public static int GET_POSITION_TAB = 0;
    public static int INPUT_NUMBER;
    public PagerAdapter adapter;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LOGGER.log("MainActivity started");
        int cpu = Runtime.getRuntime().availableProcessors();
        LOGGER.log("CPU " + cpu);

        setSupportActionBar(toolbar);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_2));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toolbar.setTitle(tab.getText());
                LOGGER.log("onTabSelected // setTitle " + tab.getText());
                viewPager.setCurrentItem(tab.getPosition());
                LOGGER.log("onTabSelected // getPosition " + String.valueOf(tab.getPosition()));
                GET_POSITION_TAB = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                LOGGER.log("onTabUnselected // getPosition " + String.valueOf(tab.getPosition()));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                LOGGER.log("onTabReselected");
            }
        });
    }

    @OnClick(R.id.button_calculate)
    void onSaveClick() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
        String number = input.getText().toString();
        if (number.length() > 0 ) {
            INPUT_NUMBER = Integer.parseInt(number);
            presenter.calculate();
        }else {
            Toast.makeText(this, " Введите число", Toast.LENGTH_SHORT).show();
        }
        LOGGER.log("onSaveClick called // INPUT_NUMBER: " + INPUT_NUMBER );

    }
}