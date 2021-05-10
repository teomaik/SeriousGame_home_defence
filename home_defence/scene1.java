import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Write a description of class scene1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class scene1 extends World
{

    /**
     * Constructor for objects of class scene1.
     * 
     */
    public GameMonitor monitor = null;
    public int burningTrees = 0;
    private boolean gameRunning = false;
    private GreenfootSound backSound;
    
    public int iDim = 40;
    public int jDim = 40;
    public Character player = new Character();
    private Water water = player.water;

    int xIncr = 20;
    int xMin = 900;
    //int xMax = 1640;

    int yIncr = 20;
    int yMin = 40;
    //int yMax = 800;

    public MyActor[][] actors = new MyActor[iDim][jDim];
    
    public scene1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1700, 850, 1);
        
        
        //addDecor();
        //level3();
        
        
        System.out.println("started...");
        //addObject(player, 1250, 350);
        //addObject(player.waterShot, player.getX(), player.getY()); //Add the object to the world.
        //player.waterShot.hide();
        gameRunning = false;
        prepare();
    }

    public void act(){
        if(!gameRunning){
            return;
        }
        
        //System.out.println("current points = "+monitor.getPoints());
        System.out.println("burningTrees = "+burningTrees);
        if(monitor.getPoints()<=0){
            gameOver();
            gameRunning=false;
            backSound.stop();
            Greenfoot.playSound("defeat.mp3");
            Button buttonMenu = new Button("defeat");
            addObject(buttonMenu,850,450);
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch(Exception e){}
            return;
        }
        if(burningTrees<=0){
            gameOver();
            gameRunning=false;
            backSound.stop();
            Greenfoot.playSound("victory.mp3");
            Button buttonMenu = new Button("victory");
            addObject(buttonMenu,850,450);
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch(Exception e){}
        }
    }
    public void addDecor(){
        addObject(player, 1250, 350);
        addObject(player.waterShot, player.getX(), player.getY()); //Add the object to the world.
        player.waterShot.hide();
        
        addObject(new River(), 600, 450);
        addObject(new Pinetree(100, 100), 100, 100);
        addObject(new Pinetree(100, 300), 100, 300);
        addObject(new Pinetree(100, 400), 100, 400);
        addObject(new Pinetree(100, 750), 100, 750);
        addObject(new Pinetree(100, 800), 100, 800);
        
        //<TODO
        addObject(new Pinetree(100, 800), 200, 350);
        addObject(new Pinetree(100, 800),400, 330);
        addObject(new Pinetree(100, 800),450, 320);
        addObject(new Pinetree(100, 800),427, 340);
        addObject(new Pinetree(100, 800),550, 320);
        
        addObject(new Pinetree(100, 800),350, 180);
        addObject(new Pinetree(100, 800),330, 195);
        addObject(new Pinetree(100, 800),400, 170);
        addObject(new Pinetree(100, 800),377, 190);
        addObject(new Pinetree(100, 800),500, 170);
        addObject(new Pinetree(100, 800),480, 155);
        addObject(new Pinetree(100, 800),550, 160);
        
        addObject(new Pinetree(100, 800),800, 170);
        addObject(new Pinetree(100, 800),850, 160);
        addObject(new Pinetree(100, 800),865, 190);
        addObject(new Pinetree(100, 800),800, 270);
        addObject(new Pinetree(100, 800),810, 370);
        addObject(new Pinetree(100, 800),790, 350);
        
        addObject(new Pinetree(100, 800),810, 470);
        addObject(new Pinetree(100, 800),790, 450);
        addObject(new Pinetree(100, 800),810, 500);
        addObject(new Pinetree(100, 800),790, 550);
        addObject(new Pinetree(100, 800),850, 480);
        addObject(new Pinetree(100, 800),760, 470);
        addObject(new Pinetree(100, 800),770, 500);
        
        //>
        addObject(new Tent(), 300, 800);
        addObject(new Tent(), 200, 700);
        addObject(new Tent(), 150, 400);
    }
    
    public void startingGame(){
        backSound.playLoop();
    }
    
    public void level1(){
        int fireSpread = 30;
        
        addDecor();
        water.fill();
        monitor = new GameMonitor();
        addObject(monitor, 70, 20);
        //addObject(player, 50, 40);
        //player
        addTress(fireSpread);
        startRandomFire();
        gameRunning = true;
        backSound = new GreenfootSound("level1.mp3");
        //backSound.playLoop();
        //Greenfoot.playSound("level1.mp3");
    }
    
    public void level2(){
        int fireSpread = 35;
        
        addDecor();
        water.fill();
        monitor = new GameMonitor();
        addObject(monitor, 70, 20);
        addTress(fireSpread);
        startRandomFire();
        startRandomFire();
        gameRunning = true;
        //Greenfoot.playSound("level2.mp3");
        backSound = new GreenfootSound("level2.mp3");
        //backSound.playLoop();
    }

    public void level3(){
        int fireSpread = 40;
        
        addDecor();
        water.fill();
        monitor = new GameMonitor();
        addObject(monitor, 70, 20);
        addTress(fireSpread);
        startRandomFire();
        startRandomFire();
        startRandomFire();
        gameRunning = true;
        //Greenfoot.playSound("level3.mp3");
        backSound = new GreenfootSound("level3.mp3");
        //backSound.playLoop();
    }

    private void addTress(int fireSpread){
        int xCur = xMin;
        int yCur = yMin;

        for(int i=0; i<iDim; i++){
            yCur = yMin;
            for(int j=0; j<jDim; j++){
                actors[i][j] = (new MyActor(new Pinetree(xCur, yCur, i, j, fireSpread), xCur, yCur, i, j));
                yCur = yCur+ yIncr;
            }
            xCur = xCur + xIncr;
        }
        putOthers();
        for(int j=0; j<jDim; j++){
            for(int i=0; i<iDim; i++){
                addObject(actors[i][j].actor, actors[i][j].xPos, actors[i][j].yPos);
            }
        }     
    }

    private void putOthers(){
        removeTrees();

        putHouse();
    }

    private void removeTrees(){

        for(int k=0; k<1700; k++){
            int i = new Random().nextInt(iDim);
            int j = new Random().nextInt(jDim);
            int xCur = actors[i][j].xPos;
            int yCur = actors[i][j].yPos;
            //if(!(actors[i][j].actor instanceof Pinetree)){
                //k--;
            //    continue;
            //}
            actors[i][j] = (new MyActor(new Placeholder(), xCur, yCur, i, j));
        }

    }
    //TODO na mpainei dunamika me kathe neo Level kai na ginete reference sta koutakia guro guro gia na mporei na kaie. Kai na mporei na kaei
    private void putHouse(){
        for(int i=12; i<20; i++){
            for(int j=10; j<18; j++){
                int xCur = actors[i][j].xPos;
                int yCur = actors[i][j].yPos;
                actors[i][j] = (new MyActor(new PropertyTile(xCur, yCur, i, j, 10), xCur, yCur, i, j));
            }
        }

        int c=16;
        int k=13;
        int xCur = actors[c][k].xPos;
        int yCur = actors[c][k].yPos;
        actors[c][k] = (new MyActor(new House(), xCur, yCur, 16, 14));
        //x = 12+ , 7
        //y = 10+ , 8
    }

    private void startRandomFire(){
        boolean again = true;
        while(again){
            int ii = new Random().nextInt(iDim);
            int jj = new Random().nextInt(jDim);
            if(actors[ii][jj].actor instanceof Pinetree && !((Pinetree)actors[ii][jj].actor).isBurning){
                ((Pinetree)actors[ii][jj].actor).doStuff();
                //burningTrees++;
                break;
            }
        }
    }
    static String[] trees = {
            "Sprite_101.png","Sprite_102.png","Sprite_103.png","Sprite_104.png","Sprite_105.png",
            "Sprite_201.png","Sprite_202.png","Sprite_203.png","Sprite_204.png","Sprite_205.png",
            "Sprite_301.png","Sprite_302.png","Sprite_303.png","Sprite_304.png","Sprite_305.png",
            "Sprite_401.png","Sprite_402.png","Sprite_403.png","Sprite_404.png","Sprite_405.png",
            "Sprite_501.png","Sprite_502.png","Sprite_503.png","Sprite_504.png","Sprite_505.png",
    };
    
    
    
    public void gameOver(){
        //World world = getWorld();
        System.out.println("Game Over called");
        this.removeObjects(this.getObjects(null)); //removes all the objects in the world;
        //this.addObject(new GameOverScreen(), world.getWidth()/2, world.getHeight()/2); //adds the game over screen in the middle of the world;
        
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(water, 97, 50);
    }
}
