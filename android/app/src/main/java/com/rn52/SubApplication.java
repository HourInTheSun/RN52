package com.rn52;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.rn52.reactnative.ExtReactNativeHost;

import java.lang.ref.WeakReference;

/**
 * description: .
 * author: menglei.
 * version: v231.
 * date: 2017/9/18.
 */
public class SubApplication implements ReactApplication{
    private static SubApplication mInstance;
    private WeakReference<Application> appReference;
    private ReactNativeHost mReactNativeHost;

    private SubApplication() {
    }

    public static SubApplication getInstance() {
        if (mInstance == null) {
            synchronized (SubApplication.class) {
                if (mInstance == null) {
                    mInstance = new SubApplication();
                }
            }
        }
        return mInstance;
    }

    public void init(Application application) {
        appReference = new WeakReference<>(application);
        mReactNativeHost = new ExtReactNativeHost(application);
    }

    public Application getApplication() {
        return appReference.get();
    }

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }
}
