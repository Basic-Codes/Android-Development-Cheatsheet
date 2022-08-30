package com.example.basiclogin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

    Button logout_button;
    Button update_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

        update_button = (Button) findViewById(R.id.button1);
        logout_button = (Button) findViewById(R.id.button2);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, ProfileUpdateActivity.class);
                startActivity(intent);

            }
        });
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);

            }
        });

    }

}