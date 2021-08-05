package com.example.lorentzfactorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MainActivity3 extends AppCompatActivity {
    double vel;
    TextView result;
    private Button convert;
    private EditText input1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        input1 = findViewById(R.id.input);
        convert=findViewById(R.id.button);
        result=findViewById(R.id.value);
        input1.addTextChangedListener(loginTextwatcher);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputTemp=input1.getText().toString();
                vel=Double.parseDouble(inputTemp);
                if(vel>=(3*pow(10,8))){
                    Toast.makeText(MainActivity3.this, "invalid input", Toast.LENGTH_SHORT).show();
                }else{
                    convertvel(vel);
                }
            }
        });

    }
    void convertvel(double vel){
        double lor=1/(sqrt(1-(vel*vel/(9*pow(10,16)))));
        result.setText("The value of lorentz factor is "+String.valueOf((lor)));
    }
    public void newactivity(View v){
        Toast.makeText(this, "opening practice mode", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity4.class);
        startActivity(intent);
    }
    private TextWatcher loginTextwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String set = input1.getText().toString().trim();
            if (!set.isEmpty()){
                convert.setEnabled(true);
            }else {
                convert.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}