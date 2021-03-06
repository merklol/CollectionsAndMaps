package com.bilingoal.collectionsandmaps.base;

public class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter<T> {
    protected T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}