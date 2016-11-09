/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author diego
 */
public class Sprite {
    
    private BufferedImage image;
    private int rate, rate_tick = 0;
    private int speed, speed_tick = 0;
    private int rows, columns;
    private int x = 0,y = 0;
    private int height = 0, width = 0;
    
    public Sprite(){
        image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        rate = 1;
        speed = 1;
        rows = 1;
        columns = 1;
    }
    
    public Sprite(String url){
        
        try {
            image = ImageIO.read(new File(url));
        } catch (IOException ex) {
            image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB); 
        }
        
        rate = 1;
        speed = 1;
        rows = 1;
        columns = 1;
    }
    
    public Sprite(String url, int speed, int rate, int rows, int columns){
        this.rate = rate;
        this.speed = speed;
        this.rows = rows;
        this.columns = columns;
        
        
        try {
            image = ImageIO.read(new File(url));
        } catch (IOException ex) {
            image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB); 
        }
        
    }
    
    public void setImage(String url) throws IOException{
        image = ImageIO.read(new File(url));    
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void setRate(int rate){
        this.rate = rate;
    }
    
    public void setRows(int rows){
        this.rows = rows;
    }
    
    public void setColumns(int columns){
        this.columns = columns;
    }
    
    private void updateX(){
        if(rate_tick == rate){
            x++;
            rate_tick = 0;
        }
        if(x==columns){
            x = 0;
            updateY();
        }
    }
    
    private void updateY(){
        y++;
        if(y==rows) y = 0;
    }
    
    private void updateHeight(){
        height += speed;
    }
    
    private void updateWidth(){
        width += speed;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
    
    public void update(){
        rate_tick++;
        updateHeight();
        updateWidth();
        updateX();
        updateY();
        
    }
    
    private int getXCoordinate(){
        return getXSize()*x;
    }
    
    private int getYCoordinate(){
        return getYSize()*y;
    }
    
    private int getXSize(){
        return image.getWidth()/columns;
    }
    
    private int getYSize(){
        return image.getHeight()/rows;
    }
    
    public BufferedImage getSprite(){
        return image.getSubimage(getXCoordinate(), getYCoordinate(), getXSize(), getYSize());
    }
    
    public Point getPosition(){
        return new Point(width, height);
    }
    
}

