/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.event.KeyEvent;

/**
 *
 * @author diego
 */
public class Controls {
    private int upButton,downButton,leftButton,rightButton;
    private int actionButton;
    
    public Controls(){
        upButton = KeyEvent.VK_UP;
        downButton = KeyEvent.VK_DOWN;
        leftButton = KeyEvent.VK_LEFT;
        rightButton = KeyEvent.VK_RIGHT;
        actionButton = KeyEvent.VK_A;
    }
    
    public void setUpButton(int key){
        upButton = key;
    }
    
    public void setDownButton(int key){
        downButton = key;
    }
    
    public void setRightButton(int key){
        rightButton = key;
    }
    
    public void setLeftButton(int key){
        leftButton = key;
    }
    
    public void setActionButton(int key){
        actionButton = key;
    }
    
    public int getUpButton(){
        return upButton;
    }
    
    public int getDownButton(){
        return downButton;
    }
    
    public int getRightButton(){
        return rightButton;
    }
    
    public int getLeftButton(){
        return leftButton;
    }
    
    public int getActionButton(){
        return actionButton;
    }
}
