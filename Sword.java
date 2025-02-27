    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * This is just the hitbox of the player's sword.
     * 
     * @author Soltuzu Emanuel & Mandache Alexandru Nutu
     * @version 22.02.2021
     */
    public class Sword extends Child
    {
        
        public Sword() {
            this(20,50,0);
        }
        /**
         * Rescales the image and changes the angle.
         */
        public Sword(int widht, int height, int angle){
            GreenfootImage image = getImage();
            image.scale(widht,height);
            setImage(image);
            turn(angle);
        }
        public void act() 
        {
            // Add your action code here.
        }
    }
