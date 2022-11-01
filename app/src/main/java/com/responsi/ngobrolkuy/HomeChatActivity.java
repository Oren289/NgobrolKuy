package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeChatActivity extends AppCompatActivity {

    private ConstraintLayout chat_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_chat);

        chat_group = findViewById(R.id.home_group_1);

        chat_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(HomeChatActivity.this, PersonalChatActivity.class);
                startActivity(pindah);
            }
        });
    }
}