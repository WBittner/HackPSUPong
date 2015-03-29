package hack.psu.game;
import hack.psu.engine.Entity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class PongBall extends Entity {
	
	private int xvel;
	private int yvel;
	private int xmid;
	private int ymid;

	public PongBall(int startx, int starty) {
		super(startx, starty, 1, 1, "Ball", Color.red);
		// TODO Auto-generated constructor stub
		
		xmid = startx;
		ymid = starty;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
		//TODO: acc?
		
		
		//ball moves
		setX(x+xvel);
		setY(y+yvel);
		
		//check for collisions
		ArrayList<Entity> collisionList = ge.checkForCollisions(this);
		
		if(!collisionList.isEmpty())
		{
			//System.out.print("in lsit");
			//deal with collisions
			for(Entity ent: collisionList)
			{
				if(ent.getType().equals("Paddle"))
					xvel=-xvel;
				else if(ent.getType().equals("Wall"))
				{
					System.out.print("WALL!");
					if(((Wall)ent).isScoring())
					{
						//TODO:
						//handle reset
						xvel=0;
						yvel=0;
						Timer t = new Timer();
						resetBall();						
					}
					else
					{
						yvel=-yvel;
					}	
				}
			}
		}
		
	}
	
	public void resetBall()
	{
		x = xmid;
		y = ymid;
		
		xvel = (int) Math.pow((-1),(int)(Math.random()*2));
		yvel = (int) Math.pow((-1),(int)(Math.random()*2));
		System.out.print("IN RESET");
	}
	
	public void setXvel(int d)
	{
		xvel = d;
	}
	
	public void setYvel(int d)
	{
		yvel = d;
	}
		

}
