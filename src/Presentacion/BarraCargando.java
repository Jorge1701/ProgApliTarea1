package Presentacion;

public class BarraCargando extends javax.swing.JInternalFrame {

    public BarraCargando() {
        initComponents();
        barra.setIndeterminate(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra = new javax.swing.JProgressBar();

        setTitle("Cargando...");
        getContentPane().setLayout(new java.awt.GridLayout());

        barra.setMinimumSize(new java.awt.Dimension(500, 80));
        barra.setPreferredSize(new java.awt.Dimension(500, 80));
        getContentPane().add(barra);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    // End of variables declaration//GEN-END:variables
}
