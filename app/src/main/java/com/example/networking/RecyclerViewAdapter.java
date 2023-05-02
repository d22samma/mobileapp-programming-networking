package com.example.networking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<RecyclerViewItem> mountains;
    private LayoutInflater layoutinflater;
    private OnClickListener onClicklistener;

    RecyclerViewAdapter(Context context, List<RecyclerViewItem> items, OnClickListener onClickListener) {
        this.layoutinflater = LayoutInflater.from(context);
        this.mountains = items;
        this.onClicklistener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutinflater.inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mountains.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
        }

        @Override
        public void onClick(View view) {
            onClicklistener.onClick(mountains.get(getAdapterPosition()));
        }
    }

    public interface OnClickListener {
        void onClick(RecyclerViewItem item);
    }
}