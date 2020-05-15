package com.bilingoal.collectionsandmaps.models;

import com.bilingoal.collectionsandmaps.utils.CollectionsUtils;
import java.util.HashMap;
import java.util.TreeMap;

public class MapsCalculator extends BaseCalculator {
    private final HashMap<Integer, String> hashMap = new HashMap<>();
    private final TreeMap<Integer, String> treeMap = new TreeMap<>();

    private final Runnable calculationTask = () -> {
        sendMessage(CollectionsUtils.addItems(hashMap, elements));
        sendMessage(CollectionsUtils.addItems(treeMap, elements));
        sendMessage(CollectionsUtils.searchByKey(hashMap,hashMap.size() / 2));
        sendMessage(CollectionsUtils.searchByKey(treeMap,treeMap.size() / 2));
        sendMessage(CollectionsUtils.removeFromMap(treeMap,hashMap.size() / 2));
        sendMessage(CollectionsUtils.removeFromMap(treeMap,treeMap.size() / 2));
        onCompleteTask();
    };

    @Override
    protected Runnable getCalculationTask() {
        return calculationTask;
    }
}