package com.bilingoal.collectionsandmaps.dto;

public class GridViewItem {
    private String title;
    private String time;
    private boolean progressBarVisibility;
    private boolean isUpdated = false;
    public final static int ANIMATION_LENGTH_SHORT = 500;
    public final static int ANIMATION_LENGTH_LONG = 2000;

    public GridViewItem(String title, String time, boolean progressBarVisibility) {
        this.title = title;
        this.time = time;
        this.progressBarVisibility = progressBarVisibility;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public boolean getProgressBarVisibility() {
        return progressBarVisibility;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setProgressBarVisibility(boolean progressBarVisibility) {
        this.progressBarVisibility = progressBarVisibility;
    }

    public boolean isUpdated() {
        return isUpdated;
    }

    public void setUpdated(boolean updated) {
        isUpdated = updated;
    }
}
