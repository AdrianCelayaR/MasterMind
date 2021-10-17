/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerocomplejo;

/**
 *
 * @author ramjam
 */
public class NumeroComplejo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Complejo c1 = new Complejo(2,3);
        Complejo c2 = new Complejo(4,-7);
        Complejo prueba = new Complejo();
        prueba = Complejo.sumar(c1, c2);
        System.out.println(prueba);
        prueba = c1.sumar(c2);
        System.out.println(prueba);
        prueba = c1.restar(c2);
        System.out.println(prueba);
        prueba = c1.producto(c2);
        System.out.println(prueba);
        prueba = c1.division(c2);
        System.out.println(prueba);
        
    }
    
}
