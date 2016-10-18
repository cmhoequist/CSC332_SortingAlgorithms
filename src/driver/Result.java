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

    public Result(int i){
        long startTime, endTime;
        List<Double> input = MergeSort.randomList(i);

        startTime = System.nanoTime();
        MergeSort.sort(input);
        endTime = System.nanoTime();

        inputSize = input.size();
        nlogn = inputSize*Math.log(inputSize);
        duration = endTime - startTime;
        division = nlogn/duration;
    }

    public String getLine(){
        return inputSize + "," + nlogn + "," + duration + "," + division + "\n";
    }
}
