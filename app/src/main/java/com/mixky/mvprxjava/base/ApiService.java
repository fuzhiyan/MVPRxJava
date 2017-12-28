package com.mixky.mvprxjava.base;

import com.mixky.mvprxjava.bean.InfoBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2017/12/28.
 */

public interface ApiService {
//    http://pic.sogou.com/pics/channel/getAllRecomPicByTag.jsp?category=%E7%BE%8E%E5%A5%B3&tag=%E5%85%A8%E9%83%A8&start=15&len=15
    //http://pic.sogou.com/pics/channel/getAllRecomPicByTag.jsp?category=%E7%BE%8E%E5%A5%B3&tag=%E5%85%A8%E9%83%A8&start=15&len=15

    //retrofit的网络请求方法，传入网址。
    @GET
    Observable<InfoBean> loadInfoData(@Url String user);
}
