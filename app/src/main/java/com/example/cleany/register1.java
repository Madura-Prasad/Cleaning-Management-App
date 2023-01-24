package com.example.cleany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.cleany.database.datahandler;
import com.example.cleany.database.houseOwner;
import com.google.android.material.textfield.TextInputLayout;

public class register1 extends AppCompatActivity {

    TextInputLayout fullname,age,mobilenumber,residence,email,password,repeatpassword;
    datahandler datahandler = new datahandler( this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        fullname = findViewById(R.id.Fname);
        age= findViewById(R.id.Age);
        mobilenumber = findViewById(R.id.Mnumber);
        residence = findViewById(R.id.Residence);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repeatpassword = findViewById(R.id.repeat_Password);

        datahandler.openDB();


    }
    //name validation
    private boolean validName() {
        String fname = fullname.getEditText().getText().toString().trim();


        if (fname.isEmpty()) {
            fullname.setError("Username is Empty.");
            return false;
        }  else {
            fullname.setError(null);
            return true;
        }

    }

    //age validation
    private boolean validNic() {
        String nic = age.getEditText().getText().toString().trim();

        if (nic.isEmpty()) {
            age.setError("Nic is Empty.");
            return false;
        } else {
            age.setError(null);
            return true;
        }

    }

    //residence validation
    private boolean validAddress() {
        String address = residence.getEditText().getText().toString().trim();

        if (address.isEmpty()) {
            residence.setError("Mobile is Empty.");
            return false;
        } else {
            residence.setError(null);
            return true;
        }

    }

    //MobileNumber validation
    private boolean validMobile() {
        String mobile = mobilenumber.getEditText().getText().toString().trim();

        if (mobile.isEmpty()) {
            mobilenumber.setError("Mobile is Empty.");
            return false;
        } else {
            mobilenumber.setError(null);
            return true;
        }

    }


    //Email validation
    private boolean validEmail() {
        String Email = email.getEditText().getText().toString().trim();

        if (Email.isEmpty()) {
            email.setError("Username is Empty.");
            return false;
        } else {
            email.setError(null);
            return true;
        }

    }


    //password validation
    private boolean validPassword() {
        String pass = password.getEditText().getText().toString().trim();
        String cpass = repeatpassword.getEditText().getText().toString().trim();
       // String vpassword = "^(?=.*[0-9])"
             //   + "(?=.[a-z])(?=.[A-Z])"
               // + "(?=.*[@#$%^&+=])"
              //  + "(?=\\S+$).{8,20}$";

        if (pass.isEmpty()) {
            password.setError("Password is Empty.");
            return false;
      //  } else if (!pass.matches(vpassword)) {
      //      password.setError("Use Strong Password.");
      //     return false;
        } else if (!pass.matches(cpass)) {
            password.setError("Please Use same Password");
            return false;
        } else {
            password.setError(null);
            return true;
        }

    }

    //confirm password validation
    private boolean validCPassword() {
        String cpass = repeatpassword.getEditText().getText().toString().trim();
        String pass = password.getEditText().getText().toString().trim();

        if (cpass.isEmpty()) {
            repeatpassword.setError("Confirm Password is Empty.");
            return false;
        } else if (!pass.matches(cpass)) {
            repeatpassword.setError("Please Use same Password");
            return false;
        } else {
            repeatpassword.setError(null);
            return true;
        }

    }

    public void houseowner (View view) {
        String Name = fullname.getEditText().getText().toString().trim();
        String Age = age.getEditText().getText().toString().trim();
        String Residence = residence.getEditText().getText().toString().trim();
        String mobile = mobilenumber.getEditText().getText().toString().trim();
        String Email = email.getEditText().getText().toString().trim();
        String Password = password.getEditText().getText().toString().trim();
        String C_Password = repeatpassword.getEditText().getText().toString().trim();

        if (!validEmail() |!validName() | !validNic() | !validAddress () | !validMobile()  | !validPassword() | !validCPassword()) {
            return;
        }


        houseOwner houseOwner = new houseOwner (Name, Age, Residence, mobile, Email, Password,C_Password);

        try {
            datahandler.houseowner_Create(houseOwner);
            Toast.makeText(getApplicationContext(), "Successfully Registered.", Toast.LENGTH_SHORT).show();



        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }
    }


























}