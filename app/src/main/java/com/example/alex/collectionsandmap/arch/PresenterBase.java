package com.example.alex.collectionsandmap.arch;


public abstract class PresenterBase <T extends MvpView >  implements  MvpPresenter <T>{

    private T view;

    @Override
    public void attachView(T mvpView) {
        view = mvpView;
    }

    @Override
    public void detachView() {
        view = null;
    }

    public T getView() {
        return view;
    }

}
