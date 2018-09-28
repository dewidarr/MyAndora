package com.example.dewid.myandora.request;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import com.example.dewid.myandora.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RequestActivity extends AppCompatActivity implements IRequestContract.IRequestView {


    @BindView(R.id.list)
    RecyclerView recyclerView;
    @BindView(R.id.progressBarRequest)
    ProgressBar ProgressBarRequest;
    //private RecyclerView recyclerView;
    //private RequestAdapter requestAdapter;
    //private ArrayList<Request> requests;

    private IRequestContract.IRequestPresenter mRequestPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request);
        ButterKnife.bind(this);

        int comp_ID = getIntent().getIntExtra("EXTRA_SESSION_ID", 0);

        mRequestPresenter = new RequestPresenter(this);

        mRequestPresenter.getRequests(this, recyclerView, comp_ID);

        /*
        requests = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            requests.add(new Request("" + i, " " + i, " " + i, " " + i, "" + i));
        }

        requestAdapter = new RequestAdapter(this, requests);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(requestAdapter);
        */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.mipmap.ic_menu);
        toolbar.setLogo(R.mipmap.ic_call);
    }


    @Override
    public void showAlert(String message) {
     //   StyleableToast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT,R.style.mytoast).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mRequestPresenter.onDestroy();
    }
/*
    public void print(View view){
        StyleableToast.makeText(getApplicationContext(),"Accept", Toast.LENGTH_SHORT,R.style.mytoast).show();
    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
