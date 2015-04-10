package ignispila.gameobject;

import ignispila.Color;
import ignispila.Draw;
import ignispila.Physics;

public class Ball extends GameObject{
	private int xVel = 0, yVel = 0;
	private Player pl, pl2;
	private boolean captured = false;
	private Player parent;
	
	public Ball(int x, int y, int size, Color color, Player pl, Player pl2){
		this.x = x;
		this.y = y;
		this.color = color;
		this.width = size;
		this.height = size;
		this.pl = pl;
		this.pl2 = pl2;
		if(Math.random() > .5){
			xVel *= -1;
			yVel *= -1;
		}
	}
	
	@Override
	public void update() {
		if(!captured){
			x += xVel;
			y += yVel;
			if(Physics.checkCollison(this, pl)){
				caught(pl);
			}
			if(Physics.checkCollison(this, pl2)){
				caught(pl2);
			}
		} else {
			x = parent.getCenterX();
			y = parent.getCenterY();
		}
	}

	@Override
	public void render() {
		Draw.Rect(x, y, width, height, color);
		
	}
	
	private void caught(Player player){
		player.holdBall();
		captured = true;
		parent = player;
	}
	
	public void dropped(){
		captured = false;
		parent = null;
		x += 30;
	}
	
}
