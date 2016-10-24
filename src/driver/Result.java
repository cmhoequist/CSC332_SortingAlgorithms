package driver;

import sorter.MergeSort;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by Moritz on 10/18/2016.
 * <p></p>
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
        name = "Array_" + i;
        long startTime, endTime;
        unsorted = MergeSort.randomList(i);

        startTime = System.nanoTime();
        sorted = MergeSort.sort(unsorted);
        endTime = System.nanoTime();

        inputSize = unsorted.size();
        nlogn = inputSize*Math.log(inputSize);
        duration = endTime - startTime;
        division = nlogn/duration;
    }

    public String getName(){return name; }
    public List<Double> getSorted(){ return sorted; }
    public List<Double> getUnsorted(){ return unsorted; }

    public String getLine(){
        NumberFormat formatter = new DecimalFormat("0.###E0");
        return inputSize + "," +
                formatter.format(nlogn) + "," +
                formatter.format(duration) + "," +
                formatter.format(division) + "\n";
    }
}
