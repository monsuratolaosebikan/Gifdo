package com.monsurat.gifdo;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;


public class MyCardViewAdapter extends RecyclerView.Adapter<MyCardViewAdapter.ViewHolder> {

    private ArrayList<ToDo> todos;
    private ToDoDAO dao;

    public MyCardViewAdapter(ArrayList<ToDo> todos) {
        this.todos = todos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView gifImageView;
        private TextView descriptionTextView;
        private CardView cardView;

        public ViewHolder(View view) {
            super(view);
            gifImageView = (ImageView) view.findViewById(R.id.gifImageView);
            descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
            cardView = (CardView) view.findViewById(R.id.cardView);

            dao = new ToDoDAO(view.getContext());

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.descriptionTextView.setText(todos.get(position).getDescription());

        Glide.with(holder.gifImageView.getContext())
                .load(todos.get(position).getImageUrl())
                .into(holder.gifImageView);

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                ToDo todo = todos.get(position);
                int id = todo.getId();
                dao.deleteTodo(id);
                todos.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }


}
