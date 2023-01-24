package com.example.cleany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cleany.database.AddReview;
import com.example.cleany.database.datahandler;
import com.google.android.material.textfield.TextInputLayout;

public class addreviewads extends AppCompatActivity {
    TextInputLayout review;
    datahandler dataHandler = new datahandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addreviewads);
        review = findViewById(R.id.review);
        //database
        dataHandler.openDB();
    }
    public void addReview(View view) {
        String Review = review.getEditText().getText().toString().trim();


        if (!validReview()) {
            return;
        }


        AddReview addReview = new AddReview( Review);
        try {
            dataHandler.AddReview_Create(addReview);
            Toast.makeText(getApplicationContext(), "Review Submitted.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }

    }

    private boolean validReview() {
        String Review = review.getEditText().getText().toString().trim();

        if (Review.isEmpty()) {
            review.setError("Review is Empty.");
            return false;
        } else {
            review.setError(null);
            return true;
        }

    }
}