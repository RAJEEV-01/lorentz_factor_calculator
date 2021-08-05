package com.example.lorentzfactorcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.Math.pow;

public class MainActivity5 extends AppCompatActivity {
    TextView currenttime;
    TextView currentspi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        currenttime = findViewById(R.id.textView4);
        currentspi = findViewById(R.id.textView7);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Calendar calendar = Calendar.getInstance();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                                String time = simpleDateFormat.format(calendar.getTime());
                                String[] units = time.split(":");
                                int hr = Integer.parseInt(units[0]);
                                int min = Integer.parseInt(units[1]);
                                int sec = Integer.parseInt(units[2]);
                                spical(hr, min, sec);
                                currenttime.setText(time);
                            }
                        });
                    }
                } catch (Exception e) {
                    currenttime.setText(R.string.app_name);
                }
            }
        };
        thread.start();

    }

    public void spical(int th, int tm, int ts) {
        double spi = fact(th) / (pow(tm, 3) + ts);
        currentspi.setText(String.valueOf(spi));

    }

    public int fact(int x) {
        if (x == 0 || x == 1) {
            return 1;
        } else
            return x * fact(x - 1);
    }
}