package com.bilingoal.collectionsandmaps.models;

import android.os.Bundle;
import android.os.Message;
import com.bilingoal.collectionsandmaps.utils.UIHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class BaseCalculator  {
    protected UIHandler uiHandler;
    protected int position = 0;
    protected int elements;
    private ExecutorService service;

    public void calculate(int poolSize){
        try{
            service = Executors.newFixedThreadPool(poolSize);
            service.execute(getCalculationTask());
        } finally {
            service.shutdown();
            position = 0;
        }
    }

    protected void sendMessage(String elapsedTime) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putInt(UIHandler.POSITION, position);
        bundle.putString(UIHandler.ELAPSED_TIME, elapsedTime);
        message.setData(bundle);
        uiHandler.sendMessage(message);
        position++;
    }

    protected abstract Runnable getCalculationTask();

    public void setElements(int elements) {
        this.elements = elements;
    }

    public void setHandler(UIHandler handler) {
        this.uiHandler = handler;
    }

    protected void onCompleteTask() {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putBoolean(UIHandler.COMPLETED_TASK, true);
        message.setData(bundle);
        uiHandler.sendMessage(message);
    }
}