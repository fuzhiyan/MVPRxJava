package com.mixky.mvprxjava.presenter;

import android.content.Context;

import com.mixky.mvprxjava.base.BasePresenter;
import com.mixky.mvprxjava.bean.GoodsBean;
import com.mixky.mvprxjava.bean.InfoBean;
import com.mixky.mvprxjava.model.InfoModel;
import com.mixky.mvprxjava.view.IView;

/**
 * Created by Administrator on 2017/12/28.
 */

public class InfoPresenterImp extends BasePresenter<IView, GoodsBean> implements InfoPresenter {

    private InfoModel infoModel;
    private Context context;

    public InfoPresenterImp(IView iView, Context context) {
        super(iView);
        this.context = context;
        this.infoModel = new InfoModel(context);
    }

    @Override
    public void loadInfoData() {
        //持有Model的实例，当请求数据的时候，调用Model的请求数据的方法
        infoModel.loadInfoData(this);

    }

    @Override
    public void onUnsubscribe() {
        //注销
        infoModel.onUnsubscribe();
    }
}
