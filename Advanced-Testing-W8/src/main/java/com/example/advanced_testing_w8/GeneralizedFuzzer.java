package com.example.advanced_testing_w8;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GeneralizedFuzzer {

    /**
     * generate random fileLine
     * @param file
     * @return int fileLine
     */
    public static int randomFileLineGenerator(ArrayList<String> file){
        int range = file.size();
        Random rand = new Random();
        int randFileLine = rand.nextInt(range);

        return randFileLine;
    }


    /**
     *
     * @param filePath
     * @return ArrayList<String> of each line
     * @throws FileNotFoundException
     */
    public static ArrayList<String> readFile(String filePath) throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();

        Scanner s = new Scanner(new File(filePath));

        while (s.hasNext()){
            String line = s.nextLine();
            result.add(line);
        }
        return result;
    }


    /**
     * write a new file with the mutatedArray
     * @param filename
     * @param mutatedArray
     * @throws IOException
     */
    public static void write (String filename, ArrayList<String> mutatedArray) throws IOException{
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < mutatedArray.size(); i++) {
            // Maybe:
            outputWriter.write(mutatedArray.get(i)+"");

            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }

    

    public static void mutate(ArrayList<String> fileArray) {


    }


    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\admin\\Documents\\GitHub\\GeneralCodingPurposes\\Advanced-Testing-W8\\src\\main\\java\\com\\example\\advanced_testing_w8\\file.txt";
        ArrayList<String> fileresults = new ArrayList<>(GeneralizedFuzzer.readFile(filePath));
        System.out.println(fileresults);

        String writeToPath = "C:\\\\Users\\\\admin\\\\Documents\\\\GitHub\\\\GeneralCodingPurposes\\\\Advanced-Testing-W8\\\\src\\\\main\\\\java\\\\com\\\\example\\\\advanced_testing_w8\\\\file1.txt";
        write(writeToPath, fileresults);

    }






}
