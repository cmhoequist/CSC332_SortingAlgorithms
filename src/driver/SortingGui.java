package driver;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Created by jessicabailey on 10/14/16.
 */
public class SortingGui extends Driver{
    arrayVariables size;
    int x;
    protected JSpinner numSpin;

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

    private class UserInput implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            x = (Integer) numSpin.getValue();
            size.arraySize = x * 1000;
        }
    }

    public SortingGui(){
        GUI_Display displayPanel = new GUI_Display();
        GridLayout GUI_buttons = new GridLayout(0,10);
        JButton doneButton = new JButton("Done");
        ButtonHandler listener = new ButtonHandler();
        doneButton.addActionListener(listener);
        JLabel num_label = new JLabel("Choose a number");
        SpinnerModel numbers = new SpinnerNumberModel(5, 1, 9, 1);
        JSpinner numSpin = new JSpinner(numbers);
        JButton userChoice = new JButton("Select");



        JPanel content = new JPanel();
        JPanel buttons = new JPanel();
        JPanel spinners = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);
        content.add(doneButton, BorderLayout.SOUTH);
        content.add(buttons, BorderLayout.NORTH);
        content.add(spinners, BorderLayout.NORTH);
        spinners.setLayout(new GridLayout(0, 4));
        spinners.add(num_label);
        spinners.add(numSpin);
        spinners.add(userChoice);


        JFrame window = new JFrame("Mergesort");
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setContentPane(content);
        window.setSize(600, 500);
        window.setLocation(100, 100);
        window.setVisible(true);

    }
}