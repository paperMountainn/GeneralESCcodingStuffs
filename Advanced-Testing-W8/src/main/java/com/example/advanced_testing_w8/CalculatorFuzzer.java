package com.example.advanced_testing_w8;

import java.util.Random;

/**
 * Pset 3 Qn 4
 * This is a fuzzer created to generate random inputs for calculator in java
 */
public class CalculatorFuzzer {

    Random rand = new Random();

    private String fuzzExpr(String expr){
        String[] choice = {"Expr + Term", "Expr - Term", "Term"};
        String result = choice[rand.nextInt(choice.length)];
        return result;

    }
    private String fuzzTerm(String term){
        String[] choice = {"Term * Factor", "Term / Factor", "Factor"};
        String result = choice[rand.nextInt(choice.length)];
        return result;
    }
    private String fuzzFactor(String factor){
        String[] choice = {"-Integer", "Expr", "Integer", "Integer.Integer"};
        String result = choice[rand.nextInt(choice.length)];
        return result;
    }
    private String fuzzInteger(String integer){
        String[] choice = {"Digit", "IntegerDigit"};
        String result = choice[rand.nextInt(choice.length)];
        return result;
    }
    private String fuzzDigit(String digit){
        String result = String.valueOf(rand.nextInt(10) + 1);
        return result;
    }

    public String fuzzer(){
        String output = "Expr";
        while (output.contains("Expr")) {
            output = fuzzExpr(output);
            while (output.contains("Term")) {
                output = output.replaceFirst("Term", fuzzTerm("Term"));
            }
            while (output.contains("Factor")) {
                output = output.replaceFirst("Factor", fuzzFactor("Factor"));
            }

        }

        while (output.contains("Integer")){
            output = output.replaceFirst("Integer", fuzzInteger("Integer"));
        }
        while (output.contains("Digit")){
            output = output.replaceFirst("Digit", fuzzDigit("Digit"));
        }

        return output;

    }


    public static void main(String[] args){
        CalculatorFuzzer fuzzer = new CalculatorFuzzer();
        String out = fuzzer.fuzzer();
        System.out.println(out);
        String out1 = fuzzer.fuzzer();
        System.out.println(out1);

    }


}

