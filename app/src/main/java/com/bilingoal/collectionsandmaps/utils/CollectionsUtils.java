package com.bilingoal.collectionsandmaps.utils;

import com.google.common.base.Stopwatch;

import java.util.*;
import java.util.stream.IntStream;

public class CollectionsUtils {

    public static String addItemsAtStart(List<Integer> list, int amount){
        int value = new Random().nextInt(10);
        list.addAll(Collections.nCopies(amount, value));
        Stopwatch stopwatch = Stopwatch.createStarted();
        list.add(0, value);
        return stopwatch.toString();
    }

    public static String addItemsWithin(List<Integer> list, int position, int amount){
        int value = new Random().nextInt(10);
        list.addAll(Collections.nCopies(amount, value));
        Stopwatch stopwatch = Stopwatch.createStarted();
        list.add(position, value);
        return stopwatch.toString();
    }

    public static String addItemsAtEnd(List<Integer> list, int amount){
        int value = new Random().nextInt(10);
        list.addAll(Collections.nCopies(amount, value));
        Stopwatch stopwatch = Stopwatch.createStarted();
        list.add(value);
        return stopwatch.toString();
    }

    public static String searchByValue(List<Integer> list, int value){
        Stopwatch stopwatch = Stopwatch.createStarted();
        return list.contains(value) ? stopwatch.toString() : "";
    }

    public static String removeFromList(List<Integer> list, int position){
        Stopwatch stopwatch = Stopwatch.createStarted();
        list.remove(position);
        return stopwatch.toString();
    }

    public static String addItems(Map<Integer, String> map, int amount){
        int value = new Random().nextInt(10);
        IntStream.range(0, amount).forEach(item -> map.put(item, String.valueOf(item)));
        Stopwatch stopwatch = Stopwatch.createStarted();
        map.put(value, String.valueOf(value));
        return stopwatch.toString();
    }

    public static String searchByKey(Map<Integer, String> map, int key){
        Stopwatch stopwatch = Stopwatch.createStarted();
        return map.containsKey(key) ? stopwatch.toString() : "";
    }

    public static String removeFromMap(Map<Integer, String> map, int key){
        Stopwatch stopwatch = Stopwatch.createStarted();
        map.remove(key);
        return stopwatch.toString();
    }
}