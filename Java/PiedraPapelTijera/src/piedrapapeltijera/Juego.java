/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package piedrapapeltijera;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/*


Falta: 
    Metodo para que el juego sepa todos los valores de "ocupado" son true y asi terminar el juego





*/

/**
 *
 * @author dekna
 */
public final class Juego extends javax.swing.JFrame {
    ImageIcon tijera =  new ImageIcon(getClass().getResource("/img/tijera.png"));
    ImageIcon piedra = new ImageIcon(getClass().getResource("/img/piedra.png"));
    ImageIcon papel = new ImageIcon(getClass().getResource("/img/papel.png"));
    ImageIcon fallo =  new ImageIcon(getClass().getResource("/img/fallo.png"));
    
    Menu me;
    Juego ju;
    Menu pip;
    Perder pe;  
    Thread hilo;
    
    private final JButton[] imglabel = new JButton[16];
    private final Boolean[] ocupado = new Boolean[16];
    ArrayList<Integer> numerosPrevios = new ArrayList<>();
    boolean juegoOn =true;    
    Boolean btij = false;
    Boolean bpie= false;
    Boolean bpap = false;
    Boolean facil = false;  
    Boolean juegoOff = false;
    int ind;
    String miMano = "Piedra" ;
    int puntuacion= 0;
    int intentos;   
    int aux = 0;
    int e;
    int i;
    int rand;   
    int Max;
   

    public Juego() {
        ju = this;
        me = new Menu();
        setSize(400,400);
        initComponents();
        facil = true;
     //   Max = 8;
    }
    public Juego( boolean dificil){
        ju = this;
        me = new Menu();
        setSize(400,400);
        initComponents();
        facil=false;
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            jButton3.setVisible(false);
            jButton4.setVisible(false);
            jButton5.setVisible(false);
            jButton6.setVisible(false);
            jButton7.setVisible(false);
            jButton8.setVisible(false);
        Max =16;
    }
   

   private  void rellenarArray(){
        imglabel[0] = jButton1;
        imglabel[1] = jButton2;
        imglabel[2] = jButton3;
        imglabel[3] = jButton4;
        imglabel[4] = jButton5;
        imglabel[5] = jButton6;
        imglabel[6] = jButton7;
        imglabel[7] = jButton8;
        imglabel[8] = jButton9;
        imglabel[9] = jButton10;
        imglabel[10] = jButton11;
        imglabel[11] = jButton12;
        imglabel[12] = jButton13;
        imglabel[13] = jButton14;
        imglabel[14] = jButton15;
        imglabel[15] = jButton16;
        
        ocupado[0] =false;
        ocupado[1] =false;
        ocupado[2] =false;
        ocupado[3] =false;
        ocupado[4] =false;
        ocupado[5] =false;
        ocupado[6] =false;
        ocupado[7] =false;
        ocupado[8] =false;
        ocupado[9] =false;
        ocupado[10] =false;
        ocupado[11] =false;
        ocupado[12] =false;
        ocupado[13] =false;
        ocupado[14] =false;
        ocupado[15] =false;
    }
     void initUI(int intentos1) {
         System.out.println("Intentos1 = " + intentos1);
        intentos = intentos1 +1;
        
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        buttonGroup1.add(btnpapel);
        buttonGroup1.add(btntijera);
        buttonGroup1.add(btnpiedra);
        //dif();
        initTemp();
    }
    int index(){
          if (facil ==false) {
            i=numalt(7,15);
        }if(facil ==true){
           i = (int) (Math.random() * 16);
            
        }
        return i;
    }
    

  
    void initTemp(){
        if (facil == true) {
            Max = 8;
        }if (facil == true) {
            Max = 16;
        }
                
        rellenarArray();
         txtpuntos.setText(puntuacion + "");
         txtintentos.setText(intentos + "");
        Runnable tempo;//End RUN
                
	//Aqui termina la declaración de runneable
            tempo = new Runnable() {                        
                @Override
                public void run() {
                    while (juegoOn == true) {
                        try{
                            Thread.sleep(2000);
                            ind = index();
                            aux=0;
                           while (ocupado[ind] == true){
                               ind = index();
                           }
                            rand = numalt(1,3);
                            if (rand == 1) {
                                imglabel[ind].setIcon(tijera); 
                                btij = true;
                            }if (rand == 2) {
                                imglabel[ind].setIcon(piedra);
               
                                bpie= true;
                            }if (rand == 3) {
                                imglabel[ind].setIcon(papel);
                                bpap= true;
                            } 
                            ocupado[ind] = true;
                            comprobacionTruers();
                            
                        }  
                        catch (Exception e){
                            e.printStackTrace();
                        }
                       
                    }//end while

                ju.setVisible(false);
                dispose();
              pe = new Perder(ju);
              pe.setVisible(true);
     
 }
                
            };
        

	hilo = new Thread(tempo);
        hilo.start();
        
        
     
    } 
    
  void comprobacionTruers(){
   for (int j = 0; j < ocupado.length; j++) {
        if (ocupado[j] ==true) {
        aux++;
        System.out.println(aux);
       
    }
}
      if ((aux == Max)||(intentos == 0)) {
           juegoOn=false;
    System.out.println("Terminado");
    juegoOff = true;
      }

// if (aux == Max){
//           juegoOn=false;
//    System.out.println("Terminado");
//    juegoOff = true;
//      }
    }   
    
    
    
    

    int numalt(int min, int max){
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }
    void solucion(int ic){
        
         //-------------------------------------------------------Piedra
        if (miMano == "Piedra") {
            if (btij ==true) {
           
                imglabel[ic].setIcon(fallo);
                puntuacion = puntuacion +2; 
                ocupado[ic] = false;
                      
            }
            if (bpie ==true) {
           
                puntuacion --;  
                ocupado[ic] = true;
            }
           
            if (bpap==true) {
          
               intentos --;
               ocupado[ic] = true;
            }
           
        
        }
      //-------------------------------------------------------Papel
      if (miMano == "Papel") {
            if (bpap == true) {
           
                puntuacion --; 
               ocupado[ic] = true;
            }
            if (bpie ==true) {
         
                imglabel[ic].setIcon(fallo);
                puntuacion = puntuacion +2; 
                ocupado[ic] = false;
                
            }
            if (btij ==true) {
   
                intentos --;
                ocupado[ic] = true;
            }
            
      
      }
       //-------------------------------------------------------Tijera
      if (miMano == "Tijera") {
            if (btij == true) {
              puntuacion --;  
              ocupado[ic] = true; 
            }
            if (bpap == true) {
              imglabel[ic].setIcon(fallo);
              puntuacion = puntuacion +2; 
              ocupado[ic] = false;
            }
            if (bpie == true) {
              intentos --;
              ocupado[ic] = true;
            }
      }
      //-------------------------------------------------------
             btij = false;
             bpie = false;
             bpap = false;
        txtpuntos.setText(puntuacion + "");
        txtintentos.setText(intentos + "");
        
    }
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        btnpiedra = new javax.swing.JRadioButton();
        btntijera = new javax.swing.JRadioButton();
        btnpapel = new javax.swing.JRadioButton();
        txtpuntos = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtintentos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(400, 400));
        setSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnpiedra.setSelected(true);
        btnpiedra.setText("Piedra");
        btnpiedra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpiedraActionPerformed(evt);
            }
        });
        getContentPane().add(btnpiedra, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 159, -1, 16));

        btntijera.setText("Tijera");
        btntijera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntijeraActionPerformed(evt);
            }
        });
        getContentPane().add(btntijera, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 98, -1));

        btnpapel.setText("Papel");
        btnpapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpapelActionPerformed(evt);
            }
        });
        getContentPane().add(btnpapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 87, -1, -1));

        txtpuntos.setEditable(false);
        txtpuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpuntosActionPerformed(evt);
            }
        });
        getContentPane().add(txtpuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 129, 35, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 65, 67));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 35, 65, 67));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 35, 65, 67));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 35, 65, 67));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, 65, 67));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 108, 65, 67));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 108, 65, 67));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 108, 65, 67));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 177, 65, 67));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 177, 65, 67));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 177, 65, 67));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 177, 65, 67));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 65, 67));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 250, 65, 67));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 250, 65, 67));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/poker_icon_154972.png"))); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 250, 65, 67));

        jLabel1.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Intentos restantes:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 218, -1, -1));

        jLabel2.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Puntuación:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 86, -1, -1));

        txtintentos.setEditable(false);
        txtintentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtintentosActionPerformed(evt);
            }
        });
        getContentPane().add(txtintentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 254, 18, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/piedrapapeltijera/fondo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, -60, 900, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpapelActionPerformed
        miMano = "Papel";
    }//GEN-LAST:event_btnpapelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        solucion(1);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnpiedraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpiedraActionPerformed
        miMano = "Piedra";
    }//GEN-LAST:event_btnpiedraActionPerformed

    private void btntijeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntijeraActionPerformed
            miMano = "Tijera";
    }//GEN-LAST:event_btntijeraActionPerformed

    private void txtpuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpuntosActionPerformed

    private void txtintentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtintentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtintentosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       solucion(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        solucion(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        solucion(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        solucion(4);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        solucion(5);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        solucion(6);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        solucion(7);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       solucion(8);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        solucion(9);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        solucion(10);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        solucion(11);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        solucion(12);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
       solucion(13);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        solucion(14);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        solucion(15);
        
    }//GEN-LAST:event_jButton16ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       Juego frame = new Juego();
       //frame.initUI();
       
        frame.setVisible(true); /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnpapel;
    private javax.swing.JRadioButton btnpiedra;
    private javax.swing.JRadioButton btntijera;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtintentos;
    private javax.swing.JTextField txtpuntos;
    // End of variables declaration//GEN-END:variables

    
}
