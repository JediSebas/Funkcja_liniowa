package com.example.funkcjaliniowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProstaPrzezPunkty extends AppCompatActivity {
    private EditText x1Et, x2Et, y1Et, y2Et;
    private TextView wzorTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prosta_przez_punkty);
        x1Et = (EditText) findViewById(R.id.x1Et);
        x2Et = (EditText) findViewById(R.id.x2Et);
        y1Et = (EditText) findViewById(R.id.y1Et);
        y2Et = (EditText) findViewById(R.id.y2Et);
        wzorTv = (TextView) findViewById(R.id.wzorTv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Prosta przez punkty");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(ProstaPrzezPunkty.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void obli(View view) {
        double x1=0, x2=0, y1=0, y2=0, a, b;
        String x1s, x2s, y1s, y2s;
        try{
            x1s = x1Et.getText().toString().trim();
            x1 = Double.parseDouble(x1s);
        } catch (NumberFormatException e) {x1Et.setText("0");}
        try{
            x2s = x2Et.getText().toString().trim();
            x2 = Double.parseDouble(x2s);
        } catch (NumberFormatException e) {x2Et.setText("0");}
        try{
            y1s = y1Et.getText().toString().trim();
            y1 = Double.parseDouble(y1s);
        } catch (NumberFormatException e) {y1Et.setText("0");}
        try{
            y2s = y2Et.getText().toString().trim();
            y2 = Double.parseDouble(y2s);
        } catch (NumberFormatException e) {y2Et.setText("0");}
        finally {
            try {
                a = (y2 - y1) / (x2 - x1);
                b = (a * -x1) + y1;
                a *= 1000;
                a = Math.round(a);
                a /= 1000;
                if (b > 0){
                    wzorTv.setText("y = " + a + "x + " + b);
                }else if (b < 0){
                    wzorTv.setText("y = " + a + "x - " + Math.abs(b));
                }else if (b == 0){
                    wzorTv.setText("y = " + a + "x");
                }else{
                    wzorTv.setText("y = ax + b");
                }
            }catch (Exception e){wzorTv.setText("Błędne dane");}
        }
    }
}