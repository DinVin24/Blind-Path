import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class contains all the buttons in the game. They change if your mouse hovers over them.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Button extends Actor
{
    GreenfootImage newgame = new GreenfootImage("newgame.png");
    GreenfootImage newgame2 = new GreenfootImage("newgame2.png");
    GreenfootImage back = new GreenfootImage("back.png");
    GreenfootImage back2 = new GreenfootImage("back2.png");
    GreenfootImage exitgame = new GreenfootImage("exitgame.png");
    GreenfootImage exitgame2 = new GreenfootImage("exitgame2.png");
    GreenfootImage howtoplay = new GreenfootImage("HowToPlay.png");
    GreenfootImage howtoplay2 = new GreenfootImage("HowToPlay2.png");
    GreenfootImage mainmenu = new GreenfootImage("mainmenu.png");
    GreenfootImage mainmenu2 = new GreenfootImage("mainmenu2.png");
    GreenfootImage next = new GreenfootImage("next.png");
    GreenfootImage next2 = new GreenfootImage("next2.png");
    GreenfootSound pressed = new GreenfootSound("button_press.wav");
    int tip;
    public Button(int caz){
        tip = caz;
    }
    /**
     * Checks what type of button this Actor is, if the mouse is hovering over it and if it's pressed.
     */
    public void act() 
    {
        switch(tip){
            case 1: //start game
                if(Greenfoot.mouseMoved(this)) setImage(rescale(newgame2,202,48));
                if (Greenfoot.mouseMoved(null)&& !Greenfoot.mouseMoved(this)) setImage(rescale(newgame,202,48));
                if(Greenfoot.mousePressed(this)) {
                    Greenfoot.setWorld(new Level1());
                    pressed.setVolume(60);
                    pressed.play();
                }
                break;
            case 2: //howtoplay
                if(Greenfoot.mouseMoved(this)) setImage(rescale(howtoplay2,266,48));
                if (Greenfoot.mouseMoved(null)&& !Greenfoot.mouseMoved(this)) setImage(rescale(howtoplay,266,48));
                if(Greenfoot.mousePressed(this)) {
                    Greenfoot.setWorld(new howtoplay1());
                    pressed.setVolume(60);
                    pressed.play();
                }
                break;
            case 3:// exit game
                if(Greenfoot.mouseMoved(this)) setImage(rescale(exitgame2,218,48));
                if (Greenfoot.mouseMoved(null)&& !Greenfoot.mouseMoved(this)) setImage(rescale(exitgame,218,48));
                if(Greenfoot.mousePressed(this)) {
                    Greenfoot.stop();
                    pressed.setVolume(60);
                    pressed.play();
                    TitleScreen.menusong.stop();
                    Level1.gamesound.stop();
                }
                break;
            case 4://next
                if(Greenfoot.mouseMoved(this)) setImage(rescale(next2,106,48));
                if (Greenfoot.mouseMoved(null)&& !Greenfoot.mouseMoved(this)) setImage(rescale(next,106,48));
                break;
            case 5://back
                if(Greenfoot.mouseMoved(this)) setImage(rescale(back2,106,48));
                if (Greenfoot.mouseMoved(null)&& !Greenfoot.mouseMoved(this)) setImage(rescale(back,106,48));
                if(Greenfoot.mousePressed(this)) {
                    Greenfoot.setWorld(new TitleScreen());
                    pressed.setVolume(60);
                    pressed.play();
                }
                break;
            case 6: //back to menu
                if(Greenfoot.mouseMoved(this)) setImage(rescale(mainmenu2,218,48));
                if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) setImage(rescale(mainmenu,218,48));
                if(Greenfoot.mousePressed(this)){
                    Greenfoot.setWorld(new TitleScreen());
                    Level1.gamesound.stop();
                    pressed.setVolume(60);
                    pressed.play();
                }
                break;
        
        }
    }
    /**
     * This is used to rescale images
     */
    public GreenfootImage rescale(GreenfootImage image,int w, int h){
        image.scale(w,h);
        return image;
    }    
}
