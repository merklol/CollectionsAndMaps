package com.bilingoal.collectionsandmaps.fragments;

import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.utils.AsyncOperations;

import java.util.ArrayList;
import java.util.List;

public class CollectionsFragment extends BasicFragment {

    @Override
    public int getSpanCount() {
        return 3;
    }

    @Override
    public List<GridViewItem> populate(boolean progressBarVisibility) {
        List<GridViewItem> gridViewItems = new ArrayList<>();
        String time = getString(R.string.time);
        gridViewItems.add(new GridViewItem(getString(R.string.add_beginning_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_beginning_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_beginning_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_middle_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_middle_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_middle_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_end_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_end_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_end_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_beginning_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_beginning_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_beginning_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_middle_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_middle_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_middle_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_end_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_end_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_end_cow_list), time, progressBarVisibility));

        return gridViewItems;
    }

    @Override
    public void onStartCalculationBtnClicked(int elements) {
        new AsyncOperations.AsyncListOperations(getView(), adapter, elements).execute();
    }
}