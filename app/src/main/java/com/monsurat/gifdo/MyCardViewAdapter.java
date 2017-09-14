package com.monsurat.gifdo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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
//        holder.gifImageView.setImageResource(R.drawable.word_art);
        holder.descriptionTextView.setText(todos.get(position).getDescription());
        Glide.with(holder.gifImageView.getContext())
                .load(todos.get(position).getImageUrl())
                .into(holder.gifImageView);
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
