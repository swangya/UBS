package com.example.swangya.ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClubAndOrganization extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_and_organization);

        btn = (Button) findViewById(R.id.bClubs);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(ClubAndOrganization.this,Club.class);
                                       startActivity(intent);
                                   }
                               }
        );

        btn = (Button) findViewById(R.id.bCR);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(ClubAndOrganization.this,CampResources.class);
                                       startActivity(intent);
                                   }
                               }
        );
    }
}
