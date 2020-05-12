package com.bilingoal.collectionsandmaps.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private List<GridViewItem> gridViewItems;

    public GridAdapter(List<GridViewItem> gridViewItems) {
        this.gridViewItems = gridViewItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.gridview_item_layout, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindItem(gridViewItems.get(position));
    }

    @Override
    public int getItemCount() {
        return gridViewItems.size();
    }

    public void updateItemAt(int position, String time){
        gridViewItems.get(position).setTime(time);
        gridViewItems.get(position).setProgressBarVisibility(false);
        gridViewItems.get(position).setUpdated(true);
        notifyItemChanged(position);
    }

    public void addNewValues(List<GridViewItem> gridViewItems){
        this.gridViewItems.clear();
        this.gridViewItems = gridViewItems;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_view) TextView title;
        @BindView(R.id.time_view) TextView time;
        @BindView(R.id.progress_circular) ProgressBar progressBar;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindItem(GridViewItem item) {
            title.setText(item.getTitle());
            time.setText(item.getTime());

            final float alpha = item.getProgressBarVisibility() ? 1 : 0;
            final int duration = item.getProgressBarVisibility() ? GridViewItem.ANIMATION_LENGTH_LONG : GridViewItem.ANIMATION_LENGTH_SHORT;
            progressBar.animate().alpha(alpha).setDuration(duration).start();
        }
    }
}