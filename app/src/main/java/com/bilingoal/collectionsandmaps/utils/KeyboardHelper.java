package com.bilingoal.collectionsandmaps.utils;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Objects;

public class KeyboardHelper {
    public static void hideKeyboard(View view){
        InputMethodManager inputMethodManager =(InputMethodManager) Objects.requireNonNull(view.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE));
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
