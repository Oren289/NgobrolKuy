package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView register_button, tologin_button;
    private EditText et_username, et_email, et_password, et_confpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_button = findViewById(R.id.register_registerbutton);
        tologin_button = findViewById(R.id.register_tologinbutton);
        et_username = findViewById(R.id.register_username_input);
        et_email = findViewById(R.id.register_email_input);
        et_password = findViewById(R.id.register_password_input);
        et_confpassword = findViewById(R.id.register_confpassword_input);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String email = et_email.getText().toString();
                String password = et_password.getText().toString();
                String confpassword = et_confpassword.getText().toString();

                Intent pindah = new Intent(RegisterActivity.this, LoginActivity.class);
                pindah.putExtra("username", username);
                pindah.putExtra("email", email);
                pindah.putExtra("password", password);
                pindah.putExtra("confpassword", confpassword);
                startActivity(pindah);
            }
        });

        tologin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(pindah);
            }
        });
    }
}