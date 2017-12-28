package com.mixky.mvprxjava.base;

/**
 * Created by Administrator on 2017/12/28.
 *
 * 视图基类
 */

public interface BaseView<T> {

    //显示加载框
    void showProgress();

    //隐藏加载框
    void hideProgress();

    //请求数据成功
    void loadDataSuccess(T data);

    //请求数据失败
    void loadDataFail(Throwable throwable);
}
