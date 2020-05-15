package com.bilingoal.collectionsandmaps.base;

public class BaseContract {
    public interface Presenter<T extends View>{
        void attachView(T view);
        void detachView();
    }
    public interface View{}
}
