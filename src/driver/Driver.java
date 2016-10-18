package driver;

import java.util.*;

/**
 * Created by Moritz on 10/5/2016.
 */
public class Driver {
    class arrayVariables {
        int arraySize;
        public void printSize() {
            int x = getSize();
            System.out.println("Size of array input: " + x);
        }
        int getSize() {
            return arraySize;
        }
    }

    private static Integer[] sampleData = {100, 2, 6, 4, 5, 15, 11, 10, 9, 8, 7, 2, 14};
    arrayVariables size = new arrayVariables();
    int x = size.getSize();

    public static void main(String[] args){
        SortingGui gui = new SortingGui();
        System.out.println(mergeSort(Arrays.asList(sampleData)));
    }

    private static <T extends Comparable<T>> List<T> mergeSort(List<T> inputList){
        //Base case
        if(inputList.size() == 1){
            return inputList;
        }
        //Recursive steps
        List<T> list1 = inputList.subList(0, inputList.size()/2);
        List<T> list2 = inputList.subList(inputList.size()/2, inputList.size());
        return merge(mergeSort(list1), mergeSort(list2));
    }

    public static <T extends Comparable<T>> List<T> merge(List<T> list1, List<T> list2){
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

