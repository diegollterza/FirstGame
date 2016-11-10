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
    private int y_pos = 0, x_pos = 0;
    private Point point_limit;
    private int direction;
    public boolean hasDirections = false;
    public boolean isMoving = false;
    
    public Sprite(){
        image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        rate = 1;
        speed = 10;
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
    
    public void updateY(){
        if(!hasDirections){
        y++;
        if(y==rows) y = 0;
        }
    }
    
    public void moveUp(){
        if(y_pos > 0) y_pos -= speed;
        setMovementAnimation(3);
    }
    
    public void moveDown(){
        if(y_pos < point_limit.y - getYSize()) y_pos += speed;
        setMovementAnimation(0);
    }
    
    public void moveLeft(){
        if(x_pos > 0) x_pos -= speed;
        setMovementAnimation(1);
        
    }
    
    public void moveRight(){
        if(x_pos < point_limit.x - getXSize()) x_pos += speed;
        setMovementAnimation(2);
    }
    
    public void setHeight(int height){
        this.y_pos = height;
    }
    
    public void setWidth(int width){
        this.x_pos = width;
    }
    
    public void update(){
        rate_tick++;
        updateX();
        
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
        if(!isMoving) return image.getSubimage(getXSize()*4, getYCoordinate(), getXSize(), getYSize());
        return image.getSubimage(getXCoordinate(), getYCoordinate(), getXSize(), getYSize());
    }
    
    public Point getPosition(){
        return new Point(x_pos, y_pos);
    }
    
    public void draw(Graphics g){
        g.drawImage(getSprite(), x_pos, y_pos,null);
    }
    
    public void setBounds(int x,int y){
        point_limit = new Point(x,y);
    }
    
    public void setMovementAnimation(int direction){
        y = direction;
    }
    
}

