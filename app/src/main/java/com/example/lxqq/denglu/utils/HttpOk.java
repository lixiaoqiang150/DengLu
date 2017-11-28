package com.example.lxqq.denglu.utils;

import android.os.Handler;
import android.text.TextUtils;

import com.example.lxqq.denglu.callback.CallBack;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/11/10.
 */

public class HttpOk {
    private static Handler handler = new Handler();
    private static volatile HttpOk instance;//他是类
    private HttpOk(){

    }
    //单列
    public static HttpOk getInstance(){
        if(null==instance){
            synchronized (HttpOk.class){
                if (instance==null){
                    instance=new HttpOk();
                }
            }


        }
        return instance;
    }
    //get请求
    public void get(String url, Map<String,String> map, final CallBack callbace, final Class cls, final String  tag){
        if(TextUtils.isEmpty(url)){
            return;
        }
        //拼接字符串
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(url);//是否是url
//包含
        if (url.contains("?")){
            // 如果包含？并且？是最后一位，对应是2类型
            if (url.indexOf("?") == url.length() - 1) {

            } else {
                // 如果包含？并且？不是最后一位，对应是3类型
                stringBuffer.append("&");
            }
        } else {
            // 不包含？，对应的1类型
            stringBuffer.append("?");
        }
        //入口
        for (Map.Entry<String,String>entry:map.entrySet()){
            stringBuffer.append(entry.getKey())
                    .append("=")
                    .append(entry.getValue())
                    .append("&");
        }
        if(stringBuffer.indexOf("&")!=-1){
            stringBuffer.deleteCharAt(stringBuffer.lastIndexOf("&"));
            
        }
        
        //开始请求
        OkHttpClient client=new OkHttpClient();
        Request build = new Request.Builder().get().url(stringBuffer.toString()).build();
        Call call = client.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                    Object o;
                        if (TextUtils.isEmpty(string)){
                            o=null;
                        }else {
                            //一个gson解析类的方法调用
                            o= GsonUlits.getInstance().fromJson(string,cls);
                        }
                        callbace.onSuccess(tag,true);
                    }
                });

            }
        });



    }

}
