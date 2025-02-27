import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Third level
 * 
 * @author  Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Level3 extends World
{

    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
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
        for(int i=0;i<2;i++){
            addObject(new Zid(),155+i*50,415);
            addObject(new Zid(),155+i*50,195);
            addObject(new Zid(),600+i*50,305);
        }
        for(int i=0;i<4;i++){
            addObject(new Zid(),365+i*50,195);
            addObject(new Zid(),260+i*50,305);
            addObject(new Zid(),365+i*50,415);
        }
        addObject(new shooting_enemy(),645,460);
        addObject(new shooting_enemy(),280,480);
        addObject(new shooting_enemy(),265,105);
        addObject(new shooting_enemy(),110,295);
        addObject(new Enemy(),290,360);
        addObject(new Enemy(),270,220);
        addObject(new Enemy(),470,250);
        addObject(new Enemy(),510,320);
        addObject(new Enemy(),160,310);
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
