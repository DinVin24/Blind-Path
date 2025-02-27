import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Seventh level
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Level7 extends World
{

    /**
     * Constructor for objects of class Level7.
     * 
     */
    public Level7()
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
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                addObject(new Zid(),75+j*50,75+i*50);
                addObject(new Zid(),725-j*50,75+i*50);
                addObject(new Zid(),75+j*50,525-i*50);
                addObject(new Zid(),725-j*50,525-i*50);
            }
        }
        for(int i=0;i<4;i++){
            addObject(new Zid(),340+i*50,320);
        }
        addObject(new shooting_enemy(),403,478);
        addObject(new shooting_enemy(),395,123);
        addObject(new shooting_enemy(),127,294);
        addObject(new Enemy(),338,258);
        addObject(new Enemy(),393,259);
        addObject(new Enemy(),441,260);
        addObject(new Enemy(),489,258);
        addObject(new Enemy(),343,361);
        addObject(new Enemy(),394,358);
        addObject(new Enemy(),443,360);
        addObject(new Enemy(),487,359);
    }
}
