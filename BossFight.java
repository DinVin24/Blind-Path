import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BossFight is the final level of the game.
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class BossFight extends World
{

    /**
     * Constructor for objects of class Level10.
     * 
     */
    public BossFight()
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
        Zid zid = new Zid();
        addObject(zid,200,150);
        Zid zid5 = new Zid();
        addObject(zid5,200,200);
        Zid zid2 = new Zid();
        addObject(zid2,150,200);
        Zid zid3 = new Zid();
        addObject(zid3,150,400);
        Zid zid6 = new Zid();
        addObject(zid6,200,400);
        Zid zid4 = new Zid();
        addObject(zid4,200,450);
        Zid zid7 = new Zid();
        addObject(zid7,600,150);
        Zid zid8 = new Zid();
        addObject(zid8,600,200);
        Zid zid9 = new Zid();
        addObject(zid9,650,200);
        Zid zid10 = new Zid();
        addObject(zid10,650,400);
        Zid zid11 = new Zid();
        addObject(zid11,600,400);
        Zid zid12 = new Zid();
        addObject(zid12,600,450);
        BOSS bOSS = new BOSS();
        addObject(bOSS,411,286);
    }
}
