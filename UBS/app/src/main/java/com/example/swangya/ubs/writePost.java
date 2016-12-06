package com.example.swangya.ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class writePost extends AppCompatActivity {

    EditText userName;
    EditText userMessage;
    dbHelper_Comms dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        userName = (EditText) findViewById(R.id.userName);
        userMessage = (EditText) findViewById(R.id.userMessage);

        dbHandler = new dbHelper_Comms(this, null, null, 1);
    }

    public void postButtonClicked(View view){
        // dbHandler.add needs an object parameter.
        if(userMessage.getText().toString().matches("") || userName.getText().toString().matches(""))
            Toast.makeText(getApplicationContext(), "Did you not enter your Name or Message", Toast.LENGTH_LONG).show();

        else{
            User user = new User(userName.getText().toString(), userMessage.getText().toString());
            dbHandler.addProduct(user);
            Toast.makeText(getApplicationContext(), "Message Posted", Toast.LENGTH_SHORT).show();
            Intent startReadActivity = new Intent(this, readPost.class);
            startActivity(startReadActivity);
        }

    }
}
