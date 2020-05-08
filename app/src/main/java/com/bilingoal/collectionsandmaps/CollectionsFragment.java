package com.bilingoal.collectionsandmaps;

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
import com.bilingoal.collectionsandmaps.utils.KeyboardHelper;

import java.util.ArrayList;
import java.util.List;

public class CollectionsFragment extends Fragment {
    @BindView(R.id.input_view) EditText inputView;
    @BindView(R.id.calc_btn) Button button;
    @BindView(R.id.grid_view) GridView gridView;

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
        GridViewAdapter adapter =  new GridViewAdapter(requireContext(), populateGridView(View.GONE));
        gridView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            if (inputView.getText().toString().trim().equalsIgnoreCase("")) {
                inputView.setError(getString(R.string.edit_text_error));
            } else {
                adapter.addNewValues(populateGridView(View.VISIBLE));
                KeyboardHelper.hideKeyboard(view);
                new AsyncOperations.AsyncListOperations(
                        getView(), adapter, Integer.parseInt(inputView.getText().toString())
                ).execute();
            }
        });
    }

    private List<GridViewItem> populateGridView(int progressBarVisibility){
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

}
