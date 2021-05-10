import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.Random;

/**
 * Write a description of class Pinetree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pinetree extends Actor
{
    /**
     * Act - do whatever the Pinetree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean isBurning = false;
    public boolean isBurnt = false;
    private int fireTimer = 1000;
    private int curTimer = 0;
    private int fireSpread = 0;
    private int fireSpreadProbability=10;
    private Fire fire;
    
    public int xPos;
    public int yPos;
    public int iAr;
    public int jAr;
    
    public Pinetree(){
        chooseTree();
    }
    public Pinetree(int x, int y){
        chooseTree();
        xPos = x;
        yPos = y;
    }
    public Pinetree( int x, int y, int i, int j, int fireProb){
        chooseTree();
        xPos = x;
        yPos = y;
        iAr = i;
        jAr = j;
        fireSpreadProbability = fireProb;
    }
    
    public void act() 
    {
        if(!isBurning || isBurnt){
            return;
        }
        
        curTimer++;
        fireSpread++;
        
        if(fireSpread%60==0){
            fireSpread=0;
            spreadFire();
        }
        
        if(curTimer > fireTimer){
            burnt();
        }
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
        
        //trees at distance of 2
        for(int i=jAr-2; i<=jAr+2; i++){
            if(new Random().nextInt(100+1)<fireSpreadProbability/5){
                try{
                    //iAr
                    ((scene1)getWorld()).actors[iAr-2][i].doStuff();
                }catch(Exception e){}
            }
        }
        for(int i=jAr-2; i<=jAr+2; i++){
            if(new Random().nextInt(100+1)<fireSpreadProbability/5){
                try{
                    //iAr
                    ((scene1)getWorld()).actors[iAr+2][i].doStuff();
                }catch(Exception e){}
            }
        }
        for(int i=iAr-1; i<=iAr+1; i++){
            if(new Random().nextInt(100+1)<fireSpreadProbability/5){
                try{
                    //iAr
                    ((scene1)getWorld()).actors[i][jAr-2].doStuff();
                }catch(Exception e){}
            }
        }
        for(int i=iAr-1; i<=iAr+1; i++){
            if(new Random().nextInt(100+1)<fireSpreadProbability/5){
                try{
                    //iAr
                    ((scene1)getWorld()).actors[i][jAr+2].doStuff();
                }catch(Exception e){}
            }
        }
    }
    
    String[] trees = {
        "Sprite_101.png","Sprite_102.png","Sprite_103.png","Sprite_104.png","Sprite_105.png",
        "Sprite_201.png","Sprite_202.png","Sprite_203.png","Sprite_204.png","Sprite_205.png",
        "Sprite_301.png","Sprite_302.png","Sprite_303.png","Sprite_304.png","Sprite_305.png",
        "Sprite_401.png","Sprite_402.png","Sprite_403.png","Sprite_404.png","Sprite_405.png",
        "Sprite_501.png","Sprite_502.png","Sprite_503.png","Sprite_504.png","Sprite_505.png",
    };
    
    private void chooseTree(){
        int type = new Random().nextInt(scene1.trees.length);
        setImage(scene1.trees[type]);
        getImage().scale(50, 60);
    }
    
    public void doStuff(){
        catchFire();
    }
    
    private void catchFire(){
        if(isBurning || isBurnt){
            return;
        }
        
        
        fire = new Fire();
        getWorld().addObject(fire, xPos+7, yPos+7);
        
        isBurning = true;
        ((scene1)getWorld()).burningTrees++;
        fireTimer = 600 + new Random().nextInt(600+1);
        
        //fireTimer = 10 + new Random().nextInt(100+1); 
        
    }
    
    private void burnt(){
        int burntTree = new Random().nextInt(2+1);
        switch (burntTree) {
        case 0:
          setImage("bruntTree1.png");
          break;
        case 1:
          setImage("bruntTree2.png");
          break;
        case 2:
          setImage("bruntTree3.png");
          break;
        default:
          setImage("bruntTree1.png");
          break;
        }
        getImage().scale(40, 40);
        if(isBurning){
            ((scene1)getWorld()).burningTrees--;   
        }
        isBurning = false;
        isBurnt = true;
        try{
           ((scene1)getWorld()).monitor.treeDestroyed();
           ((scene1)getWorld()).monitor.decrementScore(1);
        }catch(Exception e){}
        getWorld().removeObject(fire);
    }
    public void chop(){
        if(isBurnt){
            return;
        }
        extinguish();
        setImage("stump.png");
        getImage().scale(7, 10);
        setLocation(xPos+5, yPos+20);
        try{
           ((scene1)getWorld()).monitor.treeDestroyed();
           ((scene1)getWorld()).monitor.decrementScore(2);
        }catch(Exception e){}
        isBurnt=true;
    }
    
    public void extinguish(){
        
        if(isBurning){
            ((scene1)getWorld()).burningTrees--;   
        }
        
        isBurning = false;
        
        try{
            getWorld().removeObject(fire);
        }catch(Exception e){}
        fireSpread = 0;
    }
}
