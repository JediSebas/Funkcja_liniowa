package com.example.funkcjaliniowa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MiejscaZerowe extends AppCompatActivity {

    private EditText aEt, bEt;
    private TextView wyn1Tv, wyn2Tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miejsca_zerowe);
        aEt = (EditText) findViewById(R.id.aEt);
        bEt = (EditText) findViewById(R.id.bEt);
        wyn1Tv = (TextView) findViewById(R.id.wyn1Tv);
        wyn2Tv = (TextView) findViewById(R.id.wyn2Tv);
    }

    public void check(View view) {
        String as, bs;
        double a=1, b=0;
        try{
            as = aEt.getText().toString().trim();
            a = Double.parseDouble(as);
        } catch (NumberFormatException e) {aEt.setText("1");}
        try{
            bs = bEt.getText().toString().trim();
            b = Double.parseDouble(bs);
        } catch (NumberFormatException e) {bEt.setText("0");}
        finally {
            double x, y;
            if (a == 0){
                aEt.setText("1");
                a = 1;
            }
            x = -b/a;
            x *= 1000;
            x = Math.round(x);
            x /= 1000;
            y = b;
            wyn1Tv.setText("y = 0 ↔ x = " + x);
            wyn2Tv.setText("x = 0 ↔ y = " + y);
        }
    }
}