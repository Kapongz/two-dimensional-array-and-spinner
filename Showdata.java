package com.example.cwapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Showdata extends AppCompatActivity {
TextView tvname,tvsurname,tvcate,tvpro,tvgen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);

        tvname = findViewById(R.id.txtname);
        tvsurname = findViewById(R.id.txtsurname);
        tvcate = findViewById(R.id.txtcate);
        tvpro = findViewById(R.id.txtpro);
        tvgen = findViewById(R.id.txtgender);

        Bundle b = getIntent().getExtras();
        tvname.setText(b.get("Name").toString());
        tvsurname.setText(b.get("SurName").toString());
        tvcate.setText(b.get("Category").toString());
        tvpro.setText(b.get("Product").toString());
        tvgen.setText(b.get("Gender").toString());
    }
}