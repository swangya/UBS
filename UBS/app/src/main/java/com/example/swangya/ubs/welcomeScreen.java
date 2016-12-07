package com.example.swangya.ubs;


import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class welcomeScreen extends AppCompatActivity {

    DatabaseHelper FPDBH;
    Button Loginbtn, fpbtn, Registerbtn;
    EditText userid, password;
    String id,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        FPDBH= new DatabaseHelper(this);
        Loginbtn = (Button) findViewById(R.id.iblogin);
        fpbtn= (Button) findViewById(R.id.ibforgotpassword);
        Registerbtn=(Button)findViewById(R.id.ibregister);
        userid=(EditText)findViewById(R.id.etUserName);
        password=(EditText)findViewById(R.id.etPassword);


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

        Loginbtn.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View v)
                                        {
                                            int i=0;
                                            String name="";
                                            Cursor res = FPDBH.forgotPassword();
                                            res.moveToFirst();
                                            id=userid.getText().toString();
                                            pass=password.getText().toString();
                                            do
                                            {
                                                if ( (id.equals(res.getString(6))) && (pass.equals(res.getString(5))) )
                                                {
                                                    i=1;
                                                    name=res.getString(0);
                                                }
                                            }while(res.moveToNext());
                                            if(i==0)
                                            {
                                                Toast.makeText(welcomeScreen.this, "ERROR!! Details not Found, Please Try Again", Toast.LENGTH_LONG).show();
                                            }
                                            else
                                            {
                                                Toast.makeText(welcomeScreen.this, "Login Successful, Welcome "+name, Toast.LENGTH_LONG).show();
                                                Intent intent = new Intent(welcomeScreen.this, HomeScreen.class);
                                                startActivity(intent);
                                            }

                                        }
                                    }
        );
    }
}
/*boolean status=false;
                                            Cursor res= DBH.login_data();
                                            id=userid.getText().toString();
                                            pass=password.getText().toString();
                                            res.moveToFirst();
                                            String UserName="";

                                            if(res.getCount()==0)
                                            {
                                                Toast.makeText(welcomeScreen.this, "No data found", Toast.LENGTH_LONG).show();
                                            }

                                            do
                                            {
                                                if ( (id.equals(res.getString(0))) && (pass.equals(res.getString(1))) )
                                                {
                                                    UserName=res.getString(2);
                                                    status=true;
                                                }
                                            }while(res.moveToNext());

                                            if(status==true)
                                            {
                                                Toast.makeText(welcomeScreen.this, "Login Successful, Welcome "+UserName, Toast.LENGTH_LONG).show();
                                                Intent intent = new Intent(welcomeScreen.this, HomeScreen.class);
                                                startActivity(intent);
                                            }
                                            */