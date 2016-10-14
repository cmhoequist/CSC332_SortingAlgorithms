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
        JButton doneButton = new JButton("Done");
        ButtonHandler listener = new ButtonHandler();
        doneButton.addActionListener(listener);


        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(displayPanel, BorderLayout.CENTER);
        content.add(doneButton, BorderLayout.SOUTH);

        JFrame window = new JFrame("Mergesort");
        window.setContentPane(content);
        window.setSize(600, 500);
        window.setLocation(100, 100);
        window.setVisible(true);

    }
}