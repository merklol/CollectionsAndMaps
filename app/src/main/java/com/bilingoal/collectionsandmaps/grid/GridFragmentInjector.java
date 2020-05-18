package com.bilingoal.collectionsandmaps.grid;

import com.bilingoal.collectionsandmaps.models.CollectionSupplier;
import com.bilingoal.collectionsandmaps.models.CollectionsCalculator;
import com.bilingoal.collectionsandmaps.models.MapSupplier;
import com.bilingoal.collectionsandmaps.models.MapsCalculator;

public class GridFragmentInjector {
    public GridPresenter createPresenter(String type) {
        if(GridContract.COLLECTIONS.equals(type)){
            return new GridPresenter(new CollectionSupplier(), new CollectionsCalculator());
        } else {
            return new GridPresenter(new MapSupplier(), new MapsCalculator());
        }
    }
}