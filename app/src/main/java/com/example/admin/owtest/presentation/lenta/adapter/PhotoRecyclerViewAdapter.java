package com.example.admin.owtest.presentation.lenta.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.owtest.R;

public class PhotoRecyclerViewAdapter extends RecyclerView.Adapter<PhotoRecyclerViewAdapter.PhotoViewHolder> {

    public PhotoAdapterListener listener;

    public PhotoRecyclerViewAdapter(PhotoAdapterListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_photo, parent, false);

        return new PhotoViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 100;
    }

    public interface PhotoAdapterListener {
        void onClick(int position);
    }

    static class PhotoViewHolder extends RecyclerView.ViewHolder {

        public PhotoViewHolder(View itemView, PhotoAdapterListener listener) {
            super(itemView);
            itemView.setOnClickListener(v -> listener.onClick(getAdapterPosition()));
        }
    }
}
