package com.example.lab2_0.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TableRowAdapter extends RecyclerView.Adapter<TableRowAdapter.RowViewHolder>
{

    public static class RowViewHolder extends RecyclerView.ViewHolder {

        public RowViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
