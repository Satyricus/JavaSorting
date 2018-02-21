/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.io.*;
import java.util.*;

/**
 * Quick class to write random data to a file.
 * @author Jon Erik McWilliams
 */
public class WriteToFile {
    
    public static void main(String[] args) {
        
        try {
            File output = new File("output.txt");
            PrintWriter printer = new PrintWriter(output);
            
            Random random = new Random(15);
            for (int i = 0; i < 20; i++) {
                String s = "Student" + i + ",";
                double rand = Math.round(15 * random.nextDouble());
                s += rand;
                printer.println(s);
            }
            System.out.println("Done printing!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
