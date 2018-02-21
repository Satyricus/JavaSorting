package sorting;

import java.util.*;
import java.io.*;

/**
 * This class reads in data from a file. The data is then stored in Node objects
 * which are saved to an arraylist.
 * The arraylist can then be sorted.
 * TODO list: 
 *  - Implement generic types for sorting.
 *  - General optimisation.
 *  - Is Scanner or BufferedReader the better option for reading large files?
 * @author Jon Erik McWilliams
 */
public class Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double startTime;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in file name or file path.");
        String fileName = scanner.nextLine();
        scanner.close();

        List<Node> studentList = fileInput(fileName);
        
        startTime = System.currentTimeMillis(); // For timer.
        
        // NOTE: Uncomment each sorting alg to run them. 
        /*
        bubbleSort(studentList);
        */
        /*
        MergeSort ms = new MergeSort();
        ms.mergesort(studentList);
        */
        
        HeapSort hs = new HeapSort();
        hs.heapSort(studentList);
        
        
        // Elapsed time.
        System.out.println("Elapsed time: " + 
                (System.currentTimeMillis()-startTime));
        
        // Run a simple test to check the list is indeed sorted.
        sequentialTest(studentList);
    }
    
    /**
     * Simple bubble sort algorithm. Sorted by ascending.
     * Bubble sort is an extremely slow sorting alg. Only good for small lists
     * O(n^2) running time.
     * @param list List of students to be sorted by score.
     */
    public static void bubbleSort(List<Node> list) {
        System.out.println("Running bubblesort");
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if (list.get(j).compareTo(list.get(j+1)) > 0) {
                    Node tmp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, tmp);
                }
            }
        }
        /*
        for (Node student : list) {
            System.out.println(student.toString());
        }
        */
    }
    
    /**
     * Method to read in student names and score from file then save each 
     * student in a node object. Each node is added to an arraylist.
     * @param fileName Name of file.
     * @return List of students in the form of a Node
     */
    public static List<Node> fileInput(String fileName) {
        
        List<Node> studentList = new ArrayList<Node>();
        
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);
            
            while(sc.hasNextLine()) {
                String tmp = sc.next();
                String input[] = tmp.split(",");
                
                String name = input[0];
                double score = Double.parseDouble(input[1]);
                
                Node temp = new Node(name, score);
                
                studentList.add(temp);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File was not found.");
            //e.printStackTrace();
        }
        return studentList;
    }
    
    /**
     * A very simple test to check if the list is sorted.
     * @param list list of students
     * @return true is sorted, false otherwise.
     */
    public static boolean sequentialTest(List<Node> list) {
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).compareTo(list.get(i+1)) > 1) {
                System.out.println("List is not ordered");
                return false;        
            }
        }
        System.out.println("List is ordered");
        return true; 
    }
}
