import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This keeps all the text from the "Game Over" screen.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class gameover_scris extends Actor
{
    GreenfootImage game_over = new GreenfootImage("gameover.png");
    GreenfootImage you_won = new GreenfootImage("youwon.png");
    GreenfootImage you_lost = new GreenfootImage("youlost.png");
    int tip;
    /**
     * Act - do whatever the gameover_scris wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public gameover_scris(int type){
        tip = type;
    }
    public void act() 
    {
        switch(tip){
            case 1:
                setImage(rescale(game_over,320,48));
                break;
            case 2:
                setImage(rescale(you_won,176,48));
                break;
            case 3:
                setImage(rescale(you_lost,198,48));
                break;
        }
    }  
    /**
     * Rescales the image
     */
    public GreenfootImage rescale(GreenfootImage image,int w,int h){
        image.scale(w,h);
        return image;
    }  
}
