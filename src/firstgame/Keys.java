/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstgame;

/**
 *
 * @author Diego la Terza Pinelli Ferreira
 */
public class Keys {
    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key action = new Key();
    
    public boolean isMoving(){
        if(up.isDown||down.isDown||right.isDown||left.isDown) return true;
        return false;
    }
    
    public boolean isAction(){
        if(action.isDown) return true;
       return false;
    }
}
