package com.example.dewid.myandora;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OfferDetails extends AppCompatActivity {
    ImageView singleimage;
    TextView singleprcent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);
        singleimage=findViewById(R.id.singleimage);
        singleprcent=findViewById(R.id.singleprcent);

        String saleprcentage=getIntent().getExtras().getString("saleprcent");
        Integer manimage=getIntent().getExtras().getInt("manimage");
        singleimage.setImageResource(manimage);
        singleprcent.setText(saleprcentage);

                String id = getIntent().getExtras().getString("movie_id_key");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarOffer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.mipmap.ic_menu);
        toolbar.setLogo(R.mipmap.ic_call);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
