package com.rn52.reactnative;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactNativeHost;
import com.rn52.SubApplication;

import javax.annotation.Nullable;

/**
 * description: 继承ReactActivityDelegate并重写getReactNativeHost()，通过SubApplication获取ExtReactNativeHost实例.添加setLaunchOptions方法
 * author: menglei.
 * version: v270.
 * date: 2018/1/17.
 */
public class ExtReactActivityDelegate extends ReactActivityDelegate {
    private Bundle mLaunchOptions;

    public ExtReactActivityDelegate(Activity activity, @Nullable String mainComponentName) {
        super(activity, mainComponentName);
    }

    @Override
    protected ReactNativeHost getReactNativeHost() {
//        return super.getReactNativeHost();
        return SubApplication.getInstance().getReactNativeHost();
    }

    public void setLaunchOptions(Bundle launchOptions) {
        mLaunchOptions = launchOptions;
    }

    @Nullable
    @Override
    protected Bundle getLaunchOptions() {
        return mLaunchOptions;
    }
}
