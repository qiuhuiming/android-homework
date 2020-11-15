package me.qiuhuiming.searchapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<SearchItemViewHolder> {

    List<String> itemList = new ArrayList<>();

    public SearchAdapter(List<String> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        Log.d("SearchListAdapter", "SearchListAdapter(List<String>): ");
    }

    @NonNull
    @Override
    public SearchItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("SearchListAdapter", "onCreateViewHolder: ");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_search_item, parent, false);
        return new SearchItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchItemViewHolder holder, int position) {
        Log.d("SearchListAdapter", "onBindViewHolder: " + position);
        holder.setItemText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d("SearchListAdapter", "getItemCount: " + itemList.size());
        return itemList.size();
    }

    public void setItemList(List<String> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        Log.d("SearchListAdapter", "setItemList: " + this.itemList);
        notifyDataSetChanged();
    }
}
