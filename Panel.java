import com.sun.org.apache.xpath.internal.operations.Or;

import javax.swing.*;
import java.awt.*;


public class Panel extends JPanel implements Runnable{

    int mouseX;
    int mouseY;

    int mouseXScreen;
    int mouseYScreen;
    double mouseDegrees; //In Radiants (Pi)

    int posXIngame = 400;
    int posYIngame = 400;

    int posXScreen;
    int posYScreen;

    double angle;

    Squares[][] squares = new Squares[8][8];

    int dimension = 1000;
    Dimension maxSize = new Dimension(dimension/8, dimension/8);

    Panel() {
        this.setPreferredSize(new Dimension(dimension,dimension));
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(8,8));
        startGameThread();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Squares();
                squares[i][j].setPreferredSize(new Dimension(dimension/8, dimension/8));
                squares[i][j].setMaximumSize(maxSize);
                //squares[i][j].setKing();
                if ((i + j) % 2 == 0) {
                    squares[i][j].setBackground(Color.BLACK);
                } else {
                    squares[i][j].setBackground(Color.white);
                }
                this.add(squares[i][j]);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        /*
        if (mouseDegrees > Math.PI/2) {
            g2.setColor(Color.white);
            if (mouseDegrees > Math.PI) {
                g2.setColor(Color.green);
                if (mouseDegrees > Math.PI*1.5) {
                    g2.setColor(Color.orange);
                }
            }
        }
        */


        g2.rotate(mouseDegrees,posXIngame+10,posYIngame);
        g2.fillRect(posXIngame,posYIngame,20,100);
        g2.rotate(mouseDegrees, posXIngame+10, posYIngame);
        g2.dispose();
    }

    public void mousePos()   {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        mouseX = x;
        mouseY = y;
    }



    public double calculateAngle()
    {
        angle = Math.toDegrees(Math.atan2(400 - (double) mouseXScreen , (double) mouseYScreen -400));
        // Keep angle between 0 and 360
        angle = angle + Math.ceil( -angle / 360 ) * 360;

        return angle;
    }


    public void setMouseDegrees() {
        mouseDegrees = Math.toRadians(calculateAngle());
    }







    Thread gameThread;
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }
    int FPS = 144;
    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                long x = System.currentTimeMillis();

                mousePos();
                //convertScreen();
                convertMouse();
                setMouseDegrees();
                repaint();
                delta--;
                long x2 = System.currentTimeMillis();
            }
        }
    }

    public void convertScreen() {
        Point point = new Point(posXIngame, posYIngame);
        SwingUtilities.convertPointFromScreen(point, this);
        posXScreen=(int) point.getX();
        posYScreen=(int) point.getY();
    }

    public void convertMouse() {
        Point point = new Point(mouseX, mouseY);
        SwingUtilities.convertPointFromScreen(point, this);
        mouseXScreen=(int) point.getX();
        mouseYScreen=(int) point.getY();
    }

}


