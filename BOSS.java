import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This is the last enemy the player will fight. It has more health and shoots fire faster.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class BOSS extends Actor
{ 
    GreenfootImage left = new GreenfootImage("lady2left.png");
    GreenfootImage right = new GreenfootImage("lady2right.png");
    GreenfootSound deathsound = new GreenfootSound("enemy_death.wav");
    GreenfootSound hitsound = new GreenfootSound("hit.wav");
    int viteza = 1;
    int delay = 0;
    int moveframe = 0;
    int enemyHp = 10;
    int imunitate = 0;
    int cooldown = 0;
    String directie;
    public void act() 
    {
        lookAt();
        moveToPlayer();
        Shoot();
        DEATH();
    }   
    /**
     * Makes the Actor look towards the player's direction
     */
    public void lookAt(){
        if(getX()<getWorld().getObjects(Child.class).get(0).getX()) setImage(rescale(right,77,138));
        else setImage(rescale(left,77,138));
    }
    /**
     * After a cooldown, the Actor creates a new Projectile that goes to the player's last position
     */
    public void Shoot(){
        if(cooldown ==0){
        getWorld().addObject(new Projectile(25,25,6),getX(),getY());
        cooldown = 36;
        }
        cooldown--;
    }
    /**
     * Checks if the Actos has been hit and if it's dead
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
            deathsound.setVolume(80);
            deathsound.play();
            if(Child.viata<10) Child.viata = Child.viata + 1;
            getWorld().removeObject(this);
            //System.out.println("mort");
        }
        
    }
    /**
     * Moves the Actor towards the player
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
                wallDown=false;
            }
            else{ 
                wallDown = true;
                if(!collidingLeft()) dx-=viteza;
                else if(!collidingRight()) dx+=viteza;
            }
        }
        if(getY()>playerY && getY()>playerY+2 && !wallLeft && !wallRight){
            if(!collidingUp()){
                dy-=viteza; //sus
                wallUp=false;
            }
            else {
                wallUp = true;
                if(!collidingLeft()) dx-=viteza;
                else if(!collidingRight()) dx+=viteza;
            }
        }
        if(getX()<playerX && getX()<playerX+2 && !wallUp && !wallDown){
            if(!collidingRight()){
                dx+=viteza; //dreapta
                wallRight=false;
            }
            else {
                wallRight=true;
                if (!collidingUp()) dy-=viteza; 
                else if (!collidingDown())dy+=viteza;
            }
        }
        if(getX()>playerX && getX()>playerX+2 && !wallUp && !wallDown){
            if(!collidingLeft()) {
                dx-=viteza; //stanga
                wallLeft = false;
            }
            else {
                wallLeft=true;
                if (!collidingUp()) dy-=viteza;
                else if (!collidingDown())dy+=viteza;
            }
        }
        if (delay==0){
            setLocation(getX()+dx,getY()+dy);
            moveframe++;
            delay = 0;
        }
    }  
    /**
     * Checks if there's an obstacle above the Actor
     */
    public boolean collidingUp(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        List enemies = getWorld().getObjects(Child.class);
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
     * Checks if there's an obstacle below the Actor
     */
    public boolean collidingDown(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        int nr_walls = walls.size();
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        List enemies = getWorld().getObjects(Child.class);
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
     * Checks if there's an obstacle to the left of the Actor
     */
    public boolean collidingLeft(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        int nr_walls = walls.size();
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        List enemies = getWorld().getObjects(Child.class);
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
     * Checks if there's an obstacle to the right of the Actor
     */
    public boolean collidingRight(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        int nr_walls = walls.size();
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        List enemies = getWorld().getObjects(Child.class);
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
     * This is used to rescale images.
     */
    public GreenfootImage rescale(GreenfootImage image,int w, int h){
        image.scale(w,h);
        return image;
    }   
}
