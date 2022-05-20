import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class King {

    Squares square;
    BufferedImage img;

    King(boolean white, Squares s){
        square=s;
         if(white){
            createBufferedImageW();
        }
         else{
             createBufferedImageB();
         }
    }
    
    void createBufferedImageW(){
        try{
            img= ImageIO.read(getClass().getResourceAsStream("/images/King.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    void createBufferedImageB(){
        try{
            img= ImageIO.read(getClass().getResourceAsStream("/images/King.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
