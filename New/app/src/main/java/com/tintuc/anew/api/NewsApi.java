package com.tintuc.anew.api;

import android.content.Context;

import com.tintuc.anew.api.base.BaseOkHttp;
import com.tintuc.anew.com.tintuc.interfaces.HttpCallback;
import com.tintuc.anew.util.Define;
import com.tintuc.anew.util.LogUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class NewsApi {
    public static void apiEx(Context ctx, int i, int i1, int i2, HttpCallback httpCallback){
//        b1:
        BaseOkHttp baseOkHttp = new BaseOkHttp.Builder()
                                                .setHttpCallback(httpCallback)
                                                .setContext(ctx)
                                                .setWantShowDialog(true)
                                                .setWantDialogCancelable(true).setTitle(".......")
                                                .setMessage("Loadding.....").build();
//        b2:
        OkHttpClient okHttpClient =BaseOkHttp.getOkHttpClient();
//        b3
        Request request = new Request.Builder()
                .url(Define.API_EXAMPLE)
                .build();
//        b4
        okHttpClient.newCall(request).enqueue(baseOkHttp);

    }
    //
    public static void getListPost(Context ctx,int categoryId,int limit,int offset ,HttpCallback httpCallback){
//        b1:
        BaseOkHttp baseOkHttp = new BaseOkHttp.Builder().setHttpCallback(httpCallback)
                .setContext(ctx)
                .setWantShowDialog(true)
                .setWantDialogCancelable(true).setTitle(".......")
                .setMessage("Loadding.....").build();
//        b2:
        OkHttpClient okHttpClient =BaseOkHttp.getOkHttpClient();
//        ?category_id=3&?limit=10&offset=0
        String url=Define.API__GET_LIST_POST +"?category_id=3&?limit=10&offset=0" +categoryId+ "&limit"+ limit +"offset"+offset ;
        LogUtil.d("getListPost",url);
//        b3
        Request request = new Request.Builder()
                .url(Define.API_EXAMPLE)
                .build();
//        b4
        okHttpClient.newCall(request).enqueue(baseOkHttp);

    }
    //
    public static void getPostDetail(Context ctx, int postId, HttpCallback httpCallback){
//        b1:
        BaseOkHttp baseOkHttp = new BaseOkHttp.Builder()
                .setHttpCallback(httpCallback)
                .setContext(ctx)
                .setWantShowDialog(true)
                .setWantDialogCancelable(true).setTitle(".......")
                .setMessage("Loadding.....").build();
//        b2:
        OkHttpClient okHttpClient =BaseOkHttp.getOkHttpClient();
//       ?post_id=2
        String url =Define.API_GET_LIST_DETAIL +"?post_id" + postId;
//        b3
        Request request = new Request.Builder()
                .url(url)
                .build();
//        b4
        okHttpClient.newCall(request).enqueue(baseOkHttp);

    }

}
