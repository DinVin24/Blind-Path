import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is used to show the character in the "How To Play" screen
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class child_imobil extends Actor
{
    GreenfootImage left = new GreenfootImage("left.png");
    GreenfootImage left2 = new GreenfootImage("left2.png");
    GreenfootImage left3 = new GreenfootImage("left3.png");
    GreenfootImage right = new GreenfootImage("right.png");
    GreenfootImage right2 = new GreenfootImage("right2.png");
    GreenfootImage right3 = new GreenfootImage("right3.png");
    GreenfootImage atac = new GreenfootImage("rightatac.png");
    GreenfootImage atac2 = new GreenfootImage("rightatac2.png");
    GreenfootImage atac3 = new GreenfootImage("rightatac3.png");
    int moveframe = 0;
    int tip;
    /**
     * Checks if the Actor is attacking, looking to the left or to the right
     */
    public child_imobil(int caz){
        tip = caz;
    }
    public void act() 
    {
        moveframe++;
        switch (tip){
            case 1:
                moveLeft();
                break;
            case 2:
                moveRight();
                break;
            case 3:
                animateAttack();
                break;
        }
    }   
    /**
     * Animates moving to the left
     */
    public void moveLeft(){
        if(moveframe<=10) setImage(rescale(left,68,104));
            else if(moveframe<=20) setImage(rescale(left2,68,104));
            else if(moveframe<=30) setImage(rescale(left3,68,104));
            else moveframe =-1;
    }
    /**
     * Animates moving to the right
     */
    public void moveRight(){
        if(moveframe<=10) setImage(rescale(right,68,104));
            else if(moveframe<=20) setImage(rescale(right2,68,104));
            else if(moveframe<=30) setImage(rescale(right3,68,104));
            else moveframe =-1;
    }
    /**
     * Animates attacking
     */
    public void animateAttack(){
        if(moveframe<=10) setImage(rescale(atac,102,104));
            else if(moveframe<=20) setImage(rescale(atac2,68,128));
            else if(moveframe<=30) setImage(rescale(atac3,138,104));
            else moveframe =-1;
    }
    /**
     * Rescales the image.
     */
    public GreenfootImage rescale(GreenfootImage image,int w, int h){
        image.scale(w,h);
        return image;
    }
}
