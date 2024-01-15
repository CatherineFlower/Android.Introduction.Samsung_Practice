package com.example.android;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Class_Lifestyle extends AppCompatActivity {

    private static final String SAVED_INSTALL_KEY = "key";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVED_INSTALL_KEY, 10);
        Log.i("ActivityLifestyleTag", this.getClass() + "onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        int savedData = savedInstanceState.getInt(SAVED_INSTALL_KEY);
        Log.i("ActivityLifestyleTag", this.getClass() + "onRestoreInstanceState");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ActivityLifestyleTag", this.getClass() + "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ActivityLifestyleTag", this.getClass() + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ActivityLifestyleTag", this.getClass() + "onResume");
    }


}
