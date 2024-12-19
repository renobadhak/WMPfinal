package com.example.studentcampuss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }

    // Fungsi untuk memvalidasi login
    public void login(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Cek login sederhana
        if (username.equals("mahasiswa") && password.equals("password")) {
            // Jika login berhasil, lanjutkan ke MenuPendaftaranActivity
            Intent intent = new Intent(LoginActivity.this, MenuPendaftaranActivity.class);
            startActivity(intent);
        } else {
            // Jika login gagal, tampilkan pesan error
            Toast.makeText(LoginActivity.this, "Username atau Password salah", Toast.LENGTH_SHORT).show();
        }
    }
}
