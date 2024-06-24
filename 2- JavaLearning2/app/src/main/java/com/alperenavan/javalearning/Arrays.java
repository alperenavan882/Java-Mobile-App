package com.alperenavan.javalearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Arrays {

    public static void main(String[] args){

        String[] myStringArray = new String[3];

        myStringArray[0] = "Alperen";
        myStringArray[1] = "Ahmet";
        myStringArray[2] = "Berke";

        System.out.println(myStringArray);

        int[] myIntArray = {21,21,20};

        for(int i=0;i<3;i++){
            System.out.println(myStringArray[i]+"'s age = "+myIntArray[i]+"\n");
        }



        //Lists

        ArrayList<String> myStringArrayList = new ArrayList<String>();

        //You can't declare same value on different indexes for list method.

        myStringArrayList.add("Alperen");
        myStringArrayList.add("Avan");
        myStringArrayList.add("Alperen");
        myStringArrayList.add(0,"Hasan Kalyoncu Universitesi");

        System.out.println(myStringArrayList.get(0));
        System.out.println(myStringArrayList.get(1));

        System.out.println(myStringArrayList.size());

        //Sets , HashSet

        //You can't declare the same value on different indexes for this method also.
        HashSet<String> mySet = new HashSet<String>();
        mySet.add("Alperen");
        mySet.add("Alperen");

        System.out.println(mySet.size());

        //Hashmap

        HashMap<String,String> myHashMap = new HashMap<String,String>();

        myHashMap.put("name","Alperen");

        myHashMap.put("profession","Software Engineer");

        System.out.println(myHashMap.get("name")+" "+myHashMap.get("profession"));

        //Because of int is primitive we need to use Integer to create an HashMap

        HashMap<String,Integer> mySecondMap = new HashMap<String,Integer>();

        mySecondMap.put("Football",1000);
        mySecondMap.put("Golf",100);

        System.out.println(mySecondMap.get("Football"));



    }

}
