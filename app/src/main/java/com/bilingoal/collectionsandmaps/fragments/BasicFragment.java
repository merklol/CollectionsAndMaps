package com.bilingoal.collectionsandmaps.fragments;

import android.os.Bundle;
import android.text.TextUtils;
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

import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.adapters.GridAdapter;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.utils.KeyboardUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BasicFragment extends Fragment {
    @BindView(R.id.input_view) EditText inputView;
    @BindView(R.id.calc_btn) Button button;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    protected GridAdapter adapter;

    public BasicFragment() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
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
        adapter = new GridAdapter(populate(false));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), getSpanCount()));
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(v -> {
            String elements = inputView.getText().toString();
            if (TextUtils.isEmpty(elements) || "0".equals(elements.trim())) {
                inputView.setError(getString(R.string.edit_text_error));
            } else {
                adapter.addNewValues(populate(true));
                KeyboardUtil.hideKeyboard(view);
                onStartCalculationBtnClicked(Integer.parseInt(elements));
            }
        });
    }

    public abstract int getSpanCount();

    public abstract List<GridViewItem> populate(boolean progressBarVisibility);
    public abstract void onStartCalculationBtnClicked(int elements);
}