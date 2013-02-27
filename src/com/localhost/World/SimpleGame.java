package com.localhost.World;
 
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
 
public class SimpleGame extends BasicGame{
	
	Image easy = null,normal = null,hard = null,expert = null, plane = null, land = null;
	float px = 50f;
	float py = 50f;
	float scale = 1.0f;
	static String gameType = null;
 
    public SimpleGame()
    {
        super("Slick2DPath2Glory - SimpleGame");
    }
 
    @Override
    public void init(GameContainer gc) throws SlickException {
    	easy = new Image("Images/easy.png");
    	normal = new Image("Images/normal.png");
    	hard = new Image("Images/hard.png");
    	expert = new Image("Images/expert.png");
    	plane = new Image("Images/plane.png"); 
    	land = new Image("Images/land.jpg");
    }
 
    @Override
    public void update(GameContainer gc, int delta) throws SlickException     
    {
    	Input input = gc.getInput();
    	 
        if(input.isKeyDown(Input.KEY_A))
        {
            plane.rotate(-0.2f * delta);
        }
        if(input.isKeyDown(Input.KEY_D))
        {
            plane.rotate(0.2f * delta);
        }
        if(input.isKeyDown(Input.KEY_W))
        {
            float hip = 0.4f * delta;
 
            float rotation = plane.getRotation();
 
            px+= hip * Math.sin(Math.toRadians(rotation));
            py-= hip * Math.cos(Math.toRadians(rotation));
        }
        if(input.isKeyDown(Input.KEY_S))
        {
            float hip = 0.4f * delta;
 
            float rotation = plane.getRotation();
 
            px-= hip * Math.sin(Math.toRadians(rotation));
            py+= hip * Math.cos(Math.toRadians(rotation));
        }
        
        if(input.isKeyDown(Input.KEY_2))
        {
            scale += (scale >= 5.0f) ? 0 : 0.1f;
            plane.setCenterOfRotation(plane.getWidth()/2.0f*scale, plane.getHeight()/2.0f*scale);
        }
        if(input.isKeyDown(Input.KEY_1))
        {
            scale -= (scale <= 1.0f) ? 0 : 0.1f;
            plane.setCenterOfRotation(plane.getWidth()/2.0f*scale, plane.getHeight()/2.0f*scale);
        }
    }
 
    public void render(GameContainer gc, Graphics g) throws SlickException 
    {
    	/*if(gameType.equalsIgnoreCase("EASY"))
    		easy.draw(0,0);
    	else if(gameType.equalsIgnoreCase("NORMAL"))
    		normal.draw(0,0);
    	else if(gameType.equalsIgnoreCase("HARD"))
    		hard.draw(0,0);
    	else if(gameType.equalsIgnoreCase("EXPERT"))
    		expert.draw(0,0);
    	else
    	{
    		float realVal =(float)gc.getWidth();
    		scale=realVal/94f;
    		easy.draw(0,0,scale);
    	}
    	for(int x = 0; x < gc.getWidth(); x+= 11)
    	{
    		for(int y = 0; y < gc.getHeight(); y+= 11)
    		{
    			new Image("Images/Minesweeper.png").draw(x,y);
    		}
    	}*/
    	land.draw(0,0);
    	plane.draw(px, py, scale);
    	
    }
 
    public static void main(String[] args) throws SlickException
    {
    	 //System.out.println("What level would you like to play? (Easy, normal, hard, expert, or custom)");
    	 //Scanner scan = new Scanner(System.in);
    	 //gameType = scan.next();
         AppGameContainer app = new AppGameContainer(new SimpleGame());
         /*if(gameType.equalsIgnoreCase("EASY"))
         {
        	 app.setDisplayMode(99, 99, false);
         }
         else if(gameType.equalsIgnoreCase("NORMAL"))
         {   	 
        	 app.setDisplayMode(176, 176, false);
         }
         else if(gameType.equalsIgnoreCase("HARD")){
        	 app.setDisplayMode(275, 275, false);
         }
         else if(gameType.equalsIgnoreCase("EXPERT"))
         {
        	 app.setDisplayMode(396, 396, false);
         }
         else
         {
        	 System.out.println("How many Rows would you like? (Applies for columns too)");
        	 int x = scan.nextInt();
        	 app.setDisplayMode(x*11, x*11, false);
         }*/
         app.setDisplayMode(800, 600, false);
         app.setShowFPS(false);
         app.start();
    }
}