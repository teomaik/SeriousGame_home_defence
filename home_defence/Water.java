import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends Actor
{
    /**
     * Act - do whatever the Water wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public double water = 1000;
    private double maxWater = 3000;
    private double waterUsage = 30;
    public void act() 
    {
        if(scene1.isPaused){
            return;
        }
        
        if(water>=maxWater){
            return;
        }
        water += 1;
        updateImage();
    }
    private void updateImage()
    {
        setImage(new GreenfootImage("Water Reserves: "+water, 18, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
    public void fill(){
        water = maxWater;
    }
    
    public boolean use(){
        if(water<waterUsage){
            return false;
        }
        water = water - waterUsage;
        updateImage();
        return true;
    }
}
