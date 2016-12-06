package com.example.swangya.ubs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

public class LinuxUser extends AppCompatActivity implements View.OnClickListener{

    Context context = LinuxUser.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_user);
        Button button_1_option = (Button) findViewById(R.id.iblogin);
        button_1_option.setOnClickListener(this);
        //textView = (TextView) findViewById(R.id.url);
        //String webLinkText = "<a href='https://mavorgs.collegiatelink.net/organization/arthistorystudentunion'> Art History Student Union</a>";
        //textView.setText(Html.fromHtml(webLinkText));
        //textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.iblogin:
            {
                BLinuxUser();
            }
            break;
            default:
                break;
        }
    }

    private void BLinuxUser()
    {
        new AlertDialog.Builder(context)
                .setTitle("Success!")
                .setMessage("You have successful join the Linux User Group !")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        System.exit(0);
                    }
                })
                .setIcon(android.R.drawable.arrow_up_float)
                .setCancelable(false)
                .show();
    }
}