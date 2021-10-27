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
public class ControlMaster {
    private Secuencia combinacionAdivinar; //Combinacion secreta
    private Secuencia combinacionJugador; //Combinacion del jugador
    private Bandera banderas; // Pines de pistas
    private int limiteDeIntentos; //Controlar los intentos
    private String cadena;
    
    public ControlMaster(){
        
    }
    
    
    // colores = "NE AZ AM BL";
    public String colores(String colores){
        String[] color = colores.split(" ");
        for(int i=0; i<color.length; i++){
            System.out.println(color[i]);
        }
        return colores;
    }
    
    //Se encarga de verificar la secuencia ingresada y da pistas (HAY QUE MODIFICAR)
    public void verificarCombinacion(){
        banderas.inicializar();
        if(limiteDeIntentos<10){
            for(int i=1;i<5; i++){
                for(int j=1; j<5; j++){
                    if(combinacionAdivinar.verificarFicha(combinacionJugador.getFicha(j), i)==true){
                        if(i==j){
                            banderas.setPin(i, "NE");
                            j=4;
                        }
                        else{
                            banderas.setPin(i, "BL");
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
    }
    
    //Ingresa una nueva combinacion (HAY QUE MODIFICAR)
    public void nuevaCombinacion(String nueva, int posicion){
        combinacionJugador.setFicha(posicion,nueva);
    }
    
    
    /**
     * Constructor for objects of class MasterMind
     
    public ControlMaster()
    {
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
    }
    
    //Se encarga de verificar la secuencia ingresada y da pistas
    public void verificarCombinacion(){
        banderas.inicializar();
        if(limiteDeIntentos<10){
            for(int i=1;i<5; i++){
                for(int j=1; j<5; j++){
                    if(combinacionAdivinar.verificarFicha(combinacionJugador.getFicha(j), i)==true){
                        if(i==j){
                            banderas.setPin(i, "NE");
                            j=4;
                        }
                        else{
                            banderas.setPin(i, "BL");
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
    }
    
    //Ingresa una nueva combinacion
    public void nuevaCombinacion(String nueva, int posicion){
        combinacionJugador.setFicha(posicion,nueva);
    }
    */
}
