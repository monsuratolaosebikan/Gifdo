package com.monsurat.gifdo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;


public class CardFragment extends Fragment {

    ArrayList<ToDo> todos = new ArrayList<>();
    String Todos[] = {"Chichen Itza","Christ the Redeemer","Great Wall of China","Machu Picchu","Petra","Taj Mahal","Colosseum"};
//    private SQLiteDatabase db;
//    private TodoDatabaseHelper dbHelper;

    public CardFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        dbHelper = new TodoDatabaseHelper(getActivity());
//        db = dbHelper.getReadableDatabase();
        initializeList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new MyCardViewAdapter(todos));
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onStart() {
        super.onStart();
        initializeList();
    }

    public void initializeList() {
        TodoDatabaseHelper dbHelper = new TodoDatabaseHelper(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        todos.clear();
        String[] columns = new String[] {"_id", "description", "gifUrl", "isDone"};

        Cursor cursor = db.query("todos", columns, null, null, null, null, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {

            ToDo t = new ToDo(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            todos.add(t);
            cursor.moveToNext();
        }

        cursor.close();
        db.close();

    }
}
