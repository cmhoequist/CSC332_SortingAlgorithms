package sorter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Moritz on 10/18/2016.
 * <p></p>
 */
public class MergeSort {
    public static List<Double> randomList(int index){
        List<Double> outcome = new LinkedList<>();
        Random rand = new Random();
        for(int i = 0; i < index*1000; i++){
            outcome.add(rand.nextDouble()*1000); //nextDouble returns a value in [0,1)
        }
        return outcome;
    }

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
