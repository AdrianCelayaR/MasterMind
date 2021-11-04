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
 * Clase Principal que ejecuta una partida del juego de Mastermind
 *
 * @version 02/11/21
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
        do {
            int limiteDeIntentos = 0;
            boolean ban = false, victoria = false;
            String colores = generarSecuencia();
            colores = colores.toUpperCase();
            //System.out.println(colores);
            combinacionAdivinar = new Secuencia(colores.split(" "));
            System.out.println("_________________Bienvenido a MASTERMIND_________________");
            System.out.println("Ingresa el numero de oportunidades que deseas tener 10 o 15: ");
            limiteDeIntentos = scn.nextInt();
            tablero = new Tablero(limiteDeIntentos);
            tablero.dibujarTablero();
            limiteDeIntentos = 0;
            do {
                do {
                    System.out.println("TURNO # "+limiteDeIntentos+1);
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
                                tablero.dibujarRespuesta(colores);
                                victoria = true;
                            }
                        }
                    }
                } while (ban == false);
                puntos+=10*(tablero.getTurnos()-limiteDeIntentos);
                limiteDeIntentos++;
                if (limiteDeIntentos == tablero.getTurnos() && victoria == false) {
                    victoria = true;
                    System.out.println("Limite de intentos alcanzados\n\t\tPERDISTE");
                    System.out.println("RESPUESTA CORRECTA: \t[ " + colores + "] ");
                    tablero.dibujarRespuesta(colores);
                }
            } while (victoria == false);
            System.out.println("PUNTUACION FINAL: " + puntos);
            System.out.println("Volver a jugar? [SI/NO]");
            out = scn.next().toUpperCase().trim();
            if (out.equals("NO")) {
                System.out.println("_________________FIN DEL JUEGO_________________");
                System.exit(0);
            } else {
                System.out.println("Reiniciando...");
            }
            puntos = 0;
            combinacionJugador = new Secuencia();
            allColors.clear();
            colores = generarSecuencia();
        } while (!out.equalsIgnoreCase("NO"));
    }

    public void reset() {
        puntos = 0;

    }

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

    public static String generarSecuencia() {
        String color = "";
        Random alea = new Random();

        for (int i = 0; i < 4; i++) {
            switch (alea.nextInt(6)) {
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
            if (i != 3) {
                color = color.concat(" ");
            }

        }
        return color;
    }

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
