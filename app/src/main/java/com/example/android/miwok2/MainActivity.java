package com.example.android.miwok2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbers = (TextView) findViewById(R.id.numbers);
        numbers.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent openNumbersList = new Intent(MainActivity.this,NumbersActivity.class);
                openNumbersList.getAction();
                startActivity(openNumbersList);


            }
        });
        TextView colors = (TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent openColorsList = new Intent(MainActivity.this,ColorsActivity.class);
                openColorsList.getAction();
                startActivity(openColorsList);


            }
        });
        TextView phrases = (TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent openPhrasesList = new Intent(MainActivity.this,PhrasesActivity.class);
                openPhrasesList.getAction();
                startActivity(openPhrasesList);


            }
        });
        TextView family = (TextView) findViewById(R.id.family);
        family.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent openFamilyList = new Intent(MainActivity.this,FamilyActivity.class);
                openFamilyList.getAction();
                startActivity(openFamilyList);


            }
        });
    }
}

