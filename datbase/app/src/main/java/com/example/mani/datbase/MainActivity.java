package com.example.mani.datbase;

/**
 * Created by mani on 13-02-2018.
 */

import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.widget.ToggleButton;


        import com.example.mani.datbase.R;
        import com.example.mani.datbase.helper;
        import com.example.mani.datbase.Blood;


        import java.util.ArrayList;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

     helper db;
    List<Blood> bloods;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


            db = new helper(this);

            final EditText name = (EditText) findViewById(R.id.name);
            final EditText hostel = (EditText) findViewById(R.id.hostel);
            final EditText bloodgroup = (EditText) findViewById(R.id.bloodgroup);

            Button showdata = (Button) findViewById(R.id.showdata);
            Button submitbutton = (Button) findViewById(R.id.submit_button);
            submitbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String names = name.getText().toString();
                    final String hostels = hostel.getText().toString();
                    final String bloodgroups = bloodgroup.getText().toString();

                    Blood blood = new Blood(names , hostels , bloodgroups);
                    db.createBlood(blood);

                }
            });

        showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, storing_data.class);
                startActivity(intent);
            }
        });

        }


    }

    // for the options on left



