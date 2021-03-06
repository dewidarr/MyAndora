package com.example.dewid.myandora.request;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class RequestPresenter implements IRequestContract.IRequestPresenter,IRequestContract.IRequestModel.onRequestFinishedListener {

    IRequestContract.IRequestView mIRequestView;
    IRequestContract.IRequestModel mIRequestModel;
    private RequestAdapter requestAdapter;
    private List<Request> result;

    public RequestPresenter(IRequestContract.IRequestView mIRequestView){

        this.mIRequestView = mIRequestView;
        mIRequestModel = new RequestModel();
    }

    @Override
    public void getRequests(Context context, RecyclerView recyclerView, int comp_ID) {

       // mIRequestView.showProgress();

        if (mIRequestView != null) {

            //returned requsts from model
            //make requstAdapter and giv it requsts and recycleviewContext
            //give ricycle view the adapter
            result = mIRequestModel.downloadRequests(context, this, comp_ID);

            requestAdapter = new RequestAdapter(recyclerView.getContext(), result);
            //RecyclerView.LayoutManager layoutManager=new GridLayoutManager(context,3);
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(),3));
            //recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(requestAdapter);
        }
    }

    @Override
    public void onDestroy() {

        if (mIRequestView != null) {
            mIRequestView = null;
        }
    }

    @Override
    public void onSuccess() {

        if (mIRequestView != null) {
            //mIRequestView.hideProgress();
        }

    }

    @Override
    public void onFailure(String message) {

        if (mIRequestView != null) {
          //  mIRequestView.hideProgress();
            mIRequestView.showAlert(message);
        }
    }
}
