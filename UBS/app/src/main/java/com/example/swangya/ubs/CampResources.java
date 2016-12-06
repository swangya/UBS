package com.example.swangya.ubs;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CampResources extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp_resources);
    }

    public void GoToCampMap (View view) {
        goToUrl ( "https://www.uta.edu/maps/");
    }
    public void GoToEventCalendar (View view) {
        goToUrl ( "https://events.uta.edu//");
    }
    public void GoToLibrary (View view) {
        goToUrl ( "https://library.uta.edu/");
    }
    public void GoToMacHours (View view) {
        goToUrl ( "http://www.uta.edu/campusrec/facilities/mac.php");
    }
    public void GoToAcademicsCalendar (View view) {
        goToUrl ( "https://www.uta.edu/uta/acadcal.php");
    }
    public void GoToHousing (View view) {
        goToUrl ( "https://www.uta.edu/housing/");
    }
    public void GoToDining (View view) {
        goToUrl ( "https://www.uta.edu/housing/dining/");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
