/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author ramjam
 */
public class Tablero {
    HashSet<String> allColors = new HashSet<>();
    private Rectangulo tablero;
    private Rectangulo rec;
    private int contador=0;
    private int contPines=0;
    private int turnos;
    private ArrayList<Circle> fichas = new ArrayList();
    private ArrayList<Circle> agujeroBandera = new ArrayList();
    private ArrayList<Circle> respuesta= new ArrayList(4);
    
    
    public Tablero(int turnos){
        this.turnos=turnos;
        asignarTablero(turnos);
    }
    
    public int getTurnos(){
        return this.turnos;
    }
    
    public void setFichas(String color, int posicion){
        fichas.get(posicion).changeColor(color);
    }
    
    public void setBandera(String color, int posicion){
        agujeroBandera.get(posicion).changeColor(color);
    }
    
    public ArrayList<Circle> getFichas(){
        return fichas;
    }
    
    public void dibujarTablero(){
        int x=405,y=495;
        
        tablero.changeColor("cafe");
        tablero.cambiarPosicion(375, 50);
        tablero.changeSize(250, 500);
        tablero.makeVisible();
        
        rec.changeColor("cafeDark");
        rec.cambiarPosicion(400, 525);
        rec.changeSize(125, 25);
        rec.makeVisible();
        
        for(int i=0; i<fichas.size(); i++){
            if(i%4==0 && i!=0){
                x=405;
                y-=30;
            }
            fichas.get(i).changeColor("cafeDark");
            fichas.get(i).cambiarPosicion(x, y);
            fichas.get(i).changeSize(25);
            fichas.get(i).makeVisible();
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
    
    
    public String[] colores(String colores){
        String[] color = colores.split(" ");
        //for(int i=0; i<color.length; i++){
        //    System.out.println(color[i]);
        //}
        return color;
    }
    
    public void colocarFichas(String colores, Bandera banderas){
        boolean ban=true;
        String[] colors = colores(colores);
                for(int i=0; i<4; i++){
                    if(colors[i].equalsIgnoreCase("Az"))
                        fichas.get(contador+i).changeColor("blue");
                    else if(colors[i].equalsIgnoreCase("Am"))
                             fichas.get(contador+i).changeColor("yellow");
                        else if(colors[i].equalsIgnoreCase("Ro"))
                                 fichas.get(contador+i).changeColor("red");
                            else if(colors[i].equalsIgnoreCase("Ve"))
                                     fichas.get(contador+i).changeColor("green");
                                else if(colors[i].equalsIgnoreCase("Bl"))
                                         fichas.get(contador+i).changeColor("white");
                                    else if(colors[i].equalsIgnoreCase("Ne"))
                                             fichas.get(contador+i).changeColor("black");
                                    else{
                                        System.out.println(colors[i]+" Es un color no valido");
                                        ban=false;
                                    }
                }
                if(ban){
                    colocarBanderas(banderas);
                    contador+=4;
                }
                    
    }
    public void dibujarRespuesta(String resStr){
        String[] color = resStr.split(" ");
        int x=405;
        int y=525;
        for(int i=0;i<4;i++){
            respuesta.add(new Circle());
             if(color[i].equalsIgnoreCase("Az"))
                        respuesta.get(i).changeColor("blue");
                    else if(color[i].equalsIgnoreCase("Am"))
                            respuesta.get(i).changeColor("yellow");
                        else if(color[i].equalsIgnoreCase("Ro"))
                                 respuesta.get(i).changeColor("red");
                            else if(color[i].equalsIgnoreCase("Ve"))
                                     respuesta.get(i).changeColor("green");
                                else if(color[i].equalsIgnoreCase("Bl"))
                                         respuesta.get(i).changeColor("white");
                                    else if(color[i].equalsIgnoreCase("Ne"))
                                             respuesta.get(i).changeColor("black");
            respuesta.get(i).cambiarPosicion(x+(30*i), y);
            respuesta.get(i).changeSize(25);
            respuesta.get(i).makeVisible();
        }
    }
    
    public void colocarBanderas(Bandera banderas){
        for(int i=0; i<4; i++){
            agujeroBandera.get(contador+i).changeColor(banderas.getPin(i));
        }
    }
    
    
    public int asignarTablero(int intentos){
        tablero = new Rectangulo();
        rec = new Rectangulo();
        for(int i=0; i<intentos*4; i++){
            fichas.add(new Circle());
            agujeroBandera.add(new Circle());
        }
        return intentos*4;
    }
}
