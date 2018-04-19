package com.example.alex.collectionsandmap.maps;

import com.example.alex.collectionsandmap.arch.MvpPresenter;
import com.example.alex.collectionsandmap.arch.MvpView;

public interface MapsContract {

    interface View extends MvpView{

        void onButtonClick();

        void showError();
    }

    interface Presenter extends MvpPresenter<View>{

        void doTask();

        void updateAdapterItem(int position);
    }

}
