package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.android.databinding.ActivityInfoBinding;

public class InfoActivity extends Class_Lifestyle {
    private ActivityInfoBinding binding;
    private static final String EXTRA_TEXT_KEY = "extra_text_key";

    public static Intent createIntent(Context context, String text) {
        Intent intent = new Intent(context, InfoActivity.class);
        intent.putExtra(EXTRA_TEXT_KEY, text);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
    }
}
