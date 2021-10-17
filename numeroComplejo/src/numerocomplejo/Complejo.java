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
public class Complejo {
    private float real;
    private float imaginaria;
    
    public Complejo(){
        real=(float)4;
        imaginaria=(float)5;
    }
    
    public Complejo(float real, float imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }

    public float getReal() {
        return real;
    }

    public void setReal(float real) {
        this.real = real;
    }

    public float getImaginaria() {
        return imaginaria;
    }

    public void setImaginaria(float imaginaria) {
        this.imaginaria = imaginaria;
    }
    
    //------------------------------------SUMAR-------------------------------------------------------
    public void sumar(float real, float imaginaria){
        float x,y;
        x= this.real+ real;
        y=this.imaginaria + imaginaria;
        System.out.println("("+x+"+"+y+"i)");
    }
    
    public Complejo sumar(Complejo complejo){
        float x=real+complejo.real;
        float y=imaginaria+complejo.imaginaria;
        System.out.println("("+x+"+"+y+"i)");
        return new Complejo(x, y);
    }
    
    public static Complejo sumar(Complejo c1, Complejo c2){
        float x=c1.real+c2.real;
        float y=c1.imaginaria+c2.imaginaria;
        System.out.println("("+x+"+"+y+"i)");
        return new Complejo(x, y);
    }
    
    //------------------------------------RESTAR------------------------------------------------------
    public void restar(float real, float imaginaria){
        float x,y;
        x= this.real - real;
        y=this.imaginaria - imaginaria;
        System.out.println("("+x+"+"+y+"i)");
    }
    
    public Complejo restar(Complejo complejo){
        float x=real-complejo.real;
        float y=imaginaria-complejo.imaginaria;
        return new Complejo(x, y);
    }
    
    public static Complejo restar(Complejo c1, Complejo c2){
        float x=c1.real-c2.real;
        float y=c1.imaginaria-c2.imaginaria;
        System.out.println("("+x+"+"+y+"i)");
        return new Complejo(x, y);
    }
    
    //------------------------------------PRODUCTO----------------------------------------------------
    public void producto(float real, float imaginaria){
        float x,y;
        x=(this.real*real)+(-1*this.imaginaria*imaginaria);
        y=(this.real*imaginaria)+(this.imaginaria*real);
        System.out.println("("+x+"+"+y+"i)");
    }
    
    public Complejo producto(Complejo complejo){
        float x,y;
        x=(this.real*complejo.real)+(-1*this.imaginaria*complejo.imaginaria);
        y=(this.real*complejo.imaginaria)+(this.imaginaria*complejo.real);
        System.out.println("("+x+"+"+y+"i)");
        return new Complejo(x, y);
    }
    
    public static Complejo producto(Complejo c1, Complejo c2){
        float x,y;
        x=(c1.real*c2.real)+(-1*c1.imaginaria*c2.imaginaria);
        y=(c1.real*c2.imaginaria)+(c1.imaginaria*c2.real);
        System.out.println("("+x+"+"+y+"i)");
        return new Complejo(x, y);
    }
    
    //------------------------------------DIVISION----------------------------------------------------
    
    public Complejo division(float real, float imaginaria){
        float x =(((this.real * real) + 
            (this.imaginaria * imaginaria))/
            ((real * real)+
            (imaginaria * imaginaria)));
        float y =(((this.real * imaginaria ) - 
            (this.imaginaria * real ))/((real * 
            real)+(imaginaria * imaginaria)));
        System.out.println("("+x+"+"+y+"i)");
        return new Complejo(x,y);
    }
    
    public Complejo division(Complejo complejo){
        float x =(((this.real * complejo.real) + 
            (this.imaginaria * complejo.imaginaria))/
            ((complejo.real * complejo.real)+
            (complejo.imaginaria * complejo.imaginaria)));
        float y =(((this.real * complejo.imaginaria ) - 
            (this.imaginaria * complejo.real ))/((complejo.real * 
            complejo.real)+(complejo.imaginaria * 
            complejo.imaginaria)));
        System.out.println("("+x+"+"+y+"i)");
        return new Complejo(x,y);
    }
    
    public static Complejo division(Complejo c1, Complejo c2){
        float x =(((c1.real * c2.real) + 
            (c1.imaginaria * c2.imaginaria))/
            ((c2.real * c2.real)+
            (c2.imaginaria * c2.imaginaria)));
        float y =(((c1.real * c2.imaginaria ) - 
            (c1.imaginaria * c2.real ))/((c2.real * 
            c2.real)+(c2.imaginaria * 
            c2.imaginaria)));
        System.out.println("("+x+"+"+y+"i)");
        return new Complejo(x,y);
    }

    @Override
    public String toString() {
        return "Complejo: ("+real+"+"+imaginaria+"i)";
    }
    
    
    
    
}
