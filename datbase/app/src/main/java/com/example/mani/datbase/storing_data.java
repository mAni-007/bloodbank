package com.example.mani.datbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class storing_data extends AppCompatActivity {
helper db;


    List<Blood> bloods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storing_data);

        db = new helper(this);

        final EditText nametext = (EditText) findViewById(R.id.name_edittext);
        final EditText gendertext = (EditText) findViewById(R.id.gender_edittext);

        Button submitbutton = (Button) findViewById(R.id.submit_button);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = nametext.getText().toString();
                final String gender = gendertext.getText().toString();

                Blood blood = new Blood(name, gender ,);
                db.createBlood(blood);


                db = new helper(this);
                switches = db.getAllSwitches();


                List<Blood> bloods = new ArrayList<Blood>() ;
                bloods = db.getAllBloods();
                recyclerView.setAdapter(new SwitchAdapter(bloods, R.layout.list_switches, getApplicationContext()));



            }
        });

    }
}
