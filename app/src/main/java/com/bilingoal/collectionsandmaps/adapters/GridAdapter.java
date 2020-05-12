package com.bilingoal.collectionsandmaps.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;
import java.util.List;

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
        GridViewItem item = gridViewItems.get(position);
        holder.bindItem(item);
        holder.animate(item);
    }

    @Override
    public int getItemCount() {
        return gridViewItems.size();
    }

    public void updateItemAt(int position, String time){
        gridViewItems.get(position).setTime(time);
        gridViewItems.get(position).setProgressBarVisibility(View.INVISIBLE);
        gridViewItems.get(position).setUpdated(true);
        notifyItemChanged(position);
    }

    public void addNewValues(List<GridViewItem> gridViewItems){
        this.gridViewItems.clear();
        this.gridViewItems = gridViewItems;
        notifyDataSetChanged();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_view) TextView title;
        @BindView(R.id.time_view) TextView time;
        @BindView(R.id.progress_circular) ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindItem(GridViewItem item){
            title.setText(item.getTitle());
            time.setText(item.getTime());
            progressBar.setVisibility(item.getProgressBarVisibility());
        }

        public void animate(GridViewItem item){
            if(item.isUpdated() && progressBar.getVisibility() == View.VISIBLE){
                progressBar.animate().alpha(0).setDuration(GridViewItem.ANIMATION_LENGTH_SHORT);
            } else if(!item.isUpdated() && progressBar.getVisibility() == View.VISIBLE){
                progressBar.setAlpha(0);
                progressBar.animate().alpha(1).setDuration(GridViewItem.ANIMATION_LENGTH_LONG);
            }
        }
    }
}