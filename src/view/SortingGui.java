package view;

import driver.Result;
import sorter.MergeSort;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created: 10/14/16
 * Last Modified: 10/18/16
 *
 * Interface between the user and the Merge Sort algorithm.
 */
public class SortingGui extends JFrame {
    private DefaultListModel<Double> inputModel = new DefaultListModel<>(), sortedModel = new DefaultListModel<>();
    private Map<String, Result> arrays = new HashMap<>();

    public SortingGui(){
        //Initialize gui components
        JList<Double> inputList = new JList<>(inputModel), sortedList = new JList<>(sortedModel);
        getResults();

        JPanel contentPanel = new JPanel();

        //Design gui layout
        //Header
        JPanel headerPanel = new JPanel();
        String[] headers = {"1","2","3","4","5","6","7","8","9"};
        JComboBox<String> arraySelection = new JComboBox<>(headers);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
        headerPanel.setAlignmentX(CENTER_ALIGNMENT);
        headerPanel.add(arraySelection);
        //Table
        JPanel tablePanel = new JPanel();
        String[] columnNames = {"Index","Unsorted","Sorted"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        JTable table = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(table);
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.PAGE_AXIS));
        tablePanel.add(tableScroll);

        //Composing the GUI
        contentPanel.add(headerPanel);
        contentPanel.add(tablePanel);


        /*Working on adding the length of the array to be displayed to the user each time they submit*/
        //JPanel contentPanel = new JPanel();
        /*JPanel headerPanel = new JPanel();
        JLabel instruction = new JLabel("Enter an integer in the range [1,9] to build a randomly generated list of size num*1000.");*/
        JPanel inputPanel = new JPanel();
        /*JTextField input = new JTextField(20);
        JPanel countPanel = new JPanel();*/
        //JButton generate = new JButton("Submit");
        /*JLabel countLabel = new JLabel("Length of List:");
        JLabel timeLabel = new JLabel("Length of Time(nano):");
        countPanel.setLayout(new GridLayout(0,4));
        countPanel.add(countLabel);
        countPanel.add(sizeArray);
        countPanel.add(timeLabel);
        countPanel.add(time);
        inputPanel.add(input);*/
        //inputPanel.add(generate);
        /*headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.PAGE_AXIS));
        headerPanel.add(instruction);
        headerPanel.add(inputPanel);
        //headerPanel.add(countPanel);
        JPanel viewPanel = new JPanel();
        JPanel viewHeader = new JPanel();
        viewHeader.setLayout(new BoxLayout(viewHeader, BoxLayout.LINE_AXIS));
        JPanel left = new JPanel();
        JPanel leftHeader = new JPanel();
        JScrollPane originalView = new JScrollPane(inputList);
        leftHeader.add(new JLabel("Input List"));
        left.add(originalView);
        JPanel right = new JPanel();
        JPanel rightHeader = new JPanel();
        JScrollPane sortedView = new JScrollPane(sortedList);
        rightHeader.add(new JLabel("Sorted List"));
        right.add(sortedView);
        viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.LINE_AXIS));
        viewPanel.add(left);
        viewPanel.add(right);
        viewHeader.add(leftHeader);
        viewHeader.add(rightHeader);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        contentPanel.add(headerPanel);
        contentPanel.add(countPanel);
        contentPanel.add(viewHeader);
        contentPanel.add(viewPanel);*/

        //Build gui
        submit.addActionListener((event) -> {
            String strNum = arraySelection.getName();
            try{
                int num = Integer.parseInt(strNum);
                if(num > 9 || num < 1){
                    rangeErr(strNum);
                }
                else{
                    Result result;
                   // inputModel = result.getUnsorted();
                   // sortedModel = result.getSorted();
//                    publish(num);
                }
            }
            catch(Exception killSixBillionDemons){
                rangeErr(strNum);
            }
        });
        add(contentPanel);
        setTitle("Merge Sort GUI");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocation(100, 100);
        //frame.pack();
        setVisible(true);
        //frame.revalidate();
    }

    //GENERATING ARRAYS------------------------------------------------------------------------------------------------
    private void getResults(){
        int limit = 9; //Arrays 1 through 9
        for(int i = 1; i <= limit; i++){
            Result temp = new Result(i);
            arrays.put(temp.getName(), temp);
        }
        writeResults("MergeSort_Time.csv", arrays.values());
    }

    private static void writeResults(String filename, Collection<Result> results){
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

    //ERROR MESSAGES-------------------------------------------------------------------------------------
    /**
     * Pops up an invalid content error message.
     * @param str invalid content
     */
    private void rangeErr(String str){
        JOptionPane.showMessageDialog(null, "Input: "+str+ "\nis not an integer in the range [1,9]", "Value out of Range", JOptionPane.WARNING_MESSAGE);
    }
}