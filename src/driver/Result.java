package driver;

import sorter.MergeSort;

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

    public Result(int i){
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

    public List<Double> getSorted(){ return sorted; }
    public List<Double> getUnsorted(){ return unsorted; }

    public String getLine(){
        return inputSize + "," + nlogn + "," + duration + "," + division + "\n";
    }
}
