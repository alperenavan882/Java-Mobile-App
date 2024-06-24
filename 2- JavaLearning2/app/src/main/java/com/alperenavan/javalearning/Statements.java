package com.alperenavan.javalearning;

public class Statements {

    public static void main(String[] args){

        int x = 5;
        System.out.println(x);

        x = x + 1; //x++ is the same
        System.out.println(x);

        int y = 4;
        System.out.println(x > y);
        System.out.println(y > x);
        System.out.println(x >= y);
        System.out.println(x == y);
        System.out.println(x != y);

        // && is 'and'
        // || is 'or'

        x = 3;

        y = 4;

        int z = 5;

        System.out.println(x<y && y<z);
        System.out.println(x>y && y<z);

        //if statements

        for(int i=0;i<2;i++){
            if(x < y){
                System.out.println("Y is bigger than X");
            }else if(x > y){
                System.out.println("X is bigger than Y");
            }else{
                System.out.println("X is equal to Y");
            }
            x = 5;
        }

        //Switch

        /*

        if(day == 1){
            dayString = "Monday";
        }else if(day == 2){
            dayString = "Tuesday";
        }else if(day == 3){
            dayString = "Wednesday";
        }else{
            dayString = "Sunday";
        }
         */

        int day = 5;
        String dayString = "Monday";
        System.out.println(dayString);

        switch(day){

            case 1:
                dayString = "Monday";
                break;
            case 2:
                dayString = "Tuesday";
                break;
            case 3:
                dayString = "Wednesday";
                break;
            case 4:
                dayString = "Thursday";
                break;
            case 5:
                dayString = "Friday";
                break;
            case 6:
                dayString = "Saturday";
                break;
            case 7:
                dayString = "Sunday";
                break;
            default:
                dayString = "Invalid";
        }

        System.out.println(dayString);




    }

}
