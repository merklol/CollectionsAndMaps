package com.bilingoal.collectionsandmaps.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bilingoal.collectionsandmaps.grid.GridContract;

public class UIHandler extends Handler {
    private final GridContract.View view;
    public static final String POSITION = "position";
    public static final String ELAPSED_TIME = "elapsed_time";

    public UIHandler(@NonNull Looper looper, GridContract.View view) {
        super(looper);
        this.view = view;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        Bundle bundle = msg.getData();
        int position = bundle.getInt(POSITION);
        String elapsedTime = bundle.getString(ELAPSED_TIME);
        view.updateAdapter(position, elapsedTime);
    }

    public void notifyItemUpdated(int position, String elapsedTime) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putInt(UIHandler.POSITION, position);
        bundle.putString(UIHandler.ELAPSED_TIME, elapsedTime);
        message.setData(bundle);
        sendMessage(message);
    }
}