package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText BirdName, ZipCode, PersonName;
    Button Submit, Search;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Birds");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BirdName = findViewById(R.id.BirdName);
        ZipCode = findViewById(R.id.ZipCode);
        PersonName = findViewById(R.id.PersonName);
        Submit = findViewById(R.id.Submit);
        Search = findViewById(R.id.Search);

        Submit.setOnClickListener(this);
        Search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == Submit) {
            String bird = BirdName.getText().toString();
            int zip = Integer.parseInt(ZipCode.getText().toString());
            String name = PersonName.getText().toString();
            Bird temp = new Bird(bird,zip,name);
            myRef.push().setValue(temp);
            Toast.makeText(this, "Bird added to database", Toast.LENGTH_SHORT).show();

        }
        else if (view == Search) {
            Intent search = new Intent(MainActivity.this, SearchBird.class);
            startActivity(search);
        }
    }
}
