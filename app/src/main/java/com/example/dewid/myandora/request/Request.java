package com.example.dewid.myandora.request;

import android.content.Context;
import android.widget.ImageView;

public class Request {
    String saleprcent;
    Integer menpakage;
    int user_id;
    Context context;

    public Request(String name,Integer kind, int user_id, Context context) {
        this.saleprcent = name;
        this.menpakage = kind;
        this.user_id = user_id;
        this.context = context;
    }

    public String getSaleprcent() {
        return saleprcent;
    }

    public void setSaleprcent(String saleprcent) {
        this.saleprcent = saleprcent;
    }

    public Integer getMenpakage() {
        return menpakage;
    }
    public void setMenpakage(Integer menpakage) {
        this.menpakage = menpakage;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}




