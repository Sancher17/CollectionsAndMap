package com.example.alex.collectionsandmap.maps;

import com.example.alex.collectionsandmap.BasePresenter;
import com.example.alex.collectionsandmap.BaseView;

public interface MapsContract {

    interface View extends BaseView<Presenter>{

        void onButtonClick();

        void showError();
    }

    interface Presenter extends BasePresenter{

        void doTask();

        void updateAdapterItem(int position);
    }

}
