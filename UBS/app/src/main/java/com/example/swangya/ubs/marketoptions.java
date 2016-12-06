package com.example.swangya.ubs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;



public class marketoptions extends AppCompatActivity {
    GridView gridView;
    adapter pageadapter;
    Database DB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketoptions);

        gridView = (GridView) findViewById(R.id.gridView);
        DB = Database.getInstance(this.getApplicationContext());
        String string = getIntent().getStringExtra("EXTRA");

        if (string == null)
            pageadapter = new adapter(marketoptions.this, DB.returnItem());
        else{
            ArrayList<Item> items = DB.returnItem();
            ArrayList<Item> search = new ArrayList<Item>();
            for(int i=0;i<items.size();i++){
                Item founditem=items.get(i);
                if(founditem.getItemname().equals(string) || (founditem.getPrice().equals(string))|| (founditem.getDesc().equals(string))||
                        (founditem.getMail().equals(string))){
                    search.add(founditem);
                }
            }
            pageadapter = new adapter(marketoptions.this, search);
        }
        gridView.setAdapter(pageadapter);


        FloatingActionButton sell = (FloatingActionButton) findViewById(R.id.floatingActionButton3);
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page = new Intent(getApplicationContext(), sellscreen.class);
                startActivity(page);}
        });

    }
}
