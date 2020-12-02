import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortedList {
    public static void main(String []args) {
        List<Integer> sortedList = new LinkedList<>();

        //Insert into an empty list
        insertSorted(sortedList, 10);
        for(int v: sortedList) {
            System.out.print(v + " ");
        }
        System.out.println();

        //Insert at the beginning of the list
        insertSorted(sortedList, 1);
        for(int v: sortedList) {
            System.out.print(v + " ");
        }
        System.out.println();

        //Insert at the ending of the list
        insertSorted(sortedList, 20);
        for(int v: sortedList) {
            System.out.print(v + " ");
        }
        System.out.println();

        //Insert in the middle of the list
        insertSorted(sortedList, 5);
        for(int v: sortedList) {
            System.out.print(v + " ");
        }
        System.out.println();

        //Insert in the middle of the list
        insertSorted(sortedList, 5);
        for(int v: sortedList) {
            System.out.print(v + " ");
        }
        System.out.println();

        insertSorted(sortedList, 5);
        for(int v: sortedList) {
            System.out.print(v + " ");
        }
        System.out.println();

        System.out.println(countLesser(sortedList, 10));
    }

    private static void insertSorted(List<Integer> sortedList, int val) {
        int ind = Collections.binarySearch(sortedList, val);
        if(ind >= 0) {
            sortedList.add(ind, val);
        } else {
            sortedList.add((ind+1)*-1, val);
        }
    }

    private static int countLesser(List<Integer> sortedList, int val) {
        int ind = Collections.binarySearch(sortedList, val);
        if(ind < 0) {
            ind = -1*(ind+1);
            return ind;
        }
        return sortedList.indexOf(val);
    }
}

//-ind
