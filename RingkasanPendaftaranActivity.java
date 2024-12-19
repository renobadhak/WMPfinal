package com.example.studentcampuss;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.studentcampuss.model.MataKuliah;
import java.util.ArrayList;

public class RingkasanPendaftaranActivity extends AppCompatActivity {

    private TextView ringkasanTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringkasan_pendaftaran);

        ringkasanTextView = findViewById(R.id.ringkasanTextView);

        // Mengambil data yang dikirimkan dari MenuPendaftaranActivity
        ArrayList<MataKuliah> selectedMataKuliah = (ArrayList<MataKuliah>) getIntent().getSerializableExtra("selectedMataKuliah");
        int totalSks = getIntent().getIntExtra("totalSks", 0);

        // Menyiapkan teks untuk menampilkan ringkasan
        StringBuilder ringkasan = new StringBuilder();
        ringkasan.append("Total SKS yang dipilih: ").append(totalSks).append("\n");

        // Menampilkan daftar mata kuliah yang dipilih
        ringkasan.append("\nDaftar Mata Kuliah yang dipilih:\n");
        for (MataKuliah mataKuliah : selectedMataKuliah) {
            ringkasan.append(mataKuliah.toString()).append("\n");
        }

        // Menampilkan hasil ringkasan ke dalam TextView
        ringkasanTextView.setText(ringkasan.toString());
    }
}
