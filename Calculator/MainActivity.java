package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int num1 = 0;
    int num2 = 0;
    String operation = "";
    boolean isNum2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v) {
        int result = 0;
        if(operation.equals("+")) {
            result = num1+num2;
        } else if(operation.equals("-")) {
            result = num1-num2;
        } else if(operation.equals("x")) {
            result = num1*num2;
        } else {
            result = num1/num2;
        }
        ((TextView) findViewById(R.id.txtSolution)).setText(Integer.toString(result));
    }

    public void updateInput() {
        String input = "";
        if(!isNum2) {
            input = Integer.toString(num1);
        } else {
            input = Integer.toString(num1) + operation + Integer.toString(num2);
        }
        ((TextView) findViewById(R.id.txtInput)).setText(input);
    }

    public void setNumber(View v) {
        if(!isNum2) {
            num1 = Integer.parseInt(num1 + "" + v.getTag());
        } else {
            num2 = Integer.parseInt(num2 + "" + v.getTag());
        }
        updateInput();
    }

    public void setOperation(View v) {
        operation = ""+v.getTag();
        isNum2 = true;
        updateInput();
    }
    public void clear(View v) {
        operation = "";
        num1 = 0;
        num2 = 0;
        isNum2 = false;
        updateInput();
    }
}