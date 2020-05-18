package com.bilingoal.collectionsandmaps.models;

import android.content.Context;
import com.bilingoal.collectionsandmaps.App;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import java.util.ArrayList;
import java.util.List;

public class CollectionSupplier implements TaskSupplier {
    private int spanCount = 3;
    @Override
    public int getSpanCount() {
        return spanCount;
    }

    @Override
    public List<GridViewItem> getInitialResult(boolean progressBarVisibility) {
        List<GridViewItem> gridViewItems = new ArrayList<>();
        Context ctx = App.getContext();
        String time = ctx.getString(R.string.time);
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_beginning_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_beginning_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_beginning_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_middle_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_middle_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_middle_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_end_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_end_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_end_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.search_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.search_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.search_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_beginning_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_beginning_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_beginning_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_middle_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_middle_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_middle_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_end_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_end_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_end_cow_list), time, progressBarVisibility));
        return gridViewItems;
    }
}