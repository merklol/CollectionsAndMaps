package com.bilingoal.collectionsandmaps.dto;

public class GridViewItem {
    private String title;
    private String time;
    private int progressBarVisibility;
    private boolean isUpdated = false;
    public final static int ANIMATION_LENGTH = 500;

    public GridViewItem(String title, String time, int progressBarVisibility) {
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

    public int getProgressBarVisibility() {
        return progressBarVisibility;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setProgressBarVisibility(int progressBarVisibility) {
        this.progressBarVisibility = progressBarVisibility;
    }

    public boolean isUpdated() {
        return isUpdated;
    }

    public void setUpdated(boolean updated) {
        isUpdated = updated;
    }
}
