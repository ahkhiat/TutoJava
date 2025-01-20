package com.devid_academy.tutojava;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

    View fgContainer = findViewById(R.id.fg_act_container);
    Button btnGreen = findViewById(R.id.buttonGreen);
    Button btnPink = findViewById(R.id.buttonPink);

    btnGreen.setOnClickListener(v -> {
        Intent intent = new Intent(FragmentsActivity.this, FragmentGreen.class);
        startActivity(intent);
    });


    }
}