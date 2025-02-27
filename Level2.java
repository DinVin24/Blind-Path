import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Second level
 * 
 * @author  Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Level2 extends World
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        super(800, 600, 1); 
        prepare();
    }
    public void act(){
        if (getObjects(Level.class).size() == 0) addUI();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new UI(),300,400);
        for(int j=0;j<16;j++){
            addObject(new Wall(),25+j*50,25);
            addObject(new Wall(),25+j*50,575);
        }
        for(int j=0;j<12;j++){
            addObject(new Wall(),25,25+j*50);
            addObject(new Wall(),775,25+j*50);
        }
        for(int i=0;i<4;i++){
            addObject(new Zid(),225,75+i*50);
            addObject(new Zid(),225,525-i*50);
            addObject(new Zid(),575,75+i*50);
            addObject(new Zid(),575,525-i*50);
        }
        addObject(new Zid(),350,310);
        addObject(new Zid(),400,310);
        addObject(new Zid(),450,310);
        
        addObject(new shooting_enemy(),113,462);
        addObject(new shooting_enemy(),117,114);
        addObject(new shooting_enemy(),666,473);
        addObject(new shooting_enemy(),398,476);
        addObject(new shooting_enemy(),389,114);
        Enemy enemy = new Enemy();
        addObject(enemy,397,377);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,275,300);
        Enemy enemy3 = new Enemy();
        addObject(enemy3,393,243);
        Enemy enemy4 = new Enemy();
        addObject(enemy4,509,427);
        Enemy enemy5 = new Enemy();
        addObject(enemy5,311,409);
        Enemy enemy6 = new Enemy();
        addObject(enemy6,502,265);
    }
    /**
     * Refreshes the information the player recives
     */
    public void addUI(){
        Level lvl = new Level();
        addObject(lvl,285,25);
        EnemiesCount ecounter = new EnemiesCount();
        addObject(ecounter,535,25);
    }
}
