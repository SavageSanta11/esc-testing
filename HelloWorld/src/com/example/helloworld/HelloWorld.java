package com.example.helloworld;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;


//Week 8 testing campaign
public class HelloWorld {

    public static void compare_csv(Scanner csv1, Scanner csv3) throws IOException {
        ArrayList<String> compare = new ArrayList<String>();
        //The result is stored in compare.csv file in " " format
        String result = "";

        //use comma to slice the csv file
        csv1.useDelimiter(",");
        csv3.useDelimiter(",");

        while (csv1.hasNextLine() && csv3.hasNextLine()) {

            String first_line_csv1 = csv1.nextLine();

            String first_line_csv3= csv3.nextLine();

            if (!first_line_csv1.equals(first_line_csv3)) {

                compare.add(first_line_csv1);
                compare.add(first_line_csv3);
            }
        }

        csv1.close();
        csv3.close();

        // Write to the new File result.csv
        FileWriter fw = new FileWriter("./src/result.csv");
        //iterate through the size of result.csv and add the lines to it
        try{
            for (int j = 0; j < compare.size(); j++) {
                result = result + compare.get(j) + "\n";
            }
            //get exception to prevent exceptions from occuring
        } catch (Exception ex) {
            System.out.println("cannot write to result.csv file");
        }
        fw.write(result);
        fw.close();
    }
    public static void main(String[] args) throws Exception{

        Scanner csv1 = new Scanner(new File("./src/sample_file_1.csv"));

        Scanner csv3 = new Scanner(new File("./src/sample_file_3.csv"));

        compare_csv(csv1, csv3);
    }


}
