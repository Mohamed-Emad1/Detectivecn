/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7.frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Detective_CN
 */
public  abstract class ShapesAbstract implements Shape {
    private Point p ;
    private Color border; 
    private Color fillcolor;

     public ShapesAbstract(){
         
     }
    
    public ShapesAbstract(Point p) {
        this.p = p;
    }
    
    
    @Override
    public void setPosition(Point position) {
        this.p = position;
        //System.out.println("set point");
    }

    @Override
    public Point getPosition() {
        return this.p;
    }

    @Override
    public void setColor(Color color) {
        this.border=color;
    }

    @Override
    public Color getColor() {
        return this.border;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillcolor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillcolor;
    }

    @Override
    public abstract void draw(Graphics canvas);
    
}
