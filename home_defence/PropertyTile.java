import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.Random;
/**
 * Write a description of class PropertyTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PropertyTile extends Actor
{
    /**
     * Act - do whatever the PropertyTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public boolean isBurning = false;
    private int fireSpreadProbability=10;
    public int xPos;
    public int yPos;
    public int iAr;
    public int jAr;
    
    private int fireSpread = 0;
    private Fire fire;
    
    public PropertyTile( int x, int y, int i, int j, int fireProb){
        xPos = x;
        yPos = y;
        iAr = i;
        jAr = j;
        setImage("empty.png");
        getImage().scale(10, 10);
    }
    
    public void act() 
    {
        if(!isBurning){
            return;
        }
		
        fireSpread++;
	if(fireSpread%60==0){
	    fireSpread=0;
            spreadFire();
        }
    }   
    
    public void doStuff(){
        catchFire();
    }
	
    private void catchFire(){
        if(isBurning){
            return;
        }
        
        fire = new Fire();
        getWorld().addObject(fire, xPos+7, yPos+7);
        
        isBurning = true;
    }
	public void extinguish(){
        isBurning = false;
        try{
            getWorld().removeObject(fire);
        }catch(Exception e){}
        fireSpread = 0;
    }
	
    private void spreadFire(){
        
        //trees at distance of 1
        for(int i=jAr-1; i<=jAr+1; i++){
            if(new Random().nextInt(100+1)<fireSpreadProbability){
                try{
                    //iAr
                    ((scene1)getWorld()).actors[iAr-1][i].doStuff();
                }catch(Exception e){}
            }
        }
        for(int i=jAr-1; i<=jAr+1; i++){
            if(new Random().nextInt(100+1)<fireSpreadProbability){
                try{
                    //iAr
                    ((scene1)getWorld()).actors[iAr+1][i].doStuff();
                }catch(Exception e){}
            }
        }
        if(new Random().nextInt(100+1)<fireSpreadProbability){
            try{
                //iAr
                ((scene1)getWorld()).actors[iAr][jAr-1].doStuff();
            }catch(Exception e){}
        }
        if(new Random().nextInt(100+1)<fireSpreadProbability){
            try{
                //iAr
                ((scene1)getWorld()).actors[iAr][jAr+1].doStuff();
            }catch(Exception e){}
        }
        
    }
}
