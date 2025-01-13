package com.devid_academy.tutojava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    public static final String KEY_INFO = "KEY_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnMain2 = findViewById(R.id.btn_main2);

        // Intent intent = getIntent();

        // String str = "";

        User user = new User();

        if(getIntent().getExtras() != null) {
            user = (User) getIntent().getSerializableExtra(MainActivity.KEY_USER);
        }

        EditText etFirstname = findViewById(R.id.et_main2);

        etFirstname.setText(user.getFirstname(), EditText.BufferType.EDITABLE );

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
}