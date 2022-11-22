/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7.frontend;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JOptionPane;


/**
 *
 * @author Detective_CN
 */
public class LineSegment extends ShapesAbstract {
    private static int counter=0;
    Point p2 = new Point();
    
    public LineSegment(Point Poisition) {
        super(Poisition);
        counter++;
    } 
     public LineSegment(){
         
     }
private static int i=0;
         public static void setI() {
      LineSegment.i = 0;
    }
    public  int getI() {
        i++;
        return i;
    }
   
    public void getSecondPoint(Point SecondPoint)
    {
        this.p2.x = SecondPoint.x;
       
        this.p2.y = SecondPoint.y;
    }
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getColor());
        canvas.drawLine(getPosition().x, getPosition().y, p2.x, p2.y);
        //canvas.setColor(getFillColor());
        //canvas.drawLine(getPosition().x, getPosition().y, p2.x, p2.y);
    }
    
     @Override
    public String toString() {
        return "Line "+"_"+getI();
    }
    }                                           
    

