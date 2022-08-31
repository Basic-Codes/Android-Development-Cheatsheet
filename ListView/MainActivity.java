package com.example.practiceforfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EditText etInput;
    ListView listFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFont=(ListView)findViewById(R.id.listFont);
        etInput=(EditText)findViewById(R.id.etInput);

        // Adding fonts name to the list
        String[] values = new String[] {"Angilla Tattoo",
                "Cantate Beveled","Krinkes Decor PERSONAL",
                "Krinkes Regular PERSONAL","Silent Reaction"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, values);

        listFont.setAdapter(adapter);

        listFont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String itemValue=(String) listFont.getItemAtPosition(position);

                if(itemValue.equals("Angilla Tattoo")){
                    // Setting up the path of the fonts
                    String fontPath="fonts/AngillaTattoo.ttf";
                    Typeface tf=Typeface.createFromAsset(getAssets(),fontPath);

                    etInput.getText().toString();
                    etInput.setTypeface(tf);
                }
                else if(itemValue.equals("Cantate Beveled")){
                    String fontPath="fonts/CantateBeveled.ttf";
                    Typeface tf=Typeface.createFromAsset(getAssets(),fontPath);

                    etInput.getText().toString();
                    etInput.setTypeface(tf);
                }
                else if(itemValue.equals("Krinkes Decor PERSONAL")){
                    String fontPath="fonts/KrinkesDecorPERSONAL.ttf";
                    Typeface tf=Typeface.createFromAsset(getAssets(),fontPath);

                    etInput.getText().toString();
                    etInput.setTypeface(tf);
                }
                else if(itemValue.equals("Krinkes Regular PERSONAL")){
                    String fontPath="fonts/KrinkesRegularPERSONAL.ttf";
                    Typeface tf=Typeface.createFromAsset(getAssets(),fontPath);

                    etInput.getText().toString();
                    etInput.setTypeface(tf);
                }
                else if(itemValue.equals("Silent Reaction")){
                    String fontPath="fonts/Silent Reaction.ttf";
                    Typeface tf=Typeface.createFromAsset(getAssets(),fontPath);

                    etInput.getText().toString();
                    etInput.setTypeface(tf);
                }
            }
        });
    }
}