package com.example.lorentzfactorcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MainActivity4 extends AppCompatActivity {
    EditText velocity;
    EditText lor_factor;
    Button check;
    Vibrator vibrator;
    double vel1,lor1;
    TextView result;
    ConstraintLayout constraintLayout;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        constraintLayout = (ConstraintLayout) findViewById(R.id.lay);
        velocity = findViewById(R.id.editTextTextPersonName);
        lor_factor = findViewById(R.id.editTextTextPersonName2);
        check = findViewById(R.id.button5);
        result = findViewById(R.id.textView5);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        velocity.addTextChangedListener(login);
        lor_factor.addTextChangedListener(login);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String in1 = velocity.getText().toString();
                String lor2 = lor_factor.getText().toString();
                vel1 = Double.parseDouble(in1);
                lor1 = Double.parseDouble(lor2);
                if(vel1>=(3*pow(10,8))){
                    Toast.makeText(MainActivity4.this, "invalid speed input", Toast.LENGTH_SHORT).show();
                }else{
                convertvel(vel1,lor1);
                }
            }
        });
    }
    void convertvel(double vel,double fact){
        double lor=1/(sqrt(1-(vel*vel/(9*pow(10,16)))));
        double g = Math.round(lor*100000000d)/100000000d;
        if(g==fact){
            result.setText("congrats!you got the correct answer");
            constraintLayout.setBackgroundResource(R.color.green);
        }else{
            result.setText(String.format("sorry! you got the wrong answer the correct answer is %.8f",lor));
            vibrator.vibrate(1000);
            constraintLayout.setBackgroundResource(R.color.red);
        }
    }
    private TextWatcher login =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String s1 = velocity.getText().toString().trim();
            String s2 = lor_factor.getText().toString().trim();
            if(!s1.isEmpty() && !s2.isEmpty()){
                check.setEnabled(true);
            }else{
                check.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}