        import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * This is the fireball shot by the enemies. It disappears once it hits the player or a wall.
 * 
 * @author  Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Projectile extends Actor
{
    int viteza = 4;
    int caz = 0;
    int delay = 0;
    int moving = 0;
    int test = 321;
    public Projectile() {
        this(25,25,4);
    }
    public Projectile(int widht, int height,int v){
        GreenfootImage image = getImage();
        image.scale(widht,height);
        setImage(image);
        viteza = v;
    }
    public void act() 
    {
        goToPlayer();
    }
    /**
     * Makes the Actor go to the player's last location.
     * Also removes this Actor if it collides with a wall or the player's sword.
     */
    public void goToPlayer(){
        Actor player = (Actor)getWorld().getObjects(Child.class).get(0);
        int playerX=player.getX(),playerY=player.getY();
        if (moving ==0)
            turnTowards(playerX,playerY);
        move(viteza);
        if(collidingLeft() || collidingRight() || collidingUp() || collidingDown() || isTouching(Sword.class)){
            getWorld().removeObject(this);
        }
        moving++;
    }
    /**
     * Checks if there's an obstacle above this Actor
     */
    public boolean collidingUp(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        int nr_walls = walls.size();
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        for(int i=0;i<nr_walls;i++){
            Actor wall = (Actor)walls.get(i);
            wallX=wall.getX();wallY=wall.getY();wallW=wall.getImage().getWidth();wallH=wall.getImage().getHeight();
            if(y<=wallY+wallH/2+h/2+viteza && y>=wallY+wallH/2+h/2 && x>=wallX-wallW/2-w/2 && x<=wallX+wallW/2+w/2) touching = true;
        }
        return touching;
    }
    /**
     * Checks if there's an obstacle below this actor.
     */
    public boolean collidingDown(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        int nr_walls = walls.size();
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        for(int i=0;i<nr_walls;i++){
            Actor wall = (Actor)walls.get(i);
            wallX=wall.getX();wallY=wall.getY();wallW=wall.getImage().getWidth();wallH=wall.getImage().getHeight();
            if(y>=wallY-wallH/2-h/2-viteza && y<=wallY-wallH/2-h/2 && x>=wallX-wallW/2-w/2 && x<=wallX+wallW/2+w/2) touching = true;
        }
        return touching;
    }
    /**
     * Checks if there's an obstacle to the left of this actor
     */
    public boolean collidingLeft(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        int nr_walls = walls.size();
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        for(int i=0;i<nr_walls;i++){
            Actor wall = (Actor)walls.get(i);
            wallX=wall.getX();wallY=wall.getY();wallW=wall.getImage().getWidth();wallH=wall.getImage().getHeight();
            if(x<=wallX+wallW/2+w/2+viteza && x>=wallX+wallW/2+w/2 && y>=wallY-wallH/2-h/2 && y<=wallY+wallH/2+h/2) touching = true;
        }
        return touching;
    }
    /**
     * Checks if there's an obstacle to the right of this actor.
     */
    public boolean collidingRight(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        int nr_walls = walls.size();
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
        for(int i=0;i<nr_walls;i++){
            Actor wall = (Actor)walls.get(i);
            wallX=wall.getX();wallY=wall.getY();wallW=wall.getImage().getWidth();wallH=wall.getImage().getHeight();
            if(x>=wallX-wallW/2-w/2-viteza && x<=wallX-wallW/2-w/2 && y>=wallY-wallH/2-h/2 && y<=wallY+wallH/2+h/2) touching = true;
        }
        return touching;
    }
    /**
     * This is unused
     */
    public boolean touchesPlayer(){
        boolean shot = false;
        if (isTouching(Child.class)) System.out.println("dada");
        return shot;
    }
}
