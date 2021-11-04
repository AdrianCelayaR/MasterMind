/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase Principal que ejecuta una partida del juego de Mastermind
 *
 * @version 04/11/21
 * @author Adrian Celaya ft. Oscar Plata
 */
public class MasterMind {
// 

    public static int puntos = 0;

    public static void main(String[] args) {
        Secuencia combinacionAdivinar;
        Secuencia combinacionJugador = new Secuencia();
        HashSet<String> allColors = new HashSet<>();
        Bandera bandera = new Bandera();
        Tablero tablero;
        Scanner scn = new Scanner(System.in);
        String cadena;
        String out;
        String opc2;
        String colores = "";

        do {
            int limiteDeIntentos = 0;
            boolean ban = false, victoria = false;
            //CICLO PARA LOS COLORES REPETIDOS O DISTINTOS
            //GENERACION DE LA RESPUESTA
            do {
                System.out.println("¿COLORES REPETIDOS? {SI/NO}");
                opc2 = scn.next().trim().toUpperCase();
                if (opc2.equals("SI")) {
                    colores = generarSecuencia(true);
                } else if (opc2.equals("NO")) {
                    colores = generarSecuencia(false);
                } else {
                    System.out.println("Respuestar no valida");
                }
            } while (!(opc2.equals("SI") || opc2.equals("NO")));
            colores = colores.toUpperCase();
            //System.out.println(colores);
            combinacionAdivinar = new Secuencia(colores.split(" "));
            
            //INICIO DEL JUEGO
            System.out.println("_________________Bienvenido a MASTERMIND_________________");
            System.out.println("Ingresa el numero de oportunidades que deseas tener 10 o 15: ");
            limiteDeIntentos = scn.nextInt();
            tablero = new Tablero(limiteDeIntentos);
            tablero.dibujarTablero();
            limiteDeIntentos = 0;
            //CICLO PRINCIPAL
            do {
                do {
                    System.out.println("TURNO # " + (limiteDeIntentos + 1));
                    System.out.println("Colores disponibles:");
                    System.out.println("Az - Azul\nAm - Amarillo\nNe - Negro\nBl - Blanco\nVe - Verde\nRo - Rojo");
                    System.out.println("\n\nIngresa la combinacion en formato (Am Az Bl Ne): ");
                    cadena = scn.nextLine();
                    ban = comprobar(cadena);
                    if (ban) {
                        if (allColors.contains(cadena)) {
                            System.out.println("No se pueden agregar sentencias iguales!!!");
                            ban = false;
                        } else {
                            allColors.add(cadena);
                            cadena = cadena.toUpperCase();
                            combinacionJugador.setFichas(cadena.split(" "));
                            bandera = verificarCombinacion(combinacionAdivinar, combinacionJugador);
                            tablero.colocarFichas(cadena, bandera);
                            for (int i = 0; i < 4; i++) {
                                System.out.println(bandera.getPin(i));
                            }
                            if (colores.equals(cadena)) {
                                puntos += 100;
                                System.out.println("\n\n\tCOMBINACION CORRECTA. FELICIDADES JUGADOR!!!");
                                System.out.println("RESPUESTA CORRECTA: \t[ " + colores + "] ");
                                //AUMENTAR PUNTOS POR RONDA
                                puntos += 10 * (tablero.getTurnos() - limiteDeIntentos);
                                tablero.dibujarRespuesta(colores);
                                victoria = true;
                            }
                        }
                    }
                } while (ban == false);

                limiteDeIntentos++;
                // COINDICIONAR SI EL JUGADOR SE QUEDO SIN TURNOS 
                if (limiteDeIntentos == tablero.getTurnos() && victoria == false) {
                    victoria = true;
                    System.out.println("Limite de intentos alcanzados\n\t\tPERDISTE");
                    System.out.println("RESPUESTA CORRECTA: \t[ " + colores + "] ");
                    tablero.dibujarRespuesta(colores);
                }
            } while (victoria == false);
            //MUESTRA LA PUNTUACION FINAL DEL JUEGO Y CONDICIONA LA SALIDA
            System.out.println("PUNTUACION FINAL: " + puntos);
            System.out.println("Volver a jugar? [SI/NO]");
            out = scn.next().toUpperCase().trim();
            if (out.equals("NO")) {
                System.out.println("_________________FIN DEL JUEGO_________________");
                System.exit(0);
            } else {
                System.out.println("Reiniciando...");
            }
            //REICIAR JUEGO PARA VOLVER A JUGAR
            puntos = 0;
            combinacionJugador = new Secuencia();
            allColors.clear();
        } while (!out.equalsIgnoreCase("NO"));
    }

    /**
     * Esta funcion se encarga de realizar la verificacion de la combinacion que
     * ingresa el jugador con la combinacion que se crea por defecto en el juego
     * (combinacionAdivinar), esto lo hace verificando los colores por su
     * posicion combinacionAdivinar verifica la ficha de la posicion i con la
     * ficha de la posicion j de conbinacionJugador si son iguales entonces
     * regresa true y si la posicion donde se encontraron son iguales entonces
     * la ficha esta correctamente colocada si no pues quiere decir que si se
     * encuentra pero en otra posicion. Esta funcion regresa un objeto Bandera
     * que son las pistas de ese turno
     */
    public static Bandera verificarCombinacion(Secuencia combinacionAdivinar, Secuencia combinacionJugador) {
        Bandera banderas = new Bandera();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (combinacionAdivinar.verificarFicha(combinacionJugador.getFicha(j), i) == true) {
                    if (i == j) {
                        banderas.setPin(i, "black");
                        j = 3;
                        puntos += 5;
                    } else {
                        banderas.setPin(i, "white");
                        j = 3;
                        puntos += 1;
                    }
                }
            }
        }
        return banderas;
    }

    /**
     * Esta funcion se encarga de generar una secuencia de colores
     * aleatoriamente que luego se convertira en la combinacion que tiene que
     * adivinar el jugador.
     */
    public static String generarSecuencia(boolean duplicados) {
        String color = "";
        Random alea = new Random();
        final String[] colores = {"Az", "Am", "Ro", "Ve", "Bl", "Ne"}; //COLORES VALIDOS
        ArrayList<String> str = new ArrayList<>(4); //COLECCION DE COLORES GENERADOS
        str.clear();
        while (str.size() < 4) { //LLENAR COLECCION
            String aux = (colores[alea.nextInt(6)]);
            if (duplicados) { //PERMITIR DUPLICADOS
                str.add(aux);
            } else if (!str.contains(aux)) { //NO PERMITIR REPETIDOS
                str.add(aux);
            }
        }
        //CONVERTIR EL ARRAY A STRING
        for (int i = 0; i < 4; i++) {
            color = color.concat(str.get(i) + " ");
        }

        color = color.trim();
        return color;
    }

    /**
     * Esta funcion se encarga de reaizar la comprobacion de colores que ingreso
     * el jugador, si la combinacion de colores se encuentra entre los colores
     * disponibles entonces regresa true que indica que todo es correcto, de
     * caso contrario regresa false y te indica el error.
     */
    public static boolean comprobar(String colores) {
        boolean ban = true;
        String[] colors = colores.split(" ");
        //System.out.println(colors.length);
        if (colors.length == 4) {
            for (int i = 0; i < 4; i++) {
                if (colors[i].equalsIgnoreCase("Az")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Am")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Ro")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Ve")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Bl")) {
                    ban = true;
                } else if (colors[i].equalsIgnoreCase("Ne")) {
                    ban = true;
                } else {
                    System.out.println(colors[i] + " Es un color no valido");
                    ban = false;
                    i = 3;
                }
            }
        } else {
            System.out.println("Solo se permite ingresar 4 colores!!!");
            ban = false;
        }
        return ban;
    }

}
