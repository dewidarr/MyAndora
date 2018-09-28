package com.example.dewid.myandora.request;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public interface IRequestContract {

    interface IRequestView{

        void showAlert(String message);
    }

    interface IRequestPresenter{

        void getRequests(Context context, RecyclerView recyclerView, int comp_ID);
        void onDestroy();
    }

    interface IRequestModel{

        interface onRequestFinishedListener{

            void onSuccess();
            void onFailure(String message);
        }

        List<Request> downloadRequests(Context context, onRequestFinishedListener listener, int comp_ID);
    }
}
