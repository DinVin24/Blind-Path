import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Used to show the current level the player is at.
 * 
 * @author  Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Level extends UI
{
    int level=1;
    public void act() 
    {
        level = ((Child) getWorld().getObjects(Child.class).get(0)).nr_level;
        updateLevel(level);
    }
}
