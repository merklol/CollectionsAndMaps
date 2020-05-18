package com.bilingoal.collectionsandmaps.models;

import android.content.Context;
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
        Context ctx = App.getContext();
        String time = ctx.getString(R.string.time);
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.add_tree_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.search_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.search_tree_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(ctx.getString(R.string.rm_tree_map), time, progressBarVisibility));
        return gridViewItems;
    }

}
