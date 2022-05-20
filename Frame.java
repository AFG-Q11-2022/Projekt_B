import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{

    private Panel panel;
    private Dimension dimension = new Dimension(200, 200);
    
    public Frame(){

        panel = new Panel();
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Frame();
    }
}
