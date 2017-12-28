package com.mixky.mvprxjava.presenter;

/**
 * Created by Administrator on 2017/12/28.
 * P层接口，也是一个请求数据的方法，一个注销的方法
 */

public interface InfoPresenter {

    void loadInfoData();

    void onUnsubscribe();
}
