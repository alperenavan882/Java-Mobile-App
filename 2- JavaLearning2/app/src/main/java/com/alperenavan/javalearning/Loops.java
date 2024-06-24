package com.alperenavan.javalearning;

public class Loops {

    public static void main(String[] args){

        //for loop

        int myNumbers[] = {30,60,90};
        //Also it can be declare like 'int[] myNumbers = {30,60,90};

        int x = myNumbers[0] / 3 * 5;

        System.out.println(x);

        for(int i=0;i<myNumbers.length;i++){
            x = myNumbers[i] / 3 * 5;
            System.out.println(x);
        }

        //Now we'll do the same thing but with easier and different method.

        for(int number : myNumbers){ //This method is using with arrays generally.
            System.out.println(number);
        }

        //While

        boolean printCheck = true;

        while(printCheck){
            System.out.println(printCheck);
            System.out.println(printCheck);
            printCheck = false;
        }

        int count = 0;

        while(count <= 5){
            System.out.println(count);
            count++;
        }

    }
}
