package com.example.mani.datbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class storing_data extends AppCompatActivity {
helper db;


    List<Blood> bloods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storing_data);

        db = new helper(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Blood> bloods = new ArrayList<Blood>() ;
        bloods = db.getAllBloods();
        recyclerView.setAdapter(new BloodAdapter(bloods, R.layout.bloodlist, getApplicationContext()));


    }
}
