package com.pluralsight;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static HashMap<String, Product> product = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Welcome to the Online Store! \n");
        Scanner motherBoard = new Scanner(System.in);
        System.out.println("Search Products: ");
        String userInput = motherBoard.nextLine();
        

        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            Product[] products = new Product[13];

            int count = 0;


            while((input = bufReader.readLine()) != null) {
                if(input.startsWith("sku")) {
                    continue;

                }
                String[] lineSplit = input.split(Pattern.quote("\\|"));
                if (lineSplit.length < 4) {
                    System.out.println(input);
                    continue; // Skip invalid lines
                }

                product.put(lineSplit[1], new Product(lineSplit[0], lineSplit[1],Double.parseDouble(lineSplit[2]),lineSplit[3]));
                products[count++] = new Product(lineSplit[0], lineSplit[1],Double.parseDouble(lineSplit[2]),lineSplit[3]);

            bufReader.close();
        }
        } catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();

        }
    }

    }
