package hack.psu.game;

import hack.psu.CommandCenter;
import hack.psu.Connector;
import hack.psu.engine.Entity;
import hack.psu.engine.GameEngine;
import hack.psu.engine.LightsBuffer;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

public class PongMain
{
	public static Connector connector;
	private static GameEngine ge;
	
	public static void main(String[] args)
	{
		init();
		CommandCenter center=new CommandCenter(ge);
		center.pack();
		center.setVisible(true);
		//center.pack();
		while(center.wait)
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("wait: "+center.wait);
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startConnector();
		try {
			Thread.sleep(1000*2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ge.init();
	}
	
	public static boolean startConnector()
	{
		connector=new Connector();
		connector.start();
		return(true);//--------------------------YEP-------------------
	}
	
	public static void init()
	{
		ArrayList<Entity> ents = new ArrayList<Entity>();
		
		
		LightsBuffer lb = new LightsBuffer(15,5);
		
		PongBall pb = new PongBall(7,1);
		
		PongPaddle p1 = new PongPaddle(1, 1, 2);
		PongPaddle p2 = new PongPaddle(13, 2, 2);
		
		Wall top = new Wall(1, 0, lb.getWidth()-2, 1, false, Color.green);
		Wall bottom = new Wall(1, lb.getHeight()-1, lb.getWidth()-2, 1, false,Color.green);
		
		
		Wall left = new Wall(0, 0, 1,lb.getHeight() , true, Color.orange.darker());
		Wall right = new Wall(lb.getWidth()-1, 0, 1, lb.getHeight(), true, Color.orange.darker());
		
		
		
		ents.add(top);
		ents.add(bottom);
		ents.add(left);
		ents.add(right);
		ents.add(p1);
		ents.add(p2);
		ents.add(pb);
		
		pb.resetBall();
		
		ge = new GameEngine(2,ents,lb)
		{
			public void tick()
			{
				super.tick();
				try {
					connector.sendBuffer(lb.getIntBuffer(), lb.getWidth());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				print(this.lb);
			}
		};
	}
	
	public static void print(LightsBuffer lb)
	{
		for(int i = 0; i < 10; i++)
			System.out.println();
		
		for(int i = 0; i <lb.getSize();i++)
		{
			if(i%(lb.getWidth())==0)
				System.out.println();
			if(lb.getColorIndex(i) == Color.blue)
				System.out.print("b");
			else if(lb.getColorIndex(i) == Color.red)
				System.out.print("r");
			else if(lb.getColorIndex(i) == Color.green)
				System.out.print("g");
			else if(lb.getColorIndex(i) == Color.yellow)
				System.out.print("y");
			else if(lb.getColorIndex(i) == Color.gray)
				System.out.print("l");
			else if(lb.getColorIndex(i) == Color.orange)
				System.out.print("o");
			else if(lb.getColorIndex(i) == Color.yellow)
				System.out.print("y");
			else
				System.out.print("x");
		}
		
		
	}//*/
}
