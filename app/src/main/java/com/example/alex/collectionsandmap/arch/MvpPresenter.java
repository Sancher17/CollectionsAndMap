package com.example.alex.collectionsandmap.arch;


public interface MvpPresenter <V extends MvpView>  {

    void attachView(V mvpView);

    void detachView();

}
