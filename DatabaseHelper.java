package com.example.studentcampuss;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "studentcampus.db";
    private static final int DATABASE_VERSION = 1;

    // Tabel Mahasiswa
    public static final String TABLE_MAHASISWA = "mahasiswa";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    // Tabel Mata Kuliah
    public static final String TABLE_MATA_KULIAH = "mata_kuliah";
    public static final String COLUMN_KODE_MK = "kode_mk";
    public static final String COLUMN_NAMA_MK = "nama_mk";
    public static final String COLUMN_SKS = "sks";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Membuat tabel Mahasiswa
        String CREATE_MAHASISWA_TABLE = "CREATE TABLE " + TABLE_MAHASISWA + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAMA + " TEXT,"
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_MAHASISWA_TABLE);

        // Membuat tabel Mata Kuliah
        String CREATE_MATA_KULIAH_TABLE = "CREATE TABLE " + TABLE_MATA_KULIAH + "("
                + COLUMN_KODE_MK + " TEXT PRIMARY KEY,"
                + COLUMN_NAMA_MK + " TEXT,"
                + COLUMN_SKS + " INTEGER" + ")";
        db.execSQL(CREATE_MATA_KULIAH_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAHASISWA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATA_KULIAH);
        onCreate(db);
    }
}
