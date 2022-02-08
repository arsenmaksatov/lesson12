package com.example.lesson11.ui.second_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lesson11.R;
import com.example.lesson11.ui.constants.Constants;

public class SecondActivity extends AppCompatActivity {
    ImageView imIcon;
    TextView tvUserEmail, tvUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initialization();
        setupData();
    }



    private void initialization() {
        imIcon = findViewById(R.id.im_avatar);
        tvUserEmail = findViewById(R.id.tv_user_email);
        tvUserPassword = findViewById(R.id.tv_user_password);
    }
    private void setupData() {
        Intent intent = getIntent();
        String nameMain = intent.getStringExtra(Constants.EMAIL);
        String passwordMain = intent.getStringExtra(Constants.PASSWORD);
        tvUserEmail.setText(nameMain);
        Uri myUri = intent.getParcelableExtra("imageUri");
        imIcon.setImageURI(myUri);
        tvUserPassword.setText(passwordMain);
    }
}