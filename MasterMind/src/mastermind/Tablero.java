/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;

/**
 *
 * @author ramjam
 */
public class Tablero {
    private ArrayList<Ficha> fichas = new ArrayList();
    private Rectangulo tablero;
    private Rectangulo rec;
    private ArrayList<Circle> agujeroFichas = new ArrayList();
    private ArrayList<Circle> agujeroBandera = new ArrayList();
    
    
    public Tablero(){
        
    }
    
    public void dibujarTablero(){
        int x=405,y=495;
        int turnos = asignarTablero(10);
        tablero.changeColor("cafe");
        tablero.cambiarPosicion(375, 50);
        tablero.changeSize(250, 500);
        tablero.makeVisible();
        
        rec.changeColor("cafeDark");
        rec.cambiarPosicion(400, 525);
        rec.changeSize(125, 25);
        rec.makeVisible();
        
        for(int i=0; i<agujeroFichas.size(); i++){
            if(i%4==0 && i!=0){
                x=405;
                y-=30;
            }
            agujeroFichas.get(i).changeColor("cafeDark");
            agujeroFichas.get(i).cambiarPosicion(x, y);
            agujeroFichas.get(i).changeSize(25);
            agujeroFichas.get(i).makeVisible();
            x+=30;
        }
        x=550; y=510;
        for(int i=0; i<agujeroBandera.size(); i++){
            if(i%2==0 && i!=0){
                x=550;
                y-=15;
            }
            agujeroBandera.get(i).changeColor("cafeDark");
            agujeroBandera.get(i).cambiarPosicion(x, y);
            agujeroBandera.get(i).changeSize(10);
            agujeroBandera.get(i).makeVisible();
            x+=15;
            
        }
    }
    
    
    public int asignarTablero(int intentos){
        tablero = new Rectangulo();
        rec = new Rectangulo();
        for(int i=0; i<intentos*4; i++){
            agujeroFichas.add(new Circle());
            agujeroBandera.add(new Circle());
            fichas.add(new Ficha());
        }
        return intentos*4;
    }
}
