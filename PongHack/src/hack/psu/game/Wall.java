package hack.psu.game;
import java.awt.Color;

import hack.psu.engine.Entity;


public class Wall extends Entity{

	
	private boolean scoring;
	
	public Wall(int startx, int starty, int w, int h, boolean s, Color c) {
		super(startx, starty, w, h, "Wall", c);
		// TODO Auto-generated constructor stub
		scoring = s;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
		//do nothing.
	}
	
	public boolean isScoring()
	{
		return scoring;
	}
}
