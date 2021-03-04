package com.example.ComplexNum;

// Complex Num Code for ESC Pset 1
public class MyClass {
    public static void main(String[] args){
        // declare complex num
        ComplexNum c1 = new ComplexNum(1, 2);
        ComplexNum c2 = new ComplexNum(2, 3);
        ComplexNumOperations op = new ComplexNumOperations(c1, c2);
        System.out.println(op.sum());
        System.out.println(op.diff());
        System.out.println(op.divide());
        System.out.println(op.multiply());
    }

}