package driver;

import sorter.MergeSort;
import view.SortingGui;

/**
 * Created: 10/5/2016
 * Last Modified: 10/18/16
 *
 * Entry point into system.
 */
public class Driver {
    public static void main(String[] args){
        new SortingGui();
        System.out.println(MergeSort.sort(MergeSort.randomList(1)));
    }


}

