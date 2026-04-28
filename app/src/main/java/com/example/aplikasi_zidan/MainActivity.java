package com.example.aplikasi_zidan;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnRegister = findViewById(R.id.btn_register);
        EditText txtFullName = findViewById(R.id.txt_fullname);
        EditText txtEmail = findViewById(R.id.txt_email);
        EditText txtAddress = findViewById(R.id.txt_address);
        EditText txtPassword = findViewById(R.id.txt_password);
        TextView tvResult = findViewById(R.id.tv_result);
        RadioGroup rgSemester = findViewById(R.id.rg_semester);
        CheckBox cbAgreement = findViewById(R.id.cb_agreement);

        Spinner spJurusan = findViewById(R.id.sp_jurusan);
        String[] Jurusan = {"-- Pilih Jurusan --", "Teknik Informatika", "Sistem Informasi", "Ilmu Komputer"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                Jurusan
        );
        spJurusan.setAdapter(adapter);


        btnRegister.setOnClickListener(v -> {
            String name = txtFullName.getText().toString().trim();
            String email = txtEmail.getText().toString().trim();
            String address = txtAddress.getText().toString().trim();
            String password = txtPassword.getText().toString().trim();
            String jurusan = spJurusan.getSelectedItem().toString();
            int rbSemesterId = rgSemester.getCheckedRadioButtonId();


            if (name.isEmpty() || email.isEmpty() || address.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua kolom teks wajib diisi", Toast.LENGTH_SHORT).show();
            }
            else if (spJurusan.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Pilih Jurusan terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
            else if (rbSemesterId == -1) {
                Toast.makeText(this, "Pilih Semester terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
            else if (!cbAgreement.isChecked()) {
                Toast.makeText(this, "Centang persetujuan terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
            else {
                RadioButton rbSelected = findViewById(rbSemesterId);
                String semester = rbSelected.getText().toString();

                String result = "Registration Success!\n\n" +
                        "Name\t\t: " + name + "\n" +
                        "Email\t\t: " + email + "\n" +
                        "Address\t: " + address + "\n" +
                        "Jurusan\t: " + jurusan + "\n" +
                        "Semester\t: " + semester;

                tvResult.setText(result);
                Toast.makeText(this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
