package com.mixky.mvprxjava.model;

import android.content.Context;

import com.mixky.mvprxjava.base.ApiService;
import com.mixky.mvprxjava.base.BaseModel;
import com.mixky.mvprxjava.base.IBaseRequestCallBack;
import com.mixky.mvprxjava.bean.GoodsBean;
import com.mixky.mvprxjava.bean.InfoBean;
import com.mixky.mvprxjava.utils.Constant;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2017/12/28.
 */

public class InfoModel extends BaseModel implements IModel<GoodsBean> {
    private Context context = null;
    private ApiService apiService;
    private CompositeSubscription mCompositeSubscription;

    public InfoModel(Context context) {
        super();
        this.context = context;
        apiService = retrofitManager.getService();
        mCompositeSubscription = new CompositeSubscription();
    }

    //重写的请求数据的方法，传入回调。
    @Override
    public void loadInfoData(final IBaseRequestCallBack iBaseRequestCallBack) {

        //拼接参数。(拼接网址，也可以使用动态传参)
       /* StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Constant.BASE_URL)
                .append("pics/channel/")
                .append("getAllRecomPicByTag.jsp?")
                .append("category=美女")
                .append("&tag=全部")
                .append("&start=15")
                .append("&len=15");
        System.out.println(stringBuffer.toString());*/
        //将subscribe添加到subscription，用于注销subscribe
        mCompositeSubscription.add((Subscription) apiService.getUserInfo("西红柿","4d0f828dee12c5b58dfa3b5a8463a5d6")
                .observeOn(AndroidSchedulers.mainThread())//指定事件消费线程
                .subscribeOn(Schedulers.io()) //指定 subscribe() 发生在 IO 线程
                .subscribe(new Subscriber<GoodsBean>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        //onStart它总是在 subscribe 所发生的线程被调用 ,如果你的subscribe不是主线程，则会出错，则需要指定线程;
                        iBaseRequestCallBack.beforeRequest();
                        iBaseRequestCallBack.requestComplete();
                    }

                    @Override
                    public void onCompleted() {
                        //回调接口：请求已完成，可以隐藏progress
                        iBaseRequestCallBack.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        //回调接口：请求异常
                        iBaseRequestCallBack.requestError(e);
                    }

                    @Override
                    public void onNext(GoodsBean goodsBean) {
                        //回调接口：请求成功，获取实体类对象
                        iBaseRequestCallBack.requestSuccess(goodsBean);
                        iBaseRequestCallBack.requestSuccess(goodsBean);
                    }
                }));
    }

    @Override
    public void onUnsubscribe() {

        //判断状态
        if (mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription.clear();  //注销
            mCompositeSubscription.unsubscribe();

        }
    }
}
