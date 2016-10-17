package driver;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Created by jessicabailey on 10/14/16.
 */
public class sortingGUI extends Driver{

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



    public static void main (String[] args){
        //JOptionPane.showMessageDialog(null, "Mergesort Algorithm GUI");
        GUI_Display displayPanel = new GUI_Display();
        GridLayout GUI_buttons = new GridLayout(0,10);
        JButton doneButton = new JButton("Done");
        ButtonHandler listener = new ButtonHandler();
        doneButton.addActionListener(listener);
        JLabel num_label = new JLabel("Choose a number");


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

        JFrame window = new JFrame("Mergesort");
        window.setContentPane(content);
        window.setSize(600, 500);
        window.setLocation(100, 100);
        window.setVisible(true);

    }
}