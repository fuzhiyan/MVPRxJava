package com.mixky.mvprxjava.base;

import android.app.Fragment;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2017/12/29.
 */

public abstract class BaseFragment extends Fragment {
    private CompositeSubscription compositeSubscription;

    //添加Subscription
    public void addSubscription(Subscription subscription) {
        if (compositeSubscription == null) {
            this.compositeSubscription = new CompositeSubscription();
        }
        this.compositeSubscription.add(subscription);
    }

    //销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
    }
}
