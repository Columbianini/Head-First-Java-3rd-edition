package Chapter14;

import javax.swing.*;

import org.w3c.dom.events.Event;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SimpleGui3{
    private JFrame frame;
    private JLabel label;
    private Random rand = new Random();

    public static void main(String[] args) {
        SimpleGui3 gui = new SimpleGui3();
        gui.go();
    }

    public void go(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("CHANGE COLORS");
        JButton button2 = new JButton("CHANGE LABLE");  

        // button.addActionListener(new FrameListener());
        button.addActionListener(event->frame.repaint()); 
        // button2.addActionListener(new LabelListener());
        button2.addActionListener(event->label.setText("I am a label "+Integer.toString(rand.nextInt(1000))));

        

        label = new JLabel("I'm a label");

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.EAST, button2);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }


    // public class LabelListener implements ActionListener{

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         // TODO Auto-generated method stub
    //         label.setText("I am a label "+Integer.toString(rand.nextInt(1000)));
    //     }
    // }

    // public class FrameListener implements ActionListener{

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         // TODO Auto-generated method stub
    //         frame.repaint();
    //     }
        
    // }
}
