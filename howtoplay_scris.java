 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This keeps all the text from the "How To Play" screen.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class howtoplay_scris extends Actor
{
    GreenfootImage W = new GreenfootImage("up2.png");
    GreenfootImage A = new GreenfootImage("textleft.png");
    GreenfootImage S = new GreenfootImage("down.png");
    GreenfootImage D = new GreenfootImage("textright.png");
    GreenfootImage attack = new GreenfootImage("attack.png");
    GreenfootImage SPACE = new GreenfootImage("press_space.png");
    int tip;
    /**
     * Check the type of text is used
     */
    public howtoplay_scris(int caz){
        tip = caz;
    }
    public void act() 
    {
        switch(tip){
            case 1:
                setImage(rescale(W));
                break;
            case 2:
                setImage(rescale(A));
                break;
            case 3:
                setImage(rescale(S));
                break;
            case 4:
                setImage(rescale(D));
                break;
            case 5:
                setImage(rescale(attack));
                break;
            case 99:
                setImage(rescale(SPACE));
                break;
        }
    }
    /**
     * Rescales the image
     */
    public GreenfootImage rescale(GreenfootImage image){
        image.scale(300,50);
        return image;
    }
}
