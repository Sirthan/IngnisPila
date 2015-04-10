package ignispila;

import ignispila.gameobject.GameObject;

import java.awt.Rectangle;


public class Physics {
	public static boolean checkCollison (GameObject go1, GameObject go2){
		Rectangle r1 = new Rectangle((int)go1.getX(), (int)go1.getY(), (int)go1.getWidth(), (int)go1.getHeight());
		Rectangle r2 = new Rectangle((int)go2.getX(), (int)go2.getY(), (int)go2.getWidth(), (int)go2.getHeight());
		
		return r1.intersects(r2);
	}
	
	public static boolean checkTriCollison(GameObject go1, GameObject go2){
        int t1p1x = go1.getX();
        int t1p1y = go1.getY();
        int t1p2x = t1p1x + (go1.getWidth() / 2);
        int t1p2y = t1p1y + go1.getHeight();
        int t1p3x = t1p1x + go1.getWidth();
        int t1p3y = t1p1y;
        
        int t2p1x = go2.getX();
        int t2p1y = go2.getY();
        int t2p2x = t2p1x + (go1.getWidth() / 2);
        int t2p2y = t2p1y + go1.getHeight();
        int t2p3x = t2p1x + go1.getWidth();
        int t2p3y = t2p1y;
        
        return(checkPointCollison(t2p1x, t2p1y, t1p1x, t1p2y, t1p2x, t1p2y, t1p3x, t1p3y) || checkPointCollison(t2p2x, t2p2y, t1p1x, t1p2y, t1p2x, t1p2y, t1p3x, t1p3y)||  checkPointCollison(t2p3x, t2p3y, t1p1x, t1p2y, t1p2x, t1p2y, t1p3x, t1p3y)||checkPointCollison(t1p1x, t1p1y, t2p1x, t2p2y, t2p2x, t2p2y, t2p3x, t2p3y) ||checkPointCollison(t1p2x, t1p2y, t2p1x, t2p2y, t2p2x, t2p2y, t2p3x, t2p3y)|| checkPointCollison(t1p3x, t1p3y, t2p1x, t2p2y, t2p2x, t2p2y, t2p3x, t2p3y));
      
	}
	
	public static boolean checkPointCollison(int pointx, int pointy, int trip1x, int trip1y, int trip2x, int trip2y, int trip3x, int trip3y){
		boolean bool1 = halfPlane(pointx, pointy, trip1x, trip1y, trip2x, trip2y) < 0.0f;
		boolean bool2 = halfPlane(pointx, pointy, trip2x, trip2y, trip3x, trip3y) < 0.0f;
		boolean bool3 = halfPlane(pointx, pointy, trip3x, trip3y, trip1x, trip1y) < 0.0f;
		
		return ((bool1 == bool2) && (bool2 == bool3));
	}
	
	private static float halfPlane(int p1x, int p1y, int p2x, int p2y, int p3x, int p3y){
		return (p1x - p3x) * (p2y - p3y) - (p2x - p3x) * (p1y - p3y);
	}
	
}
