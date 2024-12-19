package com.example.studentcampuss;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Menyembunyikan main screen dan langsung menuju LoginActivity
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }
}
