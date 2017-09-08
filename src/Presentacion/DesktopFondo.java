package Presentacion;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class DesktopFondo extends JDesktopPane {

    public void paintComponent(Graphics g) {
        try {
            BufferedImage img = ImageIO.read(menu.class.getResource("/Imagenes/wallpaper2.jpg"));
            g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        } catch (IOException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
