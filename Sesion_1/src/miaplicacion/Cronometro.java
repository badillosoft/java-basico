package miaplicacion;

public class Cronometro extends javax.swing.JFrame {

    Reloj reloj;
    
    public Cronometro() {
        initComponents();
        
        reloj = new Reloj();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelReloj = new javax.swing.JLabel();
        botonIncrementar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        labelReloj.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        labelReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelReloj.setText("00:00");

        botonIncrementar.setText("incrementar");
        botonIncrementar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonIncrementarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelReloj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(botonIncrementar)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelReloj)
                .addGap(18, 18, 18)
                .addComponent(botonIncrementar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIncrementarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIncrementarMouseClicked
        reloj.incrementar();
        
        String text = reloj.imprimir();
        
        labelReloj.setText(text);
    }//GEN-LAST:event_botonIncrementarMouseClicked

    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cronometro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIncrementar;
    private javax.swing.JLabel labelReloj;
    // End of variables declaration//GEN-END:variables
}
