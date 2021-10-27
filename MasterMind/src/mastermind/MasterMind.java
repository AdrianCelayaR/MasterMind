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
public class MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        
        tablero.dibujarTablero();
        
        /*
        Secuencia combinacionAdivinar =  new Secuencia();
        Secuencia combinacionJugador = new Secuencia();
        Bandera banderas = new Bandera();
        int limiteDeIntentos=0; //Controlar los intentos
        
            banderas=new Bandera();
            combinacionAdivinar = new Secuencia();
            combinacionJugador = new Secuencia();
            combinacionAdivinar.setFicha(1, "Am");
            combinacionAdivinar.setFicha(2, "Az");
            combinacionAdivinar.setFicha(3, "Ne");
            combinacionAdivinar.setFicha(4, "Ro");
            combinacionJugador.setFicha(1, "Bl");
            combinacionJugador.setFicha(2, "Az");
            combinacionJugador.setFicha(3, "Am");
            combinacionJugador.setFicha(4, "Ve");

        //Se encarga de verificar la secuencia ingresada y da pistas
            banderas.inicializar();
            if(limiteDeIntentos<10){
                for(int i=1;i<5; i++){
                    for(int j=1; j<5; j++){
                        if(combinacionAdivinar.verificarFicha(combinacionJugador.getFicha(j), i)==true){
                            if(i==j){
                                banderas.setPin(i, "Ne");
                                j=4;
                            }
                            else{
                                banderas.setPin(i, "Bl");
                                j=4;
                            }
                        }
                    }
                }
                limiteDeIntentos++;
            }
            else{
                System.out.println("Limite de intentos alcanzado");
            }
        */

        //Ingresa una nueva combinacion
            //combinacionJugador.setFicha(posicion,nueva);
    }
    
}
