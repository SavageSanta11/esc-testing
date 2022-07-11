package com.example.helloworld;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.*;

//Week 8 testing campaign
public class HelloWorld {
    public static void main(String[] args){
       String path1 = "C:\\Users\\GigaB\\Documents\\Term 5\\Term 5 ESC\\sample_file_1.csv";
        String path2 = "C:\\Users\\GigaB\\Documents\\Term 5\\Term 5 ESC\\sample_file_3.csv";
        compare_csv(path1, path2);
    }

    public static void compare_csv(String path1, String path2){
        String line1;
        HashMap<String, String> f1 = new HashMap<String, String>();
        HashMap<String, String> f2 = new HashMap<String, String>();
        HashMap<String, String[]> f1asarray = new HashMap<String, String[]>();
        HashMap<String, String[]> f2asarray = new HashMap<String, String[]>();
        //Reading first file
        try {
            BufferedReader br = new BufferedReader(new FileReader(path1));
            while((line1 = br.readLine())!=null){

                String [] values = line1.split(",");
                f1.put(values[0], line1);
                f1asarray.put(values[0],values);

            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        //Reading 2nd file

        String line2 = "";
        try {
            BufferedReader br2 = new BufferedReader(new FileReader(path2));
            while((line2 = br2.readLine())!=null){
                String [] values = line2.split(",");
                f2.put(values[0], line2);
                f2asarray.put(values[0],values);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        //comparing the two files
        List<String[]> deleted = new ArrayList<String[]>();
        for(String entry : f1.keySet()) {
            if(f2.containsKey(entry)) {
                if(!((f1.get(entry)).equals(f2.get(entry)))){
                    deleted.add(f1asarray.get(entry));
                    deleted.add(f2asarray.get(entry));
                    System.out.println(f1.get(entry));
                    System.out.println(f1.get(entry));
                }
            }
        }

        String filePath = "C:\\Users\\GigaB\\Documents\\Term 5\\Term 5 ESC\\sample_output";
        //writing the output csv file
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            writer.writeAll(deleted);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
