package com.rn52.activity;

import android.os.Bundle;
import android.util.Log;

import com.rn52.reactnative.ExtReactActivity;

public class ReactIndexActivity extends ExtReactActivity {

    private Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = initBundle();
        bundle.putString("intent", "exist");
        bundle.putString("nasssme", "activity");
        bundle.putString("tab", "props");
        bundle.putString("ut", "dsad");
    }

    @Override
    protected String getMainComponentName() {
        return "RN52";
    }

    @Override
    protected Bundle getLaunchOptions() {
        return initBundle(); //mBundle必须存在，才能传值
    }

    private Bundle initBundle() {
        if (mBundle == null) mBundle = new Bundle();
        return mBundle;
    }
}
