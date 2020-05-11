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

    public static class AsyncListOperations extends AsyncTask<Void, Void, Void> {
        private final GridAdapter adapter;
        private final WeakReference<View> view;
        private final int size;
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
        protected final Void doInBackground(Void... args) {
            adapter.updateItemAt(0, CollectionsUtils.addItemsAtStart(arrayList, size));
            adapter.updateItemAt(1, CollectionsUtils.addItemsAtStart(linkedList, size));
            adapter.updateItemAt(2, CollectionsUtils.addItemsAtStart(copyOnWriteArrayList, size));
            adapter.updateItemAt(3,  CollectionsUtils.addItemsWithin(arrayList,arrayList.size() / 2, size));
            adapter.updateItemAt(4, CollectionsUtils.addItemsWithin(linkedList,arrayList.size() / 2, size));
            adapter.updateItemAt(5, CollectionsUtils.addItemsWithin(copyOnWriteArrayList,arrayList.size() / 2, size));
            adapter.updateItemAt(6, CollectionsUtils.addItemsAtEnd(arrayList, size));
            adapter.updateItemAt(7, CollectionsUtils.addItemsAtEnd(linkedList, size));
            adapter.updateItemAt(8, CollectionsUtils.addItemsAtEnd(copyOnWriteArrayList, size));
            adapter.updateItemAt(9, CollectionsUtils.searchByValue(arrayList, size / 2));
            adapter.updateItemAt(10, CollectionsUtils.searchByValue(linkedList, size / 2));
            adapter.updateItemAt(11, CollectionsUtils.searchByValue(copyOnWriteArrayList, size / 2));
            adapter.updateItemAt(12, CollectionsUtils.removeFromList(arrayList, 0));
            adapter.updateItemAt(13, CollectionsUtils.removeFromList(linkedList, 0));
            adapter.updateItemAt(14, CollectionsUtils.removeFromList(copyOnWriteArrayList, 0));
            adapter.updateItemAt(15, CollectionsUtils.removeFromList(arrayList, arrayList.size() - 1));
            adapter.updateItemAt(16, CollectionsUtils.removeFromList(linkedList, arrayList.size() - 1));
            adapter.updateItemAt(17, CollectionsUtils.removeFromList(copyOnWriteArrayList, arrayList.size() - 1));
            adapter.updateItemAt(18, CollectionsUtils.removeFromList(arrayList, arrayList.size() / 2));
            adapter.updateItemAt(19, CollectionsUtils.removeFromList(linkedList, arrayList.size() / 2));
            adapter.updateItemAt(20, CollectionsUtils.removeFromList(copyOnWriteArrayList, arrayList.size() / 2));
            return null;
        }
    }

    public static class AsyncMapOperations extends AsyncTask<Void, Void, Void> {
        private final GridAdapter adapter;
        private final WeakReference<View> view;
        private final int size;
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
        protected final Void doInBackground(Void... args) {
            adapter.updateItemAt(0, CollectionsUtils.addItems(hashMap, size));
            adapter.updateItemAt(1, CollectionsUtils.addItems(treeMap, size));
            adapter.updateItemAt(2,  CollectionsUtils.searchByKey(hashMap,hashMap.size() / 2));
            adapter.updateItemAt(3,  CollectionsUtils.searchByKey(treeMap,treeMap.size() / 2));
            adapter.updateItemAt(4,  CollectionsUtils.removeFromMap(treeMap,hashMap.size() / 2));
            adapter.updateItemAt(5,  CollectionsUtils.removeFromMap(treeMap,treeMap.size() / 2));
            return null;
        }
    }
}