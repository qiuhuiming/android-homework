package me.qiuhuiming.searchapp;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SearchInputView extends RelativeLayout {

    EditText input;
    TextView cancelView;

    OnTextChangedListener onTextChangedListener;

    public String getInputText() {
        return input.getText().toString();
    }

    public SearchInputView(Context context) {
        super(context);
        initView();
    }

    public SearchInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SearchInputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    //初始化View
    public void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_search, this);
        initInput();
        initCancelView();
    }

    private void initCancelView() {
        cancelView = findViewById(R.id.cancel);
        cancelView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                input.setText("");
            }
        });
    }

    private void initInput() {
        input = findViewById(R.id.input);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (onTextChangedListener != null) {
                    onTextChangedListener.onTextChangedCallback();
                }
            }
        });
    }

    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.onTextChangedListener = onTextChangedListener;
    }

    public interface OnTextChangedListener {
        void onTextChangedCallback();
    }

}
