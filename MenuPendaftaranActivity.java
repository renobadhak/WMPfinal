package com.example.studentcampuss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.studentcampuss.model.MataKuliah;
import java.util.ArrayList;

public class MenuPendaftaranActivity extends AppCompatActivity {

    private ArrayList<MataKuliah> selectedMataKuliah = new ArrayList<>();
    private int totalSks = 0;
    private TextView totalSksTextView;
    private ListView mataKuliahListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pendaftaran);

        totalSksTextView = findViewById(R.id.totalSksTextView);
        mataKuliahListView = findViewById(R.id.mataKuliahListView);

        // Daftar mata kuliah dengan SKS yang berbeda
        ArrayList<MataKuliah> mataKuliahList = new ArrayList<>();
        mataKuliahList.add(new MataKuliah("Matematika", 3));
        mataKuliahList.add(new MataKuliah("Fisika", 4));
        mataKuliahList.add(new MataKuliah("Kimia", 2));
        mataKuliahList.add(new MataKuliah("Biologi", 3));
        mataKuliahList.add(new MataKuliah("Ekonomi", 3));
        mataKuliahList.add(new MataKuliah("Teknik Informatika", 4));
        mataKuliahList.add(new MataKuliah("Pendidikan Pancasila", 2));
        mataKuliahList.add(new MataKuliah("Bahasa Inggris", 2));
        mataKuliahList.add(new MataKuliah("Statistika", 4));
        mataKuliahList.add(new MataKuliah("Seni Budaya", 2));

        // Buat adapter untuk menampilkan mata kuliah di ListView
        ArrayAdapter<MataKuliah> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, mataKuliahList);
        mataKuliahListView.setAdapter(adapter);

        // Set listener untuk item yang dipilih
        mataKuliahListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        mataKuliahListView.setOnItemClickListener((parent, view, position, id) -> {
            MataKuliah mataKuliah = mataKuliahList.get(position);

            if (mataKuliahListView.isItemChecked(position)) {
                selectedMataKuliah.add(mataKuliah);
                totalSks += mataKuliah.getSks();
            } else {
                selectedMataKuliah.remove(mataKuliah);
                totalSks -= mataKuliah.getSks();
            }

            updateTotalSks();
        });
    }

    // Memperbarui tampilan jumlah total SKS
    private void updateTotalSks() {
        totalSksTextView.setText("Total SKS: " + totalSks);
    }

    // Metode ini dipanggil saat tombol "Lanjutkan" di klik
    public void lanjutKeRingkasan(View view) {
        // Mengecek apakah total SKS tidak lebih dari 24
        if (totalSks <= 24) {
            // Membuat intent untuk pindah ke RingkasanPendaftaranActivity
            Intent intent = new Intent(MenuPendaftaranActivity.this, RingkasanPendaftaranActivity.class);
            // Menyertakan data total SKS dan mata kuliah yang dipilih
            intent.putExtra("totalSks", totalSks);
            intent.putExtra("selectedMataKuliah", selectedMataKuliah);  // Pastikan mata kuliah ini bisa di serialisasi
            startActivity(intent);  // Memulai aktivitas baru
        } else {
            // Menampilkan pesan error jika total SKS lebih dari 24
            Toast.makeText(MenuPendaftaranActivity.this, "Total SKS melebihi batas", Toast.LENGTH_SHORT).show();
        }
    }
}
