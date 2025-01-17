package com.devid_academy.tutojava;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private final String TAG = MainActivity2.class.getSimpleName();
    public static final String KEY_INFO = "KEY_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main2);

        Button btnMain2 = findViewById(R.id.btn_main2);

        // Intent intent = getIntent();

        // String str = "";

        User user = new User();

        if(getIntent().getExtras() != null) {
            user = (User) getIntent().getParcelableExtra(MainActivity.KEY_USER);
        }

        EditText etFirstname = findViewById(R.id.et_main2);

        etFirstname.setText(user.getFirstname(), EditText.BufferType.EDITABLE );
        Toast.makeText(this, "Les données ont été récuperés dans un Object avec Parcelable", Toast.LENGTH_SHORT).show();

        btnMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formFirstnameMain2 = etFirstname.getText().toString().trim();

                if (!formFirstnameMain2.isEmpty()) {
                    setResult(RESULT_OK, new Intent().putExtra(KEY_INFO, formFirstnameMain2));
                } else {
                    setResult(RESULT_CANCELED, new Intent());
                }
                finish();
                
            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}