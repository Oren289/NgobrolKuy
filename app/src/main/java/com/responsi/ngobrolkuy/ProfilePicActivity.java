package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePicActivity extends AppCompatActivity {

    private CircleImageView profilepic;
    private ImageView image_input_button;
    private CardView lewati_button;

    Bitmap bitmap;
    private static final String TAG = ProfilePicActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);

        profilepic = findViewById(R.id.profilePic);
        image_input_button = findViewById(R.id.profilepic_imageinputbutton);
        lewati_button = findViewById(R.id.profilepic_lewatibutton);

        image_input_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });

        lewati_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profilepic.buildDrawingCache();
                Bitmap img =profilepic.getDrawingCache();
                Bundle extras = new Bundle();
                extras.putParcelable("image", img);

                Intent pindah = new Intent(ProfilePicActivity.this, HomeChatActivity.class);
                pindah.putExtras(extras);
                startActivity(pindah);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_CANCELED){
            Toast.makeText(this, "Image input cancelled", Toast.LENGTH_SHORT).show();
        }
        else if(requestCode == GALLERY_REQUEST_CODE){
            if(data != null){
                try {
                    Uri imageUri = data.getData();
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    profilepic.setImageBitmap(bitmap);
                }
                catch (IOException e){
                    Toast.makeText(this, "Cannot load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}