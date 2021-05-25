package edu.eci.ieti.android.geolocationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddLocationActivity extends AppCompatActivity {

    public static final String NAME = "NAME";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String LATITUDE = "LATITUDE";
    public static final String LONGITUDE = "LONGITUDE";
    public static final String VALID = "VALID";
    private EditText nameText;
    private EditText descriptionText;
    private EditText longitudeText;
    private EditText latitudeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_form);
        nameText = (EditText) findViewById(R.id.name);
        descriptionText = (EditText) findViewById(R.id.description);
        longitudeText = (EditText) findViewById(R.id.longitude);
        latitudeText = (EditText) findViewById(R.id.latitude);
    }

    public void validateForm(View view){
        
        Boolean submit = true;
        if (nameText.getText().toString().length() == 0){
            submit = false;
            nameText.setError("Name expected");
        }

        if (descriptionText.getText().toString().length() == 0){
            submit = false;
            descriptionText.setError("Description expected");
        }
        try{
            Double.parseDouble(latitudeText.getText().toString());
            Double.parseDouble(longitudeText.getText().toString());
        } catch(NumberFormatException e) {
            submit = false;
            latitudeText.setError("Double expected");
        }
        try{
            Double.parseDouble(longitudeText.getText().toString());
        } catch(NumberFormatException e) {
            submit = false;
            longitudeText.setError("Double expected");
        }
        if (submit){
            goToMapsActivity();
        }
    }

    private void goToMapsActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra(VALID, true);
        intent.putExtra(NAME, nameText.getText().toString());
        intent.putExtra(DESCRIPTION, descriptionText.getText().toString());
        intent.putExtra(LATITUDE, latitudeText.getText().toString());
        intent.putExtra(LONGITUDE, longitudeText.getText().toString());
        startActivity(intent);
    }
}
