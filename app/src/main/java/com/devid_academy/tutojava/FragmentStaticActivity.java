package com.devid_academy.tutojava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class FragmentStaticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_static);

        Button btn = findViewById(R.id.btn_fragment_static);


        btn.setOnClickListener(v -> {
            Intent intent = new Intent(FragmentStaticActivity.this, FragmentStatic2Activity.class);
            startActivity(intent);
        });



    }
}