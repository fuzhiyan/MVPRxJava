package com.mixky.mvprxjava.model;

import com.mixky.mvprxjava.base.IBaseRequestCallBack;

/**
 * Created by Administrator on 2017/12/28.
 */

public interface IModel<T> {

    //M层接口，请求数据
    void loadInfoData(IBaseRequestCallBack iBaseRequestCallBack);

    //解除绑定。
    void onUnsubscribe();

}
