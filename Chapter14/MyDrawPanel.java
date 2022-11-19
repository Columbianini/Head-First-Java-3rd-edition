package Chapter14;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class MyDrawPanel extends JPanel {
    // Make a subclass of JPanel, a widget that you can add to a frame just like anything else. Except this one is your own customized widget.
    private static Random randColor = new Random();
    public void paintComponent(Graphics g){
        //This is the Big Important Graphics method. You will NEVER call this yourself. The system calls it and says, “Here’s a nice fresh drawing surface, of type Graphics, that you may paint on now.” 
        // Imagine that ‘g’ is a painting machine. You're telling it what color to paint with and then what shape to paint (with coordinates for where it goes and how big it is).
        Color color = new Color(randColor.nextInt(255), randColor.nextInt(255),randColor.nextInt(255));
        g.setColor(color);
        g.fillRect(20, 50, 100, 100);
    }
}
