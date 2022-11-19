package Chapter14;

import javax.swing.*;
import java.awt.event.*;

public class SimpleGUI2 implements ActionListener {
    // Action Listener is event listener's interface
    // SimpleGUI2 is event listener
    private JButton button;
    // button is event source
    public static void main(String[] args) {
        SimpleGUI2 gui = new SimpleGUI2();
        gui.go();

        
    }

    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("CLICK ME");
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // ActionEvent is event object
        // actionPerformed is event methods
        button.setText("I've been clicked");
    }
}
