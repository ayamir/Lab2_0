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

public class TableRowAdapter extends RecyclerView.Adapter<TableRowAdapter.TableRowViewHolder> {
    private final int INVALID = -1;
    private final List<TableRow> tableRows;
    private int fontSize = INVALID;
    private int fontColor = INVALID;

    public TableRowAdapter(List<TableRow> tableRows) {
        this.tableRows = tableRows;
    }

    public TableRowAdapter(List<TableRow> tableRows, int fontSize, int fontColor) {
        this.tableRows = tableRows;
        this.fontSize = fontSize;
        this.fontColor = fontColor;
    }

    @NonNull
    @Override
    public TableRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_row_layout, parent, false);
        return new TableRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableRowViewHolder holder, int position) {
        TableRow tableRow = tableRows.get(position);
        holder.tvId.setText(formatDisplay(tableRow.getId()));
        holder.tvName.setText(formatDisplay(tableRow.getName()));
        holder.tvGender.setText(formatDisplay(tableRow.getGender()));
        holder.tvDepartment.setText(formatDisplay(tableRow.getDepartment()));
        holder.tvSalary.setText(formatDisplay(tableRow.getSalary()));

        if (fontSize != INVALID) {
            holder.tvId.setTextSize(fontSize);
            holder.tvName.setTextSize(fontSize);
            holder.tvGender.setTextSize(fontSize);
            holder.tvDepartment.setTextSize(fontSize);
            holder.tvSalary.setTextSize(fontSize);
        }

        if (fontColor != INVALID) {
            holder.tvId.setTextColor(fontColor);
            holder.tvName.setTextColor(fontColor);
            holder.tvGender.setTextColor(fontColor);
            holder.tvDepartment.setTextColor(fontColor);
            holder.tvSalary.setTextColor(fontColor);
        }
    }

    private String formatDisplay(String string) {
        String out;
        if (string.length() == 0) {
            out = "              ";
        } else if (string.length() < 7) {
            out = string + "    ";
        } else {
            out = string;
        }
        return out;
    }

    @Override
    public int getItemCount() {
        return tableRows.size();
    }

    public static class TableRowViewHolder extends RecyclerView.ViewHolder {
        TextView tvId;
        TextView tvName;
        TextView tvGender;
        TextView tvDepartment;
        TextView tvSalary;

        public TableRowViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvGender = itemView.findViewById(R.id.tv_gender);
            tvDepartment = itemView.findViewById(R.id.tv_department);
            tvSalary = itemView.findViewById(R.id.tv_salary);
        }
    }
}
