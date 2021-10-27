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
public class Ficha {
    private Circle ficha;
    
    public Ficha(){
        ficha = new Circle();
    }
    
    public void dibujarFicha(int xPosition, int yPosition, String color){
        ficha.changeSize(25);
        ficha.cambiarPosicion(yPosition, yPosition);
        ficha.changeColor(color);
    }
    
    public void erase(){
        ficha.makeInvisible();
    }
    
}
