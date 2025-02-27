import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This contains a basic guide on how to play the game
 * 
 * @author  Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class howtoplay1 extends World
{

    /**
     * Constructor for objects of class howtoplay1.
     * 
     */
    public howtoplay1()
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
        child_imobil child_imobil = new child_imobil(1);
        addObject(child_imobil,225,170);
        child_imobil child_imobil2 = new child_imobil(2);
        addObject(child_imobil2,225,320);
        howtoplay_scris howtoplay_scris = new howtoplay_scris(2);
        addObject(howtoplay_scris,500,200);
        addObject(new howtoplay_scris(1),500,100);
        addObject(new howtoplay_scris(3),500,300);
        addObject(new howtoplay_scris(4),500,400);
        addObject(new howtoplay_scris(5),500,500);
        addObject(new child_imobil(3),225,470);
        Button button = new Button(5);
        addObject(button,90,545);
    }
}
