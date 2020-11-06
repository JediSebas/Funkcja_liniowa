package com.example.funkcjaliniowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.zeroBtn:
                intent = new Intent(MainActivity.this, MiejscaZerowe.class);
                startActivity(intent);
                break;
            case R.id.wspolBtn:
                intent = new Intent(MainActivity.this, PunktyWspolliniowe.class);
                startActivity(intent);
                break;
            case R.id.prostBtn:
                intent = new Intent(MainActivity.this, ProstopadloscProstej.class);
                startActivity(intent);
                break;
            case R.id.punktBtn:
                intent = new Intent(MainActivity.this, ProstaPrzezPunkty.class);
                startActivity(intent);
                break;
            case R.id.rownlBtn:
                intent = new Intent(MainActivity.this, ProstaRownolegla.class);
                startActivity(intent);
                break;
        }
    }
}