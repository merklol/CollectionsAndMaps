package com.bilingoal.collectionsandmaps.fragments;

import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.utils.AsyncOperations;
import java.util.*;

public class MapsFragment extends BasicFragment {
    private int spanCount;

    public void setSpanCount(int spanCount) {
        this.spanCount = spanCount;
    }

    @Override
    public int getSpanCount() {
        return this.spanCount;
    }

    @Override
    public List<GridViewItem> populate(int progressBarVisibility) {
        List<GridViewItem> gridViewItems = new ArrayList<>();
        String time = getString(R.string.time);
        gridViewItems.add(new GridViewItem(getString(R.string.add_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_tree_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_tree_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_tree_map), time, progressBarVisibility));
        return gridViewItems;
    }

    @Override
    public void onStartCalculationBtnClicked(int elements) {
        new AsyncOperations.AsyncMapOperations(getView(), adapter, elements).execute();
    }
}