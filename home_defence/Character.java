import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int speed = 2;
    
    Water water = new Water();
    public WaterShot waterShot = new WaterShot();
    
    public Character(){
        getImage().scale(30, 30);
    }
    
    public void act() 
    {
        if(scene1.isPaused){
            return;
        }
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse==null){
            return;
        }
        moveTowards(mouse.getX(), mouse.getY());
        
        int buttonNumber = mouse.getButton();
        if (buttonNumber == 3 ){//&& Greenfoot.mousePressed(null)){
            useWater();
        }
        if (buttonNumber == 1 ){//&& Greenfoot.mousePressed(null)){
            useAxe();
        }
    }
    
    private void useAxe(){
        List<Pinetree> trees = getObjectsInRange(20, Pinetree.class);
        for(Pinetree tree : trees){
            tree.chop();
        }
        List<PropertyTile> tiles = getObjectsInRange(20, PropertyTile.class);
        for(PropertyTile tile : tiles){
            tile.extinguish();
        }
    }
    private void useWater(){
        if(!water.use()){
            return;
        }
        
        waterShot.used();
            waterShot.setLocation(getX(), getY());
            waterShot.setRotation(getRotation()); //Sets the rotation of the new object to be equal to the players rotation.
            waterShot.move(25); //Move the added object x pixels in front of the player.
            
        List<Pinetree> trees = getObjectsInRange(20, Pinetree.class);
        for(Pinetree tree : trees){
            tree.extinguish();
        }
        List<PropertyTile> tiles = getObjectsInRange(20, PropertyTile.class);
        for(PropertyTile tile : tiles){
            tile.extinguish();
        }
    }
    
    private void moveTowards(int x, int y){
        
        if(Math.abs(x-this.getX())<=20 && Math.abs(y-this.getY())<=20 ){
            return;
        }
        
        this.turnTowards(x, y);
        this.move(speed);
        
    }
}
