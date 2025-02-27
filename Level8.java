import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Eighth level
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Level8 extends World
{

    /**
     * Constructor for objects of class Level8.
     * 
     */
    public Level8()
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
            addObject(new Zid(),365,75+i*50);
        }
        for(int i=0;i<3;i++) addObject(new Zid(),425,525-i*50);
        addObject(new Zid(),235,270);
        addObject(new Zid(),235,320);
        addObject(new Zid(),530,240);
        addObject(new Zid(),530,290);
        addObject(new shooting_enemy(),168,136);
        addObject(new shooting_enemy(),603,475);
        addObject(new Enemy(),290,276);
        addObject(new Enemy(),292,386);
        addObject(new Enemy(),474,225);
        addObject(new Enemy(),472,321);
        addObject(new Enemy(),383,297);
        addObject(new shooting_enemy(),127,474);
    }
}
