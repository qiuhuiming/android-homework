package me.qiuhuiming.searchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> totalData = new ArrayList<>();
    List<String> displayedData = new ArrayList<>();
    RecyclerView recyclerView;
    String inputText;
    SearchInputView searchInputView;
    LinearLayoutManager layoutManager;
    SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSearchInputView();

        initTotalData();

        initRecycleView();
    }

    private void initSearchInputView() {
        searchInputView = findViewById(R.id.searchInputView);
        searchInputView.setOnTextChangedListener(new SearchInputView.OnTextChangedListener() {
            @Override
            public void onTextChangedCallback() {
                inputText = searchInputView.getInputText();
                Log.d("MainActivity", "onTextChangedCallback: " + inputText);
                updateDisplayedData();
                searchAdapter.setItemList(displayedData);
            }
        });
    }

    private void initRecycleView() {
        recyclerView = findViewById(R.id.list);

        //配置layoutManager和searchAdapter
        layoutManager = new LinearLayoutManager(this);
        searchAdapter = new SearchAdapter(totalData);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(searchAdapter);
    }

    public void initTotalData() {
        for (int i = 0; i < 100; i++) {
            totalData.add("item" + i);
        }
    }

    //根据inputText更新展示的数据
    public void updateDisplayedData() {
        displayedData.clear();
        for (int i = 0; i < totalData.size(); i++) {
            if (totalData.get(i).contains(inputText)) {
                displayedData.add(totalData.get(i));
            }
        }
    }

}