package me.qiuhuiming.searchapp;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import static android.content.ContentValues.TAG;

public class SearchItemViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public SearchItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.itemText);
    }

    public void setItemText(String text) {
        this.textView.setText(text);
        Log.d(TAG, "setItemText: " + this.textView.getText());
    }
}
