package com.devid_academy.tutojava;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class CreateCountryActivity extends AppCompatActivity {

    Button btnValidate;
    EditText inputCountryName;
    EditText inputUrl;
    CircleImageView civPreview;
    public static final String KEY_INFO = "KEY_INFO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_country);

        btnValidate = findViewById(R.id.cca_button_validate);

        inputCountryName = findViewById(R.id.cca_input_country_name);
        inputUrl = findViewById(R.id.cca_input_url);

        civPreview = findViewById(R.id.civ_cca_preview);

//        inputUrl.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                String urlString = charSequence.toString().trim();
//
//                Picasso.get()
//                        .load(urlString)
//                        .into(civPreview);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {}
//        });

        inputUrl.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                String urlString = inputUrl.getText().toString().trim();

                Picasso.get()
                        .load(urlString)
                        .into(civPreview);
            }
        });

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
