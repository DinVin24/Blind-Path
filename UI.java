import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * UI contains the information the player sees on screen. The health, level and enemies left.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class UI extends Actor
{
    int level = 1;
    int healthpoint=0;
    public void act() 
    {
        healthpoint = ((Child) getWorld().getObjects(Child.class).get(0)).getViata();
        updateHP(healthpoint);
    }    
    /**
     * Checks the player's health and draws how many hearts it's supposed to
     */
    public void updateHP(int hp){
        int j=1;
        int n=hp/2;
        int NUMAR = getWorld().getObjects(HP.class).size()-1;
        while(NUMAR >= 0){
            getWorld().removeObject(getWorld().getObjects(HP.class).get(NUMAR));
            NUMAR = getWorld().getObjects(HP.class).size()-1;
        }
        if (hp%2==0){
            for(int i=1;i<=n;i++){
                getWorld().addObject(new HP(1),40+j*25,25);//full heart
                j++;
            }
            for(int i=1;i<=5-n;i++){
                getWorld().addObject(new HP(3),40+j*25,25);//empty heart
                j++;
            }
        }
        else if(hp%2!=0){
            for(int i =1;i<=n;i++){
                getWorld().addObject(new HP(1),40+j*25,25);//full heart
                j++;
            }
            getWorld().addObject(new HP(2),40+j*25,25);//half heart
            j++;
            for(int i=1;i<=4-n;i++){
                getWorld().addObject(new HP(3),40+j*25,25);//empty heart
                j++;
            }
        }
    }
    /**
     * Checks the level the player is at and updates it on the screen
     */
    public void updateLevel(int x){
        String text = "LEVEL: " + x;
        GreenfootImage image = new GreenfootImage(text,24,Color.WHITE,new Color(0, 0, 0, 0));
        setImage(image);
    }
    /**
     * Checks the number of enemies left and updates it on the screen
     */
    public void updateEnemies(){
        int x = getWorld().getObjects(Enemy.class).size()+getWorld().getObjects(BOSS.class).size()+getWorld().getObjects(shooting_enemy.class).size();
        String text = "Enemies: " + x;
        GreenfootImage image = new GreenfootImage(text,24,Color.WHITE,new Color(0, 0, 0, 0));
        setImage(image);
    }
    /**
     * Rescales the image.
     */
    public GreenfootImage rescale(int width, int height, GreenfootImage image){
        image.scale(width,height);
        setImage(image);
        return image;
    }
}
