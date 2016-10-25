package driver;

import sorter.MergeSort;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created: 10/18/2016.
 * Sets up a random list and sorts it with mergesort, timing the algorithm and storing the result
 */
public class Result {
    private int inputSize;
    private double nlogn;
    private long duration;
    private double division;
    private List<Double> unsorted;
    private List<Double> sorted;
    private String name;

    public Result(int i){
        //set up the array to be sorted
        name = "Array_" + i;
        long startTime, endTime;
        unsorted = MergeSort.randomList(i);

        //time the array being sorted
        startTime = System.nanoTime();
        sorted = MergeSort.sort(unsorted);
        endTime = System.nanoTime();

        //calculate and store values for CSV output
        inputSize = unsorted.size();
        nlogn = inputSize*Math.log(inputSize);
        duration = endTime - startTime;
        division = nlogn/duration;
    }

    public String getName(){return name; }
    public List<Double> getSorted(){ return sorted; }
    public List<Double> getUnsorted(){ return unsorted; }

    public String getLine(){
        //format the results for the CSV file
        NumberFormat formatter = new DecimalFormat("0.###E0");
        return inputSize + "," +
                formatter.format(nlogn) + "," +
                formatter.format(duration) + "," +
                formatter.format(division) + "\n";
    }
}
