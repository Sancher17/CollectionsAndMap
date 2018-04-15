package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.BasePresenter;
import com.example.alex.collectionsandmap.BaseView;

public interface CollectionsContract {

    interface View extends BaseView{

        void showErrorEmptyNumber();

        void attachPresenter();
    }

    interface Presenter extends BasePresenter{

        void attachView(View view);

        void detachView();


    }

}
