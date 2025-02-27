import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This door appears when a level is completed.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Door extends Actor
{
    public Door() {
        this(50,50);
    }
    /**
     * Rescales the image.
     */
    public Door(int widht, int height){
        GreenfootImage image = getImage();
        image.scale(widht,height);
        setImage(image);
    }
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
