package com.bilingoal.collectionsandmaps.fragment;

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
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.adapters.GridAdapter;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.utils.Constants;
import com.bilingoal.collectionsandmaps.utils.KeyboardUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.Objects;

public class BasicFragment extends Fragment implements BasicFragmentContract.View {
    @BindView(R.id.input_view) EditText inputView;
    @BindView(R.id.calc_btn) Button button;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    protected GridAdapter adapter;
    private BasicFragmentPresenter presenter;

    public BasicFragment() { }

    public static BasicFragment createInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.FRAGMENT_TYPE, type);
        BasicFragment fragment = new BasicFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Bundle bundle = getArguments();
        if(bundle != null){
            String type = getArguments().getString(Constants.FRAGMENT_TYPE);
            if(type != null){
                presenter = new BasicFragmentInjector().createPresenter(type);
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
        button.setOnClickListener(v -> presenter.startCalculation(inputView.getText().toString()));
    }

    @Override
    public void setError(String error) {
        inputView.setError(getString(R.string.edit_text_error));
    }

    @Override
    public void addInitialValues(List<GridViewItem> items) {
        adapter.addNewValues(items);
        KeyboardUtil.hideKeyboard(Objects.requireNonNull(getView()));
    }

    @Override
    public void updateAdapterItem(int position, String value) {
        adapter.updateItemAt(position, value);
    }

    @Override
    public void displaySnackBar() {
        Snackbar.make(Objects.requireNonNull(getView()), getResources().getString(R.string.snackbar_message), Snackbar.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();;
    }
}