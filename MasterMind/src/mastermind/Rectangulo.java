/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.awt.Rectangle;

/**
 *
 * @author ramjam
 */
public class Rectangulo{
    
    private int base, altura;
    private int xPosition;
    private int yPosition;
    private String color;
    
    private boolean isVisible;

    /**
     * Create a new square at default position with default color.
     */
    
    public Rectangulo()
    {
        color="blue";
        base = 100;
        altura = 70;
        xPosition = 0;
        yPosition = 0;
        isVisible = false;
    }
    
    public Rectangulo(int base, int altura)
    {
        color="blue";
        this.base = base;
        this.altura = altura;
        xPosition = 310;
        yPosition = 120;
        isVisible = false;
    }
    
    public Rectangulo(String color, int base, int altura)
    {
        color="blue";
        this.base = base;
        this.altura = altura;
        xPosition = 310;
        yPosition = 120;
        isVisible = false;
    }
    
    public Rectangulo(String color, int base, int altura, int xPosition, int yPosition)
    {
        this.color=color;
        this.base = base;
        this.altura = altura;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        isVisible = false;
    }
    
    public boolean getIsVisible(){
        return isVisible;
    }
    
    public void cambiarPosicion(int distanceX, int distanceY)
    {
        erase();
        xPosition += distanceX;
        yPosition += distanceY;
        draw();
    }
    
    public void moverLentamenteDiagonal(int distance)
    {
        
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            yPosition += delta;
            draw();
        }
        
    }
    
    public void blink(int times)
    {
         for(int i=0; i <= times; i++)
        {
            makeInvisible();
            delay(90);
            makeVisible();
            delay(90);
            
        }
    }
    
    public void delay(int mili)
    {
        Canvas canvas = Canvas.getCanvas();
        canvas.wait(mili);
    }
    
    /**
     * Make this square visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }
    
    /**
     * Make this square invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }
    
    /**
     * Move the square a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the square a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the square a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the square a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the square horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the square vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the square horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the square vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    
    public void changeSize(int base, int altura)
    {
        erase();
        this.base = base;
        this.altura = altura;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color=newColor;
        draw();
    }

    /**
     * Draw the square with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                        new Rectangle(xPosition, yPosition, base, altura));
            canvas.wait(10);
        }
    }

    /**
     * Erase the square on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }

    public double calcularArea() {
        return base*altura;
    }

    public double calcularPerimetro(){
        return base*2 + altura*2;
    }
    
    
//    public String toString(){
//        return super.getNombre()+" Area: "+calcularArea();
//    }
    
}
