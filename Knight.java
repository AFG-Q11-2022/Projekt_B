import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Knight {
    
    Squares square;
    BufferedImage img;

    Knight(Squares s){
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
