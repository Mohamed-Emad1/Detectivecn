/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7.frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.text.Position;

/**
 *
 * @author User
 */
public class Circle extends ShapesAbstract{
    private static int i=0;


    public Circle() {
        
    }

    public static void setI() {
        Circle.i = 0;
    }


    public  int getI() {
        i++;
        return i;
    }
private int r;



    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.getColor());
        canvas.drawOval(getPosition().x, getPosition().y, 2*r, 2*r);
        canvas.setColor(this.getFillColor());
        canvas.fillOval(getPosition().x, getPosition().y, 2*r, 2*r);
    }   

    public void setR(int r) {
        this.r = r;
    }
    
       @Override
    public String toString() {
        return "Circle "+"_"+getI();
    }
}
