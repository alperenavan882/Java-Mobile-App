package com.alperenavan.methodsandclasses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("on create called");

        testMethod();
        System.out.println(calculation(4,5));

        username = "";

        createMusicianProfile();
        createSimpsons();
    }

    public void createMusicianProfile(){
        Musicians alperen = new Musicians("James","Guitar",50);

        //alperen.name = "Alperen";
        //alperen.instrument = "Baglama";
        //alperen.age = 21;

        System.out.println(alperen.name+alperen.instrument+alperen.age);
    }

    public void createSimpsons(){

        Simpsons homer = new Simpsons("Homer",50,"Nuclear");

        System.out.println(homer.getName());
        System.out.println(homer.getAge());
        System.out.println(homer.getJob());

        homer.setName("Alperen");
        homer.setAge(21);
        homer.setJob("Software Engineering");

        System.out.println("\n\n");
        System.out.println(homer.getName());
        System.out.println(homer.getAge());
        System.out.println(homer.getJob());

    }

    public void testMethod(){
        int x = 4;
        System.out.println("x = " + x);

        username = "Alex";
    }

    public int calculation(int a,int b){
        //int x = 3;
        //int y = 4;
//
        //return x+y;

        username = "Szymanski";

        return a+b;
    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("on resume called");

        username = "Tadic";
    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("on pause called");

        username = "Dzeko";
    }

    @Override
    protected void onStop() {
        super.onStop();

        System.out.println("on stop called");

        username = "Fred";
    }
}