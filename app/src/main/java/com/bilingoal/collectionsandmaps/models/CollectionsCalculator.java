package com.bilingoal.collectionsandmaps.models;

import com.bilingoal.collectionsandmaps.utils.CollectionsUtils;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsCalculator extends BaseCalculator {
    private final ArrayList<Integer> arrayList = new ArrayList<>();
    private final LinkedList<Integer> linkedList = new LinkedList<>();
    private final CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    private final Runnable calculationTask = () -> {
        sendMessage(CollectionsUtils.addItemsAtStart(arrayList, elements));
        sendMessage(CollectionsUtils.addItemsAtStart(linkedList, elements));
        sendMessage(CollectionsUtils.addItemsAtStart(copyOnWriteArrayList, elements));
        sendMessage(CollectionsUtils.addItemsWithin(arrayList, arrayList.size() / 2, elements));
        sendMessage(CollectionsUtils.addItemsWithin(linkedList, linkedList.size() / 2, elements));
        sendMessage(CollectionsUtils.addItemsWithin(copyOnWriteArrayList, copyOnWriteArrayList.size() / 2, elements));
        sendMessage(CollectionsUtils.addItemsAtEnd(arrayList, elements));
        sendMessage(CollectionsUtils.addItemsAtEnd(linkedList, elements));
        sendMessage(CollectionsUtils.addItemsAtEnd(copyOnWriteArrayList, elements));
        sendMessage(CollectionsUtils.searchByValue(arrayList, arrayList.get(new Random().nextInt(elements))));
        sendMessage(CollectionsUtils.searchByValue(linkedList, linkedList.get(new Random().nextInt(elements))));
        sendMessage(CollectionsUtils.searchByValue(copyOnWriteArrayList, copyOnWriteArrayList.get(new Random().nextInt(elements))));
        sendMessage(CollectionsUtils.removeFromList(arrayList, 0));
        sendMessage(CollectionsUtils.removeFromList(linkedList, 0));
        sendMessage(CollectionsUtils.removeFromList(copyOnWriteArrayList, 0));
        sendMessage(CollectionsUtils.removeFromList(arrayList, arrayList.size() - 1));
        sendMessage(CollectionsUtils.removeFromList(linkedList, arrayList.size() - 1));
        sendMessage(CollectionsUtils.removeFromList(copyOnWriteArrayList, arrayList.size() - 1));
        sendMessage(CollectionsUtils.removeFromList(arrayList, arrayList.size() / 2));
        sendMessage(CollectionsUtils.removeFromList(linkedList, arrayList.size() / 2));
        sendMessage(CollectionsUtils.removeFromList(copyOnWriteArrayList, arrayList.size() / 2));
        onCompleteTask();
    };

    @Override
    protected Runnable getCalculationTask() {
        return calculationTask;
    }
}