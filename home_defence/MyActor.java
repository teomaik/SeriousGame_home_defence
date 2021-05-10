import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyActor extends Actor
{
    /**
     * Act - do whatever the MyActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    
    public int xPos;
    public int yPos;
    public int iAr;
    public int jAr;
    
    public Actor actor;
    
    public MyActor(Actor actr, int x, int y, int i, int j){
        actor = actr;
        xPos = x;
        yPos = y;
        iAr = i;
        jAr = j;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void doStuff(){
        if(actor instanceof Pinetree){
            ((Pinetree)actor).doStuff();
        }else if(actor instanceof PropertyTile){
            ((PropertyTile)actor).doStuff();
        }else if(actor instanceof House){
            ((House)actor).doStuff();
        }
    }
}
