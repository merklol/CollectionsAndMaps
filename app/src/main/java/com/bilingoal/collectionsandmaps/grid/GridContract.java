package com.bilingoal.collectionsandmaps.grid;

import com.bilingoal.collectionsandmaps.base.BaseContract;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.utils.UIHandler;

import java.util.List;

public class GridContract {
    public static final String COLLECTIONS = "collections";
    public static final String MAPS = "maps";

    public interface Presenter<T extends View> extends BaseContract.Presenter<T>{
        int getSpanCount();
        List<GridViewItem> getInitialResult(boolean progressBarVisibility);
        void startCalculation(String elements, UIHandler handler);
    }

    public interface View extends BaseContract.View{
        void setError(int resId);
        void setItems(List<GridViewItem> items);
        void updateAdapter(int position, String elapsedTime);
        void notifyItemUpdated(int position, String elapsedTime);
    }
}