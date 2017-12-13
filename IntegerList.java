// ****************************************************************
// IntegerList.java
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.        
// ****************************************************************
import java.util.Scanner;

public class IntegerList{
    int[] list; //values in the list
    int temp = -1;

    Scanner scan = new Scanner(System.in);

    //create a list of the given size
    public IntegerList(int size) {
        list = new int[size];
    }

    //fill array with integers between 1 and 100, inclusive
    public void randomize() {
        for (int i=0; i<list.length; i++) {
            list[i] = (int)(Math.random() * 100) + 1;
        }
    }

    //print array elements with indices
    public void print() {
        for (int i=0; i<list.length; i++) {
            System.out.println(i + ":\t" + list[i]);
        }
    }

    //return the index of the first occurrence of target in the list.
    //return -1 if target does not appear in the list
    public int search(int target) {
        for (int i = 0; i < list.length ; i++) {
            if (list[i] == target) {
                 temp = i;
            }
        }
        return temp;
    }

    //sort the list into ascending order using the selection sort algorithm
    public void selectionSort() {
        int minIndex;
        minIndex = list[0];
        for (int i=0; i < list.length-1; i++) {
            //find smallest element in list starting at location i
            //swap list[i] with smallest element
            for(int j = i; j < list.length; j++) {
                if (list[i+1] < minIndex) {
                     minIndex = list[i+1];
                }
            }
            list[i] = minIndex;
            minIndex = 0;
        }
    }
    
    public void replaceFirst(int oldValue, int newValue) {
        int loc = search(oldValue);
        if(loc != -1) {
            list[loc] = newValue;
        }
    }
    
    public void replaceAll(int oldValue, int newValue) {
        
        int loc = search(oldValue);
        while(loc != -1) {
            replaceFirst(oldValue,newValue);
            loc = search(oldValue);
        }
    }
}