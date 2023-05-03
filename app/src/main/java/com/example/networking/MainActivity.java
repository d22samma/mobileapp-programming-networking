package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private ArrayList<Mountain> mountains = new ArrayList<Mountain>();
    private RecyclerViewAdapter adapter;


    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // type cast from ArrayList<Mountain> to ArrayList<RecyclerViewItem>
        ArrayList<RecyclerViewItem> items = new ArrayList<>();
        for(Mountain m : mountains){
            items.add(new RecyclerViewItem(m.getName()));
            Log.d("ITEMS_IN_MOUNTAIN", "_" + items.get(items.size()-1).getTitle());
        }
        Log.d("ITEMS_IN_MOUNTAIN_SIZE", "_" + items.size());
        adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        new JsonFile(this, this).execute(JSON_FILE);
    }


    @Override
    public void onPostExecute(String json) {
        Log.d( "==>", json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();

        ArrayList<Mountain> data = gson.fromJson(json, type);


        RecyclerView view = findViewById(R.id.Recyclerview);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
        mountains.addAll(data);
        // type cast from ArrayList<Mountain> to ArrayList<RecyclerViewItem>
        ArrayList<RecyclerViewItem> items = new ArrayList<>();
        for(Mountain m : mountains){
            items.add(new RecyclerViewItem(m.getName()));
            Log.d("ITEMS_IN_MOUNTAIN", "_" + items.get(items.size()-1).getTitle());
        }
        adapter.refreshItems(items);
        adapter.notifyDataSetChanged();
    }
}
