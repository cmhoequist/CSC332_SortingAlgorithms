package driver;

import sorter.MergeSort;
import view.SortingGui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created: 10/5/2016
 * Last Modified: 10/18/16
 *
 * Entry point into system.
 */
public class Driver {
    public static void main(String[] args){
        getResults();
        new SortingGui();
    }

    private static void getResults(){
        List<Result> results = new LinkedList<>();

        int limit = 9; //Arrays 1 through 9
        for(int i = 1; i <= limit; i++){
            int size = MergeSort.sizeArray(i);
            List<Double> input = MergeSort.randomList(size);
            long startTime = System.nanoTime();
            List<Double> result = MergeSort.sort(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
        }
        writeResults("MergeSort_Time.csv", results);
    }

    private static void writeResults(String filename, List<Result> results){
        String[] tableHeader = {"Input size (n),","nlogn,","Time spent (ns),","nlogn/time"};
        try(FileWriter writer = new FileWriter(new File(filename))){
            for(String header : tableHeader){
                writer.write(header);
            }
            writer.write("\n");

            for(Result result : results){
                writer.write(result.getLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

