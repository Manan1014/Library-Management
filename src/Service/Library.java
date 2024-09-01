package com.example.library;
import java.util.*;
public class Library{
    //User can choose their method
    void chhoseoperation(){
        System.out.println("enter 1 for adding book");
        System.out.println("enter 2 for borrowbook book");
        System.out.println("enter 3 for returnbook");
        System.out.println("enter 4 for viewing book");
    }

    void userinput(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        switch(x){
            case 1:
                System.out.println("Addbook functionality");
                break;
            case 2:
                System.out.println("Borrowbook functionality");
                break;
            case 3:
                System.out.println("Returnbook functionality");
                break;
            case 4:
                System.out.println("Viewbook functionality");
                break;
            default:
                System.out.println("invalid input");
        }
    }
}