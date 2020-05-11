package com.bilingoal.collectionsandmaps.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.adapters.GridAdapter;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.utils.KeyboardUtil;

import java.util.List;

public abstract class BasicFragment extends Fragment {
    @BindView(R.id.input_view) EditText inputView;
    @BindView(R.id.calc_btn) Button button;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    protected GridAdapter adapter;
    private final int spanCount;

    public BasicFragment(int spanCount) {
        setRetainInstance(true);
        this.spanCount = spanCount;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new GridAdapter(requireContext(), populate(View.INVISIBLE));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), spanCount));
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            if (inputView.getText().toString().trim().equalsIgnoreCase("")) {
                inputView.setError(getString(R.string.edit_text_error));
            } else {
                adapter.addNewValues(populate(View.VISIBLE));
                KeyboardUtil.hideKeyboard(view);
                onBtnClick();
            }
        });
    }

    public abstract List<GridViewItem> populate(int progressBarVisibility);
    public abstract void onBtnClick();
}
