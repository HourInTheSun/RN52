package com.rn52.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rn52.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnRnActivity;
    private Button mBtnRnFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mBtnRnActivity.setOnClickListener(this);
        mBtnRnFragment.setOnClickListener(this);
    }

    private void initView() {
        mBtnRnActivity = (Button) findViewById(R.id.btn_rn_activity);
        mBtnRnFragment = (Button) findViewById(R.id.btn_rn_fragment);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_rn_activity:
                startActivity(new Intent(this, ReactIndexActivity.class));
                break;
            case R.id.btn_rn_fragment:
                startActivity(new Intent(this, ReactFragmentActivity.class));
                break;
        }
    }
}
