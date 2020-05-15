package com.bilingoal.collectionsandmaps.models;

import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import java.util.List;

public interface TaskSupplier {
    int getSpanCount();
    List<GridViewItem> getInitialResult(boolean progressBarVisibility);
}
