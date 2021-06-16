package com.example.noteapp.ui.home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.R;
import com.example.noteapp.model.TaskModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private final ArrayList<TaskModel> list = new ArrayList<>();
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasc_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addModel(TaskModel model){
        list.add(model);
        notifyDataSetChanged();
    }

   static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,  date;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_item);
//            desc = itemView.findViewById(R.id.desc_item);
            date = itemView.findViewById(R.id.txt_date);
        }
        public void onBind(TaskModel taskModel){
            title.setText(taskModel.getTitle());
//            desc.setText(taskModel.getDescription());
            date.setText(taskModel.getDate());
        }
    }
}
