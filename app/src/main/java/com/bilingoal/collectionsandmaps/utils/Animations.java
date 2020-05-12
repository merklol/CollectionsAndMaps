package com.bilingoal.collectionsandmaps.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public class Animations {
    public static void fadeOut(View view, int duration){
        view.animate().alpha(0).setDuration(duration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
                view.setAlpha(1);
            }
        });
    }
    public static void fadeIn(View view, int duration){
        view.setAlpha(0);
        view.animate().alpha(1).setDuration(duration).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.VISIBLE);
            }
        });
    }
}
