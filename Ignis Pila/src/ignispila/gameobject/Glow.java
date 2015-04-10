package ignispila.gameobject;

import ignispila.Color;
import ignispila.Draw;

public class Glow extends GameObject{
	private GameObject parent;
	private final int GROW_MAX = 1;
	private float count = 0;

	public Glow(GameObject parent, Color color){
		this.parent = parent;
		this.x = parent.getX();
		this.y = parent.getY();
		this.height = parent.getHeight();
		this.width = parent.getWidth();
		this.rot = parent.getRot();
		this.color = color;
	}
	
	@Override
	public void update() {
		count += .4;
		this.x = parent.getX();
		this.y = parent.getY();
		this.rot = parent.getRot();
		
	}

	@Override
	public void render() {
		Draw.Tri(x, y, width, height, rot, color, (float)((float)((count % (8 * GROW_MAX)) / 20.0) + 1.3));
		Draw.Tri(x, y, width, height, rot, color, (float)((float)((count % (8 * GROW_MAX)) / 20.0) + 1.1));
		Draw.Tri(x, y, width, height, rot, color, (float)((float)((count % (8 * GROW_MAX)) / 20.0) + .6));
	}
}
