 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Used to show how much health the player has left.
 * 
 * @author  Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class HP extends UI
{
    GreenfootImage full_heart = new GreenfootImage("full_heart.png");
    GreenfootImage half_heart = new GreenfootImage("half_heart.png");
    GreenfootImage empty_heart = new GreenfootImage("empty_heart.png");
    int healthpoint=0;
    /**
     * Checks the type of the heart and uses the required image
     */
    public HP(int type){
        if(type==1) setImage(rescale(25,25,full_heart));
        if(type==2) setImage(rescale(25,25,half_heart));
        if(type==3) setImage(rescale(25,25,empty_heart));
    }
    public void act(){
        //man.
    }
}
