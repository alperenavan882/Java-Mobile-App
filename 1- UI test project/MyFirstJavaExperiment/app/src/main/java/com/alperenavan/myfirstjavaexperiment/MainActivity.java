package com.alperenavan.myfirstjavaexperiment;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void changeImage(View view) {

        ImageView imageView = findViewById(R.id.imageView);

        boolean check=true;

        if(check=true){
            imageView.setImageResource(R.drawable.image2);
            check = false;
        }

    }

    public void returnImage(View view){

        ImageView imageView = findViewById(R.id.imageView);

        boolean check = true;

        if(check=true){
            imageView.setImageResource(R.drawable.image1);
            check = false;
        }
    }
}