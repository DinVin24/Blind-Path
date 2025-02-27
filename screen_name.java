import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the first screen that appears, and redirects to the main menu when you press SPACE
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class screen_name extends World
{

    /**
     * Constructor for objects of class screen_name.
     * 
     */
    public screen_name()
    {    
        super(800, 600, 1);
        prepare();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new TitleScreen());
    }
    public void prepare(){
        addObject(new howtoplay_scris(99),400,400);
    }
}
