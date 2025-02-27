import greenfoot.*;  
import java.util.List;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * First level of the game, that also starts playing the song and adds the player.
 * 
 * @author  Soltuzu Emanuel & Mandache Alexandru Nutu
 * @version 22.02.2021
 */
public class Level1 extends World
{
    static GreenfootSound gamesound = new GreenfootSound("game_music.mp3");
    static int current;
    public Level1(){
        super(800, 600, 1);
        prepare();
        TitleScreen.menusong.stop();
        gamesound.setVolume(50);
        gamesound.playLoop();
    }
    public void act(){
        if (getObjects(UI.class).size() == 0) addUI();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        for(int j=0;j<16;j++){
            addObject(new Wall(),25+j*50,25);
            addObject(new Wall(),25+j*50,575);
        }
        for(int j=0;j<12;j++){
            addObject(new Wall(),25,25+j*50);
            addObject(new Wall(),775,25+j*50);
        }
        Child child = new Child();
        addObject(child,575,135);
        Child.viata = 10;
        Zid zid = new Zid();
        addObject(zid,400,75);
        Zid zid2 = new Zid();
        addObject(zid2,400,525);
        for (int i=0;i<5;i++){
            addObject(new Zid(),400+i*50,125+i*50);
            addObject(new Zid(),400-i*50,475-i*50);
        }
        for(int i=0;i<1;i++){
            addObject(new Zid(),450+i*50,425-i*50);
            addObject(new Zid(),350-i*50,175+i*50);
        }
        addObject(new Enemy(), 349,222);
        addObject(new Enemy(),449,227);
        addObject(new Enemy(),452,383);
        addObject(new Enemy(),352,370);
        addObject(new Enemy(),399,293);
        addObject(new shooting_enemy(),530,484);
        addObject(new shooting_enemy(),669,487);
        addObject(new shooting_enemy(),263,494);
        addObject(new shooting_enemy(),133,489);
        addObject(new shooting_enemy(),191,122);
        addObject(new shooting_enemy(),131,269);
    }
    /**
     * Refreshes the information the player recives
     */
    public void addUI(){
        addObject(new UI(),300,400);
        Level lvl = new Level();
        addObject(lvl,285,25);
        EnemiesCount ecounter = new EnemiesCount();
        addObject(ecounter,535,25);
    }
}