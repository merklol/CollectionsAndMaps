package com.bilingoal.collectionsandmaps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bilingoal.collectionsandmaps.adapters.GridViewAdapter;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.utils.AsyncOperations;
import com.bilingoal.collectionsandmaps.utils.Constants;
import com.bilingoal.collectionsandmaps.utils.KeyboardHelper;
import java.util.*;

public class MapsFragment extends Fragment {
    @BindView(R.id.input_view) EditText inputView;
    @BindView(R.id.calc_btn) Button button;
    @BindView(R.id.grid_view) GridView gridView;
    private GridViewAdapter adapter;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public MapsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferences = Objects.requireNonNull(getActivity())
                .getSharedPreferences(Constants.RESULTS, Context.MODE_PRIVATE);
        editor = preferences.edit();

        if(preferences != null) {
            String data = preferences.getString(Constants.MAPS_RESULT, null);
            if(data != null)
                adapter =  new GridViewAdapter(requireContext(), populateGridView(View.GONE, data));
            else
                adapter =  new GridViewAdapter(requireContext(), repopulateGridView(View.GONE));
        }
        else
            adapter =  new GridViewAdapter(requireContext(), repopulateGridView(View.GONE));

        gridView.setAdapter(adapter);
        button.setOnClickListener(v -> {
            if (inputView.getText().toString().trim().equalsIgnoreCase("")) {
                inputView.setError(getString(R.string.edit_text_error));
            } else {
                adapter.addNewValues(repopulateGridView(View.VISIBLE));
                KeyboardHelper.hideKeyboard(view);
                new AsyncOperations.AsyncMapOperations(
                        getView(), adapter, Integer.parseInt(inputView.getText().toString())
                ).execute();
            }
        });
    }

    private List<GridViewItem> repopulateGridView(int progressBarVisibility){
        List<GridViewItem> gridViewItems = new ArrayList<>();
        String time = getString(R.string.time);
        gridViewItems.add(new GridViewItem(getString(R.string.add_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.add_tree_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.search_tree_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_hash_map), time, progressBarVisibility));
        gridViewItems.add(new GridViewItem(getString(R.string.rm_tree_map), time, progressBarVisibility));
        return gridViewItems;
    }

    private List<GridViewItem> populateGridView(int progressBarVisibility, String data){
        List<GridViewItem> gridViewItems = new ArrayList<>();
            String[] time = data.substring(1, data.length() - 1).split(",");
            gridViewItems.add(new GridViewItem(getString(R.string.add_hash_map), time[0], progressBarVisibility));
            gridViewItems.add(new GridViewItem(getString(R.string.add_tree_map), time[1], progressBarVisibility));
            gridViewItems.add(new GridViewItem(getString(R.string.search_hash_map), time[2], progressBarVisibility));
            gridViewItems.add(new GridViewItem(getString(R.string.search_tree_map), time[3], progressBarVisibility));
            gridViewItems.add(new GridViewItem(getString(R.string.rm_hash_map), time[4], progressBarVisibility));
            gridViewItems.add(new GridViewItem(getString(R.string.rm_tree_map), time[5], progressBarVisibility));
        return gridViewItems;
    }

    @Override
    public void onPause() {
        super.onPause();
        editor.putString(Constants.MAPS_RESULT, adapter.getResults().toString());
        editor.commit();
    }
}
