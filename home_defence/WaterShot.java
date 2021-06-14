import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class WaterShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterShot extends Actor
{
    /**
     * Act - do whatever the WaterShot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int timer = 10;
    GreenfootImage inactive = new GreenfootImage("empty.png");
    GreenfootImage active = new GreenfootImage("waterShoot.png");
    
    public WaterShot(){
        inactive.scale(1, 1);
        active.scale(80, 30);
    }
    
    public void act() 
    {
        if(scene1.isPaused){
            return;
        }
        
        // Add your action code here.
        timer--;
        if(timer <=0){
            hide();
        }else{
            List<Pinetree> trees = getObjectsInRange(20, Pinetree.class);
            for(Pinetree tree : trees){
                tree.extinguish();
            }
            List<PropertyTile> tiles = getObjectsInRange(20, PropertyTile.class);
            for(PropertyTile tile : tiles){
                tile.extinguish();
            }
        }
    }   
    
    public void used(){
        timer = 10;
        setImage(active);
    }
    
    public void hide(){
        setImage(inactive);
    }
}
