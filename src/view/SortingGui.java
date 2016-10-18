package view;

import sorter.MergeSort;

import javax.swing.*;
import java.util.List;

/**
 * Created: 10/14/16
 * Last Modified: 10/18/16
 *
 * Interface between the user and the Merge Sort algorithm.
 */
public class SortingGui extends JFrame {
    private DefaultListModel<Double> inputModel = new DefaultListModel<>(), sortedModel = new DefaultListModel<>();

    public SortingGui(){
        //Initialize gui components
        JList<Double> inputList = new JList<>(inputModel), sortedList = new JList<>(sortedModel);

        //Design gui layout
        JPanel contentPanel = new JPanel();
        JPanel headerPanel = new JPanel();
        JLabel instruction = new JLabel("Enter an integer in the range [1,9] to build a randomly generated list of size num*1000.");
        JPanel inputPanel = new JPanel();
        JTextField input = new JTextField(20);
        JButton generate = new JButton("Submit");
        inputPanel.add(input);
        inputPanel.add(generate);
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.PAGE_AXIS));
        headerPanel.add(instruction);
        headerPanel.add(inputPanel);
        JPanel viewPanel = new JPanel();
        JPanel left = new JPanel();
        JScrollPane originalView = new JScrollPane(inputList);
        left.add(new JLabel("Input List"));
        left.add(originalView);
        JPanel right = new JPanel();
        JScrollPane sortedView = new JScrollPane(sortedList);
        right.add(new JLabel("Sorted List"));
        right.add(sortedView);
        viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.LINE_AXIS));
        viewPanel.add(left);
        viewPanel.add(right);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        contentPanel.add(headerPanel);
        contentPanel.add(viewPanel);

        //Build gui
        generate.addActionListener((event) -> {
            String strNum = input.getText();
            try{
                int num = Integer.parseInt(strNum);
                if(num > 9 || num < 1){
                    rangeErr(strNum);
                }
                else{
                    publish(num);
                }
            }
            catch(Exception killSixBillionDemons){
                rangeErr(strNum);
            }
        });
        add(contentPanel);
        setTitle("Merge Sort GUI");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 300);
        setLocation(100, 100);
        setVisible(true);
    }

    private void publish(int num){
        inputModel.removeAllElements();
        sortedModel.removeAllElements();
        List<Double> input = MergeSort.randomList(num);
        input.forEach(inputModel::addElement);
        List<Double> result = MergeSort.sort(input);
        result.forEach(sortedModel::addElement);
    }

    /**
     * Pops up an invalid content error message.
     * @param str invalid content
     */
    private void rangeErr(String str){
        JOptionPane.showMessageDialog(null, "Input: "+str+ "\nis not an integer in the range [1,9]", "Value out of Range", JOptionPane.WARNING_MESSAGE);
    }
}