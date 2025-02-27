import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player and enemies can't go through this Actor.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Wall extends Actor
{
    /**
     * Sets the size of 50x50 px.
     */
    public Wall() {
        this(50,50);
    }
    /**
     * Rescales the image.
     */
    public Wall(int widht, int height){
        GreenfootImage image = getImage();
        image.scale(widht,height);
        setImage(image);
    }
    public void act() 
    {
        // 
    }    
}