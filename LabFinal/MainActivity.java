package com.example.labfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button login_button;
    Button register_button;

    EditText nameInput;
    EditText emailInput;
    EditText passwordInput;
    EditText mobileInput;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

        nameInput = (EditText) findViewById(R.id.name);
        passwordInput = (EditText)findViewById(R.id.password);
        mobileInput = (EditText)findViewById(R.id.mobile);

        db = new DBHandler(this);
    }

    public void addListenerOnButton() {

        final Context context = this;

        login_button = (Button) findViewById(R.id.button3);
        register_button = (Button) findViewById(R.id.button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                submitForm();
            }
        });
    }

    public void submitForm() {
        String name = nameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String mobile = mobileInput.getText().toString();

        db.add(name, password, mobile);

        List<User> contacts = db.getAllUsers();

        Log.d("================", "=================");
        for (User item : contacts) {
            String log = "Id: " + item.id + " ,Name: " + item.name + " ,Password: " + item.password + " ,Phone: " + item.phone;
            Log.d("ID " + item.id, log);
        }
        Log.d("================", "=================");
    }
}