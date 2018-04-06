package com.example.alex.collectionsandmap;

public abstract class BasePresenterDima <T extends BaseView> implements PresenterDima<T> {

    private T mMvpView;

   @Override
   public void attachView(T mvpView) {
       mMvpView = mvpView;
   }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    protected T getMvpView() {
        return mMvpView;
    }

}
