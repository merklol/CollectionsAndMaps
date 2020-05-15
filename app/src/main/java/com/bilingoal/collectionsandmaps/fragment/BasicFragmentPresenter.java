package com.bilingoal.collectionsandmaps.fragment;

import android.os.Looper;
import android.text.TextUtils;
import com.bilingoal.collectionsandmaps.App;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.models.BaseCalculator;
import com.bilingoal.collectionsandmaps.models.TaskSupplier;
import com.bilingoal.collectionsandmaps.utils.UIHandler;

import java.util.List;

public class BasicFragmentPresenter implements BasicFragmentContract.Presenter<BasicFragmentContract.View> {
    protected BasicFragmentContract.View view;
    private final TaskSupplier tasksSupplier;
    private UIHandler uiHandler;
    private final BaseCalculator calculator;

    public BasicFragmentPresenter(TaskSupplier tasksSupplier, BaseCalculator calculator) {
        this.tasksSupplier = tasksSupplier;
        this.calculator = calculator;
    }

    @Override
    public void attachView(BasicFragmentContract.View view) {
        this.view = view;
        this.uiHandler = new UIHandler(Looper.getMainLooper(), view);
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public int getSpanCount() {
        return this.tasksSupplier.getSpanCount();
    }

    @Override
    public List<GridViewItem> getInitialResult(boolean progressBarVisibility) {
        return this.tasksSupplier.getInitialResult(progressBarVisibility);
    }

    @Override
    public void startCalculation(String elements) {
        if (TextUtils.isEmpty(elements) || "0".equals(elements.trim())) {
            view.setError(App.getContext().getString(R.string.edit_text_error));
        } else {
            view.addInitialValues(getInitialResult(true));
            calculator.setHandler(uiHandler);
            calculator.setElements(Integer.parseInt(elements));
            calculator.calculate(Runtime.getRuntime().availableProcessors() * 2);
        }
    }
}