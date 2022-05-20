import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Queen {

    Squares square;
    BufferedImage img;

    Queen(Squares s){
        square=s;
        createBufferedImageW();
    }
    
    void createBufferedImageW(){
        try{
            img= ImageIO.read(getClass().getResourceAsStream("/images/King.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
