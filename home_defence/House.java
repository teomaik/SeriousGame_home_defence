import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Actor
{
    /**
     * Act - do whatever the House wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public House(){
        GreenfootImage image = getImage();
        image.scale(100, 80);
        setImage(image);
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }   
    
    public void doStuff(){
        try{
           ((scene1)getWorld()).monitor.houseBurned=true;
        }catch(Exception e){}
    }
}
