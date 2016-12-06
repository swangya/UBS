package com.example.swangya.ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.ListView;

public class Club extends AppCompatActivity {

    ListView listView;
    DBHelper myDb;

    Button btn;
    private int cid;
    private String cname;
    private String admin;
    private String function;

    public Club(){};

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);


        btn = (Button) findViewById(R.id.bclub_2100_club);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,Club_2100.class);
                                       startActivity(intent);
                                   }
                               }
        );
        btn = (Button) findViewById(R.id.bclub_a_collection_of_brothers);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,ACollectionOfBrothers.class);
                                       startActivity(intent);
                                   }
                               }
        );
        btn = (Button) findViewById(R.id.bclub_access);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,Access.class);
                                       startActivity(intent);
                                   }
                               }
        );
        btn = (Button) findViewById(R.id.bclub_accounting_society);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,AccountingSociety.class);
                                       startActivity(intent);
                                   }
                               }
        );
        btn = (Button) findViewById(R.id.bclub_actuarial_science_club);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,ActuarialScienceClub.class);
                                       startActivity(intent);
                                   }
                               }
        );
        btn = (Button) findViewById(R.id.bclub_advertising_league_of_texas_at_arlington);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,AdvertisingLeagueOfTexasAtArlington.class);
                                       startActivity(intent);
                                   }
                               }
        );
        btn = (Button) findViewById(R.id.bclub_aero_mavericks);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,AeroMavericks.class);
                                       startActivity(intent);
                                   }
                               }
        );
        btn = (Button) findViewById(R.id.bcreate_a_club);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,CreateClub.class);
                                       startActivity(intent);
                                   }
                               }
        );
        btn = (Button) findViewById(R.id.bgroup_linux_user_group);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,LinuxUser.class);
                                       startActivity(intent);
                                   }
                               }
        );

        btn = (Button) findViewById(R.id.bgroup_aiga_group);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,AIGA.class);
                                       startActivity(intent);
                                   }
                               }
        );

        btn = (Button) findViewById(R.id.bgroup_art_history_student_union);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,ArtHistoryStudentUnion.class);
                                       startActivity(intent);
                                   }
                               }
        );

        btn = (Button) findViewById(R.id.bgroup_focus);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,Focus.class);
                                       startActivity(intent);
                                   }
                               }
        );

        btn = (Button) findViewById(R.id.bgroup_aitp);
        btn.setOnClickListener(new View.OnClickListener(){
                                   @Override
                                   public void onClick(View v){
                                       Intent intent = new Intent(Club.this,AITP.class);
                                       startActivity(intent);
                                   }
                               }
        );

    }



}

