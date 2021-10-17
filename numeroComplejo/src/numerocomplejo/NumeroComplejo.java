/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerocomplejo;

import java.util.Scanner;

/**
 *
 * @author ramjam
 */
public class NumeroComplejo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc;
        Scanner scn = new Scanner(System.in);
        Complejo c1 = new Complejo(2,3);
        Complejo c2 = new Complejo(4,-7);
        Complejo prueba = new Complejo();
        do{
            System.out.println("\t\tCALCULADORA DE NUMEROS COMPLEJOS");
            System.out.println("[1] Suma\n[2] Restar\n[3] Multiplicar\n[4] Dividir\n[5] Salir\n");
            System.out.print("Seleccione una opcion [ ]\b\b");
            opc = scn.nextInt();
            
            switch(opc){
                case 1:
                    prueba = c1.sumar(c2);
                    System.out.println(prueba);
                    break;
                case 2:
                    prueba = c1.restar(c2);
                    System.out.println(prueba);
                    break;
                case 3:
                    prueba = c1.producto(c2);
                    System.out.println(prueba);
                    break;
                case 4:
                    prueba = c1.division(c2);
                    System.out.println(prueba);
                    break;
                case 5:
                    System.out.println("BYE BYE!!!");
                    break;
            }
        }while(opc!=5);
        //prueba = Complejo.sumar(c1, c2);
        //System.out.println(prueba);
        
    }
    
}
