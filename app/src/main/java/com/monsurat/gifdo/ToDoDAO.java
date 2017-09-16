package com.monsurat.gifdo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by monsurat on 9/15/17.
 */

public class ToDoDAO {

    private SQLiteDatabase db;
    private TodoDatabaseHelper dbHelper;

    public ToDoDAO(Context context) {
        dbHelper = new TodoDatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void createTodo(String description, String gifUrl) {
        Log.d("new todo", description + " " + gifUrl);
        ContentValues values = new ContentValues();
        values.put("description", description);
        values.put("gifUrl", gifUrl);
        values.put("isDone", 0);
        Log.d("todo values", values.toString());
        db.insert("todos", null, values);
    }

    public void deleteTodo(int id) {
        db.delete("todos", "_id = " + id, null);
    }

    public void close() {
        db.close();
    }

    public ArrayList<ToDo> getTodos() {

        ArrayList<ToDo> todos = new ArrayList<>();

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
        return todos;
    }
}
