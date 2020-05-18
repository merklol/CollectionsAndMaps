package com.bilingoal.collectionsandmaps.models;

import com.google.common.base.Stopwatch;
import java.util.*;

public class MapsCalculator extends BaseCalculator {

    @Override
    public List<Runnable> getCalculationTasks() {
        List<Runnable> calculationTasks = new ArrayList<>();
        calculationTasks.add(() ->
                listener.onComplete(0,addItems(HashMap.class)));
        calculationTasks.add(() ->
                listener.onComplete(1, addItems(TreeMap.class)));
        calculationTasks.add(() ->
                listener.onComplete(2, searchByKey(HashMap.class, new Random().nextInt(getElements()))));
        calculationTasks.add(() ->
                listener.onComplete(3, searchByKey(TreeMap.class, new Random().nextInt(getElements()))));
        calculationTasks.add(() ->
                listener.onComplete(4, removeFromMap(HashMap.class, new Random().nextInt(getElements()))));
        calculationTasks.add(() ->
                listener.onComplete(5, removeFromMap(TreeMap.class, new Random().nextInt(getElements()))));
        return calculationTasks;
    }

    private String addItems(Class<?> clazz){
        Map<Integer, String> map = createMap(clazz);
        int value = new Random().nextInt(10);
        Stopwatch stopwatch = Stopwatch.createStarted();
        map.put(value, String.valueOf(value));
        return stopwatch.toString();
    }

    private String searchByKey(Class<?> clazz, int key){
        Map<Integer, String> map = createMap(clazz);
        Stopwatch stopwatch = Stopwatch.createStarted();
        return map.containsKey(key) ? stopwatch.toString() : "";
    }

    private String removeFromMap(Class<?> clazz, int key){
        Map<Integer, String> map = createMap(clazz);
        Stopwatch stopwatch = Stopwatch.createStarted();
        map.remove(key);
        return stopwatch.toString();
    }
}