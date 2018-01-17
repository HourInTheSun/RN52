package com.rn52.reactnative;

import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;

import javax.annotation.Nullable;

/**
 * description: 继承ReactActivity,重写createReactActivityDelegate()方法返回ExtReactActivityDelegate.添加getLaunchOptions()方法
 * author: menglei.
 * version: v270.
 * date: 2018/1/17.
 */
public class ExtReactActivity extends ReactActivity {
    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
//        return super.createReactActivityDelegate();
        ExtReactActivityDelegate delegate = new ExtReactActivityDelegate(this, getMainComponentName());
        delegate.setLaunchOptions(getLaunchOptions());
        return delegate;
    }

    protected Bundle getLaunchOptions() {
        return null;
    }
}
