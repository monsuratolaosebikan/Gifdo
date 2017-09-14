package com.monsurat.gifdo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AddToDo extends AppCompatActivity {
    public TextView taskTextView;
    private String gifUrl;
    private String task;
    private SQLiteDatabase db;
    private TodoDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        taskTextView = (TextView) findViewById(R.id.taskTextView);
        dbHelper = new TodoDatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        FloatingActionButton confirmFab = (FloatingActionButton) findViewById(R.id.confirmFab);
        confirmFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = taskTextView.getText().toString();
                getGifUrl(task);
            }
        });
    }

    public void createTodo() {
        Log.d("new todo", task + " " + gifUrl);
        ContentValues values = new ContentValues();
        values.put("description", task);
        values.put("gifUrl", gifUrl);
         values.put("isDone", 0);
        Log.d("todo values", values.toString());
        db.insert("todos", null, values);
        db.close();
        this.finish();
    }

    public void getGifUrl(String text) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String API_KEY = "a3e117359f064f7b9bf435e5db5727ca";
        String search = "";

        //encode the task text
        try {
            search = URLEncoder.encode(text, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            Log.e("Add to do", "encoding error");
        }

        String url = "http://api.giphy.com/v1/gifs/translate?s=" + search + "&api_key=" + API_KEY;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject data = response.getJSONObject("data")
                                                      .getJSONObject("images")
                                                      .getJSONObject("fixed_width");

                            gifUrl = data.getString("url");
                            Log.d("SUCCESS", gifUrl);
                            createTodo();

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Add to do", "error getting gif url");
                        Log.e("Add to do", error.toString());
                    }
                });

        queue.add(jsonObjectRequest);
    }
}
