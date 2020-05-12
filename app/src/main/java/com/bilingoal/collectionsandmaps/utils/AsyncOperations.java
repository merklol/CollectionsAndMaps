package com.bilingoal.collectionsandmaps.utils;

import android.os.AsyncTask;
import android.view.View;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.adapters.GridAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class AsyncOperations {

    public static class AsyncListOperations extends AsyncTask<Void, String, Void> {
        private final GridAdapter adapter;
        private final WeakReference<View> view;
        private final int size;
        private int position = 0;
        private final ArrayList<Integer> arrayList = new ArrayList<>();
        private final LinkedList<Integer> linkedList = new LinkedList<>();
        private final CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        public AsyncListOperations(View view, GridAdapter adapter, int size) {
            this.view = new WeakReference<>(view);
            this.adapter = adapter;
            this.size = size;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Snackbar.make(view.get(), view.get().getContext().getResources().getString(R.string.snackbar_message), Snackbar.LENGTH_SHORT)
                    .show();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            adapter.updateItemAt(position, values[0]);
            position++;
        }

        @Override
        protected final Void doInBackground(Void... args) {
            publishProgress(CollectionsUtils.addItemsAtStart(arrayList, size));
            publishProgress(CollectionsUtils.addItemsAtStart(linkedList, size));
            publishProgress(CollectionsUtils.addItemsAtStart(copyOnWriteArrayList, size));
            publishProgress(CollectionsUtils.addItemsWithin(arrayList,arrayList.size() / 2, size));
            publishProgress(CollectionsUtils.addItemsWithin(linkedList,linkedList.size() / 2, size));
            publishProgress(CollectionsUtils.addItemsWithin(copyOnWriteArrayList,copyOnWriteArrayList.size() / 2, size));
            publishProgress(CollectionsUtils.addItemsAtEnd(arrayList, size));
            publishProgress(CollectionsUtils.addItemsAtEnd(linkedList, size));
            publishProgress(CollectionsUtils.addItemsAtEnd(copyOnWriteArrayList, size));
            publishProgress(CollectionsUtils.searchByValue(arrayList, size / 2));
            publishProgress(CollectionsUtils.searchByValue(linkedList, size / 2));
            publishProgress(CollectionsUtils.searchByValue(copyOnWriteArrayList, size / 2));
            publishProgress(CollectionsUtils.removeFromList(arrayList, 0));
            publishProgress(CollectionsUtils.removeFromList(linkedList, 0));
            publishProgress(CollectionsUtils.removeFromList(copyOnWriteArrayList, 0));
            publishProgress(CollectionsUtils.removeFromList(arrayList, arrayList.size() - 1));
            publishProgress(CollectionsUtils.removeFromList(linkedList, arrayList.size() - 1));
            publishProgress(CollectionsUtils.removeFromList(copyOnWriteArrayList, arrayList.size() - 1));
            publishProgress(CollectionsUtils.removeFromList(arrayList, arrayList.size() / 2));
            publishProgress(CollectionsUtils.removeFromList(linkedList, arrayList.size() / 2));
            publishProgress(CollectionsUtils.removeFromList(copyOnWriteArrayList, arrayList.size() / 2));
            return null;
        }
    }

    public static class AsyncMapOperations extends AsyncTask<Void, String, Void> {
        private final GridAdapter adapter;
        private final WeakReference<View> view;
        private final int size;
        private int position = 0;
        private final HashMap<Integer, String> hashMap = new HashMap<>();
        private final TreeMap<Integer, String> treeMap = new TreeMap<>();

        public AsyncMapOperations(View view, GridAdapter adapter, int size) {
            this.view = new WeakReference<>(view);
            this.adapter = adapter;
            this.size = size;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Snackbar.make(view.get(), view.get().getContext().getResources().getString(R.string.snackbar_message), Snackbar.LENGTH_SHORT)
                    .show();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            adapter.updateItemAt(position, values[0]);
            position++;
        }

        @Override
        protected final Void doInBackground(Void... args) {
            publishProgress(CollectionsUtils.addItems(hashMap, size));
            publishProgress(CollectionsUtils.addItems(treeMap, size));
            publishProgress(CollectionsUtils.searchByKey(hashMap,hashMap.size() / 2));
            publishProgress(CollectionsUtils.searchByKey(treeMap,treeMap.size() / 2));
            publishProgress(CollectionsUtils.removeFromMap(treeMap,hashMap.size() / 2));
            publishProgress(CollectionsUtils.removeFromMap(treeMap,treeMap.size() / 2));
            return null;
        }
    }
}