package me.qiuhuiming.searchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> data = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);

        for (int i = 0; i < 100; i++) {
            data.add(String.format("item %s", i + ""));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        SearchAdapter searchAdapter = new SearchAdapter(data);
//        searchListAdapter.setItemList(data);
        recyclerView.setAdapter(searchAdapter);




    }
}