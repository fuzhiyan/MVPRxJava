package com.mixky.mvprxjava.base;

/**
 * Created by Administrator on 2017/12/28.
 *
 * 引用泛型，V是视图，T是实体
 */

public class BasePresenter<V extends BaseView, T> implements IBaseRequestCallBack<T> {

    //P层会持有View的实例
    private BaseView baseView = null;

    public BasePresenter(BaseView baseView) {
        this.baseView = baseView;
    }

    //请求前
    @Override
    public void beforeRequest() {
        baseView.showProgress();
    }

    //请求错误
    @Override
    public void requestError(Throwable throwable) {
        //加载数据失败，传入异常，用于显示
        baseView.loadDataFail(throwable);
        //当请求错误的时候，隐藏dialog
        baseView.hideProgress();
    }

    //请求完成
    @Override
    public void requestComplete() {
        baseView.hideProgress();
    }

    //请求成功，传入回调
    @Override
    public void requestSuccess(T callBack) {
        baseView.loadDataSuccess(callBack);
    }
}
