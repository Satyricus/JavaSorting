package sorting;

import java.util.*;
        
/**
 * Mergesort, takes an arraylist and sorts it in ascending order.
 * The runtime of mergesort is O(n log n)
 * TODO: implement generics.
 * @author Jon Erik McWilliams
 */
public class MergeSort {
    
    private static Node[] aux;  // Auxiliary list
    
    public static void mergesort(List<Node> list) {
        System.out.println("Running mergesort:");
        int n = list.size();
        aux = new Node[n];
        mergesort(list, 0, n-1);
        /*
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        */
    }
    
    /**
     * 
     * @param list  List to be sorted
     * @param low   Low pointer/pivot
     * @param high  High pointer/pivot
     */
    public static void mergesort(List<Node> list, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;   // Calc middle pivot
        mergesort(list, low, mid);          // Sort first half
        mergesort(list, mid+1, high);       // Sort second half
        merge(list, low, mid, high);
    }
    
    public static void merge(List<Node> list, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = (Node)list.get(i);
        }
        int x = low;
        int y = mid+1;
        
        for (int i = low; i <= high; i++) {
            if (x > mid) 
                list.set(i, aux[y++]);
            else if (y > high) 
                list.set(i, aux[x++]);
            else if (aux[y].compareTo(aux[x]) < 0) 
                list.set(i, aux[y++]);
            else 
                list.set(i, aux[x++]);
        }
    }
    
}
