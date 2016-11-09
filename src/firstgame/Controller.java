/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 *
 * @author diego
 */
public class Controller implements KeyListener{
    private HashMap<Integer, Key> bindKeys;
    
    public Controller(Controls c, Keys key) {
        this.bindKeys = new HashMap<>();
        bindKeys.put(c.getUpButton(), key.up);
        bindKeys.put(c.getDownButton(), key.down);
        bindKeys.put(c.getLeftButton(), key.left);
        bindKeys.put(c.getRightButton(), key.right);
        bindKeys.put(c.getActionButton(), key.action);
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        bindKeys.get(e.getKeyCode()).isDown = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        bindKeys.get(e.getKeyCode()).isDown = false;
    }
    
}
