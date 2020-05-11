package com.bilingoal.collectionsandmaps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bilingoal.collectionsandmaps.adapters.GridAdapter;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.utils.AsyncOperations;
import com.bilingoal.collectionsandmaps.utils.Constants;
import com.bilingoal.collectionsandmaps.utils.KeyboardUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollectionsFragment extends Fragment {
    @BindView(R.id.input_view) EditText inputView;
    @BindView(R.id.calc_btn) Button button;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    private GridAdapter adapter;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public CollectionsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collections, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferences = Objects.requireNonNull(getActivity())
                .getSharedPreferences(Constants.RESULTS, Context.MODE_PRIVATE);
        editor = preferences.edit();

        String data = preferences.getString(Constants.COLLECTIONS_RESULT, null);
        if(data != null && preferences != null)
            adapter =  new GridAdapter(requireContext(), populateGridView(View.GONE, data));
        else
            adapter =  new GridAdapter(requireContext(), repopulateGridView(View.GONE));

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            if (inputView.getText().toString().trim().equalsIgnoreCase("")) {
                inputView.setError(getString(R.string.edit_text_error));
            } else {
                adapter.addNewValues(repopulateGridView(View.VISIBLE));
                KeyboardUtil.hideKeyboard(view);
                new AsyncOperations.AsyncListOperations(
                        getView(), adapter, Integer.parseInt(inputView.getText().toString())
                ).execute();
            }
        });
    }
    private List<GridViewItem> repopulateGridView(int progressBarVisibility){
        List<GridViewItem> gridViewItems = new ArrayList<>();
        String time = getString(R.string.time);
        gridViewItems.add(new GridViewItem(getString(R.string.add_beginning_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_beginning_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_beginning_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_middle_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_middle_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_middle_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_end_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_end_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_end_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_beginning_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_beginning_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_beginning_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_middle_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_middle_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_middle_cow_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_end_arr_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_end_linked_list), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_end_cow_list), time, progressBarVisibility));

        return gridViewItems;
    }

    private List<GridViewItem> populateGridView(int progressBarVisibility, String data){
        List<GridViewItem> gridViewItems = new ArrayList<>();
        String[] time = data.substring(1, data.length() - 1).split(",");
        gridViewItems.add(new GridViewItem(getString(R.string.add_beginning_arr_list), time[0], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_beginning_linked_list), time[1], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_beginning_cow_list), time[2], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_middle_arr_list), time[3], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_middle_linked_list), time[4], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_middle_cow_list), time[5], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_end_arr_list), time[6], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_end_linked_list), time[7], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_end_cow_list), time[8], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_arr_list), time[9], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_linked_list), time[10], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_cow_list), time[11], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_beginning_arr_list), time[12], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_beginning_linked_list), time[13], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_beginning_cow_list), time[14], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_middle_arr_list), time[15], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_middle_linked_list), time[16], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_middle_cow_list), time[17], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_end_arr_list), time[18], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_end_linked_list), time[19], progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_end_cow_list), time[20], progressBarVisibility));
        return gridViewItems;
    }

    @Override
    public void onPause() {
        super.onPause();
        editor.putString(Constants.COLLECTIONS_RESULT, adapter.getResults().toString());
        editor.commit();
    }
}
