import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends Actor
{
    
	public String question;
	public boolean isTrue;
	
	public Question(boolean isTrue, String question){
		this.question = question;
		this.isTrue = isTrue;
	}
}
