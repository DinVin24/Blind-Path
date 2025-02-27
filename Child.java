import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
* This is the Actor that the player controls.
* 
* @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
*/
public class Child extends Actor
{
    GreenfootImage right = new GreenfootImage("right.png");
    GreenfootImage right2 = new GreenfootImage("right2.png");
    GreenfootImage right3 = new GreenfootImage("right3.png");
    GreenfootImage left = new GreenfootImage("left.png");
    GreenfootImage left2 = new GreenfootImage("left2.png");
    GreenfootImage left3 = new GreenfootImage("left3.png");
    GreenfootImage rightatac = new GreenfootImage("rightatac.png");
    GreenfootImage rightatac2 = new GreenfootImage("rightatac2.png");
    GreenfootImage rightatac3 = new GreenfootImage("rightatac3.png");
    GreenfootImage leftatac = new GreenfootImage("leftatac.png");
    GreenfootImage leftatac2 = new GreenfootImage("leftatac2.png");
    GreenfootImage leftatac3 = new GreenfootImage("leftatac3.png");
    GreenfootSound levelup = new GreenfootSound("level_up.wav");
    int ATTACKTIME = 0;
    int nr_level = 1;
    int moveframe = 0;
    int attackframe = 0;
    int viteza = 4;
    static int viata = 100;
    int invincibleDelay = 0;
    String last_move = "D";
    public void act() 
    {
        if(viata<=0){
            GameOver gameover = new GameOver();
            Greenfoot.setWorld(gameover);
        }
        if(!attack()) move();
        if(isHit()) this.viata--;
        nextLevel();
        if(Greenfoot.isKeyDown("O") || Greenfoot.isKeyDown("M"))kill_all();
    } 
    /**
    * Used to make the character move
    */
    public void move(){
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("W")) {
            if(!collidingUp()){
                dy-=viteza;
                //last_move = "W";
            }
        }
        if (Greenfoot.isKeyDown("S")){
            if(!collidingDown()){
                dy+=viteza;
                //last_move = "S";
            }
        }
        if (Greenfoot.isKeyDown("A")){
            if(!collidingLeft()){
                dx-=viteza;
                last_move = "A";
            }
        }
        if (Greenfoot.isKeyDown("D")){
            if(!collidingRight()){
                dx+=viteza;
                last_move = "D";
            }
        }
        setLocation(getX()+dx,getY()+dy);
        walkAnimate();
    }
    /**
     * Checks if there's and obstacle above the Actor
     */
    public boolean collidingUp(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        List enemies = getWorld().getObjects(shooting_enemy.class);
        int nr_walls = walls.size(), nr_enemies = enemies.size();
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
     * Checks if there's an obstacle under the Actor
     */
    public boolean collidingDown(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        List enemies = getWorld().getObjects(shooting_enemy.class);
        int nr_walls = walls.size(), nr_enemies = enemies.size();
        int enemyX,enemyY,enemyW,enemyH;
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
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
        List enemies = getWorld().getObjects(shooting_enemy.class);
        int nr_walls = walls.size(), nr_enemies = enemies.size();
        int enemyX,enemyY,enemyW,enemyH;
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
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
     * Checks if there's an obstacle to the right of the Actor.
     */
    public boolean collidingRight(){
        boolean touching = false;
        List walls = getWorld().getObjects(Wall.class);
        List enemies = getWorld().getObjects(shooting_enemy.class);
        int nr_walls = walls.size(), nr_enemies = enemies.size();
        int enemyX,enemyY,enemyW,enemyH;
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        int wallX,wallY,wallW,wallH;
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
     * Animates the Actor walking
     */
    public void walkAnimate(){
        if(Greenfoot.isKeyDown("D")|| ((Greenfoot.isKeyDown("W")||Greenfoot.isKeyDown("S")) && last_move=="D") ){
            if (moveframe<=viteza) setImage(right);
            else if (moveframe<=viteza*2) setImage(right2);
            else if (moveframe<=viteza*3) setImage(right3);
            else moveframe = -1;
        }
        else if(Greenfoot.isKeyDown("A")|| ((Greenfoot.isKeyDown("W")||Greenfoot.isKeyDown("S")) && last_move=="A") ){
            if(moveframe<=viteza) setImage(left);
            else if(moveframe<=viteza*2) setImage(left2);
            else if(moveframe<=viteza*3) setImage(left3);
            else moveframe =-1;
        }
        else if(last_move=="A") setImage(left);
        else if(last_move=="D") setImage(right);
        moveframe++;
    }
    /**
     * Animates the actor attacking
     */
    public void attackAnimate(int atkfrm){
        if(last_move=="D"){
            if(atkfrm<=ATTACKTIME/3) setImage(rightatac);
            else if(atkfrm<=ATTACKTIME/1.5) setImage(rightatac2);
            else if(atkfrm<=ATTACKTIME) setImage(rightatac3); 
            else atkfrm =-1;
        }
        if(last_move=="A"){
            if(atkfrm<=ATTACKTIME/3) setImage(leftatac);
            else if(atkfrm<=ATTACKTIME/1.5) setImage(leftatac2);
            else if(atkfrm<=ATTACKTIME) setImage(leftatac3);
            else atkfrm =-1;
        }
    }
    /**
     * Checks if the Actor is hit
     */
    public boolean isHit(){
        boolean damage = false;
        if(invincibleDelay>0){
            damage = false;
            invincibleDelay--;
        }
        else{
            if (!attack()){
                if(isTouching(Projectile.class)) {
                    damage = true;
                    invincibleDelay = 90;
                    removeTouching(Projectile.class);
                }
                if(isTouching(Enemy.class)){
                    damage = true;
                    invincibleDelay = 90;
                }
            }
        }
        return damage;
    }
    /**
     * Used by the UI class to show the Actor's health.
     */
    public int getViata(){
        return this.viata;
    }
    /**
     * This is a tool for the developers to skip levels faster. Pressing F beats all the enemies in a level.
     */
    public void kill_all(){
        if(Greenfoot.isKeyDown("F")){
            List enemies = getWorld().getObjects(Enemy.class);
            int NUMAR = enemies.size()-1;
            while(NUMAR>=0){
                getWorld().removeObject(getWorld().getObjects(Enemy.class).get(NUMAR));
                NUMAR--;
            }
            List senemies = getWorld().getObjects(shooting_enemy.class);
            NUMAR = senemies.size()-1;
            while(NUMAR>=0){
                getWorld().removeObject(getWorld().getObjects(shooting_enemy.class).get(NUMAR));
                NUMAR--;
            }
        }
    }
    /**
     * The main method for attacking, it checks if the Actor was looking right or left before attacking, and creates a new Sword class.
     * Returns if the Actor is in the attack state or not.
     */
    public boolean attack(){
        boolean attacking = false;
        int x=getX(),y=getY(),w=getImage().getWidth(),h=getImage().getHeight();
        List enemies = getWorld().getObjects(Enemy.class);
        int NUMAR = getWorld().getObjects(Sword.class).size()-1;
        while(NUMAR >= 0){
            getWorld().removeObject(getWorld().getObjects(Sword.class).get(NUMAR));
            NUMAR = getWorld().getObjects(Sword.class).size()-1;
        }
        if(Greenfoot.isKeyDown("SPACE") && ATTACKTIME<=0){ //apesi spatiu, activezi modul atac, daca nu era deja activ
            ATTACKTIME=30; 
            attackframe=0;
        }
        if(ATTACKTIME>0) { //daca este in modul de atac
            attacking = true;
            Sword swordX = new Sword(20,40,90);
            Sword swordY = new Sword();
            if(last_move == "D"){
                getWorld().addObject(swordY,x-10,y);//dr
                getWorld().addObject(swordX,x+15,y);
            }
            else {
                getWorld().addObject(swordY,x+10,y);//st
                getWorld().addObject(swordX,x-15,y);
            }
            attackAnimate(attackframe);
            attackframe++;
        }
        ATTACKTIME--;
        return attacking;
    }
    /**
     * This method lets the Actor get to the next level by checking if there's any enemy left
     * and if you touched the door.
     */
    public void nextLevel(){
        if(getWorld().getObjects(Enemy.class).isEmpty() && getWorld().getObjects(BOSS.class).isEmpty() && getWorld().getObjects(shooting_enemy.class).isEmpty() ){
            if(nr_level==1){
                Door door = new Door();
                getWorld().addObject(door,325,75);
                Level2 level2 = new Level2();
                if(isTouching(Door.class)){
                    if(viata<10)
                        if(viata==9)
                            viata++;
                        else
                            viata+=2;
                    Greenfoot.setWorld(level2);
                    level2.addObject(this,getX(),getY());
                    nr_level++;
                    levelup.setVolume(75);
                    levelup.play();
                }
            }
            else if(nr_level==2){
                Door door = new Door();
                getWorld().addObject(door,475,75);
                Level3 level3 = new Level3();
                if(isTouching(Door.class)){
                    if(viata<10)
                        if(viata==9)
                            viata++;
                        else
                            viata+=2;
                    nr_level++;
                    Greenfoot.setWorld(level3);
                    level3.addObject(this,getX(),getY());
                    levelup.setVolume(75);
                    levelup.play();
                }
            }
            else if(nr_level==3){
                Door door = new Door();
                getWorld().addObject(door,675,75);
                Level4 level4 = new Level4();
                if(isTouching(Door.class)){
                    if(viata<10)
                        if(viata==9)
                            viata++;
                        else
                            viata+=2;
                    nr_level++;
                    Greenfoot.setWorld(level4);
                    level4.addObject(this,getX(),getY());
                    levelup.setVolume(75);
                    levelup.play();
                }
            }
            else if(nr_level==4){
                Door door = new Door();
                getWorld().addObject(door,475,75);
                Level5 level5 = new Level5();
                if(isTouching(Door.class)){
                    if(viata<10)
                        if(viata==9)
                            viata++;
                        else
                            viata+=2;
                    nr_level++;
                    Greenfoot.setWorld(level5);
                    level5.addObject(this,getX(),getY());
                    levelup.setVolume(75);
                    levelup.play();
                }
            }
            else if(nr_level==5){
                Door door = new Door();
                getWorld().addObject(door,725,325);
                Level6 level6 = new Level6();
                if(isTouching(Door.class)){
                    if(viata<10)
                        if(viata==9)
                            viata++;
                        else
                            viata+=2;
                    nr_level++;
                    Greenfoot.setWorld(level6);
                    level6.addObject(this,getX(),getY());
                    levelup.setVolume(75);
                    levelup.play();
                }
            }
            else if(nr_level==6){
                Door door = new Door();
                getWorld().addObject(door,475,75);
                Level7 level7 = new Level7();
                if(isTouching(Door.class)){
                    if(viata<10)
                        if(viata==9)
                            viata++;
                        else
                            viata+=2;
                    nr_level++;
                    Greenfoot.setWorld(level7);
                    level7.addObject(this,getX(),getY());
                    levelup.setVolume(75);
                    levelup.play();
                }
            }
            
            else if(nr_level==7){
                Door door = new Door();
                getWorld().addObject(door,475,75);
                Level8 level8 = new Level8();
                if(isTouching(Door.class)){
                    if(viata<10)
                        if(viata==9)
                            viata++;
                        else
                            viata+=2;
                    nr_level++;
                    Greenfoot.setWorld(level8);
                    level8.addObject(this,getX(),getY());
                    levelup.setVolume(75);
                    levelup.play();
                }
            }
            
            else if(nr_level==8){
                Door door = new Door();
                getWorld().addObject(door,475,75);
                Level9 level9 = new Level9();
                if(isTouching(Door.class)){
                    if(viata<10)
                        if(viata==9)
                            viata++;
                        else
                            viata+=2;
                    nr_level++;
                    Greenfoot.setWorld(level9);
                    level9.addObject(this,getX(),getY());
                    levelup.setVolume(75);
                    levelup.play();
                }
            }
            
            else if(nr_level==9){
                Door door = new Door();
                getWorld().addObject(door,525,75);
                BossFight level10 = new BossFight();
                if(isTouching(Door.class)){
                    if(viata<10)
                        if(viata==9)
                            viata++;
                        else
                            viata+=2;
                    nr_level++;
                    Greenfoot.setWorld(level10);
                    level10.addObject(this,getX(),getY());
                    levelup.setVolume(75);
                    levelup.play();
                }
            }
            
            else if(nr_level==10){
                Door door = new Door();
                getWorld().addObject(door,575,75);
                if(isTouching(Door.class)){
                    if(viata<10)
                        if(viata==9)
                            viata++;
                        else
                            viata+=2;
                    nr_level++;
                    Greenfoot.setWorld(new YouWin());
                    levelup.setVolume(75);
                    levelup.play();
                }
            }
        }
    }
}