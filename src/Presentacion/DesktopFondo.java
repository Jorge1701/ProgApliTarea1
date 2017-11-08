package Presentacion;

import Configuracion.Configuracion;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class DesktopFondo extends JDesktopPane {

    public void paintComponent(Graphics g) {

        String quitar = "Tarea1.jar!/Presentacion/DesktopFondo.class";
        String path = DesktopFondo.class.getResource("/Presentacion/DesktopFondo.class").getPath().replaceAll(quitar, Configuracion.get("pathImagenes") + "wallpaper.jpg").replace("C:", "").replace("file:", "");

        try {
            BufferedImage img = ImageIO.read(new File(path));
            g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        } catch (IOException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
