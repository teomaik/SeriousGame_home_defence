import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Button of UI
 */
public class Button extends Actor
{
    String button; //name of button
    scene1 myWorld;
    /**
     * Constructor for name and image
     */
    public Button(String button){
        this.button=button;
        setImage(button+".png");
        
        if(button.equals("level1")){
                myWorld = new scene1();
                myWorld.level1();
            }else if(button.equals("level2")){
                myWorld = new scene1();
                myWorld.level2();
            }else if(button.equals("level3")){
                myWorld = new scene1();
                myWorld.level3();
            }
    }
    
    public void act() 
    {
        if (Greenfoot.mousePressed(this)){
            //Starts the game of that level
            if(button.equals("level1")){
                loading();
                //scene1 myWorld = new scene1();
                stopMusic();
                myWorld.startingGame();
                Greenfoot.setWorld(myWorld);
                //myWorld.level1();
            }else if(button.equals("level2")){
                loading();
                //scene1 myWorld = new scene1();
                stopMusic();
                myWorld.startingGame();
                Greenfoot.setWorld(myWorld);
                //myWorld.level2();
            }else if(button.equals("level3")){
                loading();
                //scene1 myWorld = new scene1();
                stopMusic();
                myWorld.startingGame();
                Greenfoot.setWorld(myWorld);
                //myWorld.level3();
            }else if(button.equals("victory") || button.equals("defeat")){
                loading();
                //scene1 myWorld = new scene1();
                Greenfoot.setWorld(new UI(true));
                //myWorld.level3();
            }
        
        }
    }
    
    private void stopMusic(){
        try{
            ((UI)getWorld()).stopMusic();
        }catch(Exception e){}
    }
    
    public void hide(){
        setImage("empty.png");
        getImage().scale(10, 10);
    }
    
    private void loading(){
        //((UI)getWorld()).removeObjs();
        List<Button> buttons = getWorld().getObjects(Button.class);
        for(Button butt : buttons){
            butt.hide();
        }
        Button buttonLoading = new Button("loading");
        //((UI)getWorld()).removeObjs();
        getWorld().addObject(buttonLoading,512,357);
    }
}
