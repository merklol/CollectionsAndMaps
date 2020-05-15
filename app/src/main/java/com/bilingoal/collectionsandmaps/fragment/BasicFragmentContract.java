package com.bilingoal.collectionsandmaps.fragment;

import com.bilingoal.collectionsandmaps.base.BaseContract;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;

import java.util.List;

public class BasicFragmentContract {
    public interface Presenter<T extends View> extends BaseContract.Presenter<T>{
        int getSpanCount();
        List<GridViewItem> getInitialResult(boolean progressBarVisibility);
        void startCalculation(String elements);
    }

    public interface View extends BaseContract.View{
        void setError(String error);
        void addInitialValues(List<GridViewItem> items);
        void updateAdapterItem(int position, String value);
        void displaySnackBar();
    }
}