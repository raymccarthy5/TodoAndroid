package com.example.todoandroid.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoandroid.Model.TodoItem;
import com.example.todoandroid.R;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private List<TodoItem> todoItems;

    public TodoAdapter(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TodoItem todoItem = todoItems.get(position);
        holder.titleTextView.setText(todoItem.getTitle());
        holder.descriptionTextView.setText(todoItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return todoItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView descriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.todo_item_title);
            descriptionTextView = itemView.findViewById(R.id.todo_item_description);
        }
    }
}




