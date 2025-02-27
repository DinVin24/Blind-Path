import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This enemy can't move but instead shoots fireballs towards the player. If the player touches the enemy, they get damaged.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class shooting_enemy extends Actor
{
    GreenfootImage wizardleft1 = new GreenfootImage("wizardleft1.png");
    GreenfootImage wizardleft2 = new GreenfootImage("wizardleft2.png");
    GreenfootImage wizardright1 = new GreenfootImage("wizardright1.png");
    GreenfootImage wizardright2 = new GreenfootImage("wizardright2.png");
    GreenfootSound hitsound = new GreenfootSound("hit.wav");
    GreenfootSound deathsound = new GreenfootSound("enemy_death.wav");
    int imunitate = 0;
    int enemyHp = 2;
    int cooldown = 0;
    String directie;
    public void act() 
    {
        lookAt();
        Shoot();
        DEATH();
    }   
    /**
     * After the cooldown is over, this Actor creates new Projectiles.
     * This is also used to animate the Actor shooting the fireballs
     */
    public void Shoot(){
        if(cooldown<=15 || cooldown>=76 )
            if(directie=="right") setImage(wizardright2);
            else setImage(wizardleft2);
        else if (directie == "right") setImage(wizardright1);
        else setImage(wizardleft1);
        if(cooldown ==0){
        getWorld().addObject(new Projectile(),getX(),getY());
        cooldown = 91;
        }
        cooldown--;
    }
    /**
     * Makes the Actor look towards the player's direction
     */
    public void lookAt(){
        if(getX()<getWorld().getObjects(Child.class).get(0).getX()) directie = "right";
        else directie = "left";
    }
    /**
     * Checks if this Actor got hit by the player's sword when its immunity state is over.
     */
    public void DEATH(){
        imunitate--;
        if(isTouching(Sword.class)&&imunitate<=0) {
            //System.out.println("ded");
            enemyHp--;
            imunitate = 40;
            hitsound.setVolume(76);
            hitsound.play();
        }
        if(enemyHp<=0) {
            if(Child.viata<10){
                    Child.viata = Child.viata + 1;
            }
            deathsound.setVolume(80);
            deathsound.play();
            getWorld().removeObject(this);
            //System.out.println("mort");
        }
        
    }
}
