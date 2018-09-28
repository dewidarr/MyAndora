package com.example.dewid.myandora.request;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dewid.myandora.OfferDetails;
import com.example.dewid.myandora.R;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder> {
    private Context context;
    private List<Request> req;

    //String url = "https://desolate-chamber-62168.herokuapp.com/public/user/map";

    public RequestAdapter(Context context, List<Request> req) {
        this.context = context;
        this.req = req;

    }

    //create viewHolder to hold the content
    @NonNull
    @Override
    public RequestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_requests, parent, false);
        return new RequestAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RequestAdapter.ViewHolder holder, final int position) {
        final Request h = req.get(position);

       if (req.get(position).saleprcent=="New")
       {
           holder.saleprcent.setTextColor(Color.parseColor("#CCCC00"));
       }
        holder.saleprcent.setText(req.get(position).saleprcent);

        holder.menpakage.setImageResource(req.get(position).menpakage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            //get postion info image or saleprcent and send to another activity
            @Override
            public void onClick(View view) {

                Context context = view.getContext();
                Intent intent=new Intent(context,OfferDetails.class);
                intent.putExtra("manimage",req.get(position).menpakage);
                intent.putExtra("saleprcent",req.get(position).saleprcent);
                context.startActivity(intent);
            }
        });


        /*
        holder.kind.setText(req.get(position).kind);
        holder.location.setText(req.get(position).location);
        holder.quantity.setText(req.get(position).quantity);
        holder.rate.setRating((float) req.get(position).rate);
        */
        final int user_id = req.get(position).user_id;
        final Context context = req.get(position).context;




    }


    @Override
    public int getItemCount() {
        return req.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView saleprcent;
        ImageView menpakage;

        public ViewHolder(View itemView) {
            super(itemView);
            saleprcent = itemView.findViewById(R.id.slaeprecent);
            menpakage = itemView.findViewById(R.id.mennum1);
           /* kind = itemView.findViewById(R.id.kind);
            location = itemView.findViewById(R.id.location);
            quantity = itemView.findViewById(R.id.quatity);
            rate = itemView.findViewById(R.id.rate);
            acceptBtn = itemView.findViewById(R.id.acceptBtn);
            declineBtn = itemView.findViewById(R.id.declineBtn);
            */

        }
    }
}
