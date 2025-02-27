import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ninth level
 * 
 * @author Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Level9 extends World
{

    /**
     * Constructor for objects of class Level9.
     * 
     */
    public Level9()
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
            addObject(new Zid(),160+i*50,195);
            addObject(new Zid(),415+i*50,405);
        }
        for(int i=0;i<2;i++){
            addObject(new zid2(),160,245+i*50);
            addObject(new zid2(),565,355-i*50);
        }
        addObject(new shooting_enemy(),181,469);
        addObject(new shooting_enemy(),604,142);
        addObject(new Enemy(),237,254);
        addObject(new Enemy(),317,296);
        addObject(new Enemy(),512,304);
        addObject(new Enemy(),449,345);
    }
}
