package com.bilingoal.collectionsandmaps.fragments;

import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.utils.AsyncOperations;

import java.util.*;

public class MapsFragment extends BasicFragment {

    public MapsFragment(int spanCount) {
        super(spanCount);
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
    public void onBtnClick() {
        new AsyncOperations.AsyncMapOperations(
                getView(), adapter, Integer.parseInt(inputView.getText().toString())
        ).execute();
    }
}
