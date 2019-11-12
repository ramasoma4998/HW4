package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchBird extends AppCompatActivity implements View.OnClickListener{

    EditText EnterZipCode;
    TextView BirdName;
    TextView SearchedPerson;
    Button Search;
    Button Report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bird);

        EnterZipCode = findViewById(R.id.EnterZipCode);
        Search = findViewById(R.id.Search);
        BirdName = findViewById(R.id.SearchedBird);
        SearchedPerson = findViewById(R.id.SearchedPerson);
        Report = findViewById(R.id.Report);
    }


    @Override
    public void onClick(View view) {
        int zip = Integer.parseInt(EnterZipCode.getText().toString());

        if (view == Search) {
//Shit
            int ok;

        }
        else(view == Report) {
            Intent search = new Intent(SearchBird.this, MainActivity.class);
            startActivity(search);
        }

    }
}
