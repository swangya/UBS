package com.example.swangya.ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class readPost extends AppCompatActivity {

    TextView data;
    dbHelper_Comms dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_post);
        data = (TextView) findViewById(R.id.showData);
        dbHandler = new dbHelper_Comms(this, null, null, 1);
        printDatabase();
    }

    @Override
    public void onResume(){
        super.onResume();
        printDatabase();
    }

    public void writePost(View view){
        Intent startWriteActivity = new Intent(this, writePost.class);
        startActivity(startWriteActivity);
    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        if(dbString.matches("")){
            dbString="No message to show.";
        }
        data.setText(dbString);
    }
}
