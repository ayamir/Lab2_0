package com.example.lab2_0.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2_0.R;
import com.example.lab2_0.bean.TableRow;

import java.util.List;

public class TableRowAdapter extends RecyclerView.Adapter<TableRowAdapter.RowViewHolder> {
    private final List<TableRow> tableRows;
    private int textSize;

    public TableRowAdapter(List<TableRow> tableRows) {
        this.tableRows = tableRows;
    }

    public static class RowViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvName;
        TextView tvGender;
        TextView tvDepartment;
        TextView tvSalary;

        public RowViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvGender = itemView.findViewById(R.id.tv_gender);
            tvDepartment = itemView.findViewById(R.id.tv_department);
            tvSalary = itemView.findViewById(R.id.tv_salary);
        }
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_row_layout, parent, false);
        return new RowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        TableRow tableRow = tableRows.get(position);
        holder.tvId.setText(tableRow.getId());
        holder.tvName.setText(tableRow.getName());
        holder.tvGender.setText(tableRow.getGender());
        holder.tvDepartment.setText(tableRow.getDepartment());
        holder.tvDepartment.setText(tableRow.getSalary());
    }

    @Override
    public int getItemCount() {
        return tableRows.size();
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        notifyDataSetChanged();
    }

    public void insert(TableRow tableRow) {
        tableRows.add(tableRow);
        notifyItemChanged(tableRows.size() + 1);
    }

    public void delete(int position) {
        tableRows.remove(position);
        notifyItemRemoved(position);
    }

    public void update(int position, TableRow other) {
        TableRow tableRow = tableRows.get(position);
        tableRow.cover(other);
        notifyItemChanged(position);
    }
}
