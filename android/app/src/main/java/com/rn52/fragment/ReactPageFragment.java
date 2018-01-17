package com.rn52.fragment;

import android.os.Bundle;
import android.util.Log;

import com.rn52.reactnative.ReactFragment;

/**
 * description: .
 * author: menglei.
 * version: v270.
 * date: 2018/1/17.
 */
public class ReactPageFragment extends ReactFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("ReactIndexActivity-->f", "onCreate: ");
    }

    @Override
    protected String getMainComponentName() {
        return "RN52";
    }

    @Override
    protected Bundle getLaunchOptions() {
        Log.d("ReactIndexActivity-->f", "getLaunchOptions: ");
        Bundle bundle = new Bundle();
        bundle.putString("name", "fragment");
        bundle.putString("tab", "im");
        return bundle;
    }
}
