package com.bilingoal.collectionsandmaps.models;

import com.bilingoal.collectionsandmaps.App;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import java.util.ArrayList;
import java.util.List;

public class MapSupplier implements TaskSupplier {
    private int spanCount = 2;

    @Override
    public int getSpanCount() {
        return spanCount;
    }

    @Override
    public List<GridViewItem> getInitialResult(boolean progressBarVisibility) {
        List<GridViewItem> gridViewItems = new ArrayList<>();
        String time = App.getContext().getString(R.string.time);
        gridViewItems.add(new GridViewItem(App.getContext().getString(R.string.add_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(App.getContext().getString(R.string.add_tree_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(App.getContext().getString(R.string.search_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(App.getContext().getString(R.string.search_tree_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(App.getContext().getString(R.string.rm_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(App.getContext().getString(R.string.rm_tree_map), time, progressBarVisibility));
        return gridViewItems;
    }

}
