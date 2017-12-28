package com.mixky.mvprxjava.base;

import com.mixky.mvprxjava.utils.RetrofitManager;

/**
 * Created by Administrator on 2017/12/28.
 */

public class BaseModel {
    //retrofit请求数据的管理类
    public RetrofitManager retrofitManager;

    public BaseModel() {
        retrofitManager = RetrofitManager.builder();
    }
}
