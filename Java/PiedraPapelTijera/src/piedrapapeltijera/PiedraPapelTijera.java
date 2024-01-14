/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package piedrapapeltijera;

/**
 *
 * @author dekna
 */
public class PiedraPapelTijera {
Menu me;
Juego ju;
Juego facil;
boolean dificil;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       PiedraPapelTijera pi = new PiedraPapelTijera();
       pi.comenzar();
    }
    
 private void comenzar(){
        me = new Menu(this);
        ju = new Juego();
        me.setVisible(true);
        
            
        }
}
 
