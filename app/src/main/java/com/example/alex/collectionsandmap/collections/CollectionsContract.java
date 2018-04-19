package com.example.alex.collectionsandmap.collections;

import com.example.alex.collectionsandmap.arch.MvpPresenter;
import com.example.alex.collectionsandmap.arch.MvpView;

public interface CollectionsContract {

    interface View extends MvpView {

        void showErrorEmptyNumber();

        void attachPresenter();

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

    interface Presenter extends MvpPresenter<View>{

        void attachView(View view);

        void detachView();

        void calculate();

        void stopСalculation();

        void calculationStopped();


    }

}
