package com.mixky.mvprxjava.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2017/12/28.
 * 网络链接工具类，判断网络状态等
 */

public class NetUtil {
    private NetUtil() {
    }

    //判断网络是否链接
    public static boolean isNetworkConnected() {
        if (AppContextUtil.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) AppContextUtil.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    //判断是wifi
    public static boolean isWifiConnected() {
        if (AppContextUtil.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) AppContextUtil.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    //判断是移动网络
    public static boolean isMobileConnected() {
        if (AppContextUtil.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) AppContextUtil.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    //判断链接类型
    public static int getConnectedType() {
        if (AppContextUtil.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) AppContextUtil.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType();
            }
        }
        return -1;
    }

}
