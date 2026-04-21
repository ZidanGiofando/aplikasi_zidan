package com.example.aplikasi_zidan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        btnRegister.setOnClickListener(v -> {

            String name = txtFullName.getText().toString().trim();
            String email = txtEmail.getText().toString().trim();
            String address = txtAddress.getText().toString().trim();
            String password = txtPassword.getText().toString().trim();


            if (name.isEmpty() || email.isEmpty() || address.isEmpty() || password.isEmpty()) {

                android.widget.Toast.makeText(this, "All fields are required", android.widget.Toast.LENGTH_SHORT).show();
            } else {

                String result = "Registration Success!\n\n" +
                        "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Address: " + address;
                tvResult.setText(result);
            }
        });
    }
}
