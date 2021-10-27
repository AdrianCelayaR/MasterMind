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
public class Secuencia {
    
    private String[] fichas; //Crea las fichas 
    private int posicion; //Auxiliar para guardar posicion
    
    public Secuencia(){
        fichas = new String[4];
    }
    
    //Regresa una ficha
    public String getFicha(int pos){
        return fichas[pos-1];
    }
    
    //Cambia el color de una ficha
    public void setFicha(int pos, String color){
        fichas[pos-1]=color; 
    }
    
    //Regresa la posicion
    public int getPosicion(){
        return posicion;
    }
    
    //Cambiar la Posicion
    public void setPosicion(int posicion){
        this.posicion=posicion;
    }
    
    //Verifica si la ficha se encuentra y regresa un boolean
    public boolean verificarFicha(String ficha, int pos){
        boolean pista=false;
        
        if(fichas[pos-1]==ficha){
            pista=true;
        }
        
        return pista;
    }
    
}
