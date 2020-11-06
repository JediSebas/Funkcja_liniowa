package com.example.funkcjaliniowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ProstopadloscProstej extends AppCompatActivity{
    private EditText aEt, xEt, yEt;
    private TextView wynTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prostopadlosc_prostej);
        aEt = (EditText) findViewById(R.id.aaaEt);
        xEt = (EditText) findViewById(R.id.xxxEt);
        yEt = (EditText) findViewById(R.id.yyyEt);
        wynTv = (TextView) findViewById(R.id.wynrTv);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabb);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "x i y odnoszą się od punktu P(x, y)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Prostopadłość prostej");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(ProstopadloscProstej.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void obl(View view) {
        String as, xs, ys;
        double a=1, b, x=0, y=0, ap;
        try {
            as = aEt.getText().toString().trim();
            a = Double.parseDouble(as);
            double l = 1 /a;
        } catch (NumberFormatException e) { aEt.setText("1"); a=1; }
        try {
            xs = xEt.getText().toString().trim();
            x = Double.parseDouble(xs);
        } catch (NumberFormatException e) { xEt.setText("0"); }
        try {
            ys = yEt.getText().toString().trim();
            y = Double.parseDouble(ys);
        } catch (NumberFormatException e) { yEt.setText("0"); }
        finally {
            ap = -1/a;
            b = y - ap*x;
            ap *= 1000;
            ap = Math.round(ap);
            ap /= 1000;
            if (b > 0){
                wynTv.setText("y = " + ap + "x + " + b);
            }else if (b < 0){
                wynTv.setText("y = " + ap + "x - " + Math.abs(b));
            }else if (b == 0){
                wynTv.setText("y = " + ap + "x");
            }
        }
    }

}