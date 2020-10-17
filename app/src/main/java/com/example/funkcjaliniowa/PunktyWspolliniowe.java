package com.example.funkcjaliniowa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PunktyWspolliniowe extends AppCompatActivity {
    private EditText axEt, ayEt, bxEt, byEt, cxEt, cyEt;
    private TextView rownanieTv, wynikTv, prawdaTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punkty_wspolliniowe);
        axEt = (EditText) findViewById(R.id.axEt);
        ayEt = (EditText) findViewById(R.id.ayEt);
        bxEt = (EditText) findViewById(R.id.bxEt);
        byEt = (EditText) findViewById(R.id.byEt);
        cxEt = (EditText) findViewById(R.id.cxEt);
        cyEt = (EditText) findViewById(R.id.cyEt);
        rownanieTv = (TextView) findViewById(R.id.rownanieTv);
        wynikTv = (TextView) findViewById(R.id.wynikTv);
        prawdaTv = (TextView) findViewById(R.id.prawdaTv);
    }

    public void oblicz(View view) {
        String axs, ays, bxs, bys, cxs, cys;
        double ax=0, ay=0, bx=0, by=0, cx=0, cy=0;
        try{
            axs = axEt.getText().toString().trim();
            ax = Double.parseDouble(axs);
        }catch (NumberFormatException e){axEt.setText("0");}
        try{
            ays = ayEt.getText().toString().trim();
            ay = Double.parseDouble(ays);
        }catch (NumberFormatException e){ayEt.setText("0");}
        try{
            bxs = bxEt.getText().toString().trim();
            bx = Double.parseDouble(bxs);
        }catch (NumberFormatException e){bxEt.setText("0");}
        try{
            bys = byEt.getText().toString().trim();
            by = Double.parseDouble(bys);
        }catch (NumberFormatException e){byEt.setText("0");}
        try{
            cxs = cxEt.getText().toString().trim();
            cx = Double.parseDouble(cxs);
        }catch (NumberFormatException e){cxEt.setText("0");}
        try{
            cys = cyEt.getText().toString().trim();
            cy = Double.parseDouble(cys);
        }catch (NumberFormatException e){cyEt.setText("0");}
        finally {
            double a, b;
            a = cy - ay;
            b = ((by - ay)/(bx - ax)) * (cx - ax);
            a *= 10000;
            a = Math.round(a);
            a /= 10000;
            b *= 10000;
            b = Math.round(b);
            b /= 10000;
            rownanieTv.setText(cy + " - " + ay + " = " + "[(" + by + " - " + ay + ")/(" + bx + " - " + ax + ")] * (" + cx + " - " + ax + ")");
            wynikTv.setText(a + " = " + b);
            if (a == b){
                prawdaTv.setText("TAK");
            }else if (a != b){
                prawdaTv.setText("NIE");
            }
        }
    }
}