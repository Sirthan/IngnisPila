package ignispila.gameobject;

import ignispila.Color;
import ignispila.Draw;

public class BGWall extends GameObject{

	public BGWall(int x, int y, int width, int height, Color color){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.color = color;
		this.rot = 0;
	}
	@Override
	public void update() {}

	@Override
	public void render() {
		Draw.Rect(x, y, width, height, color);
	}

}
