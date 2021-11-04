/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Adrian Celaya | Oscar Plata
 */
public class MasterMind {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Secuencia combinacionAdivinar;
        Secuencia combinacionJugador = new Secuencia();
        HashSet<String> allColors = new HashSet<>();
        Bandera bandera = new Bandera();
        String colores = generarSecuencia();
        Tablero tablero;
        Scanner scn = new Scanner(System.in);
        String cadena;
        int limiteDeIntentos=0;
        boolean ban=false, victoria=false;
        
        colores = colores.toUpperCase();
        System.out.println(colores);
        
        combinacionAdivinar = new Secuencia(colores.split(" "));
        System.out.println("_________________Bienvenido a MASTERMIND_________________");
        System.out.println("Ingresa el numero de oportunidades que deseas tener 10 o 15: ");
        limiteDeIntentos=scn.nextInt();
        tablero = new Tablero(limiteDeIntentos);
        tablero.dibujarTablero();
        limiteDeIntentos=0;
        do{
            do{
                System.out.println("Colores disponibles:");
                System.out.println("Az - Azul\nAm - Amarillo\nNe - Negro\nBl - Blanco\nVe - Verde\nRo - Rojo");
                System.out.println("\n\nIngresa la combinacion en formato (Am Az Bl Ne): ");
                cadena=scn.nextLine();
                ban=comprobar(cadena);
                if(ban){
                    if(allColors.contains(cadena)){
                        System.out.println("No se pueden agregar sentencias iguales!!!");
                        ban=false;
                    }
                    else{
                        allColors.add(cadena);
                        cadena = cadena.toUpperCase();
                        combinacionJugador.setFichas(cadena.split(" "));
                        bandera = verificarCombinacion(combinacionAdivinar, combinacionJugador);
                        tablero.colocarFichas(cadena,bandera);
                        for(int i=0; i<4; i++)
                            System.out.println(bandera.getPin(i));
                        if(colores.equals(cadena)){
                            System.out.println("\n\n\tCOMBINACION CORRECTA. FELICIDADES JUGADOR!!!");
                            victoria=true;
                        }
                    }
                }
            }while(ban==false);
            limiteDeIntentos++;
            if(limiteDeIntentos==tablero.getTurnos()){
                victoria=true;
                System.out.println("Limite de intentos alcanzados\n\t\tPERDISTE");
            }
        }while(victoria==false);
    }
    
    /**
     * Esta funcion se encarga de realizar la verificacion de la combinacion que ingresa el jugador con la combinacion
     * que se crea por defecto en el juego (combinacionAdivinar), esto lo hace verificando los colores por su posicion
     * combinacionAdivinar verifica la ficha de la posicion i con la ficha de la posicion j de conbinacionJugador
     * si son iguales entonces regresa true y si la posicion donde se encontraron son iguales entonces la ficha 
     * esta correctamente colocada si no pues quiere decir que si se encuentra pero en otra posicion.
     * Esta funcion regresa un objeto Bandera que son las pistas de ese turno
     */
    public static Bandera verificarCombinacion(Secuencia combinacionAdivinar, Secuencia combinacionJugador){
        Bandera banderas = new Bandera();     
        for(int i=0;i<4; i++){
            for(int j=0; j<4; j++){
                if(combinacionAdivinar.verificarFicha(combinacionJugador.getFicha(j), i)==true){
                    if(i==j){
                        banderas.setPin(i, "black");
                        j=3;
                    }
                    else{
                        banderas.setPin(i, "white");
                        j=3;
                    }
                }
            }
        }
        return banderas;
    }
    
    /**
     * Esta funcion se encarga de generar una secuencia de colores aleatoriamente que luego se convertira en la 
     * combinacion que tiene que adivinar el jugador.
     */
    public static String generarSecuencia(){
        String color="";
        Random alea = new Random();
        
        for(int i=0; i<4; i++){
            switch(alea.nextInt(6)){
                case 0:
                    color = color.concat("Az");
                    break;
                case 1:
                    color = color.concat("Am");
                    break;
                case 2:
                    color = color.concat("Ro");
                    break;
                case 3:
                    color = color.concat("Ve");
                    break;
                case 4:
                    color = color.concat("Bl");
                    break;
                case 5:
                    color = color.concat("Ne");
                    break;
            }
            if(i!=3)
                color = color.concat(" ");
            
        }
        return color;
    }
    
    
    /**
     * Esta funcion se encarga de reaizar la comprobacion de colores que ingreso el jugador, si la combinacion de colores
     * se encuentra entre los colores disponibles entonces regresa true que indica que todo es correcto, de caso contrario 
     * regresa false y te indica el error.
     */
    public static boolean comprobar(String colores){
        boolean ban=true;
        String[] colors = colores.split(" ");
        //System.out.println(colors.length);
        if(colors.length==4){
                for(int i=0; i<4; i++){
                    if(colors[i].equalsIgnoreCase("Az"))
                        ban=true;
                    else if(colors[i].equalsIgnoreCase("Am"))
                             ban=true;
                        else if(colors[i].equalsIgnoreCase("Ro"))
                                 ban=true;
                            else if(colors[i].equalsIgnoreCase("Ve"))
                                     ban=true;
                                else if(colors[i].equalsIgnoreCase("Bl"))
                                         ban=true;
                                    else if(colors[i].equalsIgnoreCase("Ne"))
                                             ban=true;
                                    else{
                                        System.out.println(colors[i]+" Es un color no valido");
                                        ban=false;
                                        i=3;
                                    }
                }
        }
        else{
            System.out.println("Solo se permite ingresar 4 colores!!!");
            ban=false;
        }
        return ban;
    }
    
}
