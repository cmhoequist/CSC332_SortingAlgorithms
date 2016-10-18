package sorter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created: 10/18/2016
 * Last Modified: 10/18/16
 *
 * MergeSort provides a Merge Sort algorithm as well as a helper method that randomly generates sample input lists.
 */
public class MergeSort {
    /**
     * Constructs a list of randomly generated real numbers.
     * @param index the size of the list scales with index
     * @return a list of size index*1000
     */
    public static List<Double> randomList(int index){
        List<Double> outcome = new LinkedList<>();
        Random rand = new Random();
        for(int i = 0; i < index*1000; i++){
            outcome.add(rand.nextDouble()*1000); //nextInteger returns a value in [0,1)
        }
        return outcome;
    }

    /**
     * Performs a merge sort on the input list.
     * @param inputList a homogeneous list of comparable items
     * @param <T> the type Double is used to represent real numbers
     * @return a sorted reproduction of the input list
     */
    public static <T extends Comparable<T>> List<T> sort(List<T> inputList){
        //Base case
        if(inputList.size() == 1){
            return inputList;
        }
        //Recursive steps
        List<T> list1 = inputList.subList(0, inputList.size()/2);
        List<T> list2 = inputList.subList(inputList.size()/2, inputList.size());
        return merge(sort(list1), sort(list2));
    }

    /**
     * Merge function (non-recursive step in the merge sort).
     * @param list1 a sorted list
     * @param list2 another sorted list
     * @param <T> the type Double is used to represent real numbers
     * @return a sorted list containing all the elements in the input lists
     */
    private static <T extends Comparable<T>> List<T> merge(List<T> list1, List<T> list2){
        List<T> newList = new LinkedList<>();
        //Initialize looping conditions
        int i = 0, j = 0;
        //Merge
        while(i < list1.size() && j < list2.size()){
            //compareTo returns -X when the first element is smaller, 0 when equal, and +X when larger
            if(list1.get(i).compareTo(list2.get(j)) < 0){
                newList.add(list1.get(i));
                i += 1;
            }
            else{
                newList.add(list2.get(j));
                j += 1;
            }
        }
        //Add remaining elements to the new list
        if(i < list1.size()){
            for(; i < list1.size(); i++){
                newList.add(list1.get(i));
            }
        }
        if(j < list2.size()){
            for(; j < list2.size(); j++){
                newList.add(list2.get(j));
            }
        }
        //Return result
        return newList;
    }
}
