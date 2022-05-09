package com.example.cwapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spn1,spn2;
    EditText txtname,txtsurname;
    RadioButton male,female;
    Button btnok;
    String[] category={"Computer","Camera","Mobile Phone"};
    String product[][] = new String[][]  {
            new String[] {"HP","Acer","Dell","Asus"},
            new String[] {"Canon","Fuji","Nikon","Casio"},
            new String[] {"Apple","Samsung","Vivo","Huawei"}
    };
    String cate;
    String pro;
    ArrayAdapter<String> adp_cate=null;
    ArrayAdapter<String> adp_pro=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 =findViewById(R.id.spn1);
        spn2 =findViewById(R.id.spn2);
        txtname = findViewById(R.id.ename);
        txtsurname = findViewById(R.id.esurname);
        male = findViewById(R.id.Male);
        female = findViewById(R.id.Female);
        btnok = findViewById(R.id.ok);

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "Name :"+txtname.getText().toString();
                str += "\n Surname:"+txtsurname.getText().toString();
                str += "\n Category :"+cate;
                str += "\n Product :"+pro;
                String sex = "";
                if(male.isChecked()){
                    sex=male.getText().toString();
                }else {
                    sex =female.getText().toString();
                }
                str +="\n Gender:"+sex;
                Intent obj = new Intent(MainActivity.this,Showdata.class);
                obj.putExtra("Name",txtname.getText().toString());
                obj.putExtra("SurName",txtsurname.getText().toString());
                obj.putExtra("Category",cate);
                obj.putExtra("Product",pro);
                obj.putExtra("Gender",sex);
                startActivity(obj);
            }
        });

        adp_cate = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_dropdown_item_1line,category);
        spn1.setAdapter(adp_cate);
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if(position==0){
                   adp_pro = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_dropdown_item_1line,product[0]);

               }
                if(position==1){
                    adp_pro = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_dropdown_item_1line,product[1]);
                }
                if(position==2){
                    adp_pro = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_dropdown_item_1line,product[2]);
                }
                spn2.setAdapter(adp_pro);
                cate = parent.getItemAtPosition(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int p, long id) {

                pro = parent.getItemAtPosition(p).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}

