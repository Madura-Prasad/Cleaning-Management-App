package com.example.cleany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cleany.database.datahandler;
import com.google.android.material.textfield.TextInputLayout;

public class houseowner extends AppCompatActivity {

    TextInputLayout email,password;
    com.example.cleany.database.datahandler datahandler = new datahandler( this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houseowner);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        email=findViewById(R.id.user);

        password=findViewById(R.id.pass);

        datahandler.openDB();
    }
    //Email validation
    private boolean validEmail() {
        String Email = email.getEditText().getText().toString().trim();


        if (Email.isEmpty()) {
            email.setError("Email is Empty.");
            return false;
        }  else {
            email.setError(null);
            return true;
        }

    }

    //Password validation
    private boolean validPassword() {
        String Password = password.getEditText().getText().toString().trim();

        if (Password.isEmpty()) {
            password.setError("Password is Empty.");
            return false;
        } else {
            password.setError(null);
            return true;
        }

    }
    public void houseowner (View view){

        String Email = email.getEditText().getText().toString().trim();
        String Password = password.getEditText().getText().toString().trim();

        if (!validEmail()  | !validPassword() ) {
            return;
        }
        Boolean checkLogin = datahandler.checkLogin(Email, Password);
        if (checkLogin == true) {
            Toast.makeText(getApplicationContext(), "Logging Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(houseowner.this, houseownermenu.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Logging Failed.", Toast.LENGTH_SHORT).show();
        }

    }
}