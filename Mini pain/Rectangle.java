/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7.frontend;
import java.awt.Graphics;

/**
 *
 * @author Detective_CN
 */
public class Rectangle extends ShapesAbstract {
    private static int counter=0;
    int higth;
    int width;
    private static int i=0;
    //public LineSegment(Point Poisition) {
      //  super(Poisition);
    //} 
     public Rectangle(){
      
     }
         public static void setI() {
       Rectangle.i = 0;
    }
    public  int getI() {
        i++;
        return i;
    }
    public void getHightAndWidth(int hight,int width)
    {
        this.higth = hight;
       
        this.width = width;
    }
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getColor());
        canvas.drawRect(getPosition().x, getPosition().y, this.higth, this.width);
        canvas.setColor(getFillColor());
        canvas.fillRect(getPosition().x, getPosition().y, this.higth, this.width);
        
    }

    @Override
    public String toString() {
        return "Rectangle "+"_"+getI();
    }
    
    
    
    }                                
