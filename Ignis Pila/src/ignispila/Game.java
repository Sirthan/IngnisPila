package ignispila;

import ignispila.gameobject.BGWall;
import ignispila.gameobject.Ball;
import ignispila.gameobject.GameObject;
import ignispila.gameobject.Player;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Game {
	
	private ArrayList<GameObject> background; //Bottom Layer, usu background elements - things behind the players. Currently doesn't update!
	private ArrayList<GameObject> effects; //Middle Layer, usu effects created to provide info to players
	private ArrayList<GameObject> objects; //Top Layer, usually actual elements - players and the things they can interact with
	private Ball ball;
	private Player pl;
	private Player pl2;
	
	public Game(){
		background = new ArrayList<GameObject>();
		effects = new ArrayList<GameObject>();
		objects = new ArrayList<GameObject>();
		pl = new Player(Display.getWidth() / 2 - 155, Display.getHeight() /2, 270, new Color(170, 40, 80, 200));
		pl2 = new Player(Display.getWidth() / 2 + 115, Display.getHeight() /2, 90, new Color(40, 110, 160, 200));
		ball = new Ball(Display.getWidth() /2 - 16, Display.getHeight() /2, 16, new Color(100, 200, 100, 200), pl, pl2);
		pl.setOpposing(pl2);
		pl2.setOpposing(pl);
		objects.add(pl);
		objects.add(pl2);
		objects.add(ball);
		background.add(new BGWall(0, 0, Display.getWidth() / 2 + 100, Display.getHeight(), new Color(255,0,0,100)));
		background.add(new BGWall(Display.getWidth() / 2 - 100, 0, Display.getWidth(), Display.getHeight(), new Color(0,0,255,100)));
		effects.add(pl.glow);
		effects.add(pl2.glow);
	}
	
	

	public void getInput() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			pl.move(0,1);
			pl.setRot(0);
		} 
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			pl.move(-1,0);
			pl.setRot(90);
		} 
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			pl.move(0,-1);
			pl.setRot(180);
		} 
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			pl.move(1,0);
			pl.setRot(270);
		} 
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			pl2.move(0,1);
			pl2.setRot(0);
		} 
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			pl2.move(-1,0);
			pl2.setRot(90);
		} 
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
			pl2.move(0,-1);
			pl2.setRot(180);
		} 
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			pl2.move(1,0);
			pl2.setRot(270);
		} 
	}

	public void update() {
		for(GameObject GO : effects){
			GO.update();
		}
		for(GameObject GO : objects){
			GO.update();
		}
		
		if(Physics.checkCollison(pl, pl2)){
			if(pl.isHolding()){
				ball.dropped();
				pl.dropBall();
			} else if(pl2.isHolding()){
				ball.dropped();
				pl2.dropBall();
			}
		}
	}

	public void render() {
		for(GameObject GO : background){
			GO.render();
		}
		for(GameObject GO : effects){
			GO.render();
		}
		for(GameObject GO : objects){
			GO.render();
		}
	}
	
	public void addEffect(GameObject eff){
		effects.add(eff);
	}

}
