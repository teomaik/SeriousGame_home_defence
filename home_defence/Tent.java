import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.Random;
/**
 * Write a description of class Tent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tent extends Actor
{
    /**
     * Act - do whatever the Tent wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Tent(){
        tentType();
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    private void tentType(){
        int type = new Random().nextInt(3+1);
            switch (type) {
		case 0:
		  setImage("tent1.png");
		  break;
		case 1:
		  setImage("tent2.png");
		  break;
		case 2:
		  setImage("tent3.png");
		  break;
		case 3:
		  setImage("tent4.png");
		  break;
		default:
		  setImage("tent1.png");
		  break;
		}
            getImage().scale(50, 50);
    }
}
