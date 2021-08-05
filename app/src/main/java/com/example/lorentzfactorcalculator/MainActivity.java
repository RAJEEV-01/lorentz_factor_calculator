package com.example.lorentzfactorcalculator;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button2);
        b2 = findViewById(R.id.button3);
    }
    public void openactivity(View v){
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
    public void openactivity1(View v){
        Intent intent = new Intent(this,MainActivity5.class);
        startActivity(intent);
    }
}
