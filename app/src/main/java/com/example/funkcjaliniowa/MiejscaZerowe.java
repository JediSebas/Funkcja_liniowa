package com.example.funkcjaliniowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabmz);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aEt.setText("");
                bEt.setText("");
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Miejsca zerowe");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(MiejscaZerowe.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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