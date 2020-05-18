package com.bilingoal.collectionsandmaps.grid;

import android.os.Bundle;
import android.os.Looper;
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
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bilingoal.collectionsandmaps.utils.UIHandler;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;
import java.util.Objects;

public class GridFragment extends Fragment implements GridContract.View {
    @BindView(R.id.input_view) EditText inputView;
    @BindView(R.id.calc_btn) Button button;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    protected GridAdapter adapter;
    private GridPresenter presenter;
    private UIHandler uiHandler;
    public static final String FRAGMENT_TYPE = "type";

    public GridFragment() { }

    public static GridFragment createInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString(FRAGMENT_TYPE, type);
        GridFragment fragment = new GridFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Bundle bundle = getArguments();
        if(bundle != null){
            String type = getArguments().getString(FRAGMENT_TYPE);
            if(type != null){
                presenter = new GridFragmentInjector().createPresenter(type);
            }
        }
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
        adapter = new GridAdapter(presenter.getInitialResult(false));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), presenter.getSpanCount()));
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(v -> presenter.startCalculation(inputView.getText().toString(), uiHandler));
    }

    @Override
    public void setError(int resId) {
        inputView.setError(getString(resId));
    }

    @Override
    public void setItems(List<GridViewItem> items) {
        adapter.setItems(items);
        KeyboardUtil.hideKeyboard(Objects.requireNonNull(getView()));
    }

    @Override
    public void updateAdapter(int position, String value) {
        adapter.updateItemAt(position, value);
        if(adapter.allItemsAreUpdated()) {
            Snackbar.make(
                    Objects.requireNonNull(getView()), getString(R.string.snackbar_message), Snackbar.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    public void notifyItemUpdated(int position, String elapsedTime) {
        uiHandler.notifyItemUpdated(position, elapsedTime);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
        uiHandler = new UIHandler(Looper.getMainLooper(), this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }
}