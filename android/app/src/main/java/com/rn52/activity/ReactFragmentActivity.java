package com.rn52.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.rn52.R;
import com.rn52.fragment.ReactPageFragment;

public class ReactFragmentActivity extends AppCompatActivity  {

    private ReactPageFragment mReactPageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_react_fragment);
        mReactPageFragment = new ReactPageFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_rn_container, mReactPageFragment)
                .commit();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mReactPageFragment.onNewIntent(intent);
    }

    @Override
    public void onBackPressed() {
        if (!mReactPageFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return mReactPageFragment.onKeyUp(keyCode, event) || super.onKeyUp(keyCode, event);
    }
}
