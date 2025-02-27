import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fourth level
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Level4 extends World
{

    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4()
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
        for(int i=0;i<7;i++){
            addObject(new Zid(),395,140+i*50);
        }
        for(int i=0;i<7;i++){
            addObject(new zid2(),245+i*50,230);
        }
        addObject(new Zid(),245,280);
        addObject(new Zid(),545,280);
        addObject(new zid2(),345,440);
        addObject(new zid2(),445,440);
        addObject(new Enemy(),320,290);
        addObject(new Enemy(),325,380);
        addObject(new Enemy(),480,300);
        addObject(new Enemy(),480,375);
        addObject(new Enemy(),475,160);
        addObject(new Enemy(),310,160);
        addObject(new shooting_enemy(),130,115);
        addObject(new shooting_enemy(),130,435);
        addObject(new shooting_enemy(),640,440);
    }
}
