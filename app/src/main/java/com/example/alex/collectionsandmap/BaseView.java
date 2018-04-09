package com.example.alex.collectionsandmap;


import android.content.Context;

public interface BaseView {

    void onStartCalculation();

    void onCalculationFinished();

    void onDataIsStillLoadingError();

    void updateAdapter();

    void updateItemAdapter(int position);

    void showProgressBar(int position);

    void hideProgressBar(int position);

    void onCalculationStarted();

}
