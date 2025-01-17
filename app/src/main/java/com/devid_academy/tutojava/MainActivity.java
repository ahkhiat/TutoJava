package com.devid_academy.tutojava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.ui.window.DialogWindowProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    private EditText etFirstname;
    private EditText etLastname;
    private EditText etAge;
    public static final String KEY_USER = "KEY_USER";
    private final int REQUEST_FIRSTNAME = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate");

        setContentView(R.layout.activity_main);

        etFirstname = findViewById(R.id.et_main_firstname);
        etLastname = findViewById(R.id.et_main_lastname);
        etAge = findViewById(R.id.et_main_age);

        /*
        Intent intent = getIntent();
        String str = "";

        if (intent.hasExtra("firstnameMain2")){
            str = intent.getStringExtra("firstnameMain2");
        }
        etFirstname.setText(str, EditText.BufferType.EDITABLE );
        */

        Button btnVal = findViewById(R.id.btn_main);

        Button btn2 = findViewById(R.id.btn2_main);

        btnVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String formFirstname = etFirstname.getText().toString().trim();
                String formLastname = etLastname.getText().toString().trim();
                String formAge = etAge.getText().toString().trim();
                int intFormAge;

                String message;

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                if (!formFirstname.isEmpty() && !formLastname.isEmpty() && !formAge.isEmpty()) {
                    try {
                        intFormAge = Integer.parseInt(formAge);
                    } catch (NumberFormatException e) {
                        message = "L'âge doit être un nombre valide.";
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                        return;
                    }

                    User user = new User(formFirstname, formLastname, intFormAge);
                    intent.putExtra(KEY_USER, user);
                    startActivityForResult(intent, REQUEST_FIRSTNAME);
                } else {
                    Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs" , Toast.LENGTH_SHORT).show();
                }

                // Exercice 1, formulaire qui affiche un Toast
                /*
                if (!formFirstname.isEmpty() && !formLastname.isEmpty() && !formAge.isEmpty()) {
                    int formAgeInt = Integer.parseInt(formAge);
                    boolean isMajor = formAgeInt >= 18;

                    StringBuilder sentence = new StringBuilder();
                    sentence.append("Bonjour, je m'appelle " + formFirstname +
                                    " " + formLastname + ", je suis " +
                                    (isMajor ? "majeur" : "mineur") );

                    message = sentence.toString();

                } else {
                    message = "Veuillez remplir tous les champs";
                }
                Toast.makeText(MainActivity.this, message , Toast.LENGTH_SHORT).show();
                */
// 8787 463 685
                // 7898 809 083
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_FIRSTNAME) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String infoFromMain2Activity = data.getStringExtra(MainActivity2.KEY_INFO);
                    etFirstname.setText(infoFromMain2Activity);
                }
            } else { // RESULT_CANCELED
                if(data != null) { // Provient du bouton retour de MainActivity2
                    Toast.makeText(this, "Canceled From Dev !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Canceled from the system !", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG, "onStop" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, "onResume:" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, "onDestroy: ");
    }
}