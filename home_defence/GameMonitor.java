import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameMonitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameMonitor extends Actor
{
    /**
     * Act - do whatever the GameMonitor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int destroyedTrees = 0;
    
	public int round = 1;
	public boolean houseBurned = false;
	
    private int points = 0;
    
    public GameMonitor(){
        updateImage();
    }
    
    public int getPoints(){
        return points;
    }
    
    public void treeDestroyed(){
        destroyedTrees++;
    }
    
    public void changeScore(int score){
		points +=score;
        if(points<0){
            points=0;
        }
        updateImage();
    }
    public void setRound(int round) 
    {
        this.round = round;
		updateImage();
    }   
	
    /**
     * Creates (or re-creates) the image of the object.
     */
    public void updateImage()
    {
        setImage(new GreenfootImage("Round: "+round+", Points: "+points, 18, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
	public void houseBurned(){
		houseBurned = true;
	}
	
    public void act() 
    {
        // Add your action code here.
    }    
}
