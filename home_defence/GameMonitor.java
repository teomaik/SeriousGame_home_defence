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
    
    private int points = 100;
    
    public GameMonitor(){
        updateImage();
    }
    
    public int getPoints(){
        return points;
    }
    
    public void treeDestroyed(){
        destroyedTrees++;
    }
    
    public void decrementScore(int score){
        //System.out.println("score = "+score);
        if(score<=0){
            points +=score;
        }else{
            points -=score;
        }
        updateImage();
    }
    
    /**
     * Creates (or re-creates) the image of the object.
     */
    private void updateImage()
    {
        setImage(new GreenfootImage("Remaining: "+points, 18, Color.BLACK, new Color(0, 0, 0, 0)));
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
