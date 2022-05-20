import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Squares extends JPanel {

    BufferedImage king;
    /*
    void setKing()  {
        try {
            king = ImageIO.read(getClass().getResourceAsStream("/images/King.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        //g2.drawImage(king,1,1,100,200,this);
    }
}
