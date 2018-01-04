package com.mixky.mvprxjava.base;

import com.mixky.mvprxjava.bean.GoodsBean;
import com.mixky.mvprxjava.bean.InfoBean;
import com.mixky.mvprxjava.utils.Constant;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @GET("")
    Observable<InfoBean> getData();

    //http://apis.juhe.cn/cook/query.php?menu=西红柿&key=4d0f828dee12c5b58dfa3b5a8463a5d6
    @FormUrlEncoded
    @POST("cook/query.php")
    Observable<GoodsBean> getUserInfo(@Field("menu") String menu, @Field("key") String key);
}
