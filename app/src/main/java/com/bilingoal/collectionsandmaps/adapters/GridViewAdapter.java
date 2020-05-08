package com.bilingoal.collectionsandmaps.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bilingoal.collectionsandmaps.MainActivity;
import com.bilingoal.collectionsandmaps.R;
import com.bilingoal.collectionsandmaps.dto.GridViewItem;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    private final LayoutInflater layoutInflater;
    private final Context context;
    private List<GridViewItem> gridViewItems;

    public GridViewAdapter(Context context, List<GridViewItem> gridViewItems) {
        this.context = context;
        this.gridViewItems = gridViewItems;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return gridViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return gridViewItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.gridview_item_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(gridViewItems.get(position).getTitle());
        viewHolder.time.setText(gridViewItems.get(position).getTime());
        viewHolder.progressBar.setVisibility(gridViewItems.get(position).getProgressBarVisibility());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.title_view) TextView title;
        @BindView(R.id.time_view) TextView time;
        @BindView(R.id.progress_circular) ProgressBar progressBar;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
