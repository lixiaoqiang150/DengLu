package com.example.lxqq.denglu.utils;

import com.google.gson.Gson;

/**
 * Created by lenovo on 2017/11/28.
 */

public class GsonUlits {
    private static Gson instance;
    private GsonUlits(){

    }
    public static Gson getInstance(){
        if (instance==null){
            instance=new Gson();

        }
        return instance;
    }

}
