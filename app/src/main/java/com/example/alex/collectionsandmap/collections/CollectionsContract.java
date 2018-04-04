package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.BasePresenter;
import com.example.alex.collectionsandmap.BaseView;

public interface CollectionsContract {

    interface View extends BaseView<Presenter>{

        void onButtonClick();

        void showError();
    }

    interface Presenter extends BasePresenter{

        void updateAdapterItem(int position);

        public void createData();
    }

}
