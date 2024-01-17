package com.example.android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.android.databinding.ActivityInfoBinding;

public class InfoActivity extends Class_Lifestyle {
    private ActivityInfoBinding binding;
    private static final String EXTRA_EMAIL_KEY = "extra_email_key";
    private static final String EXTRA_PASSWORD_KEY = "extra_password_key";
    private static final String EXTRA_KEY_USER_KEY = "extra_password_key";
    private static final String EXTRA_KEY_PASSW_KEY = "extra_password_key";

    public static Intent createIntent(Context context, String username, String password,
                                      String keyUser, String keyPassw) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(EXTRA_PASSWORD_KEY, password);
        intent.putExtra(EXTRA_EMAIL_KEY, username);
        intent.putExtra(EXTRA_KEY_USER_KEY, keyUser);
        intent.putExtra(EXTRA_KEY_PASSW_KEY, keyPassw);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoBinding.inflate(getLayoutInflater(), null, false);
        setContentView(binding.getRoot());

        String password = getIntent().getStringExtra(EXTRA_PASSWORD_KEY);
        String email = getIntent().getStringExtra(EXTRA_EMAIL_KEY);
        String keyUser = getIntent().getStringExtra(EXTRA_KEY_USER_KEY);
        String keyPassw = getIntent().getStringExtra(EXTRA_KEY_PASSW_KEY);

        binding.printUser.setText(email);
        binding.printPass.setText(password);

        binding.save.setOnClickListener(v -> {
            String changedEMail = binding.printUser.getText().toString();
            String changedPassword = binding.printPass.getText().toString();
            Intent intent = new Intent();
            intent.putExtra(keyUser, changedEMail);
            intent.putExtra(keyPassw, changedPassword);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
