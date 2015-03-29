import java.util.ArrayList;


public class PongPaddle extends Entity {

	int toMove;
	
	public PongPaddle(int startx, int starty, int h) {
		super(startx, starty, 1, h,"Paddle");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	
		if(toMove!=0)
		{
			if(toMove>0)
				toMove--;
			else
				toMove++;
		}
		
		//check collisions against walls when they're in
		ArrayList<Entity> collisionList = ge.checkForCollisions(this);
		if(!collisionList.isEmpty())
		{
			//deal with collisions
			for(Entity ent: collisionList)
			{
				if(ent.getType().equals("Wall"))
					toMove=0;
			}
		}
	}

	
	
}
