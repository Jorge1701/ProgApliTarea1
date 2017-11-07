package Presentacion;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PanelImagen extends JPanel {

    private BufferedImage imagen;

    public PanelImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
    }
}
