import javax.swing.*;
import java.awt.*;

public class ImageLabel extends JLabel {

    private Image image;

    public ImageLabel(String path) {

        java.net.URL url = getClass().getResource(path);

        if(url == null) {

            System.out.println("FAILED LOAD: " + path);

        } else {

            ImageIcon icon = new ImageIcon(url);

            image = icon.getImage();

            System.out.println("SUCCESS LOAD: " + path);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if(image != null) {

            g.drawImage(image,0,0,getWidth(),getHeight(),this);

        }

    }

}