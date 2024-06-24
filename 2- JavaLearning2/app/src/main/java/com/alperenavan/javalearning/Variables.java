package com.alperenavan.javalearning;

public class Variables {

    public static void main(String[] args){ //psvm is shorter way to type this method.

        System.out.println("Hello Java!");
        //The shorter way of type this method is sout

        //Variables

        //Integer
        int age = 20;

        System.out.println(age);

        //Double-Float
        double price = 20;

        float price4 = 20.0f;//When we use float with decimal we need to use 'f' after the numbers.

        double pi = 3.14;

        int r = 5;

        System.out.println(2*pi*r);

        //String

        String name = "Alperen";
        String surname = "Avan";

        String fullname;

        fullname = name+" "+surname;

        //System.out.println(name);
//
        //System.out.println(surname);
//
        //System.out.println(fullname);

        //Boolean

        boolean isAlive = true;
        System.out.println(isAlive);

        //You can not change the variable type after declare it in Java.

        //Final

        //This type cant be change because its final value

        final int example = 5;

        System.out.println(example);






    }

}
