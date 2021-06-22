import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends World
{

    /**
     * Constructor for objects of class Tutorial.
     * 
     */
	 
    public int burningTrees = 0;
    private boolean gameRunning = false;
	private boolean gameOver = false;
	public static boolean isPaused = true;
	
    public Character player = new Character();
    private Water water = player.water;
	ArrayList<Pinetree> camp_trees = new ArrayList();
	
    public Tutorial()
    {
        super(600, 400, 1); 
        gameRunning = false;
		tut_dec();
    }
	
	public void act(){
		if(gameOver || isPaused){
			return;
		}
		
    }
	
	public void gameUnpause(){
		isPaused = false;
		//Greenfoot.start();
	}
	public void gamePause(){
		isPaused = true;
		//Greenfoot.stop();
	}
	
	Tut_tips tips = new Tut_tips();
        //addObject(buttonMenu,200,357);
	private void showTipQuestion(){
		//isPaused = true;
		gamePause();
		
		System.out.println("world.displayHelp()...............");
		//tips.displayHelp(this, monitor);
	}
	
	
	private void tut_dec()
    {
        addObject(water, 97, 50);
		addObject(player, 350, 350);
        addObject(player.waterShot, player.getX(), player.getY()); //Add the object to the world.
        player.waterShot.hide();
        
        addObject(new Pinetree(100, 100), 100, 100);
        addObject(new Pinetree(130, 130), 130, 130);
        addObject(new Pinetree(100, 130), 100, 130);
        addObject(new Pinetree(133, 100), 133, 100);
        addObject(new Pinetree(125, 150), 125, 150);
        addObject(new Pinetree(160, 155), 160, 155);
		
		addObject(new Pinetree(100, 100), 500, 100);
        addObject(new Pinetree(470, 130), 470, 130);
        addObject(new Pinetree(500, 130), 500, 130);
        addObject(new Pinetree(467, 100), 467, 100);
        addObject(new Pinetree(475, 150), 475, 150);
        addObject(new Pinetree(440, 155), 440, 155);
		
		camp_trees.add(new Pinetree(400, 300));
		camp_trees.add(new Pinetree(450, 300));
		camp_trees.add(new Pinetree(400, 350));
		camp_trees.add(new Pinetree(430, 333));
        addObject(camp_trees.get(0), 400, 300);
        addObject(camp_trees.get(1), 450, 300);
        addObject(camp_trees.get(2), 400, 350);
        addObject(camp_trees.get(3), 430, 333);
		
        addObject(new Tent(), 360, 300);
    }
}
