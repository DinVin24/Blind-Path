import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * This enemy can only move towards the player and damage them by touching them.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Enemy extends Actor
{
    GreenfootImage slimefront1 = new GreenfootImage("slimefront1.png");
    GreenfootImage slimefront2 = new GreenfootImage("slimefront2.png");
    GreenfootImage slimefront3 = new GreenfootImage("slimefront3.png");
    GreenfootImage slimeleft1 = new GreenfootImage("slimeleft1.png");
    GreenfootImage slimeleft2 = new GreenfootImage("slimeleft2.png");
    GreenfootImage slimeleft3 = new GreenfootImage("slimeleft3.png");
    GreenfootImage slimeright1 = new GreenfootImage("slimeright1.png");
    GreenfootImage slimeright2 = new GreenfootImage("slimeright2.png");
    GreenfootImage slimeright3 = new GreenfootImage("slimeright3.png");
    GreenfootSound deathsound = new GreenfootSound("enemy_death.wav");
    GreenfootSound hitsound = new GreenfootSound("hit.wav");
    int viteza = 2;
    int caz = 0;
    int delay = 0;
    int moveframe = 0;
    int imunitate = 0;
    int enemyHp = 2;
    String last_move="W";
    public void act() 
    {
        if(imunitate<15) moveToPlayer();
        DEATH();
    }
    /**
     * Moves this Actor to the player's coordinates
     */
    public void moveToPlayer(){
        int dx=0,dy=0;
        boolean wallLeft=false,wallRight=false,wallUp=false,wallDown=false;
        //delay--;
        Actor player = (Actor)getWorld().getObjects(Child.class).get(0);
        int playerX=player.getX(),playerY=player.getY();
        if(getY()<playerY && getY()<playerY+2 && !wallLeft && !wallRight){
            if(!collidingDown()){
                dy+=viteza; //jos
            }else if(!collidingLeft()) dx-=viteza;
            else if (!collidingRight()) dx+=viteza;
        }
        else if(getY()>playerY && getY()>playerY+2 && !wallLeft && !wallRight){
            if(!collidingUp()){
                dy-=viteza; //sus
            }else if(!collidingLeft()) dx-=viteza;
            else if(!collidingRight()) dx+=viteza;
        }
        else if(getX()<playerX && getX()<playerX+2 && !wallUp && !wallDown){
            if(!collidingRight()){
                dx+=viteza; //dreapta
            }else if(!collidingUp()) dy-=viteza;
            else if(!collidingDown())dy+=viteza;
        }
        else if(getX()>playerX && getX()>playerX+2 && !wallUp && !wallDown){
            if(!collidingLeft()) {
                dx-=viteza; //stang
            }else if(!collidingUp())dy-=viteza;
            else if(!collidingDown())dy+=viteza;
        }
        if (delay==0){
            setLocation(getX()+dx,getY()+dy);
            moveframe++;
            delay = 0;
        }
    }
    /**
     * Animates the movement
     */
    public void movinganimation(int moveframe){
        if(last_move=="D"){
            if (moveframe<=15) setImage(slimeright1);
            else if (moveframe<=30) setImage(slimeright2);
            else if (moveframe<=45) setImage(slimeright3);
            else moveframe = -1;
        }
        else if(last_move=="A"){
            if(moveframe<=15) setImage(slimeleft1);
            else if(moveframe<=30) setImage(slimeleft2);
            else if(moveframe<=45) setImage(slimeleft3);
            else moveframe =-1;
        }
        else if(last_move=="W"){
            if(moveframe<=15) setImage(slimefront1);
            else if(moveframe<=30) setImage(slimefront2);
            else if(moveframe<=45) setImage(slimefront3);
            else moveframe =-1;
        }
        else if(last_move=="S"){
            if(moveframe<=15) setImage(slimefront1);
            else if(moveframe<=30) setImage(slimefront2);
            else if(moveframe<=45) setImage(slimefront3);
            else moveframe =-1;
        }
        
    }
    /**
     * Checks if there's an obstacle above this Actor.
     */
    public boolean collidingUp(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        List enemies = getWorld().getObjects(Enemy.class);
        int nr_walls = walls.size();
        int nr_enemies = enemies.size();
        int enemyX,enemyY,enemyW,enemyH;
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        for(int i=0;i<nr_walls;i++){
            Actor wall = (Actor)walls.get(i);
            wallX=wall.getX();wallY=wall.getY();wallW=wall.getImage().getWidth();wallH=wall.getImage().getHeight();
            if(y-h/2-viteza<=wallY+wallH/2 && y-h/2-viteza>wallY && x+w/2>=wallX-wallW/2 && x-w/2<=wallX+wallW/2) touching = true;
        }
        for(int i=0;i<nr_enemies;i++){
            Actor enemy = (Actor)enemies.get(i);
            enemyX=enemy.getX();enemyY=enemy.getY();enemyW=enemy.getImage().getWidth();enemyH=enemy.getImage().getHeight();
            if(y-h/2-viteza<=enemyY+enemyH/2 && y-h/2-viteza>enemyY && x+w/2>=enemyX-enemyW/2 && x-w/2<=enemyX+enemyW/2) touching = true;
        }
        return touching;
    }
    /**
     * Checks if there's an obstacle below this Actor.
     */
    public boolean collidingDown(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        int nr_walls = walls.size();
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        List enemies = getWorld().getObjects(Enemy.class);
        int nr_enemies = enemies.size();
        int enemyX,enemyY,enemyW,enemyH;
        for(int i=0;i<nr_walls;i++){
            Actor wall = (Actor)walls.get(i);
            wallX=wall.getX();wallY=wall.getY();wallW=wall.getImage().getWidth();wallH=wall.getImage().getHeight();
            if(y+h/2+viteza>=wallY-wallH/2 && y+h/2+viteza<wallY && x+w/2>=wallX-wallW/2 && x-w/2<=wallX+wallW/2) touching = true;
        }
        for(int i=0;i<nr_enemies;i++){
            Actor enemy = (Actor)enemies.get(i);
            enemyX=enemy.getX();enemyY=enemy.getY();enemyW=enemy.getImage().getWidth();enemyH=enemy.getImage().getHeight();
            if(y+h/2+viteza>=enemyY-enemyH/2 && y+h/2+viteza<enemyY && x+w/2>=enemyX-enemyW/2 && x-w/2<=enemyX+enemyW/2) touching = true;
        }
        return touching;
    }
    /**
     * Checks if there's an obstacle to the left of this Actor.
     */
    public boolean collidingLeft(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        int nr_walls = walls.size();
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        List enemies = getWorld().getObjects(Enemy.class);
        int nr_enemies = enemies.size();
        int enemyX,enemyY,enemyW,enemyH;
        for(int i=0;i<nr_walls;i++){
            Actor wall = (Actor)walls.get(i);
            wallX=wall.getX();wallY=wall.getY();wallW=wall.getImage().getWidth();wallH=wall.getImage().getHeight();
            if(x-w/2-viteza<=wallX+wallW/2 && x-w/2-viteza>wallX && y+h/2>=wallY-wallH/2 && y-h/2<=wallY+wallH/2) touching = true;
        }
        for(int i=0;i<nr_enemies;i++){
            Actor enemy = (Actor)enemies.get(i);
            enemyX=enemy.getX();enemyY=enemy.getY();enemyW=enemy.getImage().getWidth();enemyH=enemy.getImage().getHeight();
            if(x-w/2-viteza<=enemyX+enemyW/2 && x-w/2-viteza>enemyX && y+h/2>=enemyY-enemyH/2 && y-h/2<=enemyY+enemyH/2) touching = true;
        }
        return touching;
    }
    /**
     * Checks if there's an obstacle to the right of this Actor
     */
    public boolean collidingRight(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        int nr_walls = walls.size();
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        List enemies = getWorld().getObjects(Enemy.class);
        int nr_enemies = enemies.size();
        int enemyX,enemyY,enemyW,enemyH;
        for(int i=0;i<nr_walls;i++){
            Actor wall = (Actor)walls.get(i);
            wallX=wall.getX();wallY=wall.getY();wallW=wall.getImage().getWidth();wallH=wall.getImage().getHeight();
            if(x+w/2+viteza>=wallX-wallW/2 && x+w/2+viteza< wallX && y+h/2>=wallY-wallH/2 && y-h/2<=wallY+wallH/2) touching = true;
        }
        for(int i=0;i<nr_enemies;i++){
            Actor enemy = (Actor)enemies.get(i);
            enemyX=enemy.getX();enemyY=enemy.getY();enemyW=enemy.getImage().getWidth();enemyH=enemy.getImage().getHeight();
            if(x+w/2+viteza>=enemyX-enemyW/2 && x+w/2+viteza< enemyX && y+h/2>=enemyY-enemyH/2 && y-h/2<=enemyY+enemyH/2) touching = true;
        }
        return touching;
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
            if(Child.viata<10) {
                Child.viata = Child.viata + 1;
            }
            deathsound.setVolume(80);
            deathsound.play();
            getWorld().removeObject(this);
            //System.out.println("mort");
        }
        
    }
}
