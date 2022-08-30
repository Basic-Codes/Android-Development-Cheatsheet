package com.example.labreport04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    EditText emailInput;
    EditText passwordInput;
    EditText mobileInput;
    DBHandler db;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> names = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (EditText)findViewById(R.id.name);
        emailInput = (EditText)findViewById(R.id.email);
        passwordInput = (EditText)findViewById(R.id.password);
        mobileInput = (EditText)findViewById(R.id.mobile);
        listView = (ListView) findViewById(R.id.list_view);

        db = new DBHandler(this);

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
    }

    public void submitForm(View v) {
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String mobile = mobileInput.getText().toString();

        db.add(name, email, password, mobile);

        List<User> contacts = db.getAllUsers();

        Log.d("================", "=================");
        for (User item : contacts) {
            String log = "Id: " + item.id + " ,Name: " + item.name + " ,Email: " + item.email + " ,Password: " + item.password + " ,Phone: " + item.phone;
            Log.d("ID " + item.id, log);

            names.add(item.name);
        }
        Log.d("================", "=================");

        adapter.notifyDataSetChanged();
    }
}