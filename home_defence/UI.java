import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UI extends World
{
    private GreenfootSound backSound;
    /**
     * Constructor for objects of class UI.
     * 
     */
    public UI()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 713, 1);
        
        prepare();
    }
    
    public UI(boolean withSong)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 713, 1);
        
        prepare();
        if(withSong){
            //peaceful_morning_song.mp3
            backSound = new GreenfootSound("peaceful_morning_song.mp3");
            backSound.playLoop();
        }
    }
    
    public void stopMusic(){
        try{
            backSound.stop();
        }catch(Exception e){}
    }
    
    public void prepare(){

        //menu
        Button buttonMenu = new Button("menu");
        addObject(buttonMenu,200,357);

        Button buttonL1 = new Button("level1");
        addObject(buttonL1,100,273);
		
		Button buttonL2 = new Button("tutorial");
        addObject(buttonL2,100,352);
        //Button buttonL2 = new Button("level2");
        //addObject(buttonL2,100,352);

        //Button buttonL3 = new Button("level3");
        //addObject(buttonL3,100,433);
    }
    
    public void removeObjs(){
       this.removeObjects(this.getObjects(null)); //removes all the objects in the world;
    }
}
