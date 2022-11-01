package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    private CardView login_button;
    private TextView lupa_password;
    private TextView register_button;
    private EditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_button = findViewById(R.id.login_loginbutton);
        et_username = findViewById(R.id.login_username_input);
        et_password = findViewById(R.id.login_password_input);
        lupa_password = findViewById(R.id.login_lupapassword);
        register_button = findViewById(R.id.login_registerbutton);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();

                Intent pindah = new Intent(LoginActivity.this, ProfilePicActivity.class);
                pindah.putExtra("username", username);
                pindah.putExtra("password", password);
                startActivity(pindah);
            }
        });

        lupa_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(LoginActivity.this, LupaPasswordActivity.class);
                startActivity(pindah);
            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(pindah);
            }
        });
    }
}