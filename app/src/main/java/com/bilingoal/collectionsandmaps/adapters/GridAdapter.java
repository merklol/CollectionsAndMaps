package com.bilingoal.collectionsandmaps.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bilingoal.collectionsandmaps.MainActivity;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private List<GridViewItem> gridViewItems;
    private final Context context;

    public GridAdapter(Context context, List<GridViewItem> gridViewItems) {
        this.context = context;
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
        holder.title.setText(gridViewItems.get(position).getTitle());
        holder.time.setText(gridViewItems.get(position).getTime());
        holder.progressBar.setVisibility(gridViewItems.get(position).getProgressBarVisibility());
    }

    @Override
    public int getItemCount() {
        return gridViewItems.size();
    }

    public void updateItemAt(int position, String time){
        ((MainActivity)context).runOnUiThread(() ->{
            gridViewItems.get(position).setTime(time);
            gridViewItems.get(position).setProgressBarVisibility(View.GONE);
            notifyDataSetChanged();
        });
    }

    public void addNewValues(List<GridViewItem> gridViewItems){
        this.gridViewItems.clear();
        this.gridViewItems = gridViewItems;
        notifyDataSetChanged();
    }

    public List<String> getResults(){
        List<String> arrayList = new ArrayList<>();
        gridViewItems.forEach(item -> arrayList.add(item.getTime()));
        return arrayList;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_view) TextView title;
        @BindView(R.id.time_view) TextView time;
        @BindView(R.id.progress_circular) ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
