package com.mixky.mvprxjava.base;

/**
 * Created by Administrator on 2017/12/28.
 * 数据回调接口基类
 */

public interface IBaseRequestCallBack<T> {

    /**
     * @descriptoin 请求之前的操作
     */
    void beforeRequest();

    /**
     * @param throwable 异常类型
     * @descriptoin 请求异常
     */
    void requestError(Throwable throwable);

    /**
     * @descriptoin 请求完成
     */
    void requestComplete();

    /**
     * @param callBack 根据业务返回相应的数据
     * @descriptoin 请求成功
     */
    void requestSuccess(T callBack);

}
