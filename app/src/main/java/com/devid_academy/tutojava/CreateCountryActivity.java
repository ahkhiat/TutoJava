package com.devid_academy.tutojava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateCountryActivity extends AppCompatActivity {

    Button btnValidate;
    EditText inputCountryName;
    EditText inputUrl;
    public static final String KEY_INFO = "KEY_INFO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_country);

        btnValidate = findViewById(R.id.cca_button_validate);

        inputCountryName = findViewById(R.id.cca_input_country_name);
        inputUrl = findViewById(R.id.cca_input_url);

        btnValidate.setOnClickListener(v -> {

            String insertedCountryName = inputCountryName.getText().toString().trim();
            String insertedUrl = inputUrl.getText().toString().trim();

            Intent returnIntent = new Intent();

            if(!insertedCountryName.isEmpty() && !insertedUrl.isEmpty()){
                Country country = new Country(insertedCountryName, insertedUrl);
                returnIntent.putExtra(KEY_INFO, country);
            }

            setResult(RESULT_OK, returnIntent);

            finish();
        });

    }


}
