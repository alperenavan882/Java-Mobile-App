package com.alperenavan.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alperenavan.simplecalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    public double first;
    public double second;
    public double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        activityMainBinding.addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addition();
            }
        });

        activityMainBinding.substraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                substraction();
            }
        });

        activityMainBinding.multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplication();
            }
        });

        activityMainBinding.division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                division();
            }
        });

    }

    public void addition(){

        if(activityMainBinding.number1Text.getText().toString().matches("") || activityMainBinding.number2Text.getText().toString().matches("")){
            activityMainBinding.resultText.setText("Please enter a number.");
        }else{
            first = Double.parseDouble(activityMainBinding.number1Text.getText().toString());
            second = Double.parseDouble(activityMainBinding.number2Text.getText().toString());

            result = first+second;

            activityMainBinding.resultText.setText("Result = " + result);
        }

    }

    public void substraction(){

        if(activityMainBinding.number1Text.getText().toString().matches("") || activityMainBinding.number2Text.getText().toString().matches("")){
            activityMainBinding.resultText.setText("Please enter a number.");
        }else{
            first = Double.parseDouble(activityMainBinding.number1Text.getText().toString());
            second = Double.parseDouble(activityMainBinding.number2Text.getText().toString());

            result = first - second;

            activityMainBinding.resultText.setText("Result = "+result);
        }

    }

    public void multiplication(){

        if(activityMainBinding.number1Text.getText().toString().matches("") || activityMainBinding.number2Text.getText().toString().matches("")){
            activityMainBinding.resultText.setText("Please enter a number.");
        }else{
            first = Double.parseDouble(activityMainBinding.number1Text.getText().toString());
            second = Double.parseDouble(activityMainBinding.number2Text.getText().toString());

            result = first * second;

            activityMainBinding.resultText.setText("Result = "+result);
        }

    }

    public void division(){

        if(activityMainBinding.number1Text.getText().toString().matches("") || activityMainBinding.number2Text.getText().toString().matches("")){
            activityMainBinding.resultText.setText("Please enter a number.");
        }else{
            first = Double.parseDouble(activityMainBinding.number1Text.getText().toString());
            second = Double.parseDouble(activityMainBinding.number2Text.getText().toString());

            result = first / second;

            activityMainBinding.resultText.setText("Result = "+result);
        }

    }
}