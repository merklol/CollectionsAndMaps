package com.bilingoal.collectionsandmaps.fragment;

import com.bilingoal.collectionsandmaps.models.CollectionSupplier;
import com.bilingoal.collectionsandmaps.models.CollectionsCalculator;
import com.bilingoal.collectionsandmaps.models.MapSupplier;
import com.bilingoal.collectionsandmaps.models.MapsCalculator;
import com.bilingoal.collectionsandmaps.utils.Constants;

public class BasicFragmentInjector {
    public BasicFragmentPresenter createPresenter(String type) {
        if(type.equals(Constants.FRAGMENT_COLLECTIONS)){
            return new BasicFragmentPresenter(new CollectionSupplier(), new CollectionsCalculator());
        } else {
            return new BasicFragmentPresenter(new MapSupplier(), new MapsCalculator());
        }
    }
}