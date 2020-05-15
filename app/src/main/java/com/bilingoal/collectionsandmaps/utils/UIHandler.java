package com.bilingoal.collectionsandmaps.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bilingoal.collectionsandmaps.fragment.BasicFragmentContract;

public class UIHandler extends Handler {
    private final BasicFragmentContract.View view;
    public static final String POSITION = "position";
    public static final String COMPLETED_TASK = "completed";
    public static final String ELAPSED_TIME = "elapsed_time";


    public UIHandler(@NonNull Looper looper, BasicFragmentContract.View view) {
        super(looper);
        this.view = view;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        Bundle bundle = msg.getData();
        boolean completed = bundle.getBoolean(COMPLETED_TASK);
        int position = bundle.getInt(POSITION);
        String elapsedTime = bundle.getString(ELAPSED_TIME);

        if(completed) {
            view.displaySnackBar();
        } else {
            view.updateAdapterItem(position, elapsedTime);
        }
    }
}