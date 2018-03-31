package com.example.alex.collectionsandmap;


public interface BaseView <T>{

    void setPresenter(T presenter);

    void onStartCalculation();

    void onCalculationFinished();

    void onDataIsStillLoadingError();

    void updateAdapter();

}
