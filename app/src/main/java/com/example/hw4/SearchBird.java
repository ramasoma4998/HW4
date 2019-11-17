package com.example.hw4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchBird extends AppCompatActivity implements View.OnClickListener{

    EditText EnterZipCode;
    TextView BirdName;
    TextView SearchedPerson;
    Button Search;
    Button Report;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Birds");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bird);

        EnterZipCode = findViewById(R.id.EnterZipCode);
        Search = findViewById(R.id.Search);
        BirdName = findViewById(R.id.SearchedBird);
        SearchedPerson = findViewById(R.id.SearchedPerson);
        Report = findViewById(R.id.Report);

        Search.setOnClickListener(this);
        Report.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == Search) {

            int zipcode = Integer.parseInt(EnterZipCode.getText().toString());
            myRef.orderByChild("zipcode").equalTo(zipcode).addChildEventListener(new ChildEventListener() {

                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Bird FromDatabase = dataSnapshot.getValue(Bird.class);

                    String DataName = FromDatabase.birdname;
                    String DataPerson = FromDatabase.personname;

                    BirdName.setText(DataName);
                    SearchedPerson.setText(DataPerson);

                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
        else if (view == Report) {
            Intent search = new Intent(SearchBird.this, MainActivity.class);
            startActivity(search);
        }

    }
}
