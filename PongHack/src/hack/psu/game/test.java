package hack.psu.game;
import hack.psu.Connector;
import hack.psu.engine.Entity;
import hack.psu.engine.GameEngine;
import hack.psu.engine.LightsBuffer;

import java.awt.Color;
import java.util.ArrayList;

public class test {
	
	public static Connector connector;
	
	public static void mains(String args[])
	{
		/*connector=new Connector();
		connector.start();
		
		ArrayList<Entity> ents = new ArrayList<Entity>();
		
		
		LightsBuffer lb = new LightsBuffer(15,4);
		
		PongBall pb = new PongBall(7,2);
		
		PongPaddle p1 = new PongPaddle(1, 1, 1);
		PongPaddle p2 = new PongPaddle(13, 2, 1);
		
		Wall top = new Wall(1, 0, lb.getWidth()-2, 1, false);
		Wall bottom = new Wall(1, lb.getHeight()-1, lb.getWidth()-2, 1, false);
		
		
		Wall left = new Wall(0, 0, 1,lb.getHeight() , true);
		Wall right = new Wall(lb.getWidth()-1, 0, 1, lb.getHeight(), true);
		
		
		
		ents.add(top);
		ents.add(bottom);
		ents.add(left);
		ents.add(right);
		ents.add(p1);
		ents.add(p2);
		ents.add(pb);*/
		
		
		//GameEngine ge = new GameEngine(1,ents,lb);
		
		//pb.setXvel(1);
		/*
		for(int i = 0; i <lb.getSize();i++)
		{
			if(i%(lb.getWidth())==0)
				System.out.println();
			if(lb.getColorIndex(i)==lb.COLOR_BALL)
				System.out.print("b");
			else if(lb.getColorIndex(i) == lb.COLOR_PADDLE)
				System.out.print("p");
			else if(lb.getColorIndex(i) == lb.COLOR_WALL)
				System.out.print("w");
			else if(lb.getColorIndex(i) == Color.WHITE)
				System.out.print("x");
			else
				System.out.print("y");
			//System.out.print(lb.getIntIndex(i));
		
		}
		
		for(int i = 0; i < 10; i++)
			System.out.println();
		
		*/
		//System.out.println("All done");
	}

}
