package driver;

import sorter.MergeSort;
import view.SortingGui;

/**
 * Created by Moritz on 10/5/2016.
 */
public class Driver {
    public class arraySizer {
        int arraySize;
    }

    private static Integer[] sampleData = {100, 2, 6, 4, 5, 15, 11, 10, 9, 8, 7, 2, 14};

    public static void main(String[] args){
        SortingGui gui = new SortingGui();
        System.out.println(MergeSort.sort(MergeSort.randomList(1)));
    }


}

