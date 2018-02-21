package ucstest;

import java.util.*;
/**
 * This class runs heapsort on an arrayList of node objects.
 * The running time of heapsort is O(n log n)
 * TODO: implement generics for sorting.
 * @author Jon Erik McWilliams
 */
public class HeapSort {
    
    public static void heapSort(List<Node> list) {
        System.out.println("Running heapsort:");
        int n = list.size();
        for(int i = n/2; i >= 0; i--) {
            orderHeap(list, i, n-1);
        }
        
        Node temp;
        int m = n-1;
        for (int i = m; i >= 0; i--) {
            temp = list.get(0);
            list.set(0, list.get(m));
            list.set(m, temp);
            m--;
            orderHeap(list, 0, m);
        }
        
        for (Node student : list) {
            System.out.println(student.toString());
        }
        
    }

    
    public static void orderHeap(List<Node> list, int i, int size) {
        int left = i*2;  // Left node.
        int right = 2*i+1;  // Right node.
        int largest;
        
        // Is left larger than parent?
        if (left <= size && list.get(left).compareTo(list.get(i)) > 0)
            largest = left;
        else
            largest = i;
        // Is right larger than largest (either parent or left)?
        if (right <= size && 
                list.get(right).compareTo(list.get(largest)) > 0)
            largest = right;
        
        if (largest != i) {     // Swap values in heap if needed.
            Node temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);
            orderHeap(list, largest, size);
        }       
    }
}
