import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sixth level
 * 
 * @author  Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Level6 extends World
{

    /**
     * Constructor for objects of class Level6.
     * 
     */
    public Level6()
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
        for(int i=0;i<4;i++){
            addObject(new zid2(),135+i*50,135);
            addObject(new zid2(),135+i*50,185);
            addObject(new zid2(),530+i*50,135);
            addObject(new zid2(),530+i*50,185);
            addObject(new zid2(),135+i*50,410);
            addObject(new zid2(),135+i*50,460);
            addObject(new zid2(),530+i*50,410);
            addObject(new zid2(),530+i*50,460);
            addObject(new zid2(),345+i*50,295);
        }
        addObject(new Enemy(),340,258);
        addObject(new Enemy(),401,261);
        addObject(new Enemy(),463,258);
        addObject(new Enemy(),344,364);
        addObject(new Enemy(),410,367);
        addObject(new Enemy(),467,358);
        addObject(new Enemy(),351,144);
        addObject(new Enemy(),445,144);
        addObject(new Enemy(),148,258);
        addObject(new Enemy(),149,318);
        addObject(new Enemy(),148,372);
        addObject(new Enemy(),337,479);
        addObject(new Enemy(),423,482);
    }
}
