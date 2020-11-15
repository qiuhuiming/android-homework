package me.qiuhuiming.searchapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class SearchView extends RelativeLayout {

    public SearchView(Context context) {
        super(context);
        initView();
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_search, this);
    }

}
