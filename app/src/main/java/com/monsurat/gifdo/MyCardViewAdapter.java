package com.monsurat.gifdo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MyCardViewAdapter extends RecyclerView.Adapter<MyCardViewAdapter.ViewHolder> {

    private ArrayList<ToDo> todos;

    public MyCardViewAdapter(ArrayList<ToDo> todos) {
        this.todos = todos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.gifImageView.setImageResource(R.drawable.ic_check_black_24dp);
        holder.descriptionTextView.setText(todos.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView gifImageView;
        public TextView descriptionTextView;

        public ViewHolder(View view) {
            super(view);
            gifImageView = (ImageView) view.findViewById(R.id.gifImageView);
            descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
        }
    }
}
