package com.example.dewid.myandora.request;

import android.content.Context;

import com.example.dewid.myandora.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestModel implements IRequestContract.IRequestModel {

    private ArrayList<Request> requests;

   // String url = "https://desolate-chamber-62168.herokuapp.com/public/request";

    @Override
    public List<Request> downloadRequests(final Context context, final onRequestFinishedListener listener, final int comp_ID) {

        requests = new ArrayList<>();


        /*        new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Erroe", error.toString());
                    }
                });
                */

      //  Volley.newRequestQueue(context).add(jsonArrayRequest);

          Integer[] menim = {
        R.drawable.man1,
        R.drawable.man2,
        R.drawable.man3,
        R.drawable.man4,
        R.drawable.man5,
        R.drawable.man6,
        R.drawable.man7,
                  R.drawable.man1,
                  R.drawable.man2,

          };
        List<String> list = Arrays.asList("New", "25%", "10%","New", "25%", "10%","New", "25%", "10%","New", "25%", "10%");
        for (int i=0; i<menim.length;i++)
        {
            requests.add(new Request(list.get(i),menim[i],i,context));
        }
       /* requests.add(new Request("m", null,1,context));
        requests.add(new Request("s", null,2,context));
        requests.add(new Request("t", null,3,context));
        requests.add(new Request("m", null,4,context));
        requests.add(new Request("s", null,5,context));
        requests.add(new Request("t", null,6,context));
        requests.add(new Request("m", null,8,context));
        requests.add(new Request("s", null,9,context));
        requests.add(new Request("t", null,10,context));
        requests.add(new Request("m", null,11,context));
        requests.add(new Request("s", null,12,context));
        requests.add(new Request("t", null,13,context));
        */


        return requests;
    }
}
