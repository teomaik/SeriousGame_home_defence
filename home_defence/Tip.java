import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.Random;

import java.util.List;
/**
 * Write a description of class Tip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tip extends Actor
{
    
    String[] tips = {
        "Clear your home's surroundings of \ndebris and combustible materials.",
        
        "Maintain your lawn \nand keep bushes and trees trimmed.",
        
        "Remove flammable materials from around your home's \nfoundation and outbuildings, "+
        "\nincluding garages and sheds.",
        
        "If you have trees on your property, "+
        "\nprune so the lowest branches are 6 to 10 feet from the ground.",
        
        "Keep your lawn hydrated and maintained. "+
        "\nIf it is brown, cut it down to reduce fire intensity.",
        
        "Use fire-resistant materials \nwhen building or updating your home.", 
        
        "Prepare a fire safety plan.",
        
        "Practice appropriate fire safety measures \nwith campfires.",
        
        "Protect yourself and your family from wildfire smoke.",
        
        "Install a fire extinguisher in your home.",
        
        "Keep a shovel and fire extinguisher \nin an easily accessible place.",
        
        "Keep an outdoor water supply \nwith easy access for firefighters.",
        
        "If a wildfire is imminent, "+
        "\nmake arrangements for overnight stay in a safe area."
        };
        
		Question[] questions = {
			new Question(false, "Should you go into a burning building \nto save you ID and official papers?"),
			new Question(false, "Should you go into a burning building \nto save any money and \nor precious belongings?"),
			new Question(true, "You should never go \ninto a burning building"),
			new Question(true, "Should you have an escape plan, \nin case of a fire?"),
			new Question(true, "In the summer, \nyou should prune low ganging trees \nin and around your property"),
			new Question(true, "In the summer, \nshould you keep you grass cut low?"),
			new Question(true, "In the summer, \nshould you water yout lawn regularly?"),
			new Question(false, "In the summer, \nit is ok to light a campfire \nin the forrest, \nas long as you are careful"),
			new Question(false, "In the summer, \nshould you burn dead branches in your property, \nin order to have less flamable material \nin case of a fire?"),
			new Question(true, "Is it ok to burn branches \ndurring or directly after rain?"),
			new Question(true, "Is it necessary to have an \nantifire zone around your property?"),
			new Question(true, "An antifire zone, \nis an area with well cut \nand maintained vegetation"),
			new Question(false, "An antifire zone, \nis a concrete fence"),
			new Question(false, "Green wood does not burn"),
			new Question(false, "It's ok if you have tall grass, \nas long as it's well watered \nand green"),
			new Question(false, "Durring a fire, \nyou should go towards high ground"),
			new Question(false, "Fire travels downhill"),
			new Question(true, "Fire travels uphill"),
			new Question(false, "Smoke does not kill, \nit's the fire that you should worry about"),
			new Question(true, "Smoke can be deadly")
		};
		
        String finalTip = "....and remember, the priority is to save yourself. "+
        "\nNEVER risk your life to save your property!";
 
    public Tip()
    {
        
    }
 
 
    public String tempChooseTip(){
        int tip = new Random().nextInt(tips.length);
        return tips[tip];
    }
	
    public Question tempChooseQuestion(){
        int idx = new Random().nextInt(questions.length);
        return questions[idx];
    }
	
    World scene;
	GameMonitor monitor;
	Button correctB;
	Button falseB;
	Button okB;
	Placeholder textB;
	
	String[] tutorial_tips = {
        "Try to move around by moving you mouse",
        "Try use your water by pressing the mouse's right-click",
        "Try and extinguise the fire by using the water on it",
        "You can cut down trees \nby pressing the mouse's left-click while next to them"+
				"\nTrees regrow after being cut down, or burned",
		"Press \"escape\" to go to the main menu, or \"p\" to pause the game"
	};
	public void showTutorialHint(World world, int idx){
		removeButtons();
		world.addObject(this,850,450);
        scene = world;
		
		textB = new Placeholder();
		
		GreenfootImage inner = new GreenfootImage(tutorial_tips[idx], 48, Color.BLACK, new Color(0, 0, 0, 0));
        int wide = world.getWidth();
        int high = world.getHeight()/4;
        GreenfootImage outer = new GreenfootImage(wide, high);
        int leftX = (wide - inner.getWidth())/2;
        int topY = (high - inner.getHeight())/2;
        outer.drawImage(inner, leftX, topY);
        textB.setImage(outer);
		world.addObject(textB,850,450);
		//point
		
		okB = new Button("ok", true, this);
		world.addObject(okB,850,650);
    }
	
	public void showFinalTip(World world){
		removeButtons();
		world.addObject(this,850,450);
        scene = world;
		
		textB = new Placeholder();
		
		GreenfootImage inner = new GreenfootImage(finalTip, 48, Color.BLACK, new Color(0, 0, 0, 0));
        int wide = world.getWidth();
        int high = world.getHeight()/4;
        GreenfootImage outer = new GreenfootImage(wide, high);
        int leftX = (wide - inner.getWidth())/2;
        int topY = (high - inner.getHeight())/2;
        outer.drawImage(inner, leftX, topY);
        textB.setImage(outer);
		world.addObject(textB,850,450);
		//point
		
		okB = new Button("ok", true, this);
		world.addObject(okB,850,650);
        
		
    }

    public void displayHelp(World world, GameMonitor mon){
		//getWorld().addObject(this,850,450);
		
		removeButtons();
		world.addObject(this,850,450);
		
		monitor = mon;
        scene = world;
        if(new Random().nextInt(2)<1){
            displayText(world, tempChooseTip(), true);
			okB = new Button("ok", true, this);
        	getWorld().addObject(okB,850,650);
        }else{
        	Question quest =  tempChooseQuestion();
        	
        	correctB = new Button("correct", quest.isTrue, this);
        	getWorld().addObject(correctB,800,650);
        	falseB = new Button("false", quest.isTrue, this);
        	getWorld().addObject(falseB,900,650);
			
		System.out.println(".............. final check!!!!!!!");
				if(correctB==null) System.out.println("NULL correctB!");
				if(falseB==null) System.out.println("NULL falseB!");
				if(textB==null) System.out.println("NULL textB!");
				
		System.out.println("displayHelp() ________________________________________________________________________");
        	displayText(world, quest.question, false);
		}
		
    }
    
    public void displayText(World world, String text, boolean isTip)
    {
		
		//removeButtons();
		//world.addObject(this,850,450);
		
		textB = new Placeholder();
		
		GreenfootImage inner = new GreenfootImage(text, 48, Color.BLACK, new Color(0, 0, 0, 0));
        int wide = world.getWidth();
        int high = world.getHeight()/4;
        GreenfootImage outer = new GreenfootImage(wide, high);
        int leftX = (wide - inner.getWidth())/2;
        int topY = (high - inner.getHeight())/2;
        outer.drawImage(inner, leftX, topY);
        textB.setImage(outer);
		if(isTip){
			getWorld().addObject(textB,850,450);
		}else{
			getWorld().addObject(textB,850,400);
		}
		
		System.out.println("displayText() ________________________________________________________________________");
    }
	
	public void ans_correct(){
				System.out.println("ans_correct() +++++++++++++++++++++++++++++++++++");
		continueGame();
		
		removeButtons();
		
		monitor.changeScore(-50);
		
		Greenfoot.playSound("correct.mp3");
		
		System.out.println("ans_correct() ________________________________________________________________________");
	}
	public void ans_false(){
		System.out.println("and_false() +++++++++++++++++++++++++++++++++++++++++");
		continueGame();
		
		removeButtons();
		
		Greenfoot.playSound("wrong.mp3");
		
		System.out.println("ans_false() ________________________________________________________________________");
	}
	
	public void tipOk(){
		continueGame();
		removeButtons();
	}
	
	public void continueGame(){
				System.out.println("Game continue");
		((scene1)scene).gameUnpause();
		try{
			getWorld().removeObject(this);
		}catch(Exception e){
			System.out.println("exc continueGame, removeObject: "+e.getMessage());
		}
		
	}
	
	public void removeButtons(){
		System.out.println("removeButtons() ++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				//if(correctB==null) System.out.println("NULL correctB!");
				//if(falseB==null) System.out.println("NULL falseB!");
				//if(textB==null) System.out.println("NULL textB!");
			
			
		try{
			((scene1)scene).removeObject(correctB);
			System.out.println("Removing correctB!");
		}catch(Exception e){
			System.out.println("exc correctB, removebuttons: "+e.getMessage());
		}		
		try{
			((scene1)scene).removeObject(falseB);
			System.out.println("Removing falseB!");
		}catch(Exception e){
			System.out.println("exc falseB, removebuttons: "+e.getMessage());
		}		
		try{
			((scene1)scene).removeObject(textB);
			System.out.println("Removing textB!");
		}catch(Exception e){
			System.out.println("exc textB, removebuttons: "+e.getMessage());
		}
		try{
			((scene1)scene).removeObject(okB);
			System.out.println("Removing okB!");
		}catch(Exception e){
			System.out.println("exc textB, removebuttons: "+e.getMessage());
		}
			
		System.out.println("removeButtons() ________________________________________________________________________");
	}
    // the following is optional
    // remove pop-up when clicked on
    public void act()
    {
		//System.out.println("TIP Panel ACT");
        if (Greenfoot.mouseClicked(this)){
			System.out.println("Mouse clicked in Panel");
            MouseInfo mouse = Greenfoot.getMouseInfo();
			if(mouse==null){
				return;
			}
			
			
			int buttonNumber = mouse.getButton();
			if (buttonNumber == 1 ){//&& Greenfoot.mousePressed(null)){
				System.out.println("Left mouse click!!!!!!!");
				continueGame();
				removeButtons();
			}
        }
        
        
    }
}
