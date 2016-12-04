package com.example.swangya.ubs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class welcomeScreen extends AppCompatActivity {

    Button Loginbtn;
    Button fpbtn;
    Button Registerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Loginbtn = (Button) findViewById(R.id.iblogin);
        fpbtn= (Button) findViewById(R.id.ibforgotpassword);
        Registerbtn=(Button)findViewById(R.id.ibregister);
        Registerbtn.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View v)
           {
               Intent intent = new Intent(welcomeScreen.this,Register.class);
               startActivity(intent);
           }
       }
        );
        fpbtn.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(welcomeScreen.this, ForgotPassword.class);
                 startActivity(intent);
             }
        }
        );

        Loginbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcomeScreen.this, HomeScreen.class);
                startActivity(intent);
            }
        }
        );
    }

}
