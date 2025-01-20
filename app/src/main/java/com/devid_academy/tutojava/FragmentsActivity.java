package com.devid_academy.tutojava;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentsActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        View fgContainer = findViewById(R.id.fg_act_container); // type Fragment non accepté
        Button btnGreen = findViewById(R.id.buttonGreen);
        Button btnPink = findViewById(R.id.buttonPink);

        btnGreen.setOnClickListener(v -> {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            String GreenFragmentTitle = getString(R.string.fg_green_title);

            FragmentGreen fragmentGreen = new FragmentGreen(GreenFragmentTitle);
            ft.replace(R.id.fg_act_container, fragmentGreen);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            try{
                ft.commit();
            }catch(Exception e){
                Log.d(TAG, "debug");
            }
        });

        btnPink.setOnClickListener(v -> {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            FragmentPink fragmentPink = new FragmentPink();
            ft.replace(R.id.fg_act_container, fragmentPink);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            try{
                ft.commit();
            }catch(Exception e){
                Log.d(TAG, "debug");
            }
        });
    }

    public void showToast(String message) {
        Toast.makeText(FragmentsActivity.this, message, Toast.LENGTH_SHORT).show();
    }

}