package com.example.alex.collectionsandmap;

public interface BaseView {

    void showCalculationFinished();

    void showCalculationIsStillWorking();

    void updateAdapter();

    void updateItemAdapter(int position);

    void showProgressBar(int position);

    void hideProgressBar(int position);

    void showCalculationStarted();

    void showCalculationStopped();

    void stopAllProgressBars();

    void showWait();

    void showCalculationNotStarted();
}
