package com.example.lesson11.ui.main_activity;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.lesson11.R;
import com.example.lesson11.ui.constants.Constants;
import com.example.lesson11.ui.second_activity.SecondActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imIcon;
    EditText etEmail, etPassword;
    Button btnLogin;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        setupListener();
    }

    private void initialization() {
        imIcon = findViewById(R.id.im_icon);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    private void setupListener() {
        imIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultLauncher.launch("image/*");
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                if (!email.isEmpty() && !password.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra(Constants.EMAIL, email);
                    intent.putExtra(Constants.PASSWORD, password);
                    intent.putExtra("imageUri",uri );
                    startActivity(intent);
                } else {
                    etEmail.setError("Ведите email");
                    etPassword.setError("Ведите password");
                }
            }
        });
    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    imIcon.setImageURI(result);
                    uri = result;
                }
            });

}
