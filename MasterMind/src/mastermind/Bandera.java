/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

/**
 *
 * @author ramjam
 */
public class Bandera {
    
    private String[] pines; //Son los pines de colores
    
    public Bandera(){
        pines = new String[4];
        inicializar();
    }
    
    // Regresa un pin
    public String getPin(int posicion){
        return pines[posicion];
    }
    
    // Cambia el pin de una cierta posicion
    public void setPin(int posicion, String pin){
        pines[posicion]=pin;
    }
    
    // Se encarga de Inicializar todos los pines 
    public void inicializar(){
        for(int i=0;i<pines.length;i++){
            pines[i]="cafeDark";
        }
    }
    
}
