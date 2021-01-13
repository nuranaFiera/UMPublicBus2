package com.example.umpublicbus2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    /*et1 = driver name              et2 = driver email
      et3 = driver phone number      et4 = driver password    et5 = retype password
     tv1= driver infromation    tv2 = create account */


    TextView tv1,tv2;
    EditText et1, et2, et3, et4, et5;
    Button btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();


        tv1=(TextView)findViewById(R.id.tvRegister);
        tv2=(TextView)findViewById(R.id.tvNewAccount);

        et1=(EditText)findViewById(R.id.etDriverName);
        et2=(EditText)findViewById(R.id.etRDriverEmail);
        et3=(EditText)findViewById(R.id.etPhoneNumber);
        et4=(EditText)findViewById(R.id.etRegisterPwd);
        et5=(EditText)findViewById(R.id.etRegisterRePwd);

        btnRegistration=(Button)findViewById(R.id.btRegistration);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,MainActivity.class));
            }
        });

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDriver();
            }
        });
    }



    private void registerDriver() {
        final String DriverName = et1.getText().toString().trim();
        final String DriverEmail = et2.getText().toString().trim();
        final String DriverPhone = et3.getText().toString().trim();
        String DriverPwd = et4.getText().toString().trim();
        String DriverRePwd = et5.getText().toString().trim();

        DriverData = new DriverDatabase();
        reff = FirebaseDatabase.getInstance()

        if (DriverName.isEmpty()){
            et1.setError("Full name is required!");
            et1.requestFocus();
            return;
        }

        if (DriverEmail.isEmpty()){
            et2.setError("Email is required!");
            et2.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(DriverEmail).matches()){
            et2.setError("Please provide valid email!");
            et2.requestFocus();
            return;
        }

        if (DriverPwd.isEmpty()){
            et4.setError("Password is required!");
            et4.requestFocus();
            return;
        }

        if (DriverPwd.length()<6){
            et4.setError("Minimum password is 6");
            et4.requestFocus();
            return;
        }

        if (!DriverRePwd.matches(DriverPwd)){
            et5.setError("Password is not match");
            et5.requestFocus();
            return;
        }

//        mAuth.createUserWithEmailAndPassword(DriverEmail, DriverPwd)
//                .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()){
//                            DriverDatabase DriverData = new DriverDatabase(DriverName, DriverEmail, DriverPhone);
//
//                            FirebaseDatabase.getInstance().getReference("Driver Information")
//                                    .child(FirebaseAuth.getInstance().getCurrentUser().toString())
//                                    .setValue(DriverData).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()){
//                                        Toast.makeText(Register.this,"User has benn registered!"
//                                                ,Toast.LENGTH_LONG).show();
//                                    }else{
//                                        Toast.makeText(Register.this,"Failed to register. Try again."
//                                                ,Toast.LENGTH_LONG).show();
//                                    }
//
//                                }
//                            });
//                        }else {
//                            Toast.makeText(Register.this,"Failed to register. Try again."
//                                    ,Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });

        startActivity(new Intent(Register.this,MainPage.class));
    }
}