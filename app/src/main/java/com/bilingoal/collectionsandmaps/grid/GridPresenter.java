package com.bilingoal.collectionsandmaps.grid;

import android.text.TextUtils;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.base.BasePresenter;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import com.bilingoal.collectionsandmaps.models.BaseCalculator;
import com.bilingoal.collectionsandmaps.models.TaskSupplier;
import com.bilingoal.collectionsandmaps.utils.UIHandler;
import java.util.List;
import java.util.concurrent.*;

public class GridPresenter extends BasePresenter<GridContract.View> implements GridContract.Presenter<GridContract.View> {
    private final TaskSupplier tasksSupplier;
    private final BaseCalculator calculator;
    private ExecutorService service;

    public GridPresenter(TaskSupplier tasksSupplier, BaseCalculator calculator) {
        this.tasksSupplier = tasksSupplier;
        this.calculator = calculator;
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
    public void startCalculation(String elements, UIHandler handler) {
        if (TextUtils.isEmpty(elements) || "0".equals(elements.trim())) {
            view.setError(R.string.edit_text_error);
        } else {
            view.setItems(getInitialResult(true));
            calculator.setElements(Integer.parseInt(elements));
            calculator.setOnTaskCompleted((position, elapsedTime) -> view.notifyItemUpdated(position, elapsedTime));
            try{
                service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
                calculator.getCalculationTasks().forEach(runnable -> service.submit(runnable));;
            } finally {
                service.shutdown();
            }
        }
    }
}