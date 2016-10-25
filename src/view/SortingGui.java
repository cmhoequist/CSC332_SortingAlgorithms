package view;

import driver.Result;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * Created: 10/14/16
 * Interface between the user and the Merge Sort algorithm.
 */
public class SortingGui extends JFrame {
    private Map<String, Result> arrays = new HashMap<>();

    public SortingGui(){
        //Initialize gui components
        getResults();

        //Array selection
        JPanel headerPanel = new JPanel();
        String[] headers = {"Array_1","Array_2","Array_3","Array_4","Array_5","Array_6","Array_7","Array_8","Array_9"}; //Names map to results
        JComboBox<String> arraySelection = new JComboBox<>(headers);
        headerPanel.add(arraySelection);

        //Table
        String[] columnNames = {"Index","Unsorted","Sorted"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        JTable table = new JTable(tableModel);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        table.getColumnModel().getColumn(0).setMaxWidth(45);
        JScrollPane tableScroll = new JScrollPane(table);

        //Listeners
        arraySelection.addActionListener((event)->{
            String name = (String)((JComboBox<String>)event.getSource()).getSelectedItem();
            List<Double> unsorted = arrays.get(name).getUnsorted(), sorted = arrays.get(name).getSorted();
            tableModel.setRowCount(0); //Clear table
            for(int i = 0; i < sorted.size(); i++){
                tableModel.addRow(new Object[]{(i+1),unsorted.get(i),sorted.get(i)});
            }
        });
        arraySelection.setSelectedIndex(0);

        //Composing the GUI
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(headerPanel);
        add(tableScroll);
        setTitle("Merge Sort GUI");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
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
                System.out.println(result.getLine());
                writer.write(result.getLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}