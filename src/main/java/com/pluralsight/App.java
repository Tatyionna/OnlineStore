package com.pluralsight;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void
    HashMap<String, String> product = new HashMap<>();

            product.put("|JBL Bluetooth Speaker","89.95");
            product.put("Mini 1000 Lumens Projector","149.95");
            product.put("XLR Podcast Cardiod Mic","44.99");
            product.put("Desktop PC Computer Intel Core i5","139.00");
            product.put("Wired Backlit Keyboard","21.99");
            product.put("RGB Wireless Gaming Mouse","67.45");
            product.put("Telestrations Board Game","17.99");
            product.put("Battleship Board Game","12.99");
            product.put("Retro Handheld Arcade","24.45");
            product.put("USB C to A Cable","13.95");
            product.put("Solar Powered Battery Charger","19.99");
            product.put("Wireless Charger iPhone","12.99");


            for (String k : product.keySet()) {
        System.out.println("Products: " + k + " and Price: " + product.get(k));
    }





    public static void main(String[] args) {
    // actionlogger("Launch");
    // Scanner scanner = new Scanner(System.in);
    // System.out.println("Search Products:");
    // String userInput = scanner.nextLine();

        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            Product[] products = new Product[12];

            int count = 0;

            while((input = bufReader.readLine()) != null) {
                if(input.startsWith("sku")) {
                    continue;
                }

                String[] lineSplit = input.split(Pattern.quote("|"));
                products[count++] = new Product(lineSplit[0], lineSplit[1],Double.parseDouble(lineSplit[2]),lineSplit[3]);

            bufReader.close();
        } catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();
        }
    }
// public static void  actionlogger(String action){

//         try{
//             FileWriter item = new FileWriter("src/main/resources/products.csv", true);
//             BufferedWriter logger = new BufferedWriter(item);

//             System.out.println("Search History: " + );
//         }
    }
}