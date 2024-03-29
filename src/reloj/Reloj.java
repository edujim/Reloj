/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.util.*;

/**
 *
 * @author Usuario
 */
public class Reloj extends javax.swing.JFrame implements Runnable{  // vamos a ver algo nuevo que utiliza la interfas runnable

    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;

    /**
     * Creates new form Reloj
     */
    public Reloj() {
        initComponents();
        h1 = new Thread(this);
        h1.start();

        setLocationRelativeTo(null);
        setTitle("Reloj");
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BlReloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BlReloj.setBackground(new java.awt.Color(0, 0, 0));
        BlReloj.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        BlReloj.setForeground(new java.awt.Color(255, 0, 0));
        BlReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BlReloj.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BlReloj, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BlReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    @Override
    public void run(){
        Thread ct = Thread.currentThread();
        while (ct == h1){
            calcula();
            BlReloj.setText(hora + ":" + minutos + ":" + segundos + "   " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }

        }

    }

    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
            //ACA ES DONDE SE HACE LA VALIDACION DE HORAS
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? ""
                    + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BlReloj;
    // End of variables declaration//GEN-END:variables
}