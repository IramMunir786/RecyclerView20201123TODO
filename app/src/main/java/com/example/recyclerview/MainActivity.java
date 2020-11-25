package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_submit=findViewById(R.id.Submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name=findViewById(R.id.nameText);
                EditText dob=findViewById(R.id.dateText);
                EditText city=findViewById(R.id.cityText);

                String Name=name.getText().toString();
                String DOB=dob.getText().toString();
                String City=city.getText().toString();

                if (name.length()==0){
                    Toast.makeText(MainActivity.this, "Name Field is empty", Toast.LENGTH_SHORT).show();
                    name.requestFocus();
                    dob.clearFocus();
                    city.clearFocus();
                    return;
                }


                if (dob.length()==0){
                    Toast.makeText(MainActivity.this, "Date Field is empty", Toast.LENGTH_SHORT).show();
                    dob.requestFocus();
                    name.clearFocus();
                    city.clearFocus();
                    return;
                }

                if (city.length()==0){
                    Toast.makeText(MainActivity.this, "City Field is empty", Toast.LENGTH_SHORT).show();
                    city.requestFocus();
                    name.clearFocus();
                    dob.clearFocus();
                    return;
                }

                for (int i=0;i<name.length();i++){
                    if ((Name.charAt(i)>='A' && Name.charAt(i)<='Z') ||(Name.charAt(i)>='a' && Name.charAt(i)<='z') ){
                        //valid name char
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Name Field should contain alphabets only", Toast.LENGTH_SHORT).show();
                        name.requestFocus();
                        dob.clearFocus();
                        city.clearFocus();
                        return;
                    }
                }

                for (int i=0;i<dob.length();i++){
                    if (DOB.charAt(i)>='0' && DOB.charAt(i)<='9'){
                        //valid date
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Date Field should contain numbers only", Toast.LENGTH_SHORT).show();
                        dob.requestFocus();
                        name.clearFocus();
                        city.clearFocus();
                        return;
                    }
                }

                for (int i=0;i<city.length();i++){
                    if ((City.charAt(i)>='A' && City.charAt(i)<='Z') ||(City.charAt(i)>='a' && City.charAt(i)<='z') ){
                        //valid city char
                    }
                    else{
                        Toast.makeText(MainActivity.this, "City Field should contain alphabets only", Toast.LENGTH_SHORT).show();
                        city.requestFocus();
                        dob.clearFocus();
                        name.clearFocus();
                        return;
                    }
                }
            Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("name",Name);
                intent.putExtra("date",DOB);
                intent.putExtra("city",City);
                startActivity(intent);
            }
        });
    }

}