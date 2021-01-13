package com.example.umpublicbus2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mDriverEmail, mPassword;
    Button mbuttonlogin, mbuttonregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDriverEmail = (EditText)findViewById(R.id.etLDriverEmail);
        mPassword = (EditText)findViewById(R.id.etLoginPassword);
        mbuttonlogin = (Button) findViewById(R.id.btLogin);
        mbuttonregister = (Button) findViewById(R.id.btRegister);

        mbuttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this,Register.class);
                startActivity(registerIntent);
            }
        });

        mbuttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainPageIntent = new Intent(MainActivity.this,MainPage.class);
                startActivity(mainPageIntent);
            }
        });


    }
}