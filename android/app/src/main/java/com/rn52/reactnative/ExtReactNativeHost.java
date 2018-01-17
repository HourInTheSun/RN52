package com.rn52.reactnative;

import android.app.Application;

import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.rn52.BuildConfig;

import java.util.Arrays;
import java.util.List;

/**
 * description: 继承ReactNativeHost，方便管理dev模式和package.
 * author: menglei.
 * version: v270.
 * date: 2018/1/17.
 */
public class ExtReactNativeHost extends ReactNativeHost {
    public ExtReactNativeHost(Application application) {
        super(application);
    }

    @Override
    public boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage()
        );
    }

    @Override
    protected String getJSMainModuleName() {
        return "index"; //指定server入口文件
    }
}
