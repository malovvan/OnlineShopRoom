package com.example.productapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.productapp.Presentation.Repository.Repository;
import com.example.Productapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Repository.init(getApplication());
    }
}