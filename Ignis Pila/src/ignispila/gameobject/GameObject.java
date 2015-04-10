package ignispila.gameobject;

import ignispila.Color;

public abstract class GameObject {
	
	protected int x,y;
	protected int width, height, rot;
	protected Color color;
	
	public abstract void update();
	public abstract void render();
	
	//getters and setters
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getRot(){
		return rot;
	}
	
	public int getCenterX(){
		return (int)((x * 3 + width)/ 3);
	}
	
	public int getCenterY(){
		return (int)((y * 3 + height / 2)/ 3); 
	}
	
	public void setRot(int rot){
		this.rot = rot;
	}
}
