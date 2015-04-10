package ignispila.gameobject;

import ignispila.Color;
import ignispila.Draw;
import ignispila.Physics;

public class Player extends GameObject{
	
	private final int SPEED = 4;
	private boolean holding = false;
	private Player opp;
	public Glow glow;
	
	public Player(int x, int y, int rot, Color color){
		this.x = x;
		this.y = y;
		this.color = color;
		this.rot = rot;
		this.width = 40;
		this.height = 50;
		this.glow = new Glow(this, new Color(255, 255, 0, 0));
	}

	@Override
	public void update() {	
			
	}

	@Override
	public void render() {
		Draw.Tri(x, y, width, height, rot, color, 1);
	}
	
	public void move(int magX, int magY){
		if(Physics.checkCollison(this, opp)){
			opp.move(magX, magY, 15 + (int)(Math.random() * 20 + 1));
		} else {
			x += SPEED * magX;
			y += SPEED * magY;
		}
	}
	
	public void move(int magX, int magY, int speed){
			x += speed * magX;
			y += speed * magY;
	}
	
	public void holdBall(){
		holding = true;
		glow();
	}

	private void glow() {
		glow.color.setAlpha((byte)75);
	}
	
	private void dim(){
		glow.color.setAlpha((byte)0);
	}
	
	public void dropBall(){
		if(holding){
			holding = false;
			dim();
		}
	}
	
	public boolean isHolding(){
		return holding;
	}
	
	public void setOpposing(Player player){
		opp = player;
	}
}
