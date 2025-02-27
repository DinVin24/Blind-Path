import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the main menu, with 3 buttons.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class TitleScreen extends World
{
    static GreenfootSound menusong = new GreenfootSound("menu_song.mp3");
    public TitleScreen()
    {
        super(800, 600, 1); 
        prepare();
        menusong.setVolume(40);
        menusong.playLoop();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //dada
        addObject(new Button(1),400,150);
        addObject(new Button(2),400,300);
        addObject(new Button(3),400,450);
    }
}
