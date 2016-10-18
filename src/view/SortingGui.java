package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created: 10/14/16
 * Last Modified: 10/18/16
 *
 * Interface between the user and the mergesort algorithm.
 */
public class SortingGui extends JFrame {

    private void rangeErr(Double num){
        JOptionPane.showMessageDialog(null, num + " is not in range.\nPlease enter a list of numbers in the range [1,9]", "Value out of Range", JOptionPane.WARNING_MESSAGE);
    }

    private List<Double> getInput(){
        List<Double> outcomes = new LinkedList<>();
        String inputString = (String)JOptionPane.showInputDialog(null, "Enter a space-delimited list of numbers in the range [1,9]","Input Dialog", JOptionPane.QUESTION_MESSAGE, null, null, "1 2 3");
        if(inputString == null){ //Returns null on cancel
            return new LinkedList<>();
        }
        String[] elements = inputString.split(" ");
        for(String element : elements){
            Double num = Double.parseDouble(element);
            if(num < 10 && num > 0){
                outcomes.add(num);
            }
            else{
                rangeErr(num);
                return new LinkedList<>();
            }
        }
        System.out.println(outcomes);
        return outcomes;
    }

    public SortingGui(){
        String[] buttonLabels = {"1","2","3","4","5","6","7","8","9"};
        List<JButton> buttonList = new ArrayList<>();
        for(String label : buttonLabels){
            buttonList.add(new JButton(label));
        }
        JButton inputButton = new JButton("Input");
        inputButton.addActionListener((event) -> getInput());
        JButton doneButton = new JButton("Done");
        doneButton.addActionListener((event) -> dispose());

        JPanel contentPanel = new JPanel();
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(3,3));
            buttonList.forEach(buttonPanel::add);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
        contentPanel.add(inputButton);
        contentPanel.add(buttonPanel);
        contentPanel.add(doneButton);

        add(contentPanel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLocation(100, 100);
        setVisible(true);
    }
}