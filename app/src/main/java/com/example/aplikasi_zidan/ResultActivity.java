package com.example.aplikasi_zidan;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);

        TextView tvResult = findViewById(R.id.tv_result);

        // Ambil data dari Intent
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String address = getIntent().getStringExtra("address");
        String jurusan = getIntent().getStringExtra("jurusan");
        String semester = getIntent().getStringExtra("semester");

        // Tampilkan hasil
        String finalResult = "Registration Success!\n\n" +
                "Name\t: " + name + "\n" +
                "Email\t: " + email + "\n" +
                "Address\t: " + address + "\n" +
                "Jurusan\t: " + jurusan + "\n" +
                "Semester\t: " + semester;

        tvResult.setText(finalResult);
    }
}
