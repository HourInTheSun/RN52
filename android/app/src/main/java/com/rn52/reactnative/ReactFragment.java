package com.rn52.reactnative;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.rn52.SubApplication;

/**
 * description: 仿ReactActivity实现的ReactFragment，用来加载RNView.要求所关联的activity在onNewIntent、onBackPressed、onKeyUp调用fragment相关方法。
 * author: menglei.
 * version: v270.
 * date: 2018/1/17.
 */
public class ReactFragment extends Fragment implements DefaultHardwareBackBtnHandler {
    private Context mContext;
    private ReactRootView mReactRootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mReactRootView = new ReactRootView(mContext);
        return mReactRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getMainComponentName() != null) {
            loadApp(getMainComponentName());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onHostPause(getPlainActivity());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onHostResume(
                    getPlainActivity(),
                    this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mReactRootView != null) {
            mReactRootView.unmountReactApplication();
            mReactRootView = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onHostDestroy(getPlainActivity());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager()
                    .onActivityResult(getPlainActivity(), requestCode, resultCode, data);
        }
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (getReactNativeHost().hasInstance() && getReactNativeHost().getUseDeveloperSupport()) {
            if (keyCode == KeyEvent.KEYCODE_MENU) {
                getReactNativeHost().getReactInstanceManager().showDevOptionsDialog();
                return true;
            }
        }
        return false;
    }

    public boolean onBackPressed() {
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onBackPressed();
            return true;
        }
        return false;
    }

    public boolean onNewIntent(Intent intent) {
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onNewIntent(intent);
            return true;
        }
        return false;
    }

    protected String getMainComponentName() {
        return null;
    }

    protected Bundle getLaunchOptions() {
        return null;
    }

    protected ReactNativeHost getReactNativeHost() {
        return SubApplication.getInstance().getReactNativeHost();
    }

    protected final ReactInstanceManager getReactInstanceManager() {
        return getReactNativeHost().getReactInstanceManager();
    }

    protected final void loadApp(String appKey) {
        mReactRootView.startReactApplication(
                getReactInstanceManager(),
                appKey,
                getLaunchOptions());
    }

    private Activity getPlainActivity() {
        return ((Activity) mContext);
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        getPlainActivity().finish();
    }
}
