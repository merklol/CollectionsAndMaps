package com.bilingoal.collectionsandmaps.models;

import com.google.common.base.Stopwatch;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsCalculator extends BaseCalculator {
    @Override
    public List<Runnable> getCalculationTasks() {
        List<Runnable> calculationTasks = new ArrayList<>();

        calculationTasks.add(() ->
                listener.onComplete(0, addItemsAtStart(ArrayList.class)));
        calculationTasks.add(() ->
                listener.onComplete(1, addItemsAtStart(LinkedList.class)));
        calculationTasks.add(() ->
                listener.onComplete(2, addItemsAtStart(CopyOnWriteArrayList.class)));
        calculationTasks.add(() ->
                listener.onComplete(3, addItemsWithin(ArrayList.class)));
        calculationTasks.add(() ->
                listener.onComplete(4, addItemsWithin(LinkedList.class)));
        calculationTasks.add(() ->
                listener.onComplete(5, addItemsWithin(CopyOnWriteArrayList.class)));
        calculationTasks.add(() ->
                listener.onComplete(6, addItemsAtEnd(ArrayList.class)));
        calculationTasks.add(() ->
                listener.onComplete(7, addItemsAtEnd(LinkedList.class)));
        calculationTasks.add(() ->
                listener.onComplete(8, addItemsAtEnd(CopyOnWriteArrayList.class)));
        calculationTasks.add(() ->
                listener.onComplete(9, searchByValue(ArrayList.class)));
        calculationTasks.add(() ->
                listener.onComplete(10, searchByValue(LinkedList.class)));
        calculationTasks.add(() ->
                listener.onComplete(11, searchByValue(CopyOnWriteArrayList.class)));
        calculationTasks.add(() ->
                listener.onComplete(12, removeItemFromList(ArrayList.class, 0)));
        calculationTasks.add(() ->
                listener.onComplete(13, removeItemFromList(LinkedList.class, 0)));
        calculationTasks.add(() ->
                listener.onComplete(14, removeItemFromList(CopyOnWriteArrayList.class, 0)));
        calculationTasks.add(() ->
                listener.onComplete(15, removeItemFromList(ArrayList.class, getElements() / 2)));
        calculationTasks.add(() ->
                listener.onComplete(16, removeItemFromList(LinkedList.class, getElements() / 2)));
        calculationTasks.add(() ->
                listener.onComplete(17, removeItemFromList(
                        CopyOnWriteArrayList.class, getElements()/ 2)));
        calculationTasks.add(() ->
                listener.onComplete(18, removeItemFromList(ArrayList.class, getElements() - 1)));
        calculationTasks.add(() ->
                listener.onComplete(19, removeItemFromList(LinkedList.class, getElements() - 1)));
        calculationTasks.add(() ->
                listener.onComplete(20, removeItemFromList(
                        CopyOnWriteArrayList.class, getElements() - 1)));
        return calculationTasks;
    }

    private String addItemsAtStart(Class<?> clazz){
        List<Integer> list = createList(clazz);
        int value = new Random().nextInt(10);
        Stopwatch stopwatch = Stopwatch.createStarted();
        list.add(0, value);
        return stopwatch.toString();
    }

    private String addItemsWithin(Class<?> clazz){
        List<Integer> list = createList(clazz);
        int value = new Random().nextInt(10);
        Stopwatch stopwatch = Stopwatch.createStarted();
        list.add(list.size() / 2, value);
        return stopwatch.toString();
    }

    private String addItemsAtEnd(Class<?> clazz){
        List<Integer> list = createList(clazz);
        int value = new Random().nextInt(10);
        Stopwatch stopwatch = Stopwatch.createStarted();
        list.add(value);
        return stopwatch.toString();
    }

    private String searchByValue(Class<?> clazz){
        List<Integer> list = createList(clazz);
        int value = list.get(new Random().nextInt(getElements()));
        Stopwatch stopwatch = Stopwatch.createStarted();
        return list.contains(value) ? stopwatch.toString() : "";
    }

    private String removeItemFromList(Class<?> clazz, int position){
        List<Integer> list = createList(clazz);
        Stopwatch stopwatch = Stopwatch.createStarted();
        list.remove(position);
        return stopwatch.toString();
    }
}