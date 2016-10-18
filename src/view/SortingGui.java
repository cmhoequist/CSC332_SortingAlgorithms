package view;

import driver.Driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created: 10/14/16
 * Last Modified: 10/18/16
 *
 * Interface between the user and the mergesort algorithm.
 */
public class SortingGui extends Driver {

    private static class GUI_Display extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("Mergesort Algorithm GUI", 20, 30);
        }

    }

    private static class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private void rangeErr(Double num){
        JOptionPane.showMessageDialog(null, num + " is not in range.\nPlease enter a list of numbers in the range [1,9]", "Value out of Range", JOptionPane.WARNING_MESSAGE);
    }

    private List<Double> getInput(){
        List<Double> outcomes = new LinkedList<>();
        String inputString = (String)JOptionPane.showInputDialog(null, "Enter a space-delimited list of numbers in the range [1,9]","Input Dialog", JOptionPane.QUESTION_MESSAGE, null, null, "1 2 3");
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
        JButton inputButton = new JButton("Input");
        inputButton.addActionListener((event) -> getInput());
        //JOptionPane.showMessageDialog(null, "Mergesort Algorithm GUI");
        GUI_Display displayPanel = new GUI_Display();
        GridLayout GUI_buttons = new GridLayout(0,10);
        JButton doneButton = new JButton("Done");
        ButtonHandler listener = new ButtonHandler();
        doneButton.addActionListener(listener);
        JLabel num_label = new JLabel("Choose a number");
        displayPanel.add(num_label);


        JPanel content = new JPanel();
        JPanel buttons = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);
        content.add(doneButton, BorderLayout.SOUTH);
        content.add(buttons, BorderLayout.NORTH);
        buttons.setLayout(GUI_buttons);
        buttons.add(new JButton("1"));
        buttons.add(new JButton("2"));
        buttons.add(new JButton("3"));
        buttons.add(new JButton("4"));
        buttons.add(new JButton("5"));
        buttons.add(new JButton("6"));
        buttons.add(new JButton("7"));
        buttons.add(new JButton("8"));
        buttons.add(new JButton("9"));
        content.add(inputButton);

        JFrame window = new JFrame("Mergesort");
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setContentPane(content);
        window.setSize(600, 500);
        window.setLocation(100, 100);
        window.setVisible(true);

    }
}