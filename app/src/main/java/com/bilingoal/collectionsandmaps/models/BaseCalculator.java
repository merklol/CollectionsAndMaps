package com.bilingoal.collectionsandmaps.models;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public abstract class BaseCalculator {
    private int elements;
    protected OnTaskCompleteListener listener;

    public interface OnTaskCompleteListener{
        void onComplete(int position, String elapsedTime);
    }

    public void setOnTaskCompleted(OnTaskCompleteListener onTaskCompleted) {
        this.listener = onTaskCompleted;
    }

    public abstract List<Runnable> getCalculationTasks();

    public void setElements(int elements) {
        this.elements = elements;
    }

    protected int getElements() {
        return elements;
    }

    protected List<Integer> createList(Class<?> clazz){
        int value = new Random().nextInt(10);
        if(clazz.equals(ArrayList.class)){
            return new ArrayList<>(Collections.nCopies(elements, value));
        } else if(clazz.equals(LinkedList.class)){
            return new LinkedList<>(Collections.nCopies(elements, value));
        } else {
            return new CopyOnWriteArrayList<>(Collections.nCopies(elements, value));
        }
    }

    protected Map<Integer, String> createMap(Class<?> clazz){
        Map<Integer, String> map;
        if(clazz.equals(HashMap.class)){
            map = new HashMap<>();
            IntStream.range(0, elements).forEach(item -> map.put(item, String.valueOf(item)));
        } else {
            map = new TreeMap<>();
            IntStream.range(0, elements).forEach(item -> map.put(item, String.valueOf(item)));
        }
        return map;
    }
}