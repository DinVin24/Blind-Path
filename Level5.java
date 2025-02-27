import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fifth level
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Level5 extends World
{

    /**
     * Constructor for objects of class Level5.
     * 
     */
    public Level5()
    {    
        super(800, 600, 1); 
        prepare();
    }

    public void act(){
        if (getObjects(Level.class).size() == 0) addUI();
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
        for(int i=0;i<6;i++){
            addObject(new Zid(),210,185+i*50);
            addObject(new Zid(),585,185+i*50);
        }
        for(int i=0;i<4;i++){
            addObject(new Zid(),390,75+i*50);
            addObject(new Zid(),390,525-i*50);
        }
        addObject(new Enemy(),505,305);
        addObject(new Enemy(),395,303);
        addObject(new Enemy(),300,303);
        addObject(new Enemy(),300,205);
        addObject(new Enemy(),300,410);
        addObject(new Enemy(),500,405);
        addObject(new Enemy(),490,200);
        addObject(new shooting_enemy(),672,473);
        addObject(new shooting_enemy(),118,477);
        addObject(new shooting_enemy(),116,129);
    }
}
