/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author diego
 */
public class MainFrame extends javax.swing.JFrame{

    private Sprite teste;
    private int bound = 50;
    private BufferStrategy bs;
    private Keys key;
    private Controls controls;
    private Controller controller;
    /**
     *
     */
    public MainFrame() {
        initComponents();
        String path = getClass().getResource("animacao2.png").getPath();
        teste = new Sprite(path);
        teste.setColumns(8);
        teste.setRows(4);
        teste.setHeight(20);
        teste.setRate(5);
        teste.hasDirections = true;
        startLoop();
        key = new Keys();
        controls = new Controls();
        controller = new Controller(controls, key);
        this.addKeyListener(controller);
    }
    
    public void renderGraphics(){
        teste.setBounds(getContentPane().getWidth()-bound - 50, getContentPane().getHeight()-bound);
        Graphics g = bs.getDrawGraphics();
        Graphics g2 = g.create(bound, bound, getContentPane().getWidth()-bound-50, getContentPane().getHeight()-bound);
        g2.setColor(Color.white);
        g2.fillRect(0, 0, getContentPane().getWidth(), getContentPane().getHeight());
        teste.draw(g2);
        g.dispose();
        g2.dispose();
    }
    
    
    public void paintScreen() {
        if(!bs.contentsLost())
            getBufferStrategy().show();
    }
    
    public void updateControls(){
        if(key.right.isDown){
            teste.moveRight();
        }
        if(key.left.isDown){
            teste.moveLeft();
        }
        if(key.up.isDown){
            teste.moveUp();
        }
        if(key.down.isDown){
            teste.moveDown();
        }
        if(key.isMoving()){
            teste.isMoving = true;
        }else{
            teste.isMoving = false;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    private void startLoop() {
        createBufferStrategy(2);
        bs = getBufferStrategy();
        Thread t = new Thread(){
        public void run() {
        gameLoop();
        }
    };
        t.start();
    }
    
    private void gameLoop(){
        int FPS = 60;
        double OPTIMAL = 1000000000/FPS;
        long initial = System.nanoTime();
        double delta = 0;
        
        while(true){
        long now = System.nanoTime();
        delta += (now - initial)/OPTIMAL;
        initial = now;
        
        if(delta >= 1){
            delta = 0;
            teste.update();
            renderGraphics();
            paintScreen();
            updateControls();
        }
        }
    }
}

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

