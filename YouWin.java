import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the screen that the player sees when they beat the game.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class YouWin extends World
{

    /**
     * Constructor for objects of class YouWin.
     * 
     */
    public YouWin()
    {    
        super(800, 600, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Button button = new Button(6);
        addObject(button,400,325);
        Button button2 = new Button(3);
        addObject(button2,400,425);
        addObject(new gameover_scris(1),400,100);
        addObject(new gameover_scris(2),400,175);
    }
}
