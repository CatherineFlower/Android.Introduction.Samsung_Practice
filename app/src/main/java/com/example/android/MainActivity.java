package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.databinding.ActivityMainBinding;


public class MainActivity extends Class_Lifestyle {

    private static final String RESULT_KEY = "result_key";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater(), null, false);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        binding.loginbtn.setOnClickListener(v -> {
            Intent intent= new Intent(this, InfoActivity.class);
            startActivity(intent);
        });
    }
}