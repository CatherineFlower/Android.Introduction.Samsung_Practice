package com.example.android;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends Class_Lifestyle {

    private static final String PASSWORD_KEY = "result_password_key";
    private static final String EMAIL_KEY = "result_email_key";
    private ActivityMainBinding binding;

    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                showResultCode(result.getResultCode());
                if (result.getData() != null) {
                    String email = result.getData().getStringExtra(EMAIL_KEY);
                    String password = result.getData().getStringExtra(PASSWORD_KEY);
                    binding.username.setText(email);
                    binding.username.clearFocus(); // Don't open keyboard

                    binding.password.setText(password);
                    binding.password.clearFocus(); // Don't open keyboard
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater(), null, false);
        setContentView(binding.getRoot());

        binding.loginbtn.setOnClickListener(v -> {
            String email = binding.username.getText().toString();
            String password = binding.password.getText().toString();
            Intent intent = InfoActivity.createIntent(this, email, password, PASSWORD_KEY,
                    EMAIL_KEY);
            activityResultLauncher.launch(intent);
        });
    }

    private void showResultCode(int resultCode) {
        if (resultCode == RESULT_OK) {
            showToast("Зарегистрирован");
        } else if (resultCode == RESULT_CANCELED) {
            showToast("RESULT_CANCELED");
        } else {
            showToast(String.valueOf(resultCode));
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}