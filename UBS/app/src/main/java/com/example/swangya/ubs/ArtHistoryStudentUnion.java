package com.example.swangya.ubs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.Arrays;
import java.util.List;
import android.widget.TextView;
import android.text.Html;
import android.text.method.LinkMovementMethod;

public class ArtHistoryStudentUnion extends Activity {

    TextView textView ;
    Context context = ArtHistoryStudentUnion.this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_history_student_union);
        Button send = (Button) this.findViewById(R.id.iblogin);
        textView = (TextView) findViewById(R.id.url);
        String webLinkText = "<a href='https://mavorgs.collegiatelink.net/organization/arthistorystudentunion'> Art History Student Union</a>";
        textView.setText(Html.fromHtml(webLinkText));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.i("SendMailActivity", "Send Button Clicked.");
                String fromEmail = "utaorganizationmangement@gmail.com";
                String fromPassword = "19921210";
                String toEmails = "duxxx200@gmail.com";
                List<String> toEmailList = Arrays.asList(toEmails);
                Log.i("SendMailActivity", "To List: " + toEmailList);
                String emailSubject = "Received a Request!";
                String emailBody = "A student request join the Art History Student Union Club.";
                new SendMailTask(ArtHistoryStudentUnion.this).execute(fromEmail,
                        fromPassword, toEmailList, emailSubject, emailBody);
                BCLUB();
            }
        });
    }

    private void BCLUB()
    {
        new AlertDialog.Builder(context)
                .setTitle("Success!")
                .setMessage("You have successfully Send the Request for join the Art History Student Union Club !")
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
